<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctxStatic}/lawyer/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctxStatic}/lawyer/scripts/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/lawyer/scripts/jquery.ztree.core-3.5.js"></script>

<SCRIPT type="text/javascript">
		<!--
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		
		var treequick =[
			{ id:1, pId:0, name:"快捷方式", open:true},
			  { id:11, pId:1, name:"计划生育(12)"},
			  { id:12, pId:1, name:"社会保障(11)"},
			  { id:13, pId:1, name:"安全(15)"},
			  { id:14, pId:1, name:"团委工作(10)"},
			  { id:15, pId:1, name:"日常工作(15)"},
			  { id:16, pId:1, name:"公益劳动(10)"},
			  { id:17, pId:1, name:"民防(11)"},
		];

		var treeclass =[
			{ id:1, pId:0, name:"台帐分类", open:true},
			  { id:11, pId:1, name:"行政(98)", open:true},
			      { id:111, pId:11, name:"计划生育(12)"},
				  { id:112, pId:11, name:"社会保障(11)"},
				  { id:113, pId:11, name:"机关工委(10)"},
				  { id:114, pId:11, name:"安全(15)"},
				  { id:115, pId:11, name:"司法调解(14)"},
				  { id:116, pId:11, name:"健康卫生(17)"},
				  { id:117, pId:11, name:"综合治理(8)"},
				  { id:118, pId:11, name:"民防(11)"},
			  { id:12, pId:1, name:"党群(120)"},
			      { id:121, pId:12, name:"支部工作(20)"},
				  { id:122, pId:12, name:"老干部工作(20)"},
				  { id:123, pId:12, name:"党内服务(20)"},
				  { id:124, pId:12, name:"组团式服务(20)"},
				  { id:125, pId:12, name:"妇代工作(20)"},
				  { id:126, pId:12, name:"团委工作(10)"},
				  { id:127, pId:12, name:"统战工作(10)"},
			  { id:13, pId:1, name:"自治(105)"},
			      { id:131, pId:13, name:"会议活动(20))"},
				  { id:132, pId:13, name:"日常工作(15)"},
				  { id:133, pId:13, name:"公约与章程(10)"},
				  { id:134, pId:13, name:"规章制度(10)"},
				  { id:135, pId:13, name:"特色项目(10))"},
				  { id:136, pId:13, name:"民主选举(10)"},
				  { id:137, pId:13, name:"社情民意(10))"},
				  { id:138, pId:13, name:"公益劳动(10)"},
				  { id:139, pId:13, name:"社会组织预警网络信息(10)"},
		];
		
		     var treetip =[
			{ id:1, pId:0, name:"标签", open:true},
			  { id:11, pId:1, name:"人员(12)", open:true},
			  { id:12, pId:1, name:"企业(11)"},
			  { id:13, pId:1, name:"机关(11)"},
		];

		$(document).ready(function(){
			$.fn.zTree.init($("#treequick"), setting, treequick);
			$.fn.zTree.init($("#treeclass"), setting, treeclass);
			$.fn.zTree.init($("#treetip"), setting, treetip);
		});
		//-->
	</SCRIPT>



</head>

<body id="list_body">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="230" align="left" valign="top">
    <div class="list_tree" style="height:447px; overflow:scroll; overflow-x:hidden; border:1px solid #CCC;">
    <ul id="treequick" class="ztree"></ul>
    <ul id="treeclass" class="ztree"></ul>
    <ul id="treetip" class="ztree"></ul>
    </div>
    </td>
    <td width="20">&nbsp;</td>
    <td width="*" align="left" valign="top">
    
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="all_title_left">&nbsp;</td>
        <td class="all_title_bg">小区孕妇情况登记表</td>
        <td class="all_title_right">&nbsp;</td>
      </tr>
    </table>
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
  <tr>
    <td valign="top">
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr class="list_title">
    <td>序号</td>
    <td>姓名</td>
    <td>出生年月</td>
    <td>户口性质</td>
    <td>怀孕日期</td>
    <td> 预产日期</td>
    <td>结婚日期</td>
    <td>学历</td>
    <td>职业</td>
    <td>配偶姓名</td>
      </tr>
  <tr class="list_tr">
    <td align="center">1</td>
    <td align="center">韩立春</td>
    <td align="center">1978-06</td>
    <td align="center">城镇户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2008-05</td>
    <td align="center">本科</td>
    <td align="center">教师</td>
    <td align="center">李宏涛</td>
  </tr>
  <tr class="list_tr">
    <td align="center">2</td>
    <td align="center">韩相吉</td>
    <td align="center">1978-06</td>
    <td align="center">城镇户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-05</td>
    <td align="center">2005-05</td>
    <td align="center">大专</td>
    <td align="center">销售</td>
    <td align="center">尹静波</td>
  </tr>
  <tr class="list_tr">
    <td align="center">3</td>
    <td align="center">母德强</td>
    <td align="center">1972-06</td>
    <td align="center">农村户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-05</td>
    <td align="center">2004-08</td>
    <td align="center">高中</td>
    <td align="center">销售</td>
    <td align="center">郭柏春</td>
  </tr>
  <tr class="list_tr">
    <td align="center">4</td>
    <td align="center">李东美</td>
    <td align="center">1975-06</td>
    <td align="center">城镇户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2004-09</td>
    <td align="center">本科</td>
    <td align="center">教师</td>
    <td align="center">张宏伟</td>
  </tr>
  <tr class="list_tr">
    <td align="center">5</td>
    <td align="center">朱毅敏</td>
    <td align="center">1981-06</td>
    <td align="center">农村户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-05</td>
    <td align="center">2008-07</td>
    <td align="center">高中</td>
    <td align="center">公务员</td>
    <td align="center">吴化</td>
  </tr>
  <tr class="list_tr">
    <td align="center">6</td>
    <td align="center">李湘多</td>
    <td align="center">1975-06</td>
    <td align="center">城镇户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2003-05</td>
    <td align="center">高中</td>
    <td align="center">公务员</td>
    <td align="center">刘喜明</td>
  </tr>
  <tr class="list_tr">
    <td align="center">7</td>
    <td align="center">郭柏春</td>
    <td align="center">1973-06</td>
    <td align="center">城镇户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2002-05</td>
    <td align="center">本科</td>
    <td align="center">教师</td>
    <td align="center">勾志践</td>
  </tr>
  <tr class="list_tr">
    <td align="center">8</td>
    <td align="center">张龙喜</td>
    <td align="center">1977-06</td>
    <td align="center">农村户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-05</td>

    <td align="center">2006-04</td>
    <td align="center">本科</td>
    <td align="center">公务员</td>
    <td align="center">尤文</td>
  </tr>
  <tr class="list_tr">
    <td align="center">9</td>
    <td align="center">张会轩</td>
    <td align="center">1982-06</td>
    <td align="center">农村户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2007-05</td>
    <td align="center">大专</td>
    <td align="center">教师</td>
    <td align="center">王占礼</td>
  </tr>
  <tr class="list_tr">
    <td align="center">10</td>
    <td align="center">王承美</td>
    <td align="center">1978-06</td>
    <td align="center">农村户口</td>
    <td align="center">2014-06</td>
    <td align="center">2015-04</td>
    <td align="center">2008-02</td>
    <td align="center">大专</td>
    <td align="center">公务员</td>
    <td align="center">王宏志</td>
  </tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" height="10"></td>
        </tr>
      <tr>
        <td width="50%">
        <img src="${ctxStatic}/lawyer/images/button_back.jpg" width="72" height="30" onClick="javascript:history.go(-1);" style="cursor:pointer;">
       </td>
        <td width="50%">
        <ul class="pages">
        <li><a href="#"><<</a></li>
        <li><a href="#" class="selected">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">>></a></li>
        </ul>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="10"></td>
        </tr>
    </table>
    </td>
  </tr>
</table>
    </td>
  </tr>
</table>

<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
