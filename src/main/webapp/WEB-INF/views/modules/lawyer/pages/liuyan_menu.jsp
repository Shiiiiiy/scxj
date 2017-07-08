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
<li id="menu1" onclick="setNav('menu',1,2)" class="hover"><a href="/l/lawyer/wcmdocument/lyb_con" target="rightFrame">留言板</a></li>
<li id="menu2" onclick="setNav('menu',2,2)"><a href="/l/lawyer/wcmdocument/lsly_list" target="rightFrame">历史留言</a></li>
</ul>
</body>
</html>
