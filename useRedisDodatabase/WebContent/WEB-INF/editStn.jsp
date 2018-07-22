<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>添加学生</title>
<meta charset="UTF-8" />
<script type="text/javascript">
	function noEditId(){
		alert("学号不可修改！");
	}
	function toVaild(){
		var brdVal = document.getElementById("stn_birthday").value;
		var avgVal = document.getElementById("stn_avgscore").value;
		var nameVal = document.getElementById("stn_name").value;
		if(nameVal==null||nameVal==""){
			alert("请输入姓名！");
			return false;
		}else if(!brdVal.match(/^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/)){
			alert("请按照yyyy-MM-dd输入！");
			return false;
		}else if(avgVal==null||avgVal==""){
			alert("请输入平均分！");
			return false;
		}else{
			return true;
			
		}
	}
</script>

</head>
<body>
<form action="editStn" method="post" onsubmit="return toVaild()">
    
	学号<input type="text" name="stn_id"  value="${stn.stn_id}" readonly onclick="noEditId()"><br>
	姓名<input type="text" name="stn_name" id="stn_name" value="${stn.stn_name}"><br>
	出生日期<input type="text" name="stn_birthday" id="stn_birthday" value="<fmt:formatDate value="${stn.stn_birthday}" pattern="yyyy-MM-dd"/>"
			><br>
	备注<input type="text" name="stn_description" value="${stn.stn_description}"><br>
	平均分<input type="text" name="stn_avgscore" id="stn_avgscore" value="${stn.stn_avgscore}"><br>
	<input type="submit" value="修改">
	<a href="ShowPage"><input type="button" value="取消" ></a>
	
</form>


</body>
</html>
