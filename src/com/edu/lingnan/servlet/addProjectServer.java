package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addProject")
public class addProjectServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    System.out.println("来到addProjectServer");
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String ddl = req.getParameter("ddl");
    //处理业务逻辑
    superDao sp = new superDao();
    sp.addProject(title,content,ddl);
    HttpSession session = req.getSession();
    //去往该去的页面
    resp.sendRedirect(req.getContextPath() + "/admin/addProject.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
