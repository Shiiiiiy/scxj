<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>上海市人民检察院案件诉讼流程查询平台</title>
<link href="${ctxStatic}/lawyer/css/jcy_img_tree.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/lawyer/css/jcy_tree.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
a img {
	border:none;
}
.sTable {
border-collapse: separate;
border: 1px solid #000000; }

.one{  font-size:14px; height:32px}
.two{ ;font-size:14px; height:22px}
.three{ border-left:none; border-right:1px solid #000000 ;font-size:14px; height:32px}


</style>
</head>
<body id="list_body">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">检察院</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
<tr>
	<td valign="top">
<div class="tree_head">
    <div class="tree_head_title"><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=3"><img src="${ctxStatic}/lawyer/images/jcy/tree_head-title.gif" /></a></div>
</div>
<div class="tree_projects">
	<div class="tree_projects01"><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=4"><img src="${ctxStatic}/lawyer/images/jcy/tree_projects01.gif" /></a></div>
	<div class="tree_projects02"><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=5"><img src="${ctxStatic}/lawyer/images/jcy/tree_projects02.gif" /></a></div>
	<div class="tree_projects03"><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=23"><img src="${ctxStatic}/lawyer/images/jcy/tree_projects03.gif" /></a></div>
</div>
<div class="tree_lists">
	<div class="tree_lists_left">
    	<ul>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=6"><img src="${ctxStatic}/lawyer/images/jcy/tree_li01.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=7"><img src="${ctxStatic}/lawyer/images/jcy/tree_li02.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=8"><img src="${ctxStatic}/lawyer/images/jcy/tree_li03.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=9"><img src="${ctxStatic}/lawyer/images/jcy/tree_li04.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=10"><img src="${ctxStatic}/lawyer/images/jcy/tree_li05.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=11"><img src="${ctxStatic}/lawyer/images/jcy/tree_li06.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=12"><img src="${ctxStatic}/lawyer/images/jcy/tree_li07.gif" /></a></li>
        </ul>
    </div>
	<div class="tree_lists_center">
    	<ul>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=13" alt="12"><img src="${ctxStatic}/lawyer/images/jcy/tree_li08.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=14"><img src="${ctxStatic}/lawyer/images/jcy/tree_li09.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=15"><img src="${ctxStatic}/lawyer/images/jcy/tree_li10.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=16"><img src="${ctxStatic}/lawyer/images/jcy/tree_li11.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=17"><img src="${ctxStatic}/lawyer/images/jcy/tree_li12.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=18"><img src="${ctxStatic}/lawyer/images/jcy/tree_li13.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=19"><img src="${ctxStatic}/lawyer/images/jcy/tree_li14.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=20"><img src="${ctxStatic}/lawyer/images/jcy/tree_li15.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=21"><img src="${ctxStatic}/lawyer/images/jcy/tree_li16.gif" /></a></li>
        	<li><a href="${ssUrl}?lawId=${lawyerUserS.lawid}&groupId=22"><img src="${ctxStatic}/lawyer/images/jcy/tree_li17.gif" /></a></li>
        </ul>
    </div>
	<div class="tree_lists_right">
    	<ul>
        	<li><a href="#" onclick="javascript:alert('尚未开通...');"><img src="${ctxStatic}/lawyer/images/jcy/tree_li18.gif" /></a></li>
        	<li><a href="#" onclick="javascript:alert('尚未开通...');"><img src="${ctxStatic}/lawyer/images/jcy/tree_li19.gif" /></a></li>
        	<li><a href="#" onclick="javascript:alert('尚未开通...');"><img src="${ctxStatic}/lawyer/images/jcy/tree_li20.gif" /></a></li>
        	<li><a href="#" onclick="javascript:alert('尚未开通...');"><img src="${ctxStatic}/lawyer/images/jcy/tree_li21.gif" /></a></li>
        	<li><a href="#" onclick="javascript:alert('尚未开通...');"><img src="${ctxStatic}/lawyer/images/jcy/tree_li22.gif" /></a></li>
        </ul>
    </div>
</div>
	</td>
</tr>
</table>
</body>
</html>
