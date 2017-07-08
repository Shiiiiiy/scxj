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
<script>
function printPage()  
{  
    $("#printImg").css("display","none");  
    window.print();   
    $("#printImg").css("display","");  
    return false;  
} 
</script>
<body >
<table width="96%" align="center">
	<tr>
	<td align="center" height="90" ><span style="font-size:16px;"><strong>${lawyerApply.groupName}律师预约单</strong><br><br></span><span style="font-size:12px;">联系电话：${groupTel}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系地址：${groupAdd}<br />接待时间：${groupTime}</span></td>
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
	<td class="one" width="22%">&nbsp;${lawyerApply.lawyerName}</td>
	<td class="one" width="20%">律师事务所</td>
	<td class="two">&nbsp;${lawyerApply.lawfirmName}</td>
</tr>
<tr > 
	<td class="one" >执业证号</td>
	<td class="one">&nbsp;${lawyerApply.lawyerCardnum}</td>
	<td class="one">联系电话</td>
	<td class="two">&nbsp;${lawyerApply.lawyerTel}</td>
</tr>
<tr height="8">
	<td class="three">身份证号</td>
	<td class="three" >&nbsp;${lawyerApply.lawyerIdcode}</td>
	<td class="three">联系Email</td>
	<td >&nbsp;${lawyerApply.lawyerEmail}</td>
</tr>
</table>
<br /><br />
<table width="90%" align="center">
	<tr>
	<td align="left"><span style="font-size:14px; border:thick">预约事项</span></td>
	<td align="right"><span style="font-size:14px; border:thick">流水号：${lawyerApply.searchCode}</span></td>
	</tr>
</table>
<table cellspacing="0" class="sTable" width="90%" align="center">
<tr>
	<td class="one" width="42%">犯罪嫌疑人/被告人姓名</td>
	<td class="two">&nbsp;${lawyerApply.suspectsName}</td>
</tr>
<tr>
	<td class="one">案由</td>
	<td class="two">&nbsp;${lawyerApply.brief}</td>
</tr>
<tr>
	<td class="one">诉讼参与人类别</td>
	<td class="two">${lawyerApply.relation}</td>
</tr>
<tr>
	<td class="one">诉讼阶段</td>
	<td class="two">${lawyerApply.caseType}</td>
</tr>
<tr>
	<td class="one">预约事项类别</td>
	<td class="two">&nbsp;${lawyerApply.applyMatterType}</td>
</tr>
<tr>
	<td class="one">预约说明</td>
	<td class="two">&nbsp;${lawyerApply.reservation}</td>
</tr>
<tr >
	<td class="three">拟预约时间</td>
	<td height="32" >&nbsp;${lawyerApply.orderDate}</td>
</tr>
</table>
<br />

<br />
<table width="90%" align="center">
	<tr>
	<td align="center" width="15%"><input type="button" value="打印" onclick="printPage();" id="printImg"/></td>
	</tr>
</table>
<br /><br />

</body>
</html>
