<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/news/mobile/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<title>上海检察院外网网站</title>
<%@include file="/WEB-INF/views/modules/news/mobile/include/newhead.jsp"%>
<sitemesh:head />
</head>
<body>

	<div class="navbar">
		<div class="navbar-inner">
			<ul id="main_nav" class="nav">
				<li><img src="${ctxStatic}/images/bg.png" width="110px"
					height="32px" /></li>
				<li ${channelName==62?"class=\"active\"":""}><a
					href="${ctx}/news/wcmdocument/list/62?type=portal_default">检察新闻</a></li>
				<li ${channelName==160?"class=\"active\"":""}><a
					href="${ctx}/news/wcmdocument/list/160?type=portal_default">法制经纬</a></li>
				<li ${channelName==60?"class=\"active\"":""}><a
					href="${ctx}/news/wcmdocument/list/60?type=portal_default"><span>公告</span></a></li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">
		<div class="content">
			<sitemesh:body />
		</div>
	</div>

	<c:if test="${state ne 'close'}">
		<div id="toolbar"
			style="height: 60px; width: 200px; position: fixed; right: 5px; top: 30px; padding: 2px; text-align: center; font-size: 12px;">
			<div class="btn ">
				<a href="#" onclick="loadApp()" class="btn btn-warning"><i
					class="icon-download-alt"></i>Android客户端下载</a> <a href="#"
					onclick="closeToolBar()">&times;</a>
			</div>
		</div>
	</c:if>
	<script>
		var state = '${state}';
		function closeToolBar() {
			$("#toolbar").hide();
			state = 'close';
		}

		function loadApp() {
			window.open("${ctxStatic}/app/scxj.apk");
		}

		function changeTab(channelId) {
			var url = '/scxj/f/news/wcmdocument/list/' + channelId
					+ '?type=portal_default&state=' + state;
			window.location.href = url
		}
	</script>
</body>
</html>