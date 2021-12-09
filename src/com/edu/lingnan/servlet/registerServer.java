package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class registerServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String pass = req.getParameter("pass");
    String tname = req.getParameter("tname");
    String sex = req.getParameter("sex");
    String education = req.getParameter("education");
    String info = req.getParameter("info");
    String speciality = req.getParameter("speciality");
    String rank = req.getParameter("rank");
    System.out.println("来到registerServer");
    System.out.println(pass+tname+sex);
    //处理业务逻辑
   commonDao cd = new commonDao();
   int tid = cd.register(pass,tname,sex,education,info,speciality,rank);

    //去往该去的页面
     resp.sendRedirect(req.getContextPath() + "/registerSuccess.jsp?tid="+tid);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }

}
