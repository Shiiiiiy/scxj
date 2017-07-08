<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/news/mobile/include/taglib.jsp"%>
<html>
<head>
<title>上海检察院外网网站</title>
<meta name="decorator" content="${type}" />
<style type="text/css">
      .listspinner{position:relative; height:50px;padding-left:10px;padding-right:10px;padding-top:6px;padding-bottom:6px;font-size:16px;font-weight:bolder;vertical-align: middle;} 
      .time{position:absolute;right:0px;bottom:0px; font-size: 14px;color: #C5C5C5;}
</style>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
<!-- 
法制经纬 160
检察新闻 62
图片报道 61
外网公告 60
 -->
</head>
<body>

    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	<div class="row">
        <ul class="nav nav-list bs-docs-sidenav" id="content">
        <c:forEach items="${page.list}" var="wcmdocument">
         <li> <a href="${ctx}/news/wcmdocument/form?docid=${wcmdocument.docid}&type=${type}">
            <span>${fns:abbr(wcmdocument.doctitle,60)}</span>
            <span class="pull-right  bs-docs-sidenav-date">${wcmdocument.docpubtime}</span>
          </a>
         </li>
        </c:forEach>
        </ul>
      </div>
	<script type="text/javascript">
		var pageSize = $("#pageSize").val();
		$(function() {
			var range = 50; //距下边界长度/单位px
			var elemt = '500px'; //插入元素高度/单位px
			var maxnum = 20; //设置加载最多次数
			var num = 1;
			var totalheight = 0;
			var main = $("#content"); //主体元素
			$(window).scroll(
					function() {
						var srollPos = $(window).scrollTop(); //滚动条距顶部距离(页面超出窗口的高度)

						totalheight = parseFloat($(window).height())
								+ parseFloat(srollPos);
						if (($(document).height() - range) <= totalheight
								&& num != maxnum && $("#load").length == 0) {
							appendNews(srollPos);
						}
					});

			function loading() {
				if ($("#load").length == 0)
					main.append("<li id='load'><a href='#'><span class='row span4 text-center'>正在加载...</span></a></li>");
			}
			function unbindloading() {
				$("#load").remove();
			}
			function appendNews(stPos) {
				loading();
				var startRowNum = num * pageSize;
				var endRowNum = (num + 1) * pageSize + 1;
				$
						.ajax({
							url : '${ctx}/news/wcmdocument/refreshNews?startRowNum='
									+ startRowNum + '&endRowNum=' + endRowNum + '&docchannel=${wcmdocument.docchannel}',
							success : function(data) {
								data = eval("(" + data + ")");
								unbindloading();
								for ( var i = 0; i < data.length; i++) {
									var o = data[i];
									main.append("<li><a href=\"${ctx}/news/wcmdocument/form?docid="+o.id+"&type=${type}\"'><span>" + o.title 
											+"</span><span class='pull-right  bs-docs-sidenav-date'>"+o.docpubtime+"</span></li>");
								}
							}

						});
				num++;
			}
		});
	</script>
</body>
</html>


</body>
</html>
