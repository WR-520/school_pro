<%@ page import="com.edu.lingnan.dao.superDao" %>
<%@ page import="com.edu.lingnan.dto.notice" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: qwq
  Date: 2021/6/6
<%@ page import="com.edu.lingnan.dto.news" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%--<%@ page import="com.edu.lingnan.dao.commonDao" %>--%>
<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page import="com.edu.lingnan.dto.myProject" %>
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
    <div class="panel-head"><strong class="icon-reorder"> 申报详情</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <table class="table table-hover text-center">
      <tr>
        <%--        <th width="100"><input type="checkbox" onclick="allCheck(this)"/></th>--%>
<%--        <th>项目序号</th>--%>
<%--          <th>申报人</th>--%>
        <th>标题</th>
        <th>内容</th>
        <th width="10%">成员</th>
        <%--        <th width="310">操作</th>--%>
        <%--        <th> <div class="button-group"> <a class="button border-red" onclick="deleAll();"><span class="icon-trash-o"></span> 批量删除</a> </div></th>--%>
      </tr>


      <%
        int proid = Integer.parseInt(request.getParameter("proid"));
        commonDao cm = new commonDao();
        myProject m = cm.applyDetail(proid);
      %>
<%--      <c:forEach items="${allPros}" var="project" >--%>
        <tr>

          <th><%=m.getTitle()%></th>
          <th><%=m.getContent()%></th>
          <th><%=m.getMembers()%></th>

<%--      </c:forEach>--%>
      </tr>
      <button><a href="email.jsp?tid=<%=m.getTid()%>&proid=<%=m.getProid()%>&pass=1">通过</a></button> <button><a href="email.jsp?tid=<%=m.getTid()%>&proid=<%=m.getProid()%>&pass=-1">不通过</a></button>


    </table>
  </div>
</form>

<script type="text/javascript" >

</script>
</body>
</html>
