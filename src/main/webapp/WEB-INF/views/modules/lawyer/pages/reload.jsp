<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>登录页</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
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
    <td class="all_title_bg">操作结果</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
  <c:if test="${applyType=='error'}">
  <tr>
    <td width="100%" valign="middle" align="center">
		<script>
			var opresult='${OPRESULT}';
			document.write(opresult+"!");
			//window.parent.location.href="/l/lawyer/wcmdocument/index";
		</script>    
	</td>
  </tr>
  </c:if>

  <c:if test="${applyType=='ssyw'}">
    <tr>
  	<td width="20%"></td>
    <td width="60%" valign="middle" align="center">
		 您的申请提交成功了！ 
	</td>
	<td width="20%"></td>
  </tr>
  <tr>
  <td width="20%"></td>
    <td width="60%" valign="middle" align="left">
		 您此次申请的<font style="font-weight:bold ">回复ID</font>：<a href="#" style="color:blue;">${lawyerApply.id}</a>、<font style="font-weight:bold ">预约流水号</font>：<a href="#" style="color:blue;">${lawyerApply.searchCode}</a>。<br/>
                      您提交的<font style="font-weight:bold ">联系电话</font>：<a href="#" style="color:blue;">${lawyerApply.lawyerTel}</a>、<font style="font-weight:bold ">联系Email</font>：<a href="#" style="color:blue;">${lawyerApply.lawyerEmail}</a>。
	</td>
	<td width="20%"></td>
  </tr>
   <tr>
   <td width="20%"></td>
    <td width="60%" valign="middle" align="left">
        <font style="font-weight:bold ">注意</font>：请在收到回复后，尽快通过短信或网上确认，否则系统将在半个工作日前自动取消!  
	</td>
	<td width="20%"></td>
  </tr>

  </c:if>
  <c:if test="${applyType=='sslc'}">
   <tr>
  	<td width="20%"></td>
    <td width="60%" valign="middle" align="center">
		 您的申请提交成功了！ 
	</td>
	<td width="20%"></td>
  </tr>
  <tr>
  <td width="20%"></td>
    <td width="60%" valign="middle" align="left">
		 您此次申请的<font style="font-weight:bold ">预约流水号</font>：<a href="#" style="color:blue;">${searchApply.searchcode}</a>。<br/>
                      您提交的<font style="font-weight:bold ">联系电话</font>：<a href="#" style="color:blue;">${searchApply.lawyertel}</a>、<font style="font-weight:bold ">联系Email</font>：<a href="#" style="color:blue;">${searchApply.lawyeremail}</a>。
	</td>
	<td width="20%"></td>
  </tr>
   <tr>
   <td width="20%"></td>
    <td width="60%" valign="middle" align="left">
        <font style="font-weight:bold ">注意</font>： 我们将尽快办理您的申请事项，请及时关注网上回复、手机短信、Email信箱！
	</td>
	<td width="20%"></td>
  </tr>
  </c:if>
  
</table>
</body>
</html>
