package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/editProject")
public class eidtProjectServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    //处理业务逻辑
    System.out.println("来到editProject");
    commonDao cd = new commonDao();
    int id = Integer.parseInt(req.getParameter("id"));
    String title = req.getParameter("title");
    System.out.println("title获取到了" + title);
    String content = req.getParameter("content");
    System.out.println("获取到了题目和内容" + title);
    String ddl = req.getParameter("ddl");
//    System.out.println("获取到了"+ id);
    superDao sp = new superDao();
    // editNews en = sp.edit(id);
    sp.eidtOrNot(id,title,content,ddl);

    //去往该去的页面

    resp.sendRedirect(req.getContextPath() + "/admin/projects.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
