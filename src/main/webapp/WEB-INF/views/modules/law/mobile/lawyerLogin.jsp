<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/law/mobile/include/taglib.jsp"%>
<html>
<head>
<title>登录</title>
<meta name="decorator" content="law_default" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<style type="text/css">
html,body,table {
	background-color: #f5f5f5;
	width: 100%;
	height: 400px;
	text-align: center;
}

.form-signin-heading {
	font-size: 36px;
	margin-bottom: 20px;
	color: #0663a2;
}

.form-signin {
	position: relative;
	text-align: center;
	width: 300px;
	padding: 25px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .checkbox {
	margin-bottom: 10px;
	color: #0663a2;
}

.form-signin .input-label {
	font-size: 16px;
	line-height: 23px;
	color: #999;
}

.form-signin .input-block-level {
	font-size: 16px;
	height: auto;
	margin-top: 15px;
	margin-bottom: 15px;
	padding: 7px;
	*width: 200px;
	*padding-bottom: 0;
	_padding: 7px 7px 9px 7px;
}

.form-signin .btn.btn-large {
	font-size: 16px;
}

.form-signin #themeSwitch {
	position: absolute;
	right: 15px;
	bottom: 10px;
}

.form-signin div.validateCode {
	padding-bottom: 15px;
}

.mid {
	vertical-align: middle;
}

.header {
	height: 60px;
	padding-top: 30px;
}

.alert {
	position: relative;
	width: 300px;
	margin: 0 auto;
	*padding-bottom: 0px;
}

label.error {
	background: none;
	padding: 2px;
	font-weight: normal;
	color: inherit;
	margin: 0;
}
</style>
</head>
<body>
	<!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
	<div class="header"></div>
	<h1 class="form-signin-heading">
		<img style="width: 100px; height: 100px;"
			src="${ctxStatic}/images/logo.png" />${fns:getConfig('productName')}
	</h1>

	<div class="form-signin">
		<div class="row">
			<label class="input-label" for="username">请使用东方律师网账号登录</label>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<c:choose>
			    <c:when test="${type == 'login' }">
                    <a href="${ctx}/law/apply/login" class="btn btn-large btn-primary">登录东方律师网</a>
                </c:when> 
                <c:when test="${type == 'logout' }">
                    <a href="${ctx}/law/apply/login" class="btn btn-large btn-primary">登录东方律师网</a>
                </c:when> 
				<c:when test="${type == 'apply' }">
					<a href="${ctx}/law/apply/list" class="btn btn-large btn-primary">登录东方律师网</a>
				</c:when>
				<c:when test="${type == 'applyform' }">
					<a href="${ctx}/law/apply/form" class="btn btn-large btn-primary">登录东方律师网</a>
				</c:when>
			</c:choose>
		</div>
	</div>


</body>
</html>