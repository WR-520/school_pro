package com.edu.lingnan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myapply")
public class myapplyServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    //处理业务逻辑

    //去往该去的页面
    if(req.getParameter("v") == null){
       req.setAttribute("v",1);

    }
    else{
      int v = Integer.parseInt(req.getParameter("v"));
      System.out.println("来到MyapplyServer:"+v);
      req.setAttribute("v",req.getParameter("v"));
    }
    req.getRequestDispatcher("/myapply.jsp").forward(req,resp);


  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    doGet(req,resp);
  }
}
