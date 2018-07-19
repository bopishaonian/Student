/**
 * 
 */
package com.biz.stn.util;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


import com.biz.stn.pojo.Student;

import redis.clients.jedis.Jedis;

/**
 * @author 小脑斧
 *
 */
public class DBconn {
	private static Jedis jedis;
	private static int x = 0;
	
	
	
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
		if(stnMap!=null){
			x++;
			String sortNumber = Integer.toString(x);
			jedis.hmset(sortNumber, stnMap);
			jedis.lpush("stn", sortNumber);
		}
		
	}
	public List<Student> getAllStn(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<Student> stns = new ArrayList<Student>();
		Student stn = new Student();
		List<String> sortNumbers = jedis.lrange("stn", 0, jedis.llen("stn"));
		System.out.println(sortNumbers+"*****************************************");
		if(sortNumbers.size()>0 && sortNumbers!=null){
			for(int i = 0;i<sortNumbers.size();i++){
				System.out.println(sortNumbers.get(i));
				
				Map<String, String> hgetAll = jedis.hgetAll(sortNumbers.get(i));
				try {
					Date Stn_birthday = formatter.parse(hgetAll.get("stn_birthday"));
					System.out.println(hgetAll.get("stn_avgscore"));
					int stn_avgscore = Integer.valueOf(hgetAll.get("stn_avgscore")).intValue();
				
					stn.setStn_id(hgetAll.get("stn_id"));
					stn.setStn_name(hgetAll.get("stn_name"));
					stn.setStn_birthday(Stn_birthday);
					stn.setStn_description(hgetAll.get("stn_description"));
					stn.setStn_avgscore(stn_avgscore);
					stns.add(stn);
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return stns;
	}
}
