<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>
<head>
<title>页面</title>
<script type="text/javascript">

function sub(){
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
function putStatus(){
	var statu=$("#status").val();
	if(statu=='clz'){
		$("#dealStatus").val(101112);
		$("#ismiss").val(-1);
		$("#feedbackStatus").val(-1);
	}else if(statu=='yhf'){
		$("#dealStatus").val(13);
		$("#ismiss").val(-1);
		$("#feedbackStatus").val(-1);
	}else if(statu=='yqr'){
		$("#dealStatus").val(13);
		$("#ismiss").val(-1);
		$("#feedbackStatus").val(20);
	}else if(statu=='yqx'){
		//实际应为30/40/31/34/35进行 或  考虑长度给予一个代表 值
		$("#feedbackStatus").val(313435);
	}else if(statu=='yth'){
		$("#dealStatus").val(14);
	}else if(statu=='ysy'){
		$("#ismiss").val(1);
	}else if(statu=='jdwb'){
		$("#dealStatus").val(19);
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
   <form  id="searchForm" name="searchForm" modelAttribute="searchApply" action="/l/lawyer/wcmdocument/ajax/ssyw_list"  >
    <input type="hidden" value="${pageNumHid}" name="pageNumHid" id="pageNumHid" />
    <input type="hidden" value="${total}" name="total" id="total" />
    <input type="hidden" value="" name="dealStatus" id="dealStatus" />
    <input type="hidden" value="" name="ismiss" id="ismiss" />
    <input type="hidden" value="" name="feedbackStatus" id="feedbackStatus" />
    <div class="search">
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td align="right" style="font-size:14px;">诉讼阶段：</td>
          <td>
          	<select name="CASETYPE" class="search_input" style="width:210px;height:25px;line-height:25px;">
          				 <option value="">-- 请选择 --</option>
						 <option value="侦查阶段" >侦查阶段</option>
						  <option value="批捕阶段" >批捕阶段</option>
						  <option value="起诉阶段" >起诉阶段</option>
						  <option value="二审程序" >二审程序</option>
						  <option value="审判监督程序" >审判监督程序</option>
						  </select>
		  </td>
          <td height="35" align="right" style="font-size:14px;">犯罪嫌疑人/被告人姓名：</td>
          <td>
            <input type="text" name="suspectsname" id="suspectsname"  class="search_input" style="width:170px;height:25px;line-height:25px;"/>
          </td>
          <td align="right" style="font-size:14px;">流水号：</td>
          <td><input type="text" name="searchcode" id="searchcode" class="search_input" style="width:170px;height:25px;line-height:25px;" /></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="35" align="right" style="font-size:14px;">申请时间：</td>
          <td><input type="text" class="Wdate" id="StartDate" name="StartDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" style="width:95px;border:1px solid #cccccc;height:25px;line-height:25px;"/>
          	至<input type="text" class="Wdate" id="EndDate" name="EndDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" style="width:95px;border:1px solid #cccccc;height:25px;line-height:25px;"/>
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
          	 <select name="status" id="status" style="width:170px;height:25px;" class="search_input" onchange="putStatus()">
				<option value="" >--状态--</option>
				<option value="clz">处理中</option>
				<option value="yhf" >已回复</option>
				<option  value="yqr" >已确认</option>
				<option value="yqx" >已取消</option>
				<option value="yth" >已退回</option>
				<option value="ysy" >已爽约</option>
				<option value="jdwb" >接待完毕</option>
			</select>
          </td>
          <td>
          <input type="button"  id="subbutton" name="button" class="button_search" value=" " onclick="sub()"/>
          &nbsp;&nbsp; 
          </td>
        </tr>
        </table>
    </div>
  </form>
 <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr class="list_title">
    <td class="td1">序号</td>
    <td class="td1">回复ID</td>
    <td class="td1">预约流水号</td>
    <td class="td1">申请时间</td>
    <td class="td1">案件名称</td>
    <td class="td1">诉讼阶段</td>
    <td class="td1">检察院</td>
    <td class="td1">接待时间</td>
    <td class="td1">更新时间</td>
    <td class="td1">状态</td>
    <td class="td1">操作</td>
  </tr>
 <c:forEach items="${page.list}" var="lawyerApply" varStatus="status">
	<tr  class="list_tr" style="font-size:12px;">
		<td align="center" style="font-size:12px;">${(pageNumHid-1)*10+status.index+1}&nbsp;</td>
		<td align="center" style="font-size:12px;">${lawyerApply.id}&nbsp;</td>
		<td align="center" style="font-size:12px;">${lawyerApply.searchCode}&nbsp;</td>
		<td align="center" style="font-size:12px;">${fns:getDateStr(lawyerApply.crtime)}&nbsp;</td>
		<td align="center" style="font-size:12px;">${lawyerApply.suspectsName}${lawyerApply.brief}案</td>
		<td align="center" style="font-size:12px;">${lawyerApply.caseType}&nbsp;</td>
		<td align="center" style="font-size:12px;">${lawyerApply.groupName}&nbsp;</td>
		<td align="center" style="font-size:12px;">${lawyerApply.receptionDate}&nbsp;</td>
		<td align="center" style="font-size:12px;">${fns:getDateStr(lawyerApply.applyDate)}&nbsp;</td>
		<td align="center" style="font-size:12px;">${fns:getDealStr(lawyerApply.dealStatus,lawyerApply.ismiss,lawyerApply.feedbackStatus)}</td>
		<td align="center" style="font-size:12px;"><a href="/l/lawyer/wcmdocument/ssywview?id=${lawyerApply.id}">查看</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${(lawyerApply.dealStatus==10||lawyerApply.dealStatus==16)&&lawyerApply.feedbackStatus<=0}">
			  	<a href="/l/lawyer/wcmdocument/ssywedit?id=${lawyerApply.id}">修改</a>
		</c:if>
		<c:if test="${!((lawyerApply.dealStatus==10||lawyerApply.dealStatus==16)&&lawyerApply.feedbackStatus<=0)}">
			  	修改
		</c:if>
		</td>
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
        <ul class="pages" style="background-color:#E9F0F8;font-size:12px;">
         <li><a href="javascript:void(0)" onclick="changePage('sy')" style="font-weight:bold;">首页</a></li>
        <li><a href="javascript:void(0)" onclick="changePage('last')"><<</a></li>
        <li><input type="text" value="${pageNumHid}" name="pageNum" id="pageNum" style="background-color:#E9F0F8;height:32px;line-height: 32px;" /></li>
        <li><a href="javascript:void(0)" onclick="changePage('next')">>></a></li>
        <li><a href="javascript:void(0)" onclick="changePage('my')" style="font-weight:bold;">末页</a></li>
        <li><a href="#" style="width:150px;height:30px;font-weight:bold;">共${totals}条记录,共 ${total}页</a></li>
        </ul>
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
