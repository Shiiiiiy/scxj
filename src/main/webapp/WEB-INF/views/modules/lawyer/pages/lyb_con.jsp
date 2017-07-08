<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function validate() {
		var lyone = document.lybForm.LYONE.value;
		var lytwo = document.lybForm.LYTWO.value;
		var lmsg = document.lybForm.LMSG.value;
		if (lyone == "") {
			alert("请选择你认为本平台是否便捷");
			document.lybForm.LYONE.onfocus;
			return;
		} else if (lytwo == "") {
			alert("请选择你对本平台是否满意");
			document.lybForm.LYTWO.onfocus;
			return;
		} else if (lmsg == "") {
			alert("请填写你对本平台的意见");
			document.lybForm.LMSG.onfocus;
			return;
		}
		document.lybForm.submit();
		alert("感谢你对本平台的大力支持");
	}
</script>
</head>
<body id="list_body" bgcolor="#E9F0F8">
<form name="lybForm" action="../wcmdocument/leamassge" method="post">
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  		<tr>
   		<td class="all_title_left">&nbsp;</td>
    	<td class="all_title_bg">留言板</td>
    	<td class="all_title_right">&nbsp;</td>
  		</tr>
	</table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
			<tr>
				<td align="left" width="50%">
					<TABLE width="100%" align="center" height="150" border="0"
						cellpadding="0" cellspacing="1" style="border:1px solid #e7d3ac;">
						<TR bgcolor="#fffbdd">
							<TD colspan="2" valign="top" >
								<fieldset>
									<legend>
										<span id="block_37">您认为本平台使用是否便捷？</span>
									</legend>
									<!---显式定义一个BLOCK用来装载ITEM的容器，以指明ITEM集合的位置---->
									<table align="center" width="100%" border="0" cellpadding="0"
										cellspacing="1">
										<tr>
											<td><input type="radio" name="LYONE" id="LYONE" value=1>方便</td>
										</tr>
									</table>
									<table align="center" width="100%" border="0" cellpadding="0"
										cellspacing="1">
										<tr>
											<td><input type="radio" name="LYONE" id="LYONE" value=0>不方便</td>
										</tr>
									</table>
									<br>
								</fieldset> <br/>
								<fieldset>
									<legend>
										<span id="block_39">您对本平台是否满意？</span>
									</legend>
									<!---显式定义一个BLOCK用来装载ITEM的容器，以指明ITEM集合的位置---->
									<table align="center" width="100%" border="0" cellpadding="0"
										cellspacing="1">
										<tr>
											<td><input type="radio" name="LYTWO" value=1>是</td>
										</tr>
									</table>
									<table align="center" width="100%" border="0" cellpadding="0"
										cellspacing="1">
										<tr>
											<td><input type="radio" name="LYTWO" value=0>否</td>
										</tr>
									</table>
									<br>
								</fieldset>
							</TD>
						</TR>
					</TABLE>
					<br/>
					<br/>
				</td>
				<td width="50%">
					<table width="100%" align="center" height="150" >
						<tr>
							<td style="font-size: 16px; font-weight: bold;">您对本平台的意见或建议？</td>
						</tr>
						<tr>
							<td>请遵纪守法并注意语言文明（最多为1000个汉字）</td>
						</tr>
						<tr>
							<td><textarea id="LMSG" name="LMSG"
									style="width: 550px; height: 180px;background-color:#fffbdd;border:1px solid #e7d3ac;" rows=8 cols=70 ></textarea></td>
						</tr>
					</table>
					<br/>
					<br/>
					<br/>
				</td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0">
			<tbody align="center">
				<tr align="center">
					<td width="500">&nbsp;&nbsp;</td>
					<td><img src="${ctxStatic}/lawyer/images/tijiao.jpg"
						width="72" height="30" onclick="validate()" /></td>
					<td width="10">&nbsp;&nbsp;</td>
					<td width="10">&nbsp;&nbsp;</td>
					<%-- <td><img src="${ctxStatic}/lawyer/images/button_back.jpg"
						width="72" height="30" /></td> --%>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
