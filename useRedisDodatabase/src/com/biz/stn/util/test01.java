/**
 * 
 */
package com.biz.stn.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ð¡ÄÔ¸«
 *
 */
public class test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);
		  ParsePosition pos = new ParsePosition(8);
		  Date currentTime_2 = formatter.parse(dateString, pos);
		  System.out.println(currentTime_2);
	}

}
