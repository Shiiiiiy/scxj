<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/law/mobile/include/taglib.jsp"%>
<html>
<head>
<title>诉讼业务办理管理</title>
<meta name="decorator" content="law_default" />
<style type="text/css">
.listspinner {
	height: 50px;
	padding-left: 12px;
	padding-right: 12px;
	padding-top: 6px;
	padding-bottom: 6px;
	font-size: 17.5px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>

    <tags:message content="${message}" />
	<form:form id="searchForm" modelAttribute="lawyerApply"
		action="${ctx}/law/apply/list" method="post"
		class="form-horizontal">
		<tags:message content="${message}"/>		
        <div class="control-group">
            
        </div> 
        <div class="control-group">
            <label class="control-label">犯罪嫌疑人姓名:</label>
            <div class="controls">
                <form:input path="suspectsName" htmlEscape="false" maxlength="200"/>
            </div>
            <label class="control-label">案由:</label>
            <div class="controls">
                <form:input path="brief" htmlEscape="false" maxlength="200" />
            </div>
            <label class="control-label">流水号:</label>
            <div class="controls">
                <form:input path="searchCode" htmlEscape="false" maxlength="200"/>
            </div>
        </div>    
        <div class="control-group">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;
        </div>
	</form:form>

</body>
</html>
