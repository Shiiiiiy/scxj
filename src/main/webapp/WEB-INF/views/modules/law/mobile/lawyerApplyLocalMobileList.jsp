<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/law/mobile/include/taglib.jsp"%>
<html>
<head>
<title>诉讼业务办理管理</title>
<meta name="decorator" content="law_default" />
<style type="text/css">
      .listspinner{height:50px;padding-left:20px;padding-right:20px;padding-top:6px;padding-bottom:6px;font-size:17.5px;} 
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
	<form:form id="searchForm" modelAttribute="lawyerApply"
		action="${ctxf}/law/apply/list" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<label>查询号：</label>
		<form:input path="searchCode" htmlEscape="false" maxlength="50"
			class="input-medium" />
		<label>查询密码：</label>
        <form:input path="searchPass" htmlEscape="false" maxlength="50"
            class="input-medium" />
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit"
			value="查询" />
	</form:form>
	<tags:message content="${message}" />
	<table class="table table-condensed">
		<tbody>
			<c:forEach items="${page.list}" var="lawyerApply">
				<tr>
					<td>
						<div class="listspinner"
							onclick="location.href='${ctx}/law/apply/form?id=${lawyerApply.id}'">
							<div class="pull-right">${lawyerApply.caseType}</div>
							<div>${lawyerApply.brief}</div>
							${lawyerApply.suspectsName}
						</div>
					</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>
