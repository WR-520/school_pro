<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>简易科研平台 </title>
  <link rel="stylesheet" href="/css/pintuer.css">
  <link rel="stylesheet" href="/css/admin.css">
  <script src="/js/jquery.js"></script>
</head>
<% int admin = (int) session.getAttribute("admin");
%>

<body style="background-color:#f2f9fd;" onload="opener.Location.reload()">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />简易科研平台</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span>
    前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span>
    清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="/loginout"><span
    class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-pencil-square-o"></span>新闻展示</h2>
  <ul style="display:block" >
    <li><a href="/list.jsp" target="right"><span class="icon-caret-right"></span>研究成果</a></li>
    <li><a onclick="go(<%=admin%>)"><span class="icon-caret-right"></span>科研通知</a></li>
    <li><a href="/admin/add.jsp" target="right"><span class="icon-caret-right"></span>发布新闻</a></li>
  </ul>
  <h2><span class="icon-user"></span>基本功能</h2>

  <c:if test="<%=admin == 0%>">
  <ul style="display:block" >
    <li><a href="/myapply" target="right"><span class="icon-caret-right"></span>我的申报</a></li>
  </ul>
  </c:if>
  <c:if test="<%=admin == 1%>">
  <ul style="display:block" >
    <li><a href="/allTeachers" target="right"><span class="icon-caret-right"></span>教师信息</a></li>
    <li><a href="/admin/notice.jsp" target="right"><span class="icon-caret-right"></span>我的通知</a></li>
  </ul>
    </c:if>


</div>
<script type="text/javascript">
  $(function () {
    $(".leftnav h2").click(function () {
      $(this).next().slideToggle(200);
      $(this).toggleClass("on");
    })
    $(".leftnav ul li a").click(function () {
      $("#a_leader_txt").text($(this).text());
      $(".leftnav ul li a").removeClass("on");
      $(this).addClass("on");
    })
  });
</script>
<ul class="bread">
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="/list.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<style>
  .copyrights {
    text-indent: -9999px;
    height: 0;
    line-height: 0;
    font-size: 0;
    overflow: hidden;
  }
</style>
<div class="copyrights" id="links20210126">
  Collect from <a href="http://www.cssmoban.com/" title="网站模板">模板之家</a>
  <a href="https://www.chazidian.com/" title="查字典">查字典</a>
</div>
</body>
<script>
  var go = x => {
   if(x == 1)
     // location.href="/admin/projects.jsp";
window.open("/admin/projects.jsp",'right')
   else{
     window.open("/projects.jsp",'right')
   }
  }
</script>
</html>
