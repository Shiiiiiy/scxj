<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>
<head>
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function setAllValue(){
	$("#relation option").each(function(){
	    if($(this).val()=='${searchApply.relation}'){
	        $(this).attr('selected',true);
	    }
	});
}
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
		prevDiv.innerHTML = '<img style="width:80px;height:56px;" src="' + evt.target.result + '" />';  
		}    
		reader.readAsDataURL(file.files[0]);  
	}else{  
		var url = getPath(file)

		prevDiv.innerHTML = '<div class="img" style="width:80px;height:56px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + url + '\')"></div>';  
	}  
}  

function getPath(obj) { 
	if (obj) {  
		if(window.navigator.userAgent.indexOf("MSIE") >= 1) {   
			obj.select();   
			return document.selection.createRange().text;  
		} else if(window.navigator.userAgent.indexOf("Firefox") >= 1){  
			if (obj.files){   
				return obj.files.item(0).getAsDataURL();   
			}   
			return obj.value;  
		}  
		return obj.value; 
		}
	}
</script>
</head>

<body id="list_body" onload="setAllValue();">
<form  method="post" id="sslcapply" name="sslcapply" modelAttribute="searchApply" action="/l/lawyer/wcmdocument/sslc/edit" enctype="multipart/form-data">
<input type="hidden" name="searchappid"   value="${searchApply.searchappid}" />
<input type="hidden" name="groupId"   value="${searchApply.groupid}" />
<input type="hidden" name="groupName" value="${searchApply.groupname}">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">诉讼流程>>修改</td>
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
		              <li class="choose"><span class="fontcol">*</span>上传证件：</li>
		              <li class="choose" style="height: 60px;">执业证：</li>
		              <li class="choose" style="height: 60px;">律所函：</li>
		              <li class="choose" style="height: 60px;">委托书：</li>
		              <li class="choose" style="height: 60px;">撤销委托书：</li>
		              <li class="choose" style="height: 60px;">关系证明：</li>
		              <c:if test="${fn:length(searchApply.lawAppendixs)<5}" >
		              <li class="choose" style="height: 60px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		              <c:if test="${fn:length(searchApply.lawAppendixs)>=5}" >
		              <li class="choose" style="height: 120px;"><span class="fontcol"></span>已上传证件：</li>
		              </c:if>
		            </ul>
				</td>
  				<td width="50%" align="center">
  					<ul class="choose_menu">
		              <li class="chooseinput"><input type="text" name="suspectsname" id="suspectsname" class="inputform" value="${searchApply.suspectsname}"/></li>
		              <li class="chooseinput" style="height: 60px;"><textarea name="brief" id="brief" class="inputform" style="height: 56px;line-height: 20px;" >${searchApply.brief}</textarea></li>
		              <li class="chooseinput">
		                <span class="inputform" style="border:0;overflow:hidden;height:30px;">
		              	<select name="relation" id="relation" class="inputform" style="margin:-1px;">					  
							<option value="">请选择</option>	
							<option value="本人">本人</option>
							<option value="夫妻">夫妻</option>
							<option value="父母">父母</option>
							<option value="子女">子女</option>
							<option value="同胞兄弟姐妹">同胞兄弟姐妹</option>	
							<option value="监护人">监护人</option>
							<option value="其他">其他</option>									
					  	</select>
					  	</span>
					  </li>
					  <li class="chooseinput"><a href="/static/lawyer/zhengjian1.jsp" target="_blank"><span class="fontcol">上传格式要求</span></a></li>
		              <li class="chooseinput" style="height: 60px;">
		              	<table border="0" align="center" cellpadding="0" cellspacing="0">
		              		<tr>
		              			<td width="80px"><div id="preview1" style="width:80px;height:56px;" style="border:none;"></div> </td>
		              			<td width="*"><input class="inputform" name="fileZyz" type="file" onchange="preview('preview1',this)" id="fileSfz1"/></td>
		              		</tr>
		              	</table>
		              </li>
		              <li class="chooseinput" style="height: 60px;">
		              	<table border="0" align="center" cellpadding="0" cellspacing="0">
		              		<tr>
		              			<td width="80px"><div id="preview2" style="width:80px;height:56px;" style="border:none;"></div> </td>
		              			<td width="*"><input class="inputform" name="filelsh" type="file" onchange="preview('preview2',this)" id="fileSfz2"/></td>
		              		</tr>
		              	</table>
		              </li>
		              <li class="chooseinput" style="height: 60px;">
		              	<table border="0" align="center" cellpadding="0" cellspacing="0">
		              		<tr>
		              			<td width="80px"><div id="preview3" style="width:80px;height:56px;" style="border:none;"></div> </td>
		              			<td width="*"><input class="inputform" name="filewts" type="file" onchange="preview('preview3',this)" id="fileSfz3"/></td>
		              		</tr>
		              	</table>
		              </li>
		              <li class="chooseinput" style="height: 60px;">
		              	<table border="0" align="center" cellpadding="0" cellspacing="0">
		              		<tr>
		              			<td width="80px"><div id="preview4" style="width:80px;height:56px;" style="border:none;"></div> </td>
		              			<td width="*"><input class="inputform" name="filecx" type="file" onchange="preview('preview4',this)" id="fileSfz4"/></td>
		              		</tr>
		              	</table>
		              </li>
		              <li class="chooseinput" style="height: 60px;">
		              	<table border="0" align="center" cellpadding="0" cellspacing="0">
		              		<tr>
		              			<td width="80px"><div id="preview5" style="width:80px;height:56px;" style="border:none;"></div> </td>
		              			<td width="*"><input class="inputform" name="filegx" type="file" onchange="preview('preview5',this)" id="fileSfz5"/></td>
		              		</tr>
		              	</table>
		              </li>
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
                <td align="center" class="lsxx_info">${lawyerUser.name}<input name="lawyername" id="lawyername" type="hidden" size="28" value="${lawyerUser.name}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">身份证号：</td>
                <td align="center" class="lsxx_info">${lawyerUser.idnumber}<input name="lawyeridcode" id="lawyeridcode" type="hidden" size="28" value="${lawyerUser.idnumber}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">执业证号：</td>
                <td align="center" class="lsxx_info">${lawyerUser.lisensenumber}<input name="lawyercardnum" id="lawyercardnum" type="hidden" size="28" value="${lawyerUser.lisensenumber}" /></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx">所在事务所名称：</td>
                <td align="center" class="lsxx_info">${lawyerUser.lawfirmname}<input name="lawfirmname" id="lawfirmname" type="hidden" size="28" value="${lawyerUser.lawfirmname}"/></td>
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
                <td align="center" bgcolor="#fffbdd"><input type="text" name="lawyertel" id="lawyertel" class="inputform" value="${searchApply.lawyertel}"/></td>
              </tr>
              <tr class="list_tr border_none">
                <td align="center" class="lsxx"><span class="fontcol">*</span>联系Email：</td>
                <td align="center" bgcolor="#fffbdd"><input type="text" name="lawyeremail"  id="lawyeremail" class="inputform" value="${searchApply.lawyeremail}"  /></td>
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
		   				<c:if test="${searchApply.dealstatus==17}">
				      		<img src="/static/lawyer/images/button_tj.jpg" onclick="submitForm()"/>
				   			&nbsp;&nbsp;&nbsp;&nbsp;
				   		</c:if>
				   			
				        	<img src="/static/lawyer/images/button_back.jpg" onclick="resetForm()"/>
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
</body>
</html>
