<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page import="com.edu.lingnan.dto.news" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: qwq
  Date: 2021/6/3
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title></title>
  <link rel="stylesheet" href="/css/pintuer.css">
  <link rel="stylesheet" href="/css/admin.css">
  <script src="/js/jquery.js"></script>
  <script src="/js/check.js"></script>
</head>
<style>
  table th {
    vertical-align: middle !important;
    font-weight:500 !important;
  }
</style>
<body onload="opener.Location.reload()">
<form method="post" action="" name="listform" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="/admin/add.jsp"> 添加内容</a> </li>
        <if condition="$iscid eq 1">
        </if>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a id="go" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100"><input type="checkbox" onclick="allCheck(this)"/></th>
        <th>标题</th>
        <th>内容</th>
        <th width="10%">更新时间</th>
        <th width="310">操作</th>
        <th> <div class="button-group"> <a class="button border-red" onclick="deleAll();"><span class="icon-trash-o"></span> 批量删除</a> </div></th>
      </tr>

      <% String K = request.getAttribute("search").toString();%>
          <%
            commonDao cd = new commonDao();
            Vector<news> v1= cd.searchByKeywords(K);
            Iterator<news> it = v1.iterator();
            news t = null;
            while( it.hasNext() ){
              t = it.next();
          %>
          <tr>
            <th><input type="checkbox" name="check" value="<%=t.getId()%>"/></th>
            <th><%=t.getTitle()%></th>
            <th><%=t.getContent()%></th>
            <th><%=t.getDatetime()%></th>
            <td><div class="button-group"> <a class="button border-main" href="/admin/editNews.jsp?id=<%=t.getId()%>"><span class="icon-edit"></span> 修改</a>
              <a class="button border-red" href= "deleteNews?flag=all&id=<%=t.getId()%>"> <span class="icon-trash-o"></span> 删除</a> </div></td>
          </tr>
          <%
            }
          %>

    </table>
  </div>
</form>

<script type="text/javascript" >

  //搜索
  function changesearch(){
    const listform = document.forms['listform'];
    const keywords = listform.keywords.value;

    if(keywords.toString().trim() == '' ){
      return;
    }
    else{
      alert("你要搜的关键词为"+keywords);
      window.location.href="/searchByKeywords?keywords="+keywords ;
      // console.log(window)
    }
  }



  //全选
  var oCheck = document.getElementsByName('check');
  function allCheck(checkbox){
    if(checkbox.checked == true){
      for( let item of oCheck ){
        item.checked = true;
      }
    }else{
      for(let item of oCheck){
        item.checked = false;
      }
    }
  }

  //批量删除
  deleAll = () => {

    let flag = false;
    let allsid = new Array();
    for(let item of oCheck){
      if(item.checked == true){
        allsid.push(item.value);
        flag = true;
      }
    }
    if(flag == true) {
      if(confirm("您确定要删除这些记录吗？")){
        location.href = "deleteNews?flag=all&id="+allsid;
      }
    }else{
      alert("请选择您要删除的新闻");
    }


  }

  //批量排序
  function sorts(){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");
      return false;
    }
  }


  //批量首页显示
  function changeishome(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量推荐
  function changeisvouch(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){


      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量置顶
  function changeistop(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }


  //批量移动
  function changecate(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量复制
  function changecopy(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){
      var i = 0;
      $("input[name='id[]']").each(function(){
        if (this.checked==true) {
          i++;
        }
      });
      if(i>1){
        alert("只能选择一条信息!");
        $(o).find("option:first").prop("selected","selected");
      }else{

        $("#listform").submit();
      }
    }
    else{
      alert("请选择要复制的内容!");
      $(o).find("option:first").prop("selected","selected");
      return false;
    }
  }

</script>
</body>
</html>
