<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 

<html>
<head>
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.dTc {
	font-size: 12px;
	text-decoration: none;
	width:300px;
	border:solid 1px #E1E1E1;
	background-color: #F7F7F7;
	color:#333333;
	visibility:hidden;
	position: absolute;
	z-index: 200; 
	overflow: hidden;
	top:282px;
	left:560px;
}
.dTc p{ width:100%; background-color: #E1E1E1; height:26px; margin-top:0px}
.dTc p img{ float:right; margin-right:10px; margin-top:6px}
.dTc ul {padding:1px 12px 5px 12px;}
.dTc ul li{ font-size:12px; color:#333333; line-height:25px
}
</style>
</head>

<body id="list_body">
<form  id="ssywapply" name="ssywapply"  action="/l/lawyer/wcmdocument/ssyw/newSave" method="POST" enctype="multipart/form-data">
<input type="hidden" name="oldSearchId"   value="${searchApply.searchappid}" />
<input type="hidden" name="groupId"   value="${searchApply.groupid}" />
<input type="hidden" name="groupName" value="${searchApply.groupname}">
<input type="hidden" id="applyMatterType" name="applyMatterType" value=""/>
<input type="hidden" id="orderDate" name="orderDate" value="">

<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">诉讼业务>>预约</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
  <tr>
    <td valign="top">
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr><td>&nbsp;</td></tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="50%" valign="top" rowspan="2" class="choose_bg">
         <span class="choose_title">申请信息</span>
         <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
  			<tr>
  				<td width="50%" align="center">
  					<ul class="choose_menu">
		              <li class="choose"><span class="fontcol">*</span>犯罪嫌疑人/被告人姓名：</li>
		              <li class="choose" style="height: 60px;"><span class="fontcol">*</span> 案由：</li>
		              <li class="choose"><span class="fontcol">*</span>委托人与嫌疑人/被告人的关系：</li>
		              <li class="choose"><span class="fontcol">*</span>诉讼阶段：</li>
		              <li class="choose"><span class="fontcol">*</span>预约事项类别：</li>
		              <c:if test="${fn:length(searchApply.lawAppendixs)<5}" >
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		              <c:if test="${fn:length(searchApply.lawAppendixs)>=5}" >
		              <li class="choose" style="height: 120px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		              <li class="choose" style="height: 60px;">预约说明：</li>
		              <li class="choose">拟预约时间：</li>
		              <li class="choose" style="height: 60px;">请选择2－4个时间，以便我们安排!<br/><span class="fontcol">(*双击删除)</span></li>
		        	</ul>
				</td>
  				<td width="50%" align="center">
  					<ul class="choose_menu">
		              <li class="chooseinput">${searchApply.suspectsname}<input type="hidden" name="suspectsName" id="suspectsName" class="inputform" value="${searchApply.suspectsname}"/></li>
		              <li class="chooseinput" style="height: 60px;">${searchApply.brief}<input type="hidden" name="brief" id="brief" class="inputform" value="${searchApply.brief}"/></li>
		              <li class="chooseinput">${searchApply.relation}<input type="hidden" name="relation" id="relation" class="inputform" value="${searchApply.relation}"/></li>
					  <li class="chooseinput">
  						<select name="caseType" id="caseType" class="inputform" onChange="javascritp:if(this.value=='批捕阶段'){alert('请在审查批捕期限届满前三天申请预约!')};document.getElementById('APPLYMATTERTYPENUM').value='';javascritp:document.getElementById('applyMatterType').value='';">
								  <option value="">请选择</option>
								  <option value="侦查阶段">侦查阶段</option>
								  <option value="批捕阶段">批捕阶段</option>
								  <option value="起诉阶段">起诉阶段</option>
								  <option value="二审程序">二审程序</option>
								  <option value="审判监督程序">审判监督程序</option>
								  
						</select>	
  					  </li>
  					  <li class="chooseinput"><input type="text" id="APPLYMATTERTYPENUM" name="APPLYMATTERTYPENUM" value="" readonly class="inputform"   onFocus="showCaseType()" ></li>
					   <c:if test="${fn:length(searchApply.lawAppendixs)<5}" >
					   	<li class="chooseinput" style="height: 60px;">
		                <table height="56px" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
              			<tr>
		              	<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status">
							<td>	
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;"/>
								<input type="file" style="display:none" value="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}"/>
							</td>
						</c:forEach>
						</tr>
						</table>
		              	</li>
					  </c:if>
					  <c:if test="${fn:length(searchApply.lawAppendixs)>=5}" >
					  <li class="chooseinput" style="height: 120px;">
		                <table height="56px" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
              			<tr>
		              	<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status" begin="0" end="3">
							<td>	
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;"/>
								<input type="file" style="display:none" value="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}"/>
							</td>
						</c:forEach>
						</tr>
						<tr>
		              	<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status" begin="4">
							<td>	
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;"/>
								<input type="file" style="display:none" value="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}"/>
							</td>
						</c:forEach>
						</tr>
						</table>
		              	</li>
					  </c:if>
		              <li class="chooseinput" style="height: 60px;"><textarea name="reservation" id="reservation" class="inputform" style="height: 56px;line-height: 20px;"></textarea></li>
  					  <li class="chooseinput"><input id="selDate" name="selDate" class="Wdate" type="text"  style="width:120px;height:100%;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});clearAll();" readonly="readonly" >
            			<input type="checkbox" onClick="setDateTime(this);" id="AM" value="上午" style="width:20px;valign:top" />上午&nbsp;<input type="checkbox" id="PM" value="下午" onClick="setDateTime(this)" style="border:none;width:20px;"/>下午
				   	  </li>
				   	  <li class="chooseinput" style="height: 60px;">
  						<select id='s_orderDate' multiple='multiple' name='s_orderDate' ondblclick="removeItem();" class="inputform" style="height: 60px;"></select>
  					  </li>
		            </ul>
				</td>
  			</tr>
		 </table>
      </td>
      <td width="20" rowspan="2">&nbsp;</td>
      <td width="*" valign="top" class="choose_bg">
        <span class="choose_title">律师信息</span>
        <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#dddddd" style="margin-top: 8px;">
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">姓名：</td>
                <td align="center" class="lsxx_info">${lawyerUser.name}<input name="lawyerName" id="lawyerName" type="hidden" size="28" value="${lawyerUser.name}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">身份证号：</td>
                <td align="center" class="lsxx_info">${lawyerUser.idnumber}<input name="lawyerIdcode" id="lawyerIdcode" type="hidden" size="28" value="${lawyerUser.idnumber}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">执业证号：</td>
                <td align="center" class="lsxx_info">${lawyerUser.lisensenumber}<input name="lawyerCardnum" id="lawyerCardnum" type="hidden" size="28" value="${lawyerUser.lisensenumber}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">所在事务所名称：</td>
                <td align="center" class="lsxx_info">${lawyerUser.lawfirmname}<input name="lawfirmName" id="lawfirmName" type="hidden" size="28" value="${lawyerUser.lawfirmname}"/></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">注册电话：</td>
                <td align="center" class="lsxx_info">${lawyerUser.mobile}</td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">注册Email：</td>
                <td align="center" class="lsxx_info">${lawyerUser.email}</td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol">*</span>联系电话：</td>
                <td align="center" bgcolor="#fffbdd"><input type="text" name="lawyerTel" id="lawyerTel" class="inputform" value="${searchApply.lawyertel}"/></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol">*</span>联系Email：</td>
                <td align="center" bgcolor="#fffbdd"><input type="text" name="lawyerEmail"  id="lawyerEmail" class="inputform" value="${searchApply.lawyeremail}"  /></td>
              </tr>
              <tr class="list_tr border_none">
                <td colspan="2"  class="lsxx" align="center">（如以上信息有变动，请到市律师协会修改）</td>
              </tr>
              <tr class="list_tr border_none">
                <td colspan="2" align="center" class="lsxx">
                	<input id="queren" value="1" type="checkbox" style="border:none;width:20px;"/><span class="fontcol">*</span>我已确认以上信息
				</td>
              </tr>
        </table>
        </td>
          </tr>
           <tr>
           	<td valign="middle" >
            	<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
            		<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
            		<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
		   			<tr>
		   				<td width="96%" align="center">
		   					<c:if test="${fns:getStatuStr(searchApply.dealstatus)=='已通过'}">
				      		<img src="/static/lawyer/images/button_tj.jpg" onclick="submitForm()"/>
				   			</c:if>
				   			&nbsp;&nbsp;&nbsp;&nbsp;
				        	<img src="/static/lawyer/images/button_back.jpg" onclick="javascript:history.back(-1);"/>
				        </td>
		   			</tr>
		   			<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
		   		</table>
		   		<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
		        	<tr>
		   				<td>&nbsp;</td>
		   			</tr>
		   			<tr>
		   				<td width="96%"  style="font-size: 14px;">
		   				    <span style="font-weight: bold;">联系电话：</span>${groupTel} &nbsp; &nbsp; &nbsp; &nbsp;<span style="font-weight: bold;">联系地址：</span>${groupAdd}<br/>
		   				    <span style="font-weight: bold;">接待时间：</span>${groupTime}
		   				</td>
		   			</tr>
		   		</table>
            </td>
           </tr>
        </table>
        </td>
      </tr>
	  <tr><td width="96%" style="font-size: 14px;"></td></tr>
	  <tr><td>&nbsp;</td></tr>
</table>
</form>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<div id="jcjd" class="dTc">
	<p><img src="/static/lawyer/images/closebt.gif"  border="0" onClick="document.getElementById('jcjd').style.visibility='hidden'"/></p>
	<ul>
	<li><input id="jcjd1" type="checkbox" onClick="setValue(this)" title="(一)" value="(一)提出听取意见的要求；">(一)提出听取意见的要求；</li>
	<li><input id="jcjd2" type="checkbox" onClick="setValue(this)" title="(二)" value="(二)刑诉法规定的其他可以预约事项；">(二)刑诉法规定的其他可以预约事项；</li>
	
	</ul>
		
</div>
<div id="pbjd" class="dTc">
	<p><img src="/static/lawyer/images/closebt.gif"  border="0" onClick="document.getElementById('pbjd').style.visibility='hidden'"/><br>
	<ul>
	<li><input id="pbjd1" type="checkbox" onClick="setValue(this)" title="(一)" value="(一)在审查逮捕过程中，提出不需要逮捕犯罪嫌疑人的意见；">(一)在审查逮捕过程中，提出不需要逮捕犯罪嫌疑人的意见；</li>
	<li><input id="pbjd2" type="checkbox" onClick="setValue(this)" title="(二)" value="(二)提出听取意见的要求；">(二)提出听取意见的要求；</li>
	<li><input id="pbjd3" type="checkbox" onClick="setValue(this)" title="(三)" value="(三)刑诉法规定的其他可以预约事项；">(三)刑诉法规定的其他可以预约事项；</li>
	
	</ul>
		
</div>
<div id="qsjd" class="dTc">
	<p><img src="/static/lawyer/images/closebt.gif"  border="0" onClick="document.getElementById('qsjd').style.visibility='hidden'"/></p>
	<ul>
	<li><input id="qsjd1" type="checkbox" onClick="setValue(this)" title="(一)" value="(一)提出听取意见的要求；">(一)提出听取意见的要求；</li>
	<li><input id="qsjd2" type="checkbox" onClick="setValue(this)" title="(二)" value="(二)申请查阅、摘抄、复制本案的案卷材料；">(二)申请查阅、摘抄、复制本案的案卷材料；</li>
	<li><input id="qsjd3" type="checkbox" onClick="setValue(this)" title="(三)" value="(三)刑诉法规定的其他可以预约事项；">(三)刑诉法规定的其他可以预约事项；</li>
	
	</ul>
		
</div>
<div id="escx" class="dTc">
	<p><img src="/static/lawyer/images/closebt.gif"  border="0" onClick="document.getElementById('escx').style.visibility='hidden'"/></p>
	<ul>
	<li><input id="escx1" type="checkbox" onClick="setValue(this)" title="(一)" value="(一)提出听取意见的要求；">(一)提出听取意见的要求；</li>
	<li><input id="escx2" type="checkbox" onClick="setValue(this)" title="(二)" value="(二)申请查阅、摘抄、复制本案的案卷材料；">(二)申请查阅、摘抄、复制本案的案卷材料；</li>
	<li><input id="escx3" type="checkbox" onClick="setValue(this)" title="(三)" value="(三)刑诉法规定的其他可以预约事项；">(三)刑诉法规定的其他可以预约事项；</li>
	</ul>
		
</div>
<div id="spjdcx" class="dTc">
	<p><img src="/static/lawyer/images/closebt.gif"  border="0" onClick="document.getElementById('spjdcx').style.visibility='hidden'"/></p>
	<ul>
	<li><input id="spjdcx1" type="checkbox" onClick="setValue(this)" title="(一)" value="(一)提出听取意见的要求；">(一)提出听取意见的要求；</li>
	<li><input id="spjdcx2" type="checkbox" onClick="setValue(this)" title="(二)" value="(二)申请查阅、摘抄、复制本案的案卷材料；">(二)申请查阅、摘抄、复制本案的案卷材料；</li>
	<li><input id="spjdcx3" type="checkbox" onClick="setValue(this)" title="(三)" value="(三)刑诉法规定的其他可以预约事项；">(三)刑诉法规定的其他可以预约事项；</li>				    </ul>
		
</div>

</body>
<script language="JavaScript">
function preview(id,file){  
	var prevDiv = document.getElementById(id);  
	if (file.files && file.files[0]) {  
		var reader = new FileReader();  
		reader.onload = function(evt){  
		prevDiv.innerHTML = '<img style="width:80px;height:60px;" src="' + evt.target.result + '" />';  
		}    
		reader.readAsDataURL(file.files[0]);  
	}else{  
		prevDiv.innerHTML = '<div class="img" style="width:80px;height:60px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
	}  
} 
function submitForm(){
	getSelectValue();
	if($("#suspectsName").val()==null || $("#suspectsName").val()==""){
		alert("【犯罪嫌疑人/被告人】不能为空，请重新输入");
		return false;
	}if($("#brief").val()==null || $("#brief").val()==""){
		alert("【案由】不能为空，请重新输入");
		return false;
	}if($("#relation").val()==null || $("#relation").val()==""){
		alert("请选择【委托人与嫌疑人/被告人】！");
		return false;
	}if($("#caseType").val()==null || $("#caseType").val()==""){
		alert("请选择【诉讼阶段】");
		return false;
	}
	if($("#applyMatterType").val()==null || $("#applyMatterType").val()==""){
		alert("【预约事项类别】不能为空，请重新选择");
		return false;
	}/*if(document.all.frma.RESERVATION.value==null || document.all.frma.RESERVATION.value==""){
		alert("预约说明不能为空，请重新输入！");
		return false;
	}*/
	if($("#orderDate").val()==null || $("#orderDate").val()==""){
		alert("【拟预约时间】不能为空，请重新选择");
		return false;
	}
	if($("#lawyerTel").val()==null || $("#lawyerTel").val()==""){
		alert("【联系电话】不能为空，请重新输入");
		return false;
	}
	if($("#lawyerEmail").val()==null || $("#lawyerEmail").val()==""){
		alert("【联系Email】不能为空，请重新输入");
		return false;
	}
	if(!document.getElementById('queren').checked){
		alert("请先【确认】您的个人信息");
		return false;
	
	}
	$("#ssywapply").submit();
}
function getSelectValue(){
	var s = document.getElementById("s_orderDate");
	var value = "";
	for(var i=0;i<s.options.length;i++){
		value+=s.options[i].value;
	}
	//return value;
	$("#orderDate").val(value);
}



//根据选择的“诉讼阶段”来展示相对应的预约事项类别
function showCaseType(){
	var code_Values = document.getElementById("caseType");  
	var  caseTypeValue ="";
	for(var i=0;i<code_Values.options.length;i++){
	   // alert(i); 
		var tempOption=code_Values.options[i];  
		
		if(tempOption.selected){
			caseTypeValue = tempOption.value;
		}   
	}
	if(caseTypeValue=="侦查阶段"){
		document.getElementById('jcjd').style.visibility='visible'
	}else if(caseTypeValue=="批捕阶段"){
		document.getElementById('pbjd').style.visibility='visible'
	}else if(caseTypeValue=="起诉阶段"){
		document.getElementById('qsjd').style.visibility='visible'
	}else if(caseTypeValue=="二审程序"){
		document.getElementById('escx').style.visibility='visible'
	}else if(caseTypeValue=="审判监督程序"){
		document.getElementById('spjdcx').style.visibility='visible'
	}
}
//设置选中的预约事项类别的值
function setValue(num){
	var id = num.id;
	
	var typeValue = document.getElementById("applyMatterType").value;
	var typeNumValue = document.getElementById("APPLYMATTERTYPENUM").value;
	if(document.getElementById(id).checked){
			//alert("您选择了'"+num.value+"'");
			typeValue += num.value;
			typeNumValue += num.title;
			document.getElementById("applyMatterType").value = typeValue; 
			document.getElementById("APPLYMATTERTYPENUM").value = typeNumValue;
						
		}else{
			//alert("您取消了'"+num.value+"'的选择");
			var begin = typeValue.indexOf(num.value);
			if(begin!=-1){				
				document.getElementById("applyMatterType").value = typeValue.replace(num.value,"");
				document.getElementById("APPLYMATTERTYPENUM").value = typeNumValue.replace(num.title,"");;
			}
			
		}
}
//获取当前时间
function CurentTime(num)
    { 
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate()+num;          //日
       
        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分
       
        var clock = year + "-";
       
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day+" ";
        
		 if(hh < 10)
		 clock += "0";           
		 clock += hh + ":";
		 if (mm < 10) clock += '0'; 
		 clock += mm; 
		
       
        return(clock); 
    } 
//选中“上午”或“下午时”，将日期和选中的时间段放在select中
function setDateTime(num){
	var id = num.id;
	var selDateValue = document.getElementById("selDate").value;
	
	if(selDateValue==null || selDateValue==""){
		alert("请先选择【日期】");
		return false;
	}else{
		
		var specialDates = '2013-04-27,2013-04-28,2013-06-09,2013-06-08,2013-09-22,2013-09-29,2013-10-12,2014-02-08,2014-01-26,2014-05-04,2014-09-28,2014-10-11,2015-01-04,2015-02-15,2015-02-28,2015-09-06,2015-10-10,2016-02-06,2016-02-14,2016-06-12,2016-09-18,2016-10-08,2016-10-09,';//周末上班
		var disabledDates = '2013-04-29,2013-04-30,2013-05-01,2013-06-10,2013-06-11,2013-06-12,2013-09-19,2013-09-20,2013-10-01,2013-10-02,2013-10-03,2013-10-04,2013-10-07,2014-01-01,2014-01-31,2014-02-03,2014-02-04,2014-02-05,2014-02-06,2014-04-07,2014-05-01,2014-05-02,2014-06-02,2014-09-08,2014-10-01,2014-10-02,2014-10-03,2014-10-06,2014-10-07,2015-01-01,2015-01-02,2015-04-06,2015-05-01,2015-06-22,2015-10-01,2015-10-02,2015-10-05,2015-10-06,2015-10-07,2015-02-18,2015-02-19,2015-02-20,2015-02-23,2015-02-24,2015-09-03,2015-09-04,2016-01-01,2016-02-08,2016-02-09,2016-02-10,2016-02-11,2016-02-12,2016-04-04,2016-05-02,2016-06-09,2016-06-10,2016-09-15,2016-09-16,2016-10-03,2016-10-04,2016-10-05,2016-10-06,2016-10-07,';//周一至周五放假
		var dt2 = new Date(Date.parse(selDateValue.replace(/\-/g,"/")));
		var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
		var selWeek = weekDay[dt2.getDay()];
		if(((selWeek=="星期天" || selWeek=="星期六") && specialDates.indexOf(selDateValue)==-1)||(selWeek!='星期天' && selWeek!='星期六' && disabledDates.indexOf(selDateValue)!=-1)){
			alert(selDateValue+"不是工作日，请重新选择！");
			clearAll();
			return false;
			
		}

		
		var value = num.value;

		//判断接待时间是否晚于当前时间半个工作日
		//var orderDate = document.all.frma.RECEPTIONDATE.value;
		if(value!=null&& value!=""){
			var selTime = "";
			var now = "";
			if(value.indexOf("上午")>-1){
				now = CurentTime(1);
				selTime = selDateValue+" 12:00";
			}else if(value.indexOf("下午")>-1){
				now = CurentTime(1);
				selTime =  selDateValue+" 23:59";
			}
			if(selTime<=now){
				alert("当日12点前预约时间最早为次日上午；当日12点后预约时间最早为次日下午！");
				return false;
			}
		}
		
			
		if(document.getElementById(id).checked){
			//alert("您选择了'"+num.value+"'");
			var thisValue = selDateValue+" "+num.value+" 或 ";
			var s=document.getElementById("s_orderDate");  
			if(s.options.length<4){
				s.options[s.options.length] = new Option(thisValue,thisValue);
			}else{
				alert("抱歉，您最多只能预约4个时间段！");
				document.getElementById(id).checked = false;
				return false;
			}
			
		}/*else{
			//alert("您取消了'"+num.value+"'的选择");
			var begin = orderDate.indexOf(selDateValue+" "+num.value);
			if(begin!=-1){
				var end = orderDate.indexOf(";",begin);
				var str = orderDate.substring(begin,end+3);
				orderDate = orderDate.replace(str,"");
				document.getElementById("ORDERDATE").value = orderDate;
			}
			
		}*/
	}
		
}
function clearAll(){
	document.getElementById("AM").checked=false;
	document.getElementById("PM").checked=false;
}
//双击删除select选中的option
function removeItem(){
	var sltSrc=document.getElementById('s_orderDate');
	for(var i=0;i<sltSrc.options.length;i++)
	{
		var tempOption=sltSrc.options[i];
		if(tempOption.selected){
			sltSrc.removeChild(tempOption);
			//sltTarget.appendChild(tempOption);//移动到另一个select中
		}    
	}
}

</script>
</html>
