<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
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
        <td class="all_title_bg">计划生育(12)</td>
        <td align="right" class="all_title_bg"><span>筛选</span>
             <select name="select" class="search_select">
              <option selected>全部</option>
              <option>计划生育协会概况</option>
              <option>计划生育协会会员名册</option>
              <option>计划生育协会会费缴纳记录表</option>
              <option>协会工作大事记</option>
              <option>监督工作记录</option>
              <option>典型事例记录</option>
              <option>小区孕妇情况登记表</option>
              <option>计划生育生殖健康培训情况</option>
              <option>家庭计划指导重点对象宣教情况表</option>
              <option>计划生育药具免费发放收发帐</option>
              <option>避孕节育分级随访统计表</option>
              <option>优生促进指导服务情况表</option>
              <option>基层0-3岁科学育儿指导服务工作情况表</option>
              <option>出生缺陷一级预防重点对象指导服务情况表</option>
              <option>流动人口计划生育服务管理基本情况表</option>
              <option>流动人口计划生育服务管理</option>
              <option>流动人口计划生育服务管理情况统计</option>
              </select>
        </td>
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
    <td>台帐名称</td>
    <td>指导部门</td>
    <td>统计日期</td>
    <td>报送日期</td>
    <td> 状态</td>
    <td>操作</td>
  </tr>
  <tr class="list_tr">
    <td align="center">1</td>
    <td align="center">监督工作记录</td>
    <td align="center">区卫生局</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">2</td>
    <td align="center">计划生育生殖健康培训情况</td>
    <td align="center">镇居委会</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">3</td>
    <td align="center">典型事例记录</td>
    <td align="center">区卫生局</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">4</td>
    <td align="center">计划生育药具免费发放收发帐</td>
    <td align="center">镇居委会</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">5</td>
    <td align="center">避孕节育分级随访统计表</td>
    <td align="center">镇居委会</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">6</td>
    <td align="center">优生促进指导服务情况表</td>
    <td align="center">区卫生局</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">7</td>
    <td align="center">小区孕妇情况登记表</td>
    <td align="center">区卫生局</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">8</td>
    <td align="center">家庭计划指导重点对象宣教情况表</td>
    <td align="center">镇居委会</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>

    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">9</td>
    <td align="center">基层0-3岁科学育儿指导服务工作情况表</td>
    <td align="center">镇居委会</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
  <tr class="list_tr">
    <td align="center">10</td>
    <td align="center">出生缺陷一级预防重点对象指导服务情况表</td>
    <td align="center">区卫生局</td>
    <td align="center">06-05</td>
    <td align="center">06-09</td>
    <td align="center">未填报</td>
    <td align="center"><a href="/l/lawyer/wcmdocument/tb_list_3">查看</a></td>
  </tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" height="10"></td>
        </tr>
      <tr>
        <td width="50%">
        <img src="${ctxStatic}/lawyer/images/button_add.jpg" width="72" height="30">
        &nbsp;
        <img src="${ctxStatic}/lawyer/images/button_export.jpg" width="72" height="30" />
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
