package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/ToApply")
public class ToApplyServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    req.setCharacterEncoding("UTF-8");
    System.out.println("打印content" + req.getParameter("content"));
    System.out.println("打印tname" + req.getParameter("tname"));
    System.out.println("打印id"+req.getParameter("id"));
    int id = Integer.parseInt( req.getParameter("id") );
    int tid = Integer.parseInt(req.getParameter("tid"));
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String members = req.getParameter("members");

    //处理业务逻辑
    commonDao cm = new commonDao();
    cm.apply(id,tid,title,content,members);
    //去往该去的页面
    resp.sendRedirect(req.getContextPath() + "/myapply?v=0");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
