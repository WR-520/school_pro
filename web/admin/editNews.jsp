<%@ page import="com.edu.lingnan.dao.superDao" %>
<%@ page import="com.edu.lingnan.dto.editNews" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title></title>
  <link rel="stylesheet" href="../css/pintuer.css">
  <link rel="stylesheet" href="../css/admin.css">
  <script src="../js/jquery.js"></script>
  <script src="../js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
<%
  superDao sp = new superDao();
  editNews en = new editNews();
  int id = Integer.parseInt( request.getParameter("id") );
  en = sp.edit(id);

%>
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>编辑内容</strong></div>
  <div class="body-content">

    <form class="form-x" action="/editNews">
      <input type="hidden" name="id" value=<%=en.getId()%> />
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="title" value="<%=en.getTitle()%>" name="title" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>内容：</label>
        </div>
        <div class="field">
          <textarea id="content" name="content" class="input" style="height:450px; border:1px solid #ddd;"><%=en.getContent()%></textarea>
          <div class="tips"></div>
        </div>
      </div>

<%--      <div class="form-group">--%>
<%--        <div class="label">--%>
<%--          <label>更新日期：</label>--%>
<%--        </div>--%>
<%--        <div class="field">--%>
<%--          <textarea id="datetime" name="datetime" class="input" style="height:450px; border:1px solid #ddd;"><%=en.getDatetime()%></textarea>--%>
<%--          <div class="tips"></div>--%>
<%--        </div>--%>
<%--      </div>--%>



      <div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>

  </div>
</div>

</body>
<script>
  document.getElementById('content').value ="<%=en.getContent()%>";
</script>
</html>

