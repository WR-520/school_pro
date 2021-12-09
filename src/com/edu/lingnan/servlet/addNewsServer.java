package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dao.superDao;
import com.edu.lingnan.dto.news;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/addNews")
public class addNewsServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    System.out.println("来到addNewsServer");
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    System.out.println("页面参数获取成功");
    System.out.println( "title:" + title );
    System.out.println("content:" + content );
    //处理业务逻辑
    superDao sp = new superDao();
    sp.addNews(title,content);
    HttpSession session = req.getSession();
    //去往该去的页面
    resp.sendRedirect(req.getContextPath() + "/list.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }
}
