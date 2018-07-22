/**
 * 
 */
package com.biz.stn.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ð¡ÄÔ¸«
 *
 */
public class Page {
	private List<Student> pageStnList = null;
	private Integer nowPage = null;
	private Integer allPage = null;
	
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	public List<Student> getPageStnList() {
		return pageStnList;
	}
	public void setPageStnList(List<Student> pageStnList) {
		this.pageStnList = pageStnList;
	}
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
}
