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
  int tid = (int) session.getAttribute("tid");
  String tname = (String) session.getAttribute("tname");
%>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 项目申报</strong></div>
  <div class="body-content" >
    <form method="post"  class="form-x" action="/ToApply">
      <div>

<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label for="id">比赛编号</label>--%>
<%--          </div>--%>
<%--          <div class="field">--%>
            <input type="text" style="display:none;" type="hidden" class="input w50" id="id"  name="id" size="50" value="<%=id%>" />
<%--          </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label for="tid">教师id</label>--%>
<%--          </div>--%>
<%--        <div class="field">--%>
          <input type="text" style="display:none;" type="hidden" class="input w50" id="tid"  name="tid" size="50" value="<%=tid%>" />
<%--        </div>--%>
<%--        <div>--%>

        <div class="form-group" style="display:none;">
          <div class="label">
            <label for="tname">姓名</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" id="tname" name="tname" size="50"  value="<%=tname%>" />
          </div>
        </div>

        <div class="form-group" >
          <div class="label">
            <label for="title">项目名称</label>
          </div>
          <div class="field" >
            <input type="text" id="title" class="input w50" id="sex" name="title" size="50" placeholder="项目名称" data-validate="required:请输入项目名称"/>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label for="content">内容</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" id="content" name="content" size="50" placeholder="项目内容" data-validate="required:请输入项目内容" />
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label for="members">项目成员</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" id="members" name="members" size="50" placeholder="请输入项目成员" data-validate="required:请输入项目成员" />
          </div>
        </div>
          <div class="field">
            <button class="button bg-main icon-check-square-o" type="submit">提交申报</button>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
<script>

</script>
</html>


<%--<!DOCTYPE html>--%>
<%--<html lang="zh-cn">--%>
<%--<head>--%>
<%--  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
<%--  <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />--%>
<%--  <meta name="renderer" content="webkit">--%>
<%--  <title></title>--%>
<%--  <link rel="stylesheet" href="/css/pintuer.css">--%>
<%--  <link rel="stylesheet" href="/css/admin.css">--%>
<%--  <script src="/js/jquery.js"></script>--%>
<%--  <script src="/js/check.js"></script>--%>
<%--</head>--%>
<%--<style>--%>
<%--  table th {--%>
<%--    vertical-align: middle !important;--%>
<%--    font-weight:500 !important;--%>
<%--  }--%>
<%--</style>--%>
<%--<body onload="opener.Location.reload()">--%>
<%--<form method="post" action="" name="listform" id="listform">--%>

<%--<% int id = Integer.parseInt(request.getParameter("id"));%>--%>
<%--<%--%>
<%--  int tid = (int) session.getAttribute("tid");--%>
<%--  String tname = (String) session.getAttribute("tname");--%>
<%--%>--%>
<%--<div class="panel admin-panel">--%>
<%--  <div class="panel-head"><strong><span class="icon-key"></span> 项目申报</strong></div>--%>
<%--  <div class="body-content" >--%>
<%--    <form method="post" class="form-x" action="/ToApply">--%>
<%--      <div>--%>
<%--        <div class="form-group">--%>
<%--          <input type="hidden" name="id" value="<%=id%>">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--          <input type="hidden" name="tid" value="<%=tid%>">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label for="tname">申报人姓名</label>--%>
<%--          </div>--%>
<%--          <div class="field">--%>
<%--               <div id="tname"><input type="text" disabled="disabled"  value="<%=tname%>"/></div>--%>
<%--          </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--          <label for="title">项目名称</label>--%>
<%--          </div>--%>
<%--          <div class="field" >--%>
<%--            <input type="text" class="input w50" id="title" name="title" size="50" placeholder="项目名称" data-validate="required:请输入项目名称"/>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label for="content">项目内容</label>--%>
<%--          </div>--%>
<%--          <div class="field">--%>
<%--            <input type="text" class="input w50" id="content" name="content" size="50" placeholder="项目内容" data-validate="required:请输入项目内容" />--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label for="members">项目成员</label>--%>
<%--          </div>--%>
<%--          <div class="field">--%>
<%--            <input type="text" class="input w50" id="members" name="members" size="50" placeholder="请输入项目成员" data-validate="required:请输入项目成员" />--%>
<%--          </div>--%>
<%--        </div>--%>


<%--        <div class="form-group">--%>
<%--          <div class="label">--%>
<%--            <label></label>--%>
<%--          </div>--%>
<%--          <div class="field">--%>
<%--            <button class="button bg-main icon-check-square-o" type="submit">提交申报</button>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </form>--%>
<%--  </div>--%>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>

