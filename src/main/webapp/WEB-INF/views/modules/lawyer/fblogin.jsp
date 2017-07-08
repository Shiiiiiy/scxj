<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>
<head>
<meta name="renderer" content="ie-comp">
<meta name="renderer" content="ie-stand">
<meta http-equiv="X-UA-Compatible"content="IE=7;IE=8;IE=9;"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>上海市人民检察院非本地律师查询</title>
<script type="text/javascript">

function sub(){
	if($("#lawyercardnum").val()==null || $("#lawyercardnum").val()==""){
		alert("【执业证号】不能为空，请重新输入");
		return false;
	}
	if($("#searchpass").val()==null || $("#searchpass").val()==""){
		alert("【查询密码】不能为空，请重新输入");
		return false;
	}
	$("#pageNumHid").val($("#pageNum").val());
	$("#searchForm").submit();
	
}
function changePage(state){
	var tot=$("#total").val();
	if(state=='sy'){
		$("#pageNumHid").val(1);
		$("#pageNum").val(1);
		sub();
	}else if(state=='my'){
		$("#pageNumHid").val(tot);
		$("#pageNum").val(tot);
		sub();
	}else if(state=='last'){
		if($("#pageNum").val()==1){
			alert('已到首页');
			return;
		}
		var num=$("#pageNum").val()-1;
		$("#pageNum").val(num);
		$("#pageNumHid").val(num);
		sub();
	}else if(state=='next'){
		if($("#pageNum").val()==tot){
			alert('已到末页');
			return;
		}
		var num=$("#pageNum").val();
		num=num-1+2;
		$("#pageNum").val(num);
		$("#pageNumHid").val(num);
		sub();
	}
}
</script>
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
    <td class="all_title_bg">在线查询</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
  <tr>
    <td valign="top">
   <form  id="searchForm" name="searchForm"  action="/l/lawyer/fblist"  >
    <input type="hidden" value="${pageNumHid}" name="pageNumHid" id="pageNumHid" />
    <input type="hidden" value="${total}" name="total" id="total" />
    <div class="search">
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="25px" align="right" style="font-size:14px;font-weight:bold;"><span class="fontcol">*</span>执业证号：</td>
          <td>
            <input type="text" name="lawyercardnum" id="lawyercardnum" value="${lawyercardnum}"  class="search_input" style="width:210px;height:25px;line-height:25px;"/>
          </td>
          <td align="right" style="font-size:14px;font-weight:bold;"><span class="fontcol">*</span>查询密码：</td>
          <td><input type="text" name="searchpass" id="searchpass" value="${searchpass}" class="search_input" style="width:170px;height:25px;line-height:25px;"/></td>
           <td align="right" style="font-size:14px;">流水号：</td>
          <td><input type="text" name="searchcode" id="searchcode" class="search_input" style="width:170px;height:25px;line-height:25px;" /></td>
          <td>&nbsp;&nbsp; </td>
        </tr>
        <tr>
          <td height="35" align="right"  style="font-size:14px;">犯罪嫌疑人/被告人姓名：</td>
          <td>
            <input type="text" name="suspectsname" id="suspectsname"  class="search_input" style="width:210px;height:25px;line-height:25px;"/>
          </td>
          <td align="right" style="font-size:14px;">检察院：</td>
          <td>
          	<select id="groupid" name="groupid" style="width:170px;height:25px;" class="search_input">
                <option value="" >------ 请 选  择 ------</option>
				<option value="3" >&nbsp;&nbsp;上海市人民检察院</option>
				<option value="4" >&nbsp;&nbsp;上海市检察院一分院</option>
				<option value="5" >&nbsp;&nbsp;上海市检察院二分院</option>
				<option value="23" >&nbsp;&nbsp;上海市检察院铁路分院</option>
				<option value="6" >&nbsp;&nbsp;浦东新区人民检察院</option>
				<option value="7" >&nbsp;&nbsp;徐汇区人民检察院</option>
				<option value="8" >&nbsp;&nbsp;长宁区人民检察院</option>
				<option value="9" >&nbsp;&nbsp;闵行区人民检察院</option>
				<option value="10" >&nbsp;&nbsp;金山区人民检察院</option>
				<option value="11" >&nbsp;&nbsp;松江区人民检察院</option>
				<option value="12" >&nbsp;&nbsp;奉贤区人民检察院</option>
				<option value="13" >&nbsp;&nbsp;黄浦区人民检察院</option>
				<option value="14" >&nbsp;&nbsp;静安区人民检察院</option>
				<option value="15" >&nbsp;&nbsp;普陀区人民检察院</option>
				<option value="16" >&nbsp;&nbsp;闸北区人民检察院</option>
				<option value="17" >&nbsp;&nbsp;虹口区人民检察院</option>
				<option value="18" >&nbsp;&nbsp;杨浦区人民检察院</option>
				<option value="19" >&nbsp;&nbsp;宝山区人民检察院</option>
				<option value="20" >&nbsp;&nbsp;嘉定区人民检察院</option>
				<option value="21" >&nbsp;&nbsp;青浦区人民检察院</option>
				<option value="22" >&nbsp;&nbsp;崇明县人民检察院</option>
				<option value="24" >&nbsp;&nbsp;上海铁检院</option>
          	</select>
          </td>
          <td align="right" style="font-size:14px;">当前状态：</td>
          <td>
          	<select id="dealstatus" name="dealstatus" style="width:170px;height:25px;" class="search_input">
				<option value="">所有状态</option>
				<option  value="10">待审核</option>
				<option  value="11">未通过</option>
				<option  value="12">已通过</option>
				<option  value="13">尚未进入检察环节</option>
				<option  value="17">材料缺失</option>
				<option  value="18">材料补齐</option>
				<option  value="14">律师撤销绑定</option>
				<option  value="15">后台撤销委托</option>
				<option  value="16">结束</option>
          	</select>
          </td>
          <td>
          <input type="button"  id="subbutton" name="button" class="button_search" value=" " onclick="sub()" />
          &nbsp;&nbsp; 
          </td>
        </tr>
        </table>
    </div>
  </form>
 <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr class="list_title">
    <td class="td1">序号</td>
    <td class="td1">预约流水号</td>
    <td class="td1">案件名称</td>
    <td class="td1">申请时间</td>
    <td class="td1">检察院</td>
    <td class="td1">诉讼阶段</td>
    <td class="td1">状态</td>
  </tr>
 <c:forEach items="${list}" var="searchApply" varStatus="status">
	<tr  class="list_tr">
		<td align="center" style="font-size:12px;">${(pageNumHid-1)*10+status.index+1}&nbsp;</td>
		<td align="center" style="font-size:12px;">${searchApply.searchcode}&nbsp;</td>
		<td align="center" style="font-size:12px;">${searchApply.suspectsname}${searchApply.brief}案&nbsp;</td>
		<td align="center" style="font-size:12px;">${fns:getDateStr(searchApply.crtime)}&nbsp;</td>
		<td align="center" style="font-size:12px;">${searchApply.groupname}&nbsp;</td>
		<td align="center" style="font-size:12px;">${searchApply.czdlstage}&nbsp;</td>
		<td align="center" style="font-size:12px;">${fns:getStatuStr(searchApply.dealstatus)}&nbsp;</td>
	</tr>
</c:forEach>
</table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" height="10"></td>
        </tr>
      <tr>
        <td width="50%"></td>
        <td width="50%">
        <c:if test="${pageNumHid!='0'}"> 
        <ul class="pages" style="background-color:#E9F0F8;font-size:12px;">
        <li><a href="javascript:void(0)" onclick="changePage('sy')" style="font-weight:bold;width:30px;height:30px;">首页</a></li>
        <li><a href="javascript:void(0)" onclick="changePage('last')" style="font-weight:bold;width:30px;height:30px;"><<</a></li>
        <li><input type="text" value="${pageNumHid}" name="pageNum" id="pageNum" style="background-color:#E9F0F8;height:32px;line-height:32px;"/></li>
        <li><a href="javascript:void(0)" onclick="changePage('next')" style="font-weight:bold;width:30px;height:30px;">>></a></li>
        <li><a href="javascript:void(0)" onclick="changePage('my')" style="font-weight:bold;width:30px;height:30px;">末页</a></li>
        <li><a href="#" style="width:150px;height:30px;font-weight:bold;">共${totals}条记录,共 ${total}页</a></li>
        </ul>
        </c:if>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="10"></td>
        </tr>
    </table>
    </td>
  </tr>
</table>
<table id="dg"  singleSelect="true" fitColumns="false" width="100%" height="100%" align="center"></table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>

</body>
</html>
