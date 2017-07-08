<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>页面</title>
<link href="${ctxStatic}/lawyer/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body id="list_body">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="all_title_left">&nbsp;</td>
    <td class="all_title_bg">低收入群体补助</td>
    <td class="all_title_right">&nbsp;</td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="all_content">
  <tr>
    <td valign="top">
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="180" valign="top" class="choose_bg">
        
         <span class="choose_title">待选择项</span>
            <ul class="choose_menu">
              <li class="choose">性别</li>
              <li class="choose">政治面貌</li>
              <li class="choose">文化程度</li>
              <li>户口性质</li>
              <li>某某选项</li>
              <li>某某选项</li>
            </ul>
            
            <span class="choose_title">统计类型</span>
              <input name="radio" type="radio" id="radio2" value="radio" checked>
              <label for="radio2">人数</label>
              <input type="radio" name="radio" id="radio2" value="radio">
              <label for="radio2">补贴金额</label>
      
      </td>
        <td width="20">&nbsp;</td>
        <td width="*" valign="top">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="49%" valign="top"  class="selected_bg">
            <span class="choose_title">表头</span>
            <ul class="selected_menu">
              <li>性别</li>
              <li>文化程度</li>
            </ul>
            </td>
            <td width="2%">&nbsp;</td>
            <td width="49%" valign="top" class="selected_bg">
            <span class="choose_title">表行</span>
            <ul class="selected_menu">
              <li>政治面貌</li>
            </ul>
            </td>
          </tr>
          <tr>
            <td height="20" colspan="3"></td>
            </tr>
          <tr>
            <td colspan="3"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#dddddd">
              <tr class="list_title">
                <td bgcolor="#e9f0f8">&nbsp;</td>
                <td bgcolor="#e9f0f8">&nbsp;</td>
                <td bgcolor="#e9f0f8">党员</td>
                <td bgcolor="#e9f0f8">团员</td>
                <td bgcolor="#e9f0f8">群众</td>
                </tr>
              <tr class="list_tr border_none">
                <td rowspan="3" align="center" bgcolor="#E9F0F8">男</td>
                <td align="center" bgcolor="#F9F9F9">本科</td>
                <td align="center" bgcolor="#FFFFFF">12</td>
                <td align="center" bgcolor="#FFFFFF">11</td>
                <td align="center" bgcolor="#FFFFFF">10</td>
                </tr>
              <tr class="list_tr border_none">
                <td align="center" bgcolor="#F9F9F9">大专</td>
                <td align="center" bgcolor="#FFFFFF">23</td>
                <td align="center" bgcolor="#FFFFFF">25</td>
                <td align="center" bgcolor="#FFFFFF">28</td>
                </tr>
              <tr class="list_tr border_none">
                <td align="center" bgcolor="#F9F9F9">高中</td>
                <td align="center" bgcolor="#FFFFFF">15</td>
                <td align="center" bgcolor="#FFFFFF">16</td>
                <td align="center" bgcolor="#FFFFFF">18</td>
                </tr>
              <tr class="list_tr border_none">
                <td rowspan="3" align="center" bgcolor="#E9F0F8">女</td>
                <td align="center" bgcolor="#F9F9F9">本科</td>
                <td align="center" bgcolor="#FFFFFF">11</td>
                <td align="center" bgcolor="#FFFFFF">10</td>
                <td align="center" bgcolor="#FFFFFF">16</td>
                </tr>
              <tr class="list_tr border_none">
                <td align="center" bgcolor="#F9F9F9">大专</td>
                <td align="center" bgcolor="#FFFFFF">34</td>
                <td align="center" bgcolor="#FFFFFF">35</td>
                <td align="center" bgcolor="#FFFFFF">32</td>
                </tr>
              <tr class="list_tr border_none">
                <td align="center" bgcolor="#F9F9F9">高中</td>
                <td align="center" bgcolor="#FFFFFF">18</td>
                <td align="center" bgcolor="#FFFFFF">16</td>
                <td align="center" bgcolor="#FFFFFF">14</td>
                </tr>
            </table></td>
            </tr>
        </table></td>
      </tr>
    </table>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
