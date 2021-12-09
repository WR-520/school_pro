<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.edu.lingnan.dao.superDao" %>
<%@ page import="com.edu.lingnan.dto.teacher" %>
<%@ page import="com.edu.lingnan.dao.commonDao" %>
<%@ page import="com.edu.lingnan.dto.myProject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<% int tid = Integer.parseInt(request.getParameter("tid"));
   int proid =Integer.parseInt(request.getParameter("proid"));
   int pass = Integer.parseInt(request.getParameter("pass"));
   superDao sp = new superDao();
   sp.passOrNot(proid,pass);
   teacher t = new superDao().findATeacher(tid);
   String tname = t.getTname();
   String yx = t.getInfo();
   commonDao cm = new commonDao();
   myProject mp = cm.findUserProject(proid);
 %>

  <%
   String result;
   // 发件人的电子邮件
   String from = "1016002920@qq.com";

   // 授权码
   String code = "vzawavvjehxsbdja";

   // 收件人的电子邮件
//   String to = "2038835087@qq.com";
    String to = yx;

   // 假设你是从本地主机发送电子邮件
   String host = "localhost";

   // 获取系统属性对象
   Properties properties = System.getProperties();

   // 设置邮件传输协议为SMTP
   properties.setProperty("mail.transport.protocol", "SMTP");

   // 设置邮件服务器
   properties.setProperty("mail.host", "smtp.qq.com");
   properties.setProperty("mail.smtp.auth", "true");

   // 构建授权对象
   Authenticator authenticator = new Authenticator() {
     public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(from, code);
     }
   };

   // 获取默认的Session对象。
   Session mailSession = Session.getInstance(properties, authenticator);

   try{
      // 创建一个默认的MimeMessage对象。
      MimeMessage message = new MimeMessage(mailSession);
      // 设置 From: 头部的header字段
      message.setFrom(new InternetAddress(from));
      // 设置 To: 头部的header字段
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));
      // 设置 Subject: header字段
      message.setSubject("来自简易科研平台");
      // 现在设置的实际消息
//      message.setText("This is actual message");
      message.setText("亲爱的"+tname+"：您的项目《"+mp.getTitle()+"》已获审！请自行前去查看。");
      // 发送消息
      Transport.send(message);
      result = "Sent message successfully...";
   }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }
%>
<html>
<head>
  <title>Send Email using JSP</title>
</head>
<body>
<center>
<%--  <h1>Send Email using JSP</h1>--%>
</center>
<p align="center">
  <%
    out.println("Result: " + result + "\n");
  %>
</p>
</body>
</html>
