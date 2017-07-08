<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/lawyer/pages/headerInclude.jsp"%>
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
			$("#pageNumHid").val($("#pageCount").val());
			$("#pageNum").val($("#pageCount").val());
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
			if ($("#pageNum").val() == $("#pageCount").val()) {
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
		action="/l/lawyer/wcmdocument/lsly_list">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
		</table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">历史留言</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="all_content">
			<tr>
				<td valign="top"><input type="hidden" value="${pageNumHid}"
					name="pageNumHid" id="pageNumHid" /> <input type="hidden"
					value="${pageCount}" name="pageCount" id="pageCount" /> <input
					type="hidden" value="${record}" name="record" id="record"></input>
					<input type="hidden" readonly="true" value="${pageNumHid}"
					name="pageNum" id="pageNum" />
					<div class="search">
						<table width="98%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr align="center">
							</tr>
						</table>
					</div>
					<div>
						<table>
							<c:forEach items="${page.list}" var="msg" varStatus="status">
								<div>
									<table width="96%" border="0" align="center" cellpadding="0"
										cellspacing="0"
										style="border-right: 1px; border-top: 1px; border-left: 1px; border-color: #F5F5F5; border-bottom: 1px dashed">
										<tbody>
											<tr>
												<td  width="4%">时间：</td>
												<td width="96%" style="margin-left: 0" align="left"><font><strong>${fns:getDateStr(msg.crtime)}</strong></font></td>
											</tr>
											<tr>
												<td align="left"><img
													src="${ctxStatic}/lawyer/images/hdpt_bmwd_wen.jpg"
													width="35" height="17" /></td>
												<td width="97%" height="25" style="margin-left: 0" align="left"><font><strong>${msg.lmsg}</strong></font></td>
											</tr>
											<tr>
												<td align="left"><img
													src="${ctxStatic}/lawyer/images/hdpt_bmwd_da.jpg"
													width="35" height="17" /></td>
												<td width="90%" height="25" align="left">${msg.dealcontent}</td>
											</tr>
										</tbody>
									</table>
									<table width="96%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tbody>
											<tr>
												<td class="hdpt_line">&nbsp;</td>
											</tr>

										</tbody>
									</table>

								</div>


							</c:forEach>
						</table>
					</div>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2" height="10"></td>
			</tr>
			<tr align="center">
				<td align="center">共${record}条记录 |&nbsp; 共${pageCount}页|&nbsp;
					<a href="javascript:void(0)" onclick="changePage('sy')">首页|&nbsp;</a>
					<a href="javascript:void(0)" onclick="changePage('last')">上一页|&nbsp;</a>
					第${pageNumHid}页&nbsp; <a href="javascript:void(0)"
					onclick="changePage('next')">下一页|&nbsp;</a> <a
					href="javascript:void(0)" onclick="changePage('my')">末页&nbsp;</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="10"></td>
			</tr>
		</table>
	</form>
</body>
</html>
