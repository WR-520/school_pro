<%@ page import="com.edu.lingnan.dao.superDao" %>
<%@ page import="com.edu.lingnan.dto.notice" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <div class="panel-head"><strong class="icon-reorder"> 通知列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <table class="table table-hover text-center">

      <%  superDao sp = new superDao();
        Vector<notice> v= sp.myNotice();
        Iterator<notice> it = v.iterator();
        notice t = null;
        while( it.hasNext() ){
          t = it.next();
      %>
      <div style="font-size:20px; "><a href="findATeacher.jsp?tid=<%=t.getTid()%>" style="color:cornflowerblue"><%=t.getTname()%></a>申报
        <a  href="../findAProject.jsp?id=<%=t.getId()%>" style="color:cornflowerblue">《<%=t.getTitle()%>》</a><button>
          <a href="../applydetail.jsp?proid=<%=t.getProid()%>">查看详情</a></button></div>
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
