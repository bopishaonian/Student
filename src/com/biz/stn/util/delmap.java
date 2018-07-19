/**
 * 
 */
package com.biz.stn.util;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * @author Ð¡ÄÔ¸«
 *
 */
public class delmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//jedis.del("stn");
		List<String> sortNumbers = jedis.lrange("stn", 0, jedis.llen("stn"));
		for(int i = 0;i<sortNumbers.size();i++){
			//System.out.println(sortNumbers.get(i));
			jedis.del(sortNumbers.get(i));
			
		}	
	}

}
