<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/modules/law/mobile/include/taglib.jsp"%>
<html>
<head>
	<title>诉讼业务办理管理</title>
	<meta name="decorator" content="law_default"/>
	<style type="text/css">
      .listspinner{height:50px;padding-left:20px;padding-right:20px;padding-top:6px;padding-bottom:6px;font-size:17.5px;} 
    </style>
	<script type="text/javascript">
		$(document).ready(function() {
			openLawyerSearch();
		});

	    function openLawyerSearch() {
	        var pid = $("#personid").val();
	        var searchappid = $("#searchappid").val();
	        var lisensenumber = $("#lisensenumber").val();
	        AndroidFunction.openLawyerSearch(searchappid, pid,lisensenumber);
	    }
	</script>
</head>
<body>
	<form:form id="userForm" modelAttribute="lawyerUser" action="${ctx}/law/apply/save" method="post" class="form-horizontal">
	   <form:hidden path="personid"/>
	   <form:hidden path="lisensenumber"/>
	</form:form>
	<form:form id="lawyerForm" modelAttribute="searchApply" action="${ctx}/law/apply/save" method="post" class="form-horizontal">
        <form:hidden path="searchappid"/>
    </form:form>
</body>
</html>
