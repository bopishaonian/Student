/**
 * 
 */
package com.biz.stn.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import redis.clients.jedis.Jedis;

/**
 * @author 小脑斧
 *
 */
public class setvalues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1",6379);
		Map stnMap = new HashMap();
		stnMap.put("stn_id", "1");
		stnMap.put("stn_name", "张春");
		stnMap.put("stn_birthday", "1995-01-19");
		stnMap.put("stn_description", "记大过一次");
		stnMap.put("stn_avgscore", "69");
		System.out.println(stnMap);
		if(stnMap!=null){
			jedis.hmset("1", stnMap);
			jedis.lpush("stn", "1");
		}
	}

}
