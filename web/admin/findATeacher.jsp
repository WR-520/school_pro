<%@ page import="com.edu.lingnan.dao.superDao" %>
<%@ page import="com.edu.lingnan.dto.teacher" %><%--
  Created by IntelliJ IDEA.
  User: qwq
  Date: 2021/6/10
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("tid"));%>

<%
  superDao cm = new superDao();
  teacher p = cm.findATeacher(id);
%>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 比赛详情</strong></div>
  <div class="body-content" >
    <form method="post" class="form-x" >
      <div>
        <div class="form-group">
          <div class="label">
            <label for="id">ID</label>
          </div>
          <input  disabled="disabled" id="id" name="id" value="<%=p.getTid()%>">
        </div>
        <div class="form-group">
          <div class="label">
            <label for="tname">姓名</label>
          </div>
          <input id="tname" disabled="disabled" name="tid" value="<%=p.getTname()%>">
        </div>
        <div class="form-group">
          <div class="label">
            <label for="sex">
            性别
            </label>
          </div>
          <div class="field">
            <div id="sex"><input type="text" disabled="disabled"  value="<%=p.getSex()%>"/></div>
          </div>
        </div>

        <div class="form-group">
          <div class="label">
            <label for="education">最高学历</label>
          </div>
          <div class="field">
            <input type="text" disabled="disabled" class="input w50" id="education" name="members" size="50" value="<%=p.getEducation()%>" />
          </div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label for="speciality">专业方向</label>
        </div>
        <div class="field">
          <input type="text" disabled="disabled" class="input w50" id="speciality" name="members" size="50" value="<%=p.getSpeciality()%>" />
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label for="rank">职称</label>
        </div>
        <div class="field">
          <input type="text" disabled="disabled" class="input w50" id="rank" name="members" size="50" value="<%=p.getRank()%>" />
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label for="admin">管理权限</label>
        </div>
        <div class="field">
          <input type="text" disabled="disabled" class="input w50" id="admin" name="members" size="50" value="<%=p.getAdmin()%>" />
        </div>
      </div>

    </form>
  </div>
</div>
</body>
</html>
