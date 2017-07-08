<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>

<head><title>HTML Table</title></head>
<style type="text/css">
.sTable {
border-collapse: separate;
border: 1px solid #000000; }

.one{ border-left:none; border-right:1px solid #000000 ; border-bottom:1px solid ; font-size:14px; height:32px}
.two{ border-left:none; border-bottom:1px solid #000000 ;font-size:14px; height:32px}
.three{ border-left:none; border-right:1px solid #000000 ;font-size:14px; height:32px}


</style>
<body >
<table width="96%" align="center">
	<tr>
	<td align="center" height="90" ><span style="font-size:16px;"><strong>上海市人民检察院律师预约单</strong><br><br></span><span style="font-size:12px;">联系电话：24079825&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系地址：建国西路75号<br />接待时间：周一至周四上午9:15～11:00，下午1:30～4:30；周五下午1:30～4:30。</span></td>
	</tr>
</table>
<table width="90%" align="center">
<tr>
	<td align="left" headers="8"  width="50%"><span style="font-size:14px; border:thick">律师信息</span></td>
	
	</tr>
</table>
<table cellspacing="0" class="sTable" width="90%" align="center">
<tr >
	<td class="one" width="28%">律师姓名</td>
	<td class="one" width="22%">&nbsp;测试员1</td>
	<td class="one" width="20%">律师事务所</td>
	<td class="two">&nbsp;上海第1同道律师事务所</td>
</tr>
<tr > 
	<td class="one" >执业证号</td>
	<td class="one">&nbsp;13101201410000001</td>
	<td class="one">联系电话</td>
	<td class="two">&nbsp;18018883559</td>
</tr>
<tr height="8">
	<td class="three">身份证号</td>
	<td class="three" >&nbsp;31010120141201000001</td>
	<td class="three">联系Email</td>
	<td >&nbsp;dingni0392@163.com</td>
</tr>
</table>
<br /><br />
<table width="90%" align="center">
	<tr>
	<td align="left"><span style="font-size:14px; border:thick">预约事项</span></td>
	<td align="right"><span style="font-size:14px; border:thick">流水号：201605041656559</span></td>
	</tr>
</table>
<table cellspacing="0" class="sTable" width="90%" align="center">
<tr>
	<td class="one" width="42%">犯罪嫌疑人/被告人姓名</td>
	<td class="two">&nbsp;20160504</td>
</tr>
<tr>
	<td class="one">案由</td>
	<td class="two">&nbsp;故意伤害</td>
</tr>
<tr>
	<td class="one">诉讼参与人类别</td>
	<td class="two">&nbsp;</td>
</tr>
<tr>
	<td class="one">诉讼阶段</td>
	<td class="two">&nbsp;起诉阶段</td>
</tr>
<tr>
	<td class="one">预约事项类别</td>
	<td class="two">&nbsp;(二)申请查阅、摘抄、复制本案的案卷材料；</td>
</tr>
<tr>
	<td class="one">预约说明</td>
	<td class="two">&nbsp;</td>
</tr>
<tr >
	<td class="three">拟预约时间</td>
	<td height="32" >&nbsp;2016-05-10 上午 或</td>
</tr>
</table>
<br />

<br />
<table width="90%" align="center">
	<tr>
	<td align="center" width="15%"><input type="button" value="打印" onclick="window.print();" /></td>
	
	</tr>
</table>
<br /><br />

</body>
</html>
