/**
 * 
 */
package com.biz.stn.pojo;

import java.util.Date;

/**
 * @author Ð¡ÄÔ¸«
 *
 */
public class Student {
	private String stn_id;
	private String stn_name;
	private Date stn_birthday;
	private String stn_description;
	private int stn_avgscore;
	public String getStn_id() {
		return stn_id;
	}
	public void setStn_id(String stn_id) {
		this.stn_id = stn_id;
	}
	public String getStn_name() {
		return stn_name;
	}
	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
	}
	public Date getStn_birthday() {
		return stn_birthday;
	}
	public void setStn_birthday(Date stn_birthday) {
		this.stn_birthday = stn_birthday;
	}
	public String getStn_description() {
		return stn_description;
	}
	public void setStn_description(String stn_description) {
		this.stn_description = stn_description;
	}
	public int getStn_avgscore() {
		return stn_avgscore;
	}
	public void setStn_avgscore(int stn_avgscore) {
		this.stn_avgscore = stn_avgscore;
	}
}
