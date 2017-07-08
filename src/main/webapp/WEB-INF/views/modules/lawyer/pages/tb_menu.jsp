<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>菜单</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctxStatic}/lawyer/scripts/common.js"></script>
<style type="text/css">
body { background:#e5e9f4 url(${ctxStatic}/lawyer/images/menu_bg.jpg) repeat-y right; overflow-x:hidden;}
</style>
</head>
<body>
<ul class="menu">
<li id="menu1" onclick="setNav('menu',1,2)" class="hover"><a href="/l/lawyer/wcmdocument/tb_list_1" target="rightFrame">待处理台帐</a></li>
<li id="menu2" onclick="setNav('menu',2,2)"><a href="/l/lawyer/wcmdocument/tb_list_2" target="rightFrame">工作台帐</a></li>
</ul>
</body>
</html>
