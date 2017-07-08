var objBanner;
var objCtrl;
var objMenu;
var objFooter;
var objContent;
var objWidth;
var objWidth2;
//左菜单
function showHideBar() {
objWidth2 = parseInt(document.getElementById("ctrl").offsetWidth);
if (parseInt(objMenu.style.width) != 0) {
   objWidth = parseInt(document.getElementById("menu").offsetWidth);
   objMenu.style.width = "0px";
   objMenu.style.display = "none";
   objCtrl.style.left = objMenu.style.width;
   objContent.style.left = parseInt(objMenu.style.width) + objWidth2 + "px";
   objContent.style.width = parseInt(document.body.offsetWidth) - parseInt(document.getElementById("menu").offsetWidth) - parseInt(document.getElementById("ctrl").offsetWidth) + "px";
   objCtrl.className = "ctrl_visibility";
}
else {
   objMenu.style.width = objWidth + "px";
   objCtrl.style.left = objWidth + "px";
   objMenu.style.display = "block";
   objContent.style.left = objWidth + objWidth2 + "px";
   objCtrl.className = "ctrl_hidden";
objContent.style.width = parseInt(document.body.offsetWidth) - parseInt(document.getElementById("menu").offsetWidth) - parseInt(document.getElementById("ctrl").offsetWidth) + "px"; }
}
//布局高宽
function initSideBar() {
objBanner = document.getElementById("banner");
     objCtrl = document.getElementById("ctrl");
     objMenu = document.getElementById("menu");
	 objFooter = document.getElementById("footer");
objContent = document.getElementById("content");
objMenu.style.height = parseInt(document.body.offsetHeight) - parseInt(document.getElementById("banner").offsetHeight) - parseInt(document.getElementById("footer").offsetHeight) + "px";

objCtrl.style.height = parseInt(document.body.offsetHeight) - parseInt(document.getElementById("banner").offsetHeight)  - parseInt(document.getElementById("footer").offsetHeight) + "px";

objContent.style.height = parseInt(document.body.offsetHeight) - parseInt(document.getElementById("banner").offsetHeight)  - parseInt(document.getElementById("footer").offsetHeight) + "px";

objContent.style.width = parseInt(document.body.offsetWidth) - parseInt(document.getElementById("menu").offsetWidth) - parseInt(document.getElementById("ctrl").offsetWidth) + "px";
}


//顶部菜单
 function setNav(name,cursel,n){
 for(i=1;i<=n;i++){
  var nav=document.getElementById(name+i);
  nav.className=i==cursel?"hover":"";
 }
}

//显示隐藏列表
function select_changed(){  
   document.getElementById("nextOption").style.display= document.getElementById("nextOption").style.display=="none"? 
"":"none";
} 

