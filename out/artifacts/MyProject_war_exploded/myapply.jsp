<%@ page import="com.edu.lingnan.dto.news" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page import="com.edu.lingnan.dto.project" %>
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
<body>
<form method="post" action="" name="listform" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">我的申报</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <select onchange="f(this)" autocomplete="off">
      <%-- js中下拉框自动回显(selected) 直接可以用三目运算符来进行自动选中 其中parma.是跳转到jsp页面传进来的参数--%>
      <option   value="1" ${'1' eq param.v  ? 'selected':''}  >我的在研项目</option>
      <option value="0" ${'0' eq param.v  ? 'selected':''}   >我的未获审申报</option>
      <option value="-1" ${'-1' eq param.v  ? 'selected':''} >我的失败申报</option>
    </select>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

        <if condition="$iscid eq 1">
        </if>
        <li>

      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <%--        <th width="100"><input type="checkbox" onclick="allCheck(this)"/></th>--%>
        <th>比赛序号</th>
        <th>标题</th>
        <th>内容</th>
        <th width="10%">成员</th>
<%--        <th width="310">操作</th>--%>
        <%--        <th> <div class="button-group"> <a class="button border-red" onclick="deleAll();"><span class="icon-trash-o"></span> 批量删除</a> </div></th>--%>
      </tr>


      <%
       int tid = (int) session.getAttribute("tid");
        commonDao cd = new commonDao();
        Vector<myProject> v = cd.findAllMyProjects(tid, Integer.parseInt(request.getAttribute("v").toString()) );
        request.setAttribute("allPros",v);
      %>
      <c:forEach items="${allPros}" var="project" >
        <tr>
          <th><a href="findAProject.jsp?id=${project.id}"><c:out value="${project.id}"/></a></th>
          <th><c:out value="${project.title}"/></th>
          <th><c:out value="${project.content}"/></th>
          <th><c:out value="${project.members}"/></th>

        </tr>
      </c:forEach>
      <tr>



    </table>
  </div>
</form>

<script type="text/javascript" >
    function f(obj){
      let v = obj.options[obj.selectedIndex].value;
      window.location.href="/myapply?v="+v;

    }

</script>
</body>
</html>
