<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>登录页</title>
<link href="${ctxStatic}/lawyer/css/login.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
var MyWin = new Win();
var imgfile = "http://www.poluoluo.com/example/css/1/img/"; //设置图片路径,相对或绝对都行
var imgname=new Array();
var img = new Array();
imgname[0] = imgfile+"c.gif";  
imgname[1] = imgfile+"b1.png";
imgname[2] = imgfile+"l1.png";  
imgname[3] = imgfile+"l2.png";  
imgname[4] = imgfile+"r1.png";  
imgname[5] = imgfile+"r2.png";  
imgname[6] = imgfile+"t1.png";  
imgname[7] = imgfile+"t2.png";  
imgname[8] = imgfile+"t3.png";  
//预读图片
for (i=0;i<=imgname.length-1;i++)
{
   img[i] = new Image();
   img[i].src = imgname[i];
}
var zIndex = 0;
var Winid  = 0;
var Ie = /msie/i.test(navigator.userAgent);
function $(Id){return(document.getElementById(Id))}
function Win()
{
 this.Create = function(mask,title, wbody, w, h, l, t)
 {
  Winid++;
  mask = mask;
  title = title || "新窗口 - 加载中...";
  wbody = wbody || " <p align='center'>正在载入…</p>";
  w = w || 350;
  h = h || 150;
  cw = document.documentElement.clientWidth;
  ch = document.documentElement.clientHeight;
  sw = document.documentElement.scrollWidth;
  sh = document.documentElement.scrollHeight;
        st = (document.documentElement.scrollTop || document.body.scrollTop);
  if (w > cw)
  ww = 0;
  else
  ww = (cw - w)/2;
  if (h > ch)
  hh = 0;
  else
  hh = (st + (ch - h)/2);
  l = l || ww;
  t = t || hh;
  
        if (mask != "no"){
    var ndiv = document.createElement("DIV");
    ndiv.setAttribute("id", "ndiv"+ Winid);
    ndiv.style.cssText = "width:"+ sw +"px;height:"+ sh +"px;left:0px;top:0px;position:absolute;overflow:hidden;background:#fff;filter:alpha(opacity=20); opacity:0.2;-moz-opacity:0.2;";
    document.body.appendChild(ndiv);
  
    if (Ie)
    {
    var niframe = document.createElement("iframe");
    niframe.style.width = sw;
    niframe.style.height = sh;    
          niframe.style.top = "0px";    
          niframe.style.left = "0px";  
          niframe.style.visibility = "inherit";    
          niframe.style.filter = "alpha(opacity=0)";    
          niframe.style.position = "absolute";    
          niframe.style.zIndex = -1;   
    ndiv.insertAdjacentElement("afterBegin",niframe);
    }
        }
  var mywin = document.createElement("DIV");
  mywin.setAttribute("id", "win"+ Winid);
  mywin.style.cssText = "width:"+ w +"px;height:"+ h +"px;left:0px;top:0px;position:absolute;overflow:hidden;padding:0px;font-family:Arial, 宋体";
  mywin.style.zIndex = ++zIndex;
  document.body.appendChild(mywin);
  
  var mytie = document.createElement("DIV");
  var myboy = document.createElement("DIV");
  var mybom = document.createElement("DIV");
  
  mytie.style.cssText = "overflow:hidden;height:30px;font-weight:bold;font-size:14px;width:100%";
  myboy.style.cssText = "overflow:hidden;width:100%";
  mybom.style.cssText = "overflow:hidden;height:30px;width:100%";
  
  mywin.appendChild(mytie);
  mywin.appendChild(myboy);
  mywin.appendChild(mybom);
  var wintag = [[mytie, 30, 15, "t1"], [mytie, 30, w-30, "t2"], [mytie, 30, 15, "t3"], [myboy, h-45, 15, "l1"], [myboy, h-47, w-32], [myboy, h-45, 15, "r1"], [mybom, 15, 15, "l2"], [mybom, 15, w-30, "b1"], [mybom, 15, 15, "r2"]];
  for (var i = 0; i < 9; i++)
  {
   var temp = document.createElement("DIV");
   temp.setAttribute("Fid", "win"+ Winid);
   wintag[i][0].appendChild(temp);
      if (wintag[i][3])
   {
    temp.style.cssText = "float:left;height:"+ wintag[i][1] +"px;width:"+ wintag[i][2] +"px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+imgfile+""+ wintag[i][3] +".png', sizingMethod='scale');background:url('"+imgfile+""+ wintag[i][3] +".png') !important;background:;";
   }
   else
   {
    temp.style.cssText = "float:left;filter:alpha(Opacity=95,style=0);opacity:0.95;height:"+ wintag[i][1] +"px;width:"+ wintag[i][2] +"px;background:#f7f7f7;border:1px solid #666;overflow:hidden;padding:0px";
   }
  }
  mytie.childNodes[1].innerHTML = "<div style=\"position:absolute;overflow:hidden;height:15px;top:12px;padding-left:4px;padding-right:4px;\"></div><div style=\"position:absolute;background:url('"+imgfile+"c.gif');overflow:hidden;width:43px;height:17px;top:7px !important;right:15px\" title=\"关闭窗口\" onclick=\"MyWin.Close('win"+ Winid +"',10); MyWin.ndiv('ndiv"+ Winid +"',10);\"></div>";
  this.Title("win"+ Winid, title);
  this.Body("win"+ Winid, wbody);
  this.Move_e("win"+ Winid, l, t, 0, 0);
  return(mywin);
 }
 this.Title = function(Id, title)
 {
     if (Id == null) return;
     var o = $(Id);
     if (!o) return;
     o.childNodes[0].childNodes[1].childNodes[0].innerHTML = title;
 }
 this.Body = function(Id, wbody)
 {
     if (Id == null) return;
     var o = $(Id);
        if (!o) return;
        if (wbody.slice(0, 4) == "[pg]")
            o.childNodes[1].childNodes[1].innerHTML = "<iframe onfocus=\"MyWin.Show('"+ Id +"',this)\" src='"+ wbody.slice(4) +"' frameBorder='0' marginHeight='0' marginWidth='0' scrolling='no' width='100%' height='100%'></iframe>";
        else
            o.childNodes[1].childNodes[1].innerHTML = wbody;
 }
 this.Show = function(Id)
    {     
     if (Id == null) return;
     var o = $(Id);
        if (!o) return;
     o.style.zIndex = ++zIndex;
    }
    this.Move_e = function(Id, l , t, ll, tt)
    {
     if (typeof(window["ct"+ Id]) != "undefined") clearTimeout(window["ct"+ Id]);
     var o = $(Id);
     if (!o) return;
      o.style.left = l +"px";
      o.style.top = t +"px";
     window["ct"+ Id] = window.setTimeout("MyWin.Move_e('"+ Id +"', "+ l +" , "+ t +", "+ ll +", "+ tt +")", 1);
    }
    this.Close = function(Id, Opacity)
    {
     if (typeof(window["et"+ Id]) != "undefined") clearTimeout(window["et"+ Id]);
     var o = $(Id);
     if (!o) return;
     if (Opacity == 10) o.childNodes[0].childNodes[1].innerHTML = "";
     if (Ie)
     {
      o.style.filter = "alpha(opacity="+ Opacity +",style=0)";
     }
     else
     {
      o.style.opacity = Opacity / 10;
     }
     if (Opacity > 20)
      Opacity -= 10;
     else
      Opacity--;
     if (Opacity <= 0)
     {
         if (o.getElementsByTagName("IFRAME").length != 0)
         {
             o.getElementsByTagName("IFRAME").src = "about:blank";
         }
         o.innerHTML = "";
      document.body.removeChild(o);
      return;
     }
     window["et"+ Id] = window.setTimeout("MyWin.Close('"+ Id +"', "+ Opacity +")", 1);
    }
    this.ndiv = function(Id, Opacity)
    {
     var o = $(Id);
     if (!o) return;
     o.innerHTML = "";
  document.body.removeChild(o);
  return;
    }
}
</script>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="loginbefore">
  <tr>
    <td align="center" valign="top">
    <table width="920" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
        <td width="625" height="150">&nbsp;</td>
        <td width="295" align="left">&nbsp;</td>
      </tr>
      <tr>
        <td width="625" height="70" >
        <div>
        	<table width="600">
        		<tr>
        			<td width="300"></td>
        			<td width="100" ><img src="/static/lawyer/images/shjcy-qr-code-s.png" /></td>
        			<td width="160" style="vertical-align: top;"><br/>Android客户端下载 <br/>APP于2015-5-29升级 <br/>敬请扫描下载</td>
        		</tr>
        	</table>
        </div>
        </td>
        <td width="295" align="left">
		   <div class="login_before">
		   "律师服务平台"是专门在线接受本市注册律师就本人接受委托的刑事案件向受理、查办案件所在地检察院提交诉讼业务办理、诉讼流程查询的预约申请，为律师（含非本市注册律师）提供在线查询、短信接收等服务的在线平台。
		   </div>
		</td>
      </tr>
      <tr>
        <td height="70">&nbsp;</td>
        <td align="left">
        <input type="submit" name="button" class="tologin_button" value=" " onclick="window.location.href='/l/lawyer/wcmdocument/index'"/>
        &nbsp;
        <input type="submit" name="button" class="check_button" value=" " onClick="window.location.href='/l/lawyer/fblogin'"/>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
