<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%> 
<html>
<head>
<title>页面</title>
<script type="text/javascript">
	function sub() {
		$("#searchForm").submit();

	}
	function changePage(state) {

		if (state == 'sy') {
			$("#pageNumHid").val(1);
			$("#pageNum").val(1);
			sub();
		} else if (state == 'my') {
			if($("#pageNum").val()==$("#pageCount").val()){
				alert("已到末页")
				return;
			}
			sub();

		} else if (state == 'last') {
			if ($("#pageNum").val() == 1) {
				alert('已到首页');
				return;
			}
			var num = $("#pageNum").val() - 1;
			$("#pageNum").val(num);
			$("#pageNumHid").val(num);
			sub();

		} else if (state == 'next') {
			if ($("#pageNum").val() == 10) {
				alert('已到末页');
				return;
			}
			var num = $("#pageNum").val();
			num = num - 1 + 2;
			$("#pageNum").val(num);
			$("#pageNumHid").val(num);
			sub();
		}
	}
</script>
</head>
<body id="list_body">
	 <form id="searchForm" name="searchForm" modelAttribute="searchApply"
		action="/l/lawyer/wcmdocument/lyb_list"> 
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="all_content">
			<tr>
				<td valign="top"><input type="hidden" value="${pageNumHid}"
					name="pageNumHid" id="pageNumHid" />
					<input type="hidden" value="${pageCount}"
					name="pageCount" id="pageCount" />
					<div class="search">
						<table width="98%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr align="center">
								<a href="../wcmdocument/lyb_con"><font color="red" size="3">>>留言板</font></a>
							</tr>
						</table>
					</div>

					<table width="96%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr class="list_title">
							<td style="width:30px">序号</td>
							<td style="width:65px">提交时间</td>
							<td style="width:65px">是否便捷</td>
							<td style="width:65px">是否满意</td>
							<td style="width:30px">留言</td>
							<td style="width:65px">处理意见</td>
						</tr>
						<c:forEach items="${page.list}" var="msg"
							varStatus="status">
							<tr class="list_tr">
								<td align="center">${status.index+1}</td>
								<td align="center">${msg.crtime}</td>
								<td align="center">${msg.lyone}</td>
								<td  align="center">${msg.lytwo}</td>
								<td ><p style="text_indent:2em">${msg.lmsg}</p></td>
								<td align="center">${msg.cruser}</td>
							</tr>
						</c:forEach>
					</table>
					<table width="96%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>&nbsp;
						</tr>
					</table></td>
			</tr>
		</table>
		<table id="dg" singleSelect="true" fitColumns="false" width="100%"
			height="100%" align="center"></table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2" height="10"></td>
			</tr>
			<tr>
				<%--  <td width="50%"><img
					src="${ctxStatic}/lawyer/images/button_export.jpg" width="72"
					height="30" /></td>  --%>
				<td width="50%">
					<ul class="pages">
						<li><a href="javascript:void(0)" onclick="changePage('sy')">首页</a></li>
						<li><a href="javascript:void(0)" onclick="changePage('last')"><<</a></li>
						<li><input type="text" readonly="true" value="${pageNumHid}" name="pageNum" 
							id="pageNum"></li>
						<li><a href="javascript:void(0)" onclick="changePage('next')">>></a></li>
						<li><a href="javascript:void(0)" onclick="changePage('my')">末页</a></li>
					</ul>
				</td>
			</tr>
			<tr>

				<td colspan="2" height="10"></td>
			</tr>
		</table>
	</form> 
</body>
</html>
