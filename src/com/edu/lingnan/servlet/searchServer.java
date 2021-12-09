package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/searchByKeywords")
public class searchServer  extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    //处理业务逻辑
    System.out.println("来到searchServer");
    System.out.println( req.getRequestURL().toString() );
    String keywords = req.getParameter("keywords");
    req.setAttribute("search",keywords);
    System.out.println("获取到的keywords是" + keywords);
    //去往该去的页面
    req.getRequestDispatcher("/searchlist.jsp").forward(req,resp);
    //resp.sendRedirect(req.getContextPath() + "/list.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    doGet(req,resp);
  }
}
