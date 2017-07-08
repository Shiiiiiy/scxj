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
.center-block {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>
<script type="text/javascript">
	var pageNo;
	var pageSize;
	var totalNum;
	 $(document).ready(function() {
	     pageNo = $("#pageNo").val();
	     pageSize = $("#pageSize").val();
	     totalNum = $("#totalNum").val();
	 });
 
    $(function() {
        var range = 50; //距下边界长度/单位px
        var elemt = '500px'; //插入元素高度/单位px
        var maxnum = totalNum; //设置加载最多次数
        var num = 1;
        var totalheight = 0;
        var main = $("#content"); //主体元素
        $(window).scroll(
                function() {
                    var srollPos = $(window).scrollTop(); //滚动条距顶部距离(页面超出窗口的高度)
                    totalheight = parseFloat($(window).height())
                            + parseFloat(srollPos);
                    if (($(document).height() - range) <= totalheight
                            && num * pageSize < maxnum && $("#load").length == 0) {
                        pageNo++;
                        num = pageNo;
                        appendNews(srollPos);
                    }
                });

        function loading() {
            if ($("#load").length == 0)
                main
                        .append("<li id='load'><a href='#'><span class='row span4 text-center'>正在加载...</span></a></li>");
        }
        function unbindloading() {
            $("#load").remove();
        }
        function appendNews(stPos) {
	            loading();
	            $
	                    .ajax({
	                        url : '${ctx}/law/apply/listdata?pageNo='+pageNo+'&pageSize=${page.pageSize}',
	                        success : function(data) {
	                            data = eval("(" + data + ")");
	                            unbindloading();
	                            for ( var i = 0; i < data.length; i++) {
	                                var o = data[i];
	                                main.append("<li><a href=\"${ctx}/law/apply/form?id="+o.id+"\"'>" 
	                                        +"<span class=\"span4\">" + o.suspectsBriefName 
	                                        +"<span class=\"pull-right bs-docs-sidenav-date\">"+ o.dealDate+"</span></span>"
	                                        +"<span class=\"span4 list-divider\">&nbsp;</span>"
	                                        +"<span class=\"row span4\">"+o.status+"<span class='pull-right  bs-docs-sidenav-date'>"+o.receptionDate+"</span>"
	                                        +"</span></a></li>");
	                            }
	                        }
	
	                    });
        }
            
    });
</script>
</head>
<body>
	<div class="row" >
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <input id="totalNum" name="totalNum" type="hidden" value="${page.count}"/>
		<ul class="nav nav-list bs-docs-sidenav" id="content">
		    <li style="height:40px;background:#607B8B;color:white;">
		    	<span style="float:left;">案件名</span>
		    	<span style="float:right;">申请时间</span>
		        <br/>
		    	<span style="float:left;">状态</span>
		    	<span style="float:right;">接待时间</span>
		    </li>
			<c:forEach items="${page.list}" var="lawyerApply">
				<li><a href="${ctx}/law/apply/form?id=${lawyerApply.id}"> 
				        <span class="span4">${fns:abbr(lawyerApply.suspectsBriefName,36)} 
				        <span class="pull-right bs-docs-sidenav-date"><fmt:formatDate
                                    value="${lawyerApply.dealDate}" pattern="yyyy-MM-dd" /></span></span>
							<span class="span4 list-divider">&nbsp;</span>
						<span class="row span4">${lawyerApply.status} 
						<span class="pull-right bs-docs-sidenav-date">${lawyerApply.receptionDate}</span>
					</span>
				</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
