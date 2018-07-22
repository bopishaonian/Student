<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>添加学生</title>
<meta charset="UTF-8" />
<script type="text/javascript">
	function init(){
		if(document.getElementById("flag").value=="1"){
			alert("学号已存在，请重新输入！");
		}
	}

	function toVaild(){
		var brdVal = document.getElementById("stn_birthday").value;
		var avgVal = document.getElementById("stn_avgscore").value;
		var nameVal = document.getElementById("stn_name").value;
		var idVal = document.getElementById("stn_id").value;
		if(idVal==null||idVal==""){
			alert("输入学号！");
			return false;
		}else if(isNaN(idVal)){
			alert("请输入纯数字学号！");
			return false;
		}else if(nameVal==null||nameVal==""){
			alert("请输入姓名！");
			return false;
		}else if(!brdVal.match(/^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/)){
			alert("出生日期请按照19**-**-**输入！");
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
<body onload="init()">
<input type="hidden" id="flag" value="${flag}">
<form action="addStn" method="post" onsubmit="return toVaild()">

	学号<input type="text" name="stn_id" id="stn_id"><br>
	姓名<input type="text" name="stn_name" id="stn_name"><br>
	出生日期<input type="text" name="stn_birthday" id="stn_birthday"><br>
	备注<input type="text" name="stn_description" id="stn_description"><br>
	平均分<input type="text" name="stn_avgscore" id="stn_avgscore"><br>
	<input type="submit" value="添加">
	<a href="ShowPage"><input type="button" value="取消"></a>
	
</form>


</body>
</html>
