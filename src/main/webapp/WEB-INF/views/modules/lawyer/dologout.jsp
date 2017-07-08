<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>退出</title>
<link href="${ctxStatic}/lawyer/css/login.css" rel="stylesheet" type="text/css" />
<script>
function tiao(){
	window.parent.location.href="/l/lawyer/loginb";
}
</script>
</head>
<body>
<iframe src="http://passport3.lawyers.org.cn/logout.do" width="10" id="logoutFrame" name="logoutFrame" height="10" noresize="noresize" scrolling="no" sroll="no" align="center" style="border: none;"></iframe>
<script>
	window.setInterval(tiao, 1000); 
</script>
</body>
</html>
