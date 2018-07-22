<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*,java.util.regex.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<body> 

	
	<a href="showAddStnPage" style="margin: 0 auto"><button>添加学生</button></a>
	
	
	<table border="1px" style="border-collapse: collapse">
			<tr>
				<td>学生编号</td>
				<td>姓名</td>
				<td>出生日期</td>
				<td>备注</td>
				<td>平均分▽</td>
				<td>操作</td>
			</tr>
	<c:forEach items="${page.pageStnList}" var="stn">
			<tr>
				<td>${stn.stn_id}</td>
				<td>${stn.stn_name}</td>
				<td>
					<fmt:formatDate value="${stn.stn_birthday}" 
								pattern="yyyy-MM-dd"/>
				</td>
				<td>${stn.stn_description}</td>
				<td>${stn.stn_avgscore}</td>
				<td>
					<a href="showEditPage?id=${stn.stn_id}">修改</a>
					<a href="delStn?id=${stn.stn_id}" 
						onclick="return confirm('确定要删除吗？')">删除</a>
				</td>
               	</tr>
	</c:forEach>
	</table>
	<a href="ShowPage?nowPage=1"><button>首页</button></a>
	<c:forEach begin='1' end='${page.allPage}' var="i">
		<a href="ShowPage?nowPage=${i}"><button>${i}</button></a>
	</c:forEach>
	<c:choose>
		<c:when test="${page.nowPage!=1}">
			<a href="ShowPage?nowPage=${page.nowPage-1}"><button>上一页</button></a>
		</c:when>
	</c:choose>
	
	
	<c:choose>
		<c:when test="${page.nowPage!=page.allPage}"> 
			<a href="ShowPage?nowPage=${page.nowPage+1}"><button>下一页</button></a>
		</c:when>
	</c:choose>
	<a href="ShowPage?nowPage=${page.allPage}"><button>尾页</button></a>
	
</body>

</html>