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
		jedis.del("5");
		jedis.zrem("stn","5");
	}

}
