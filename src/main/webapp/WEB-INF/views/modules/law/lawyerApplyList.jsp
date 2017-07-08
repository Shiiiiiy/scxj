<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>诉讼业务办理管理</title>
	<meta name="decorator" content="default"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/law/apply/">诉讼业务办理列表</a></li>
		<shiro:hasPermission name="law:lawyer:edit"><li><a href="${ctx}/law/apply/form">诉讼业务办理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="lawyerApply" action="${ctx}/law/apply/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="brief" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>犯罪嫌疑人姓名</th>
		<th>案由</th><th>诉讼参与人类别</th><th>诉讼阶段</th><th>预约事项类别</th><th>预约事宜</th><th>拟预约时间</th><th>备注</th><shiro:hasPermission name="law:lawyer:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="lawyerApply">
			<tr>
				<td><a href="${ctx}/law/apply/form?id=${lawyerApply.id}">${lawyerApply.suspectsName}</a></td>
				<td>${lawyerApply.brief}</td>
				<td>${lawyerApply.lawsuitPeopleType}</td>
				<td>${lawyerApply.caseType}</td>
				<td>${lawyerApply.applyMatterType}</td>
				<td>${lawyerApply.reservation}</td>
				<td>${lawyerApply.orderDate}</td>
				<td>${lawyerApply.accusation}</td>
				<shiro:hasPermission name="law:lawyer:edit"><td>
    				<a href="${ctx}/law/apply/form?id=${lawyerApply.id}">修改</a>
					<a href="${ctx}/law/apply/delete?id=${lawyerApply.id}" onclick="return confirmx('确认要删除该诉讼业务办理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
