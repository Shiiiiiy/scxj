<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/news/mobile/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:title default="欢迎光临"/>Powered By wonders</title>
	<%@include file="/WEB-INF/views/modules/news/mobile/include/head.jsp" %>
	<sitemesh:head/>
</head>
<body>
	
	<div class="container-fluid">
		<div class="content">
			<sitemesh:body/>
		</div>
    </div> <!-- /container -->
</body>
</html>