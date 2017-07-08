<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
span {font-size; 10px;
	font-style: oblique;
	font-weight: 700;
	color: blue;
}

@font-face {
	font-family: myfont;
	src
	.url("");
}

span {
	font-family: myfont;
}

strong {
	font-family: myfont;
}

strong {
	font-weight: 700;
	font-style: normal;
	font-size: 27px;
	color: black;
}

.tr1, .tr2, .tr3 {
	height: 30px;
	width: 100%;
	text-align: center;
}

.td11 {
	width: 80px;
	height: 30px;
	text-align: center;
	font-family: myfont;
	font-size: 15px;
	color: black;
	font-weight: 700;
}

.td21, .td31 {
	width: 80px;
	height: 30px;
	text-align: center;
	font-family: myfont;
	font-size: 15px;
	color: black;
	font-weight: 700;
}

.td12, .td22, .td32 {
	width: 55px;
	height: 30px;
	text-align: center;
	font-family: myfont;
	font-size: 13px;
	color: black;
}
</style>
</head>

<body id="list_body">
	<form name="lybForm" action="../wcmdocument/sy_list" method="post">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td class="all_title_left">&nbsp;</td>
				<td class="all_title_bg"></td>
				<td class="all_title_right">&nbsp;</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="all_content">
			<tr>
				<td valign="top">
					<table width="96%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><img src="${ctxStatic}/lawyer/images/yypt03.jpg" /></td>
							<td><strong>&nbsp;&nbsp;${lawyerUser.name}：您好！<br />
								<br />欢迎登陆律师预约平台
							</strong></td>
							<td><img
								src="${ctxStatic}/lawyer/images/shjcy-qr-code-s.png" /><br>

									<span>Android客户端下载<br> APP于2015-5-29升级<br>
												敬请扫描下载 </span></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>

					<table align="center">
						<tr class="tr1">
							<td class="td11">事务所:&nbsp;</td>
							<td class="td12">${lawyerUser.lawfirmname}</td>
						</tr>
						<tr class="tr2">
							<td class="td21">身份证号:</td>
							<td class="td22">&nbsp;${lawyerUser.idnumber}&nbsp;</td>
						</tr>
						<tr class="tr3">
							<td class="td31">执业证号:</td>
							<td class="td32">&nbsp;${lawyerUser.lisensenumber}&nbsp;</td>
						</tr>
					</table>
					<table width="96%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>

					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
					</form>
</body>
</html>
