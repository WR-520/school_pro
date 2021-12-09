<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page import="com.edu.lingnan.dto.project" %>
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
  <script src="/js/pintuer.js"></script>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id"));%>

<%
   commonDao cm = new commonDao();
   project p = cm.findAProject( Integer.parseInt(request.getParameter("id")));
%>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 比赛详情</strong></div>
  <div class="body-content" >
    <form method="post" class="form-x" >
      <div>
        <div class="form-group">
          <div class="label">
            <label for="id">编号</label>
          </div>
          <input  disabled="disabled" id="id" name="id" value="<%=p.getId()%>">
        </div>
        <div class="form-group">
          <div class="label">
            <label for="title">比赛主题</label>
          </div>
          <input id="title" disabled="disabled" name="tid" value="<%=p.getTitle()%>">
        </div>
        <div class="form-group">
          <div class="label">
            <label for="content">比赛内容</label>
          </div>
          <div class="field">
            <div id="content"><input type="text" disabled="disabled"  value="<%=p.getContent()%>"/></div>
          </div>
        </div>

        <div class="form-group">
          <div class="label">
            <label for="ddl">截止日期</label>
          </div>
          <div class="field">
            <input type="text" disabled="disabled" class="input w50" id="ddl" name="members" size="50" value="<%=p.getDdl()%>" />
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
</body>

</html>

