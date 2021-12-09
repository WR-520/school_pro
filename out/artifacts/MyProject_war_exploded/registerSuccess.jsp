<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
  body{
    background:url(/images/ocean-bg.jpg) no-repeat!important;
  }
  #box{
    width:100%;
    height:100%;
    display:flex;
    display:-webkit-flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
  }
  #btn{
    float: right;
    width: 122px;
    height: 32px;
    background: url(/images/site_bg.png) no-repeat -153px -850px;
    border: none;
    color: #FFF;
    padding-bottom: 2px;
    font-size: 14px;
    font-weight: bold;
  }
</style>
<body>
<div id="box">
<h1>注册成功！您的账号是：<%=request.getParameter("tid")%></h1>
  <button id="btn" onclick="tologin()">立即登录</button>
</div>
</body>

</html>
<script>
  function tologin(){
    location.href="/login.html";
  }
</script>
