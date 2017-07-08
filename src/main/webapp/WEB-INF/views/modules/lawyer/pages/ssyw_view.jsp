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
<form id="ssywview" name="ssywview" action="" method="POST">
<input type="hidden" name="id"   value="${lawyerApply.id}" />
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">诉讼业务>>信息查看</td>
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
  					  <li class="choose"><span class="fontcol"></span>回复ID：</li>
  					  <li class="choose"><span class="fontcol"></span>预约流水号：</li>
		              <li class="choose"><span class="fontcol"></span>犯罪嫌疑人/被告人姓名：</li>
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>案由：</li>
  					  <li class="choose"><span class="fontcol"></span>诉讼参与人类别：</li>
  					  <li class="choose"><span class="fontcol"></span>诉讼阶段：</li>
  					  <li class="choose" style="height: 60px;"><span class="fontcol"></span>预约事项类别：</li>
  					  <li class="choose" style="height: 60px;"><span class="fontcol"></span>预约说明：</li>
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>拟预约时间：</li>
		              <c:if test="${fn:length(lawyerApply.lawAppendixs)<5}" >
		              <li class="choose" style="height:60px;"><span class="fontcol"></span>附件：</li>
		              </c:if>
		              <c:if test="${fn:length(lawyerApply.lawAppendixs)>=5}" >
		              <li class="choose" style="height: 120px;"><span class="fontcol"></span>附件：</li>
		              </c:if>
		              <li class="choose"><span class="fontcol"></span>申请时间：</li>
		              <li class="choose"><span class="fontcol"></span>更新时间：</li>
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>回复内容：</li>
		              <li class="choose"><span class="fontcol"></span>接待时间：</li>
		              <c:if test="${lawyerApply.isOntime>-1}">
		              	<li class="choose"><span class="fontcol"></span>承诺按时赴约：</li>
		              </c:if>
		              <li  id="TRreasonTit" class="choose" style="height: 60px;display:none"><span class="fontcol">*</span>
  					  	<c:if test="${lawyerApply.feedbackStatus == 20 }">取消理由:</c:if>
						<c:if test="${lawyerApply.feedbackStatus != 20 }">不能按时赴约理由:</c:if>
					  </li>
					</ul>
				</td>
  				<td width="50%" align="center">
  					<ul class="choose_menu">
  					<li class="chooseinput">&nbsp;${lawyerApply.id}</li>
  					<li class="chooseinput">&nbsp;${lawyerApply.searchCode}</li>
  					<li class="chooseinput">&nbsp;${lawyerApply.suspectsName}</li>
  					<li class="chooseinput" style="height: 60px;">&nbsp;${lawyerApply.brief}</li>
  					<li class="chooseinput">&nbsp;${lawyerApply.relation}</li>
  					<li class="chooseinput">&nbsp;${lawyerApply.caseType}</li>
  					<li class="chooseinput" style="height: 60px;line-height:15px;font-size:12px;">&nbsp;${lawyerApply.applyMatterType}</li>
  					<li class="chooseinput" style="height: 60px;">&nbsp;${lawyerApply.reservation}</li>
  					<li class="chooseinput" style="height: 60px;">&nbsp;${lawyerApply.orderDate}</li>
  					<c:if test="${fn:length(lawyerApply.lawAppendixs)<5}" >
  					<li class="chooseinput" style="height: 60px;">
  					 <table height="56px" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
              			<tr>
		              	<c:forEach items="${lawyerApply.lawAppendixs}" var="lawAppendix" varStatus="status">					
							<td>
								<img src="/l/lawyer/wcmdocument/getLawyerAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
							</td>
						</c:forEach>
						</tr>
					</table>
  					</li>
  					</c:if>
  					<c:if test="${fn:length(lawyerApply.lawAppendixs)>=5}" >
  					<li class="chooseinput" style="height: 120px;">
  					 <table height="56px" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
              			<tr>
		              	<c:forEach items="${lawyerApply.lawAppendixs}" var="lawAppendix" varStatus="status"   begin="0" end="3" >					
							<td>
								<img src="/l/lawyer/wcmdocument/getLawyerAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
							</td>
						</c:forEach>
						</tr>
						<tr>
		              	<c:forEach items="${lawyerApply.lawAppendixs}" var="lawAppendix" varStatus="status"   begin="4">					
							<td>
								<img src="/l/lawyer/wcmdocument/getLawyerAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
							</td>
						</c:forEach>
						</tr>
					</table>
  					</li>
  					</c:if>
  					<li class="chooseinput" style="height: 30px;">&nbsp;${fns:getDateStr(lawyerApply.crtime)}</li>
  					<li class="chooseinput" style="height: 30px;">&nbsp;${fns:getDateStr(lawyerApply.applyDate)}</li>
  					<li class="chooseinput" style="height: 60px;">&nbsp;${lawyerApply.dealContent}</li>
  					<li class="chooseinput" style="height: 30px;">&nbsp;${lawyerApply.receptionDate}</li>
		            <c:if test="${lawyerApply.isOntime>-1}">
		              	<li class="chooseinput">&nbsp;<c:if test="${lawyerApply.isOntime==0}">否</c:if><c:if test="${lawyerApply.isOntime!=0}">是</c:if></li>
		              </c:if>
		            <li id="TRreasonCon" class="chooseinput" style="height: 60px;display:none"><textarea name="notontimeReason" id="notontimeReason" class="inputform" style="height: 56px;line-height: 20px;"></textarea></li>
		            </ul>
				</td>
  			</tr>
		 </table>
      </td>
      <td width="20" rowspan="2">&nbsp;</td>
      <td width="*" valign="top" class="choose_bg">
        <span class="choose_title">律师信息</span>
          <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#dddddd" style="margin-top: 8px;">
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">姓名：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawyerName}<input name="lawyername" id="lawyername" type="hidden" size="28" value="${lawyerApply.lawyerName}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">身份证号：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawyerIdcode}<input name="lawyeridcode" id="lawyeridcode" type="hidden" size="28" value="${lawyerApply.lawyerIdcode}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">执业证号：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawyerCardnum}<input name="lawyercardnum" id="lawyercardnum" type="hidden" size="28" value="${lawyerApply.lawyerCardnum}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">所在事务所名称：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawfirmName}<input name="lawfirmname" id="lawfirmname" type="hidden" size="28" value="${lawyerApply.lawfirmName}"/></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">注册电话：</td>
                <td align="center" class="lsxx_info">${lawyerUser.mobile}</td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">注册Email：</td>
                <td align="center" class="lsxx_info">${lawyerUser.email}</td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol"></span>联系电话：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawyerTel}</td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol"></span>联系Email：</td>
                <td align="center" class="lsxx_info">${lawyerApply.lawyerEmail}</td>
              </tr>
              
        </table>
        </td>
          </tr>
           <tr>
           	<td valign="middle" >
            	<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
            		<tr><td width="96%" style="font-size: 14px;" align="center">
					<c:if test="${(lawyerApply.feedbackStatus==20) && lawyerApply.dealStatus!=15}">
							<input type="radio" name="dealType" value="0" style="border:none" />取消预约 &nbsp;
            		</c:if>
            		<c:if test="${(lawyerApply.ismiss !=1 && lawyerApply.feedbackStatus<=0 && lawyerApply.dealStatus!=13 && lawyerApply.dealStatus!=14 && lawyerApply.dealStatus!=15)}">
						<input type="radio" name="dealType" value="0" style="border:none" />取消预约 &nbsp;
            		</c:if>
            		<c:if test="${(lawyerApply.feedbackStatus==40)}">
            		<span style="color:red;">本预约没有及时回复确认，已被系统取消</span>
            		</c:if>
            		<c:if test="${(lawyerApply.feedbackStatus==30||lawyerApply.feedbackStatus==31)}">
            		<span style="color:red;">本预约已被您取消</span>
            		</c:if>
            		<c:if test="${(lawyerApply.feedbackStatus==35)}">
            		<span style="color:red;">本预约因为不能按时赴约已被您取消</span>
            		</c:if>
            		<c:if test="${(lawyerApply.feedbackStatus==34)}">
            		<span style="color:red;">本预约已回复确认后又被您取消</span>
            		</c:if>
					</td></tr>
					<tr><td width="96%" style="font-size: 14px;" align="center">
						<c:if test="${lawyerApply.ismiss!=1 && lawyerApply.feedbackStatus <= 0 && lawyerApply.dealStatus==13}">
							确认是否按时赴约：<input type="radio" name="isOntime" value="1" onClick="showReason(this)" style="border:none"/>是&nbsp;&nbsp;
								  <input type="radio" name="isOntime" value="0" onClick="showReason(this)" style="border:none"/>否
            			</c:if>
					</td>
					</tr>
            		<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
		   			<tr>
		   				<td width="96%" align="center">
		   					<img src="/static/lawyer/images/button_print.png"  onclick="window.open('/l/lawyer/wcmdocument/ssyw_dyview?id=${lawyerApply.id}')"/>
				      		&nbsp;&nbsp;&nbsp;
				      		<img src="/static/lawyer/images/button_tj.jpg" onclick="check()"/>
				      		&nbsp;&nbsp;&nbsp;
				        	<img src="/static/lawyer/images/button_back.jpg"  onclick="javascript:history.back(-1);" id="fh"/>
				        </td>
		   			</tr>
		   			<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
		   		</table>
		   		<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
		        	<tr>
		   				<td>&nbsp;</td>
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
function check(){
	var checkValue =yz("dealType");
	var checkOnTimeValue = yz("isOntime");
	if(checkValue==0){
		if(confirm("提示：预约取消后将不再恢复，如需再次预约必须重新申请，确定要取消该预约吗?")){
			$.ajax({
				url:'/l/lawyer/wcmdocument/ssyw/qxedit/${lawyerApply.id}',
				success:function(data) {
					//alter("预约已取消");
					//location.href=window.onload();
				}
			});
		}else {
			return false;
		}
	}else if(checkOnTimeValue>=0){//选择了是否按时赴约则可以直接提交；
		submitForm();
	}else{
		$("#fh").click();
	}
}	
//是否按时赴约
function showReason(num){
	var onTimeValue = num.value;
	if(onTimeValue==1){
		document.getElementById("TRreasonTit").style.display="none";
		document.getElementById("TRreasonCon").style.display="none";
	}else if(onTimeValue==0){
		document.getElementById("TRreasonTit").style.display="block";
		document.getElementById("TRreasonCon").style.display="block";
	}
}



//验证单选框是否选择
function yz(numValue){
	var b="";
	var a=document.getElementsByName(numValue);
	for(var i=0;i<a.length;i++)
	{
		if(a[i].checked==true)
		{
			return a[i].value;
		}
	}
	return -1;
}
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
	var b="";
	var a=document.getElementsByName("isOntime");
	for(var i=0;i<a.length;i++)
	{
		if(a[i].checked==true && a[i].value==0){
			if($("#notontimeReason").val()==null ||$("#notontimeReason").val()==""){
				alert("不能按时赴约理由不能为空，请重新填写！");
				return false;
			}
		}
	}
	$('#ssywview').attr('action', '/l/lawyer/wcmdocument/ssyw/ontimeedit');
	$("#ssywview").submit();
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
