<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible"content="IE=7;IE=8;IE=9;"/>
<title>上海市人民检察院律师服务平台</title>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/lawyer/css/layout.css"/>
<script type="text/javascript" src="${ctxStatic}/lawyer/scripts/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/lawyer/scripts/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(".def-nav,.info-i").hover(function(){
		$(this).find(".pulldown-nav").addClass("hover");
		$(this).find(".pulldown").show();
	},function(){
		$(this).find(".pulldown").hide();
		$(this).find(".pulldown-nav").removeClass("hover");
	});
	
});
function pointing(id,url){
	if(id == 'a'){
		document.getElementById("pointingto").innerText="诉讼业务办理";
	}else if(id == 'b'){
		document.getElementById("pointingto").innerText="诉讼流程查询";
	}else if(id == 'c'){
		document.getElementById("pointingto").innerText="留言板";
	}else{
		document.getElementById("pointingto").innerText="工作台";
	}
	parent.frames['main_frame'].location=url;
}
</script>
</head>
<body onload="initSideBar()">

<!--页面顶部开始-->
<div id="banner">
 

<div class="hd-main">	

<div class="logo"></div>
<div class="info">
	  <ul>
			<li class="info-i user-name has-pulldown">
				<em class="t-icon pull-arrow"></em>
				<a class="t-icon identity" href="javascript:void(0)" ></a>
				<span class="name top-username">联系电话</span>	
				<div class="pulldown user-info">
					<em class="arrow"></em>
					<div class="content" style="width:400px;height:500px;overflow-y:scroll">
						<span class="li" style="height:19px;"><a href="#">上海市人民检察院&nbsp;|&nbsp;建国西路75号&nbsp;|&nbsp;24079825</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">上海市人民检察院第一分院&nbsp;|&nbsp;淮海西路606号&nbsp;|&nbsp;32267400</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">上海市人民检察院第二分院&nbsp;|&nbsp;和田路17号&nbsp;|&nbsp;31105012</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">上海铁路运输检察分院&nbsp;|&nbsp;锦绣路3265号（成山路）&nbsp;|&nbsp;51223567</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">黄浦区人民检察院&nbsp;|&nbsp;建国中路22号&nbsp;|&nbsp;23520447</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">徐汇区人民检察院&nbsp;|&nbsp;浦北路268号&nbsp;|&nbsp;34768086</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">长宁区人民检察院&nbsp;|&nbsp;安顺路160号&nbsp;|&nbsp;62081100-31123</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">静安区人民检察院&nbsp;|&nbsp;昌平路1036号&nbsp;|&nbsp;62315556-812</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">普陀区人民检察院&nbsp;|&nbsp;北石路609号&nbsp;|&nbsp;52564588-4122</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">闸北区人民检察院&nbsp;|&nbsp;天目中路606号&nbsp;|&nbsp;22257280</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">虹口区人民检察院&nbsp;|&nbsp;唐山路902号&nbsp;|&nbsp;65852175</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">杨浦区人民检察院&nbsp;|&nbsp;河间路31号&nbsp;|&nbsp;65041876</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">闵行区人民检察院&nbsp;|&nbsp;凯诚路99号&nbsp;|&nbsp;64609443</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">宝山区人民检察院&nbsp;|&nbsp;友谊路959号&nbsp;|&nbsp;36558893</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">嘉定区人民检察院&nbsp;|&nbsp;德富路1231号&nbsp;|&nbsp;59105153</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">浦东新区人民检察院&nbsp;|&nbsp;丁香路633号&nbsp;|&nbsp;50138695</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">奉贤区人民检察院&nbsp;|&nbsp;南桥镇南奉公路9511号&nbsp;|&nbsp;67117803</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">松江区人民检察院&nbsp;|&nbsp;文诚路100号&nbsp;|&nbsp;37696358</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">金山区人民检察院&nbsp;|&nbsp;浩源路211号（金山大道)&nbsp;|&nbsp;51918381</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">青浦区人民检察院&nbsp;|&nbsp;华乐路399号&nbsp;|&nbsp;69720659</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">崇明县人民检察院&nbsp;|&nbsp;城桥镇人民路27号&nbsp;|&nbsp;59624091</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">上海铁检院&nbsp;|&nbsp;宝通路466弄64号&nbsp;|&nbsp;51224695</a></span>
					</div>
			  </div>			
			</li>
			<li class="info-i user-name has-pulldown">
				<em class="f-icon pull-arrow"></em>
				<a class="f-icon identity" href="javascript:void(0)" ></a>
				<span class="name top-username">${lawyerUser.name}</span>	
				<div class="pulldown user-info">
					<em class="arrow"></em>
					<div class="content" style="width:220px;height:80px;">
						<span class="li" style="height:19px;"><a href="#">事务所:${lawyerUser.lawfirmname}</a></span>
                        <span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">身份证号:${lawyerUser.idnumber}</a></span>
						<span class="separate-li"></span>
						<span class="li" style="height:19px;"><a href="#">执业证号:${lawyerUser.lisensenumber}</a></span>
					</div>
			  </div>			
			</li>
	        <li class="info-i default-text">
				<a class="notice" href="/static/lawyer/syxz.pdf" id="notificationTrigger">使用须知</a>
		    </li>
			<li class="info-i default-text">
				<a class="notice" href="/static/lawyer/readMe.pdf" id="notificationTrigger">帮助文件</a>
		    </li>
          <li class="info-i no-separate">
			  <span class="more"><a href="/l/lawyer/logout">退出登录</a></span>
	      </li>
          
	  </ul>
	</div>


<ul class="nav">
	<!-- <li id="nav1" onclick="setNav('nav',1,8)"><a href="/l/lawyer/wcmdocument/person_home" target="main_frame"><img src="${ctxStatic}/lawyer/images/nav_icon_b.png" align="absmiddle" /> 个人资料</a></li> -->
	<li id="nav1" onclick="setNav('nav',1,3);pointing('a','/l/lawyer/wcmdocument/ssyw_frame');" class="hover">
		<a href="javascript:void();">
		    <table width="100%" height="100%"><tr>
		    	<td width="25%" align="right"><img src="${ctxStatic}/lawyer/images/nav_icon_a.png" /> </td>
		    	<td width="75%" align="left" class="navmenu">诉讼业务办理</td>
			</tr></table>
		</a>
	</li>
	<li id="nav2" onclick="setNav('nav',2,3);pointing('b','/l/lawyer/wcmdocument/sslc_frame');" >
		<a href="javascript:void();">
		<table width="100%" height="100%"><tr>
		    <td width="25%" align="right"><img src="${ctxStatic}/lawyer/images/nav_icon_f.png" align="absmiddle" /> 
			<td width="75%" align="left" class="navmenu">诉讼流程查询</td>
		</tr></table></a>
	</li>
	<li id="nav3" onclick="setNav('nav',3,3);pointing('c','/l/lawyer/wcmdocument/liuyan_frame');">
		<a href="javascript:void();">
		<table width="100%" height="100%"><tr>
		<td width="25%" align="right"><img src="${ctxStatic}/lawyer/images/nav_icon_d.png" align="absmiddle" /> </td>
		<td width="75%" align="left" class="navmenu">留言板</td>
		</tr></table></a>
	</li>
</ul>

<div id="position" style="float: left">
	<table width="100%" align="left" height="100%"><tr>
		<td width="12px" align="right"><img src="${ctxStatic}/lawyer/images/position_icon.png" width="16" height="16" align="absmiddle" /></td>
 		<td width="*" align="left" class="gztmenu"><strong>当前所在位置：</strong><span id="pointingto">诉讼业务办理</span></td>
 	</tr></table>
 </div>
</div>
 
</div>

<!--菜单开始-->
<div id="menu"></div>

<!--控制条开始-->
<div id="ctrl"  onclick="showHideBar();" class="ctrl_hidden"><a></a></div>

<!--内容开始-->
<div id="content">
  <iframe src="/l/lawyer/wcmdocument/ssyw_frame" id="main_frame" name="main_frame" frameborder="0" width="100%" height="100%"></iframe>
</div>

<!--版权开始-->
<div id="footer" >上海市人民检察院 版权所有</div>

</body>
</html>
