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
	<table border="1px" style="margin: 0 auto">
			<tr>
				<td>学生编号</td>
				<td>姓名</td>
				<td>出生日期</td>
				<td>备注</td>
				<td>平均分</td>
			</tr>
	<c:forEach items="${stns}" var="stn">
			<tr>
				<td>${stn.stn_id}</td>
				<td>${stn.stn_name}</td>
				<td>${stn.stn_birthday}</td>
				<td>${stn.stn_description}</td>
				<td>${stn.stn_avgscore}</td>
			</tr>
	</c:forEach>
	</table>
</body>

</html>