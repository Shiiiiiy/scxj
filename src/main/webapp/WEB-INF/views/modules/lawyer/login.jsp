<html>
<head>
	<title>用户认证中心</title>
	<script type="text/javascript">
		var $ctx = '';
		window.load = function(){ 
		document.getElementById('password').value=''; 
		}; 
	</script>
	<link href="/shjcy/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form class="form-signin" id="loginForm" action="" method="post">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="login">
		  <tr>
		    <td align="center" valign="top">
		    <table width="920" border="0" align="center" cellpadding="0" cellspacing="0">
		      <tr>
		        <td width="625" height="180">&nbsp;</td>
		        <td width="295">&nbsp;</td>
		      </tr>
		      <tr>
		        <td height="70">&nbsp;</td>
		        <td align="left"><input type="text" id="username" name="j_username" class="login_input user" /></td>
		      </tr>
		      <tr>
		        <td height="70">&nbsp;</td>
		        <td align="left"><input type="text" id="password" name="j_password" onfocus="this.type='password'" class="login_input password" /></td>
		      </tr>
		      <tr>
		        <td height="70">&nbsp;</td>
		        <td align="left">
		        <input type="submit" id="btn-submit" name="button" class="login_button" value=""/>
		        &nbsp;&nbsp;
		        <a href="javascript:void()" style="cursor: default;text-decoration: none;">请使用东方律师网账号 </a></td>
		      </tr>
		      <tr>
		      	<td>&nbsp;</td>
		      	<td><div id="err" style="color: red;"></div></td>
		      </tr>
		    </table>
		    </td>
		  </tr>
		</table>
	    <script src="/common/bootstrap/js/jquery-1.7.1.min.js"></script>
	    <script type="text/javascript" src="/shjcy/signin.js"></script>
	</form>
</body>
</html>
