/**
 * 
 */
package com.biz.stn.util;

import redis.clients.jedis.Jedis;

/**
 * @author С�Ը�
 *
 */
public class getOneValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println(jedis.lrange("stn", 0,jedis.llen("stn") ));
		
	}

}
