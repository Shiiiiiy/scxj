<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>诉讼业务办理管理</title>
	<meta name="decorator" content="default"/>
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
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/law/apply/">诉讼业务办理列表</a></li>
		<li class="active"><a href="${ctx}/law/apply/form?id=${lawyerApply.id}">诉讼业务办理<shiro:hasPermission name="law:lawyer:edit">${not empty lawyerApply.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="law:apply:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="lawyerApply" action="${ctx}/law/apply/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">犯罪嫌疑人姓名:</label>
			<div class="controls">
				<form:input path="suspectsName" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
            <label class="control-label">案由:</label>
            <div class="controls">
                <form:input path="brief" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">诉讼参与人类别:</label>
            <div class="controls">
                <form:input path="lawsuitPeopleType" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">诉讼阶段:</label>
            <div class="controls">
                <form:input path="caseType" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">预约事项类别:</label>
            <div class="controls">
                <form:input path="applyMatterType" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">预约事宜:</label>
            <div class="controls">
                <form:input path="reservation" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">拟预约时间:</label>
            <div class="controls">
                <form:input path="orderDate" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">律师联系电话:</label>
            <div class="controls">
                <form:input path="lawyerTel" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">律师Email:</label>
            <div class="controls">
                <form:input path="lawyerEmail" htmlEscape="false" maxlength="200" class="required"/>
            </div>
        </div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="accusation" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="law:lawyer:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
