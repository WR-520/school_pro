package com.edu.lingnan.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//注解的方式
@WebServlet(urlPatterns={"/loginout","/admin/loginout"})
public class loginOutServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    System.out.println("in the LoginOutServlet");
    //处理业务逻辑
    HttpSession session = req.getSession();
    session.invalidate();
    //去往该去的页面
    resp.sendRedirect(req.getContextPath() + "/login.html");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
