package com.edu.lingnan.servlet;

import com.edu.lingnan.dao.commonDao;
import com.edu.lingnan.dto.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/success/allTeachers")
public class findAllTeachersServer extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1.获取页面提交的参数
   //2.处理业务逻辑
     commonDao c = new commonDao();
     Vector<teacher> v = c.findAllTeachers();
     System.out.println("来到findAllTeachersServer");
     HttpSession session = req.getSession();
     session.setAttribute("allTeachers",v);
     System.out.println("来到findAllTeachersServer");
     System.out.println(session.getAttribute("allTeachers"));
    //3.去往该去的地方
    resp.sendRedirect(req.getContextPath() + "/admin/allTeachers.jsp");
 }

  @Override
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);
  }

}
