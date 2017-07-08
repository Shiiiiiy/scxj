<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>控制条</title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background:#e5e9f4;
}
</style>
<script>
function fr(){
	var f = parent.document.getElementById("main").cols;
	
	if(f=="180,8,*"){ parent.document.getElementById("main").cols = "0,8,*";
		document.getElementById("di").innerHTML="<img src=${ctxStatic}/lawyer/images/arrow_right.jpg title='显示菜单' style='margin:200px 0 0 0'>"
	}else{
		parent.document.getElementById("main").cols = "180,8,*";
		document.getElementById("di").innerHTML="<img src=${ctxStatic}/lawyer/images/arrow_left.jpg title='隐藏菜单' style='margin:200px 0 0 0'>"
	}
	
}
function onLoad(){
	document.getElementById("di").focus();
}
</script>
</head>

<body onLoad="onLoad()" >
<table width="8" height="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
    <td width="8" align="left" style="CURSOR:hand;" title="隐藏/显示菜单" onClick="fr()"><div id="di" style="display: ;"><img src=
	"${ctxStatic}/lawyer/images/arrow_left.jpg" width="8" height="66" border="0" style="margin:200px 0 0 0;" /></div></td>
  </tr>
</table>
</body>
</html>
