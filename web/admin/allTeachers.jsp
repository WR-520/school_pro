<%@ page import="com.edu.lingnan.dto.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.edu.lingnan.dao.*" %>
<%--
  Created by IntelliJ IDEA.
  User: qwq
  Date: 2021/5/22
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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
  <body  onload="opener.Location.reload()">

  <table class="table table-hover text-center">
  <tr>
    <th width="120">ID</th>
    <th> </th>
    <th>姓名</th>
    <th>性别</th>
    <th>最高学历</th>
    <th>专业方向</th>
    <th>职称</th>
    <th>个人邮箱</th>
   <th width="25%">是否为管理员</th>
    <th>操作</th>
  </tr>
  <%
    Vector<teacher> v = (Vector<teacher>)session.getAttribute("allTeachers");
    Iterator<teacher> it = v.iterator();
    teacher t = null;
    while( it.hasNext() ){
      t = it.next();
      %>
    <tr>
      <td><%=t.getTid() %><td>
      <td><%=t.getTname() %></td>
      <td><%=t.getSex() %></td>
      <td><%=t.getEducation()%></td>
      <td><%=t.getSpeciality()%></td>
      <td><%=t.getRank() %></td>
      <td><%=t.getInfo()%></td>
      <td><%=t.getAdmin()%></td>
      <td><div class="button-group" onclick="deleOrNot(<%=t.getAdmin()%>)"><a class="button border-red" href="/deleATeacher?tid=<%=t.getTid()%>">删除</a></div></td>
    </tr>
  <%
    }
  %>
  </table>

  <script type="text/javascript">
   function deleOrNot(admin){
     if(admin == 1){
       alert("管理员不能删除！");
     }
   }

  $("#checkall").click(function(){
      $("input[name='id[]']").each(function(){
        if (this.checked) {
          this.checked = false;
        }
        else {
          this.checked = true;
        }
      });
    })

    function DelSelect(){
      var Checkbox=false;
      $("input[name='id[]']").each(function(){
        if (this.checked==true) {
          Checkbox=true;
        }
      });
      if (Checkbox){
        var t=confirm("您确认要删除选中的内容吗？");
        if (t==false) return false;
      }
      else{
        alert("请选择您要删除的内容!");
        return false;
      }
    }

  </script>
  </body></html>
