<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head></head>
<body>
<!-- <FORM NAME="frmAction" ID="frmAction" METHOD=POST target="_self" ACTION="./leamassge_addedit_dowith.jsp" style="margin-top:0">
	<input type="hidden" name="lawyerId" value="">

<TABLE width="1001" height="100%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
    	<td height="251" background="../extends/images/yypt5.jpg" align="right">&nbsp;</td>
  	</tr>
	<tr>
    <td valign="top" background="../extends/images/lsyypt23.gif">
    	<table width="791" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr><td height="46">&nbsp;</td></tr>
        <tr><td height="107" background="../extends/images/lsyypt241.gif" align="right">&nbsp;<a href="./leamassge_viewList_new.jsp?lawyerId=be4ea7c3bc484408b0eba720642689d5" style="text-decoration:none;"><span style="color:red;"><strong>历史留言>></strong></span></a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF"><table width="75%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody>
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
					<tr style="display:none">
							<td width="60" align="left">表ID：</td>
							<td><INPUT id="PID" name="PID" type="text" style="width:100px" elname="表ID属性" pattern="integer" not_null="0" value="be4ea7c3bc484408b0eba720642689d5"><span class="font_red">*</span></td>
					</tr>
					<tr style="display:none">
							<td width="60" align="left">留言者姓名：</td>
							<td><INPUT id="LMUSERNAME" name="LMUSERNAME" type="text" style="width:250px" elname="留言者姓名属性" pattern="string" not_null="0" value="测试员1"><span class="font_red">*</span></td>
					</tr>
					<tr>
                      <td  width="598" height="260" colspan="2">
					  <TABLE width="550" align="center" height="150" border="0" cellpadding="0" cellspacing="1" style="border:gray solid 1px">
						<TR bgcolor="#FFFFFF">
						<TD colspan="2" valign="top" style="padding:10px">-显式定义一个POLL用来装载BLOCK的容器，以指明POLLBLOCK集合的位置-- 
						<fieldset>
							<legend><span id="block_37">您认为本平台使用是否便捷？</span></legend> -显式定义一个BLOCK用来装载ITEM的容器，以指明ITEM集合的位置--
							<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr>
								<td>-定义一个ITEM的显示，内容-- 
								<input type="radio" name="LYONE" id="LYONE" value=1>方便</td>
							</tr>
							</table>
							<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr>
								<td>-定义一个ITEM的显示，内容-- 
								<input type="radio" name="LYONE" id="LYONE" value=0>不方便</td>
							</tr>
							</table>
							<br>
							</legend>
						</fieldset>
						<br>
						<fieldset>
							<legend><span id="block_39">您对本平台是否满意？</span></legend> -显式定义一个BLOCK用来装载ITEM的容器，以指明ITEM集合的位置--
							<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr>
								<td>-定义一个ITEM的显示，内容-- 
								<input type="radio" name="LYTWO" value=1>是</td>
							</tr>
							</table>
							<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr>
								<td>-定义一个ITEM的显示，内容-- 
								<input type="radio" name="LYTWO" value=0>否</td>
							</tr>
							</table>
							<br>
							</legend>
						</fieldset>
						<br>	
						</TD>
						</TR>
					</TABLE>
					</td>
				</tr>
			</tbody>
			</table>
			</td>
			</tr>
			<tr>
               <td colspan="2">
               	<table cellpadding="0" cellspacing="0" border="0" align="center" width="550">
				<tr><td style="font-size:16px; font-weight:bold;">您对本平台的意见或建议？</td></tr>
				<tr><td>
					<table cellspacing=0 cellpadding=0 border=0> 
			  			<tr><td align="left" ></td></tr>
			  			<tr><td class=l15 height="37">请遵纪守法并注意语言文明（最多为1000个汉字）</td></tr>
			  			<tr><td height=80><textarea id="LMSG" name="LMSG" style="width:550px" rows=8 cols=70></textarea></td></tr>
			  			<tr><td align="right" height="20"></td></tr>
					</table>
				</td></tr>
				</table>
				</td>
             </tr>
            </tbody>
            </table>
			</td>
			</tr>
			</table>
			</td>
			</tr>		
			<TR>
				<TD align="center">
				<script src="../js/CTRSButton.js"></script> 
					<script>
						//定义一个TYPE_ROMANTIC_BUTTON按钮
						var oTRSButtons		= new CTRSButtons();
						
						oTRSButtons.cellSpacing	= "0";
						oTRSButtons.nType	= TYPE_ROMANTIC_BUTTON;

						oTRSButtons.addTRSButton("确定", "submitForm()");
						
						oTRSButtons.addTRSButton("取消", "window.close();");
						
						oTRSButtons.draw();	
					</script>
				</TD>
			</TR>			
</TABLE>	 	
</FORM>-->
hello
<%
 out.print( request.getAttribute("msg"));


%>

</body>
</html>
