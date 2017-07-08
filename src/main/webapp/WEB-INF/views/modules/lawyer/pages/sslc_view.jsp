<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>
<head>
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
//提交
function submitForm(){    
	if($("#suspectsname").val()==null || $("#suspectsname").val()==""){
		alert("【犯罪嫌疑人/被告人】不能为空，请重新输入！");
		return false;
	}if($("#brief").val()==null || $("#brief").val()==""){
		alert("【案由】不能为空，请重新输入");
		return false;
	}if($("#relation").val()==null || $("#relation").val()==""){
		alert("请选择【委托人与嫌疑人/被告人的关系】！");
		return false;
	}if($("#lawyertel").val()==null || $("#lawyertel").val()==""){
		alert("请在【联系电话】内正确输入11位手机号码！");
		return false;
	}if(!document.getElementById('queren').checked){
		alert("请先【确认】您的个人信息！");
		return false;	
	}	
	$("#sslcapply").submit();
}
function resetForm(){
	document.getElementById("SUSPECTSNAME").value="";
	document.getElementById("BRIEF").value="";
	document.getElementById('queren').checked=false;
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
    <td class="all_title_bg">诉讼流程>>信息查看</td>
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
  					  <li class="choose"><span class="fontcol"></span>预约流水号：</li>
		              <li class="choose"><span class="fontcol"></span>犯罪嫌疑人/被告人姓名：</li>
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span> 案由：</li>
		              <li class="choose"><span class="fontcol"></span>申请方式：</li>
		              <c:if test="${fn:length(searchApply.lawAppendixs)<5}" >
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		              <c:if test="${fn:length(searchApply.lawAppendixs)>=5}" >
		              <li class="choose" style="height: 120px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		              <li class="choose"><span class="fontcol"></span>承办检察院：</li>
		              <li class="choose"><span class="fontcol"></span>案件受理号：</li>
		              <li class="choose"><span class="fontcol"></span>案件诉讼阶段：</li>
		              <li class="choose"><span class="fontcol"></span>申请日期：</li>
		              <li class="choose"><span class="fontcol"></span>审核日期：</li>
		              <li class="choose"><span class="fontcol"></span>更新日期：</li>
		              <li class="choose"><span class="fontcol"></span>审核是否通过：</li>
		              <li class="choose"><span class="fontcol"></span>审核意见：</li>
		            </ul>
				</td>
  				<td width="50%" align="center">
  					<ul class="choose_menu">
  					  <li class="chooseinput">&nbsp;${searchApply.searchcode}</li>
		              <li class="chooseinput">&nbsp;${searchApply.suspectsname}</li>
		              <li class="chooseinput" style="height: 60px;">&nbsp;${searchApply.brief}</li>
		              <li class="chooseinput">&nbsp;${fns:getWayStr(searchApply.applyway)}</li>
		              <c:if test="${fn:length(searchApply.lawAppendixs)<5}" >
  					  	<li class="chooseinput" style="height: 60px;">
		              	<table height="56px" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
              				<tr>
		              		<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status">
							<td>
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
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
		              	<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status"   begin="0" end="3" >					
							<td>
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
							</td>
						</c:forEach>
						</tr>
						<tr>
		              	<c:forEach items="${searchApply.lawAppendixs}" var="lawAppendix" varStatus="status"   begin="4">					
							<td>
								<img src="/l/lawyer/wcmdocument/getSearchAppendixFile/${lawAppendix.appendixid}" width="60px" height="55px" style="float:left;border:0px;"/>
							</td>
						</c:forEach>
						</tr>
					</table>
  					</li>
  					</c:if>
		              <li class="chooseinput">&nbsp;${searchApply.groupname}</li>
		              <li class="chooseinput">&nbsp;${searchApply.caseaccepctnum}</li>
		              <li class="chooseinput">&nbsp;${searchApply.casestage}</li>
		              <li class="chooseinput">&nbsp;${fns:getDateStr(searchApply.crtime)}</li>
		              <li class="chooseinput">&nbsp;${fns:getDateStr(searchApply.dealdate)}</li>
		              <li class="chooseinput">&nbsp;${fns:getDateStr(searchApply.enddate)}</li>
		              <li class="chooseinput">&nbsp;${fns:getStatuStr(searchApply.dealstatus)}</li>
		              <li class="chooseinput">&nbsp;${searchApply.dealcontent}</li>
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
                <td align="center" class="lsxx_info">${searchApply.lawyername}<input name="lawyername" id="lawyername" type="hidden" size="28" value="${lawyerUser.name}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">身份证号：</td>
                <td align="center" class="lsxx_info">${searchApply.lawyeridcode}<input name="lawyeridcode" id="lawyeridcode" type="hidden" size="28" value="${lawyerUser.idnumber}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">执业证号：</td>
                <td align="center" class="lsxx_info">${searchApply.lawyercardnum}<input name="lawyercardnum" id="lawyercardnum" type="hidden" size="28" value="${lawyerUser.lisensenumber}" /></td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx">所在事务所名称：</td>
                <td align="center" class="lsxx_info">${searchApply.lawfirmname}<input name="lawfirmname" id="lawfirmname" type="hidden" size="28" value="${lawyerUser.lawfirmname}"/></td>
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
                <td align="center" class="lsxx_info">${searchApply.lawyertel}</td>
              </tr>
              <tr class="yw_list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol"></span>联系Email：</td>
                <td align="center" class="lsxx_info">${searchApply.lawyeremail}</td>
              </tr>
              
        </table>
            </td>
           </tr>
           <tr>
           	<td valign="middle" >
            	<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
            	    <tr><td width="96%" style="font-size: 14px;" align="center"></td></tr>
            		<tr><td width="96%" style="font-size: 14px;">&nbsp;</td></tr>
		   			<tr>
		   				<td width="96%" align="center">
				      		<img src="/static/lawyer/images/button_back.jpg"  onclick="javascript:history.back(-1);"/>
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

<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
