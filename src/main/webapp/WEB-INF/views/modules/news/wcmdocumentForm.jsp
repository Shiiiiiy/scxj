<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/modules/news/mobile/include/taglib.jsp"%>
<html>
<head>
	<title>检察院andriod版新闻管理</title>
	<meta name="decorator" content="${type}"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	<style>
	.title{
	padding: 12px;
	}
	</style>
</head>
<body>
	<c:if test="${type eq 'portal_form_default'}">
	<div class="navbar navbar-fixed-top">
	      <div class="navbar-inner">
	        <div class="container">
	          <div class="container-fluid" style="text-align:center;" align="center">  
		          <ul id="main_nav" class="nav" style="width:100%;text-align: center;">
		             	<li style="width:100%;text-align: center;">
		           			 <a href=""><span>检察新闻</span></a>
		             	</li>
		          </ul>
	          </div>
	        </div>
	      </div>
    </div>
    <style>
	.title{
	padding-top:0px;
	}
	</style>
	</c:if>
<div>

     <div class="container title">
       <p><h5 class="text-center"> ${wcmdocument.doctitle}</h5></p>
       <p class="text-center"><small>发布时间：&nbsp;${wcmdocument.docpubtime}</small></p>
         <div class="content">${wcmdocument.docpubhtmlcon}</div>
     </div>
	<form:form id="inputForm" modelAttribute="wcmdocument" action="${ctx}/news/wcmdocument/save" method="post" class="container">
		<form:hidden path="docid"/>
		<tags:message content="${message}"/>
	</form:form>
</div>
</body>
</html>
