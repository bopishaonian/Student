/**
 * 
 */
package com.biz.stn.util;

import java.sql.*;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.junit.Test;


import com.biz.stn.pojo.Page;
import com.biz.stn.pojo.Student;

import redis.clients.jedis.Jedis;

/**
 * @author 小脑斧
 *
 */
public class DBconn {
	private static Jedis jedis;
	
	/*
	 * 连接redis
	 */
	static{
		jedis = new Jedis("127.0.0.1",6379);
	}
	/*
	 * 添加学生
	 */
	public void addStn(Student stn){
		
		Map<String,String> stnMap = new HashMap<String,String>();
		
		stnMap.put("stn_id", stn.getStn_id());
		stnMap.put("stn_name", stn.getStn_name());
		stnMap.put("stn_birthday", stn.getStn_birthday().toString());		
		stnMap.put("stn_description", stn.getStn_description());
		stnMap.put("stn_avgscore", String.valueOf(stn.getStn_avgscore()));
		
		//使用zset数据类型在redis储存信息，key储存一个固定入口，score储存平均分，number储存学号
		jedis.zadd("stn", stn.getStn_avgscore(), stn.getStn_id());
		
		//使用map数据类型储存学生信息，key为学号，value为学生信息(map类型)
		jedis.hmset(stn.getStn_id(), stnMap);
		
	}
	/*
	 * 获取全部学生
	 */
	public List<Student> getAllStn() throws ParseException{
		
		List<Student> stns = new ArrayList<Student>();
		
		Set<String> stnids = jedis.zrange("stn", 0, -1);
		System.out.println(stnids);
		for(String stn_id: stnids){
			
			
			Student stn = new Student();
			
			Map<String, String> hgetAll = jedis.hgetAll(stn_id);
			
			
			Date stn_birthday = new Date(hgetAll.get("stn_birthday"));
			//平均数转成整型
			int stn_avgscore = Integer.valueOf(hgetAll.get("stn_avgscore")).intValue();
			
			stn.setStn_id(hgetAll.get("stn_id"));
			stn.setStn_name(hgetAll.get("stn_name"));
			stn.setStn_birthday(stn_birthday);
			stn.setStn_description(hgetAll.get("stn_description"));
			stn.setStn_avgscore(stn_avgscore);
			
			stns.add(stn);
		}
		return stns;
	}
	/*
	 * 删除学生
	 */
	public void delStn(String stn_id){
		jedis.del("stn_id");
		jedis.zrem("stn", stn_id);
	}
	/*
	 * 修改信息
	 */
	public void editStn(Student stn){
		this.delStn(stn.getStn_id());
		this.addStn(stn);
	}
	/*
	 * 查找一个学生信息
	 */
	@Test
	public Student findOneStudent(String stn_id){
		
		Student stn =new Student();
		//根据key取出存储学生信息的map
		if(stn_id!=null){
			System.out.println("DB前*****************");
			Map<String,String> stnMap  = jedis.hgetAll(stn_id);
			
			//对数据类型进行处理
			Date stn_birthday = new Date(stnMap.get("stn_birthday"));
			int stn_avgscore = Integer.valueOf(stnMap.get("stn_avgscore")).intValue();

			//将学生信息存入Student
			stn.setStn_id(stnMap.get("stn_id"));
			stn.setStn_name(stnMap.get("stn_name"));
			stn.setStn_birthday(stn_birthday);
			stn.setStn_description(stnMap.get("stn_description"));
			stn.setStn_avgscore(stn_avgscore);
		}
		
		return stn;
		
	}
	/*
	 * 查询当前页数的stnlist
	 */
	/**
	 * @param nowPage
	 * @return
	 */
	public Page getSomeStnList(String nowPage) {
		List<Student> stns = new ArrayList<Student>();
		Student stn =new Student();
		Page page = new Page();
		Integer nowPage01 = new Integer(nowPage);
		Integer allStnsLen = null;
		try {
			allStnsLen = this.getAllStn().size();
			if(allStnsLen/5>nowPage01-2){
				if((allStnsLen-5*nowPage01)>-1){
					for(int i = (nowPage01-1)*5;i<(nowPage01-1)*5+5;i++){
						stns.add(this.getAllStn().get(i));
					}
				}else{
					for(int i = (nowPage01-1)*5;i<allStnsLen;i++){
						stns.add(this.getAllStn().get(i));
					}
				}			
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		page.setPageStnList(stns);
		page.setAllPage(allStnsLen/5+1);
		page.setNowPage(nowPage01);
		
		return page;
		
	}
	/*
	 * 检查id重复
	 */
	public Boolean checkStn_id(String id) {
		if(jedis.exists(id)){
			return false;
		}else {
			return true;
		}
	}
}

