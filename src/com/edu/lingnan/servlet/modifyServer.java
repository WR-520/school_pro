package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;
import com.edu.lingnan.dto.editNews;
import com.edu.lingnan.dto.news;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

//编辑新闻内容
@WebServlet("/editNews")
public class modifyServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    //处理业务逻辑
    System.out.println("来到editNews");
    commonDao cd = new commonDao();
    int id = Integer.parseInt(req.getParameter("id"));
    String title = req.getParameter("title");
    System.out.println("title获取到了" + title);
    String content = req.getParameter("content");
    //String datetime = req.getParameter("datetime");
    System.out.println("获取到了题目和内容" + title);
//    System.out.println("获取到了"+ id);
    superDao sp = new superDao();
   // editNews en = sp.edit(id);
    sp.toEdit(id,title,content);

    //去往该去的页面

    resp.sendRedirect(req.getContextPath() + "list.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
