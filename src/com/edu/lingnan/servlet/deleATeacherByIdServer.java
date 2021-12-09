package com.edu.lingnan.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.edu.lingnan.dao.superDao;

@WebServlet("/deleATeacher")
public class deleATeacherByIdServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      System.out.println("来到deleATeacherByIdServer");
      int tid = Integer.parseInt( req.getParameter("tid") );

      System.out.println("The value tid in deleATeacher is:" + tid);
      //处理业务逻辑
      superDao sd = new superDao();
      boolean flag = sd.deleATeacherByID(tid);
      HttpSession session = req.getSession();
      session.setAttribute("deleOrNot",flag);
      System.out.println("删除结果:"+flag);
      //去往该去的页面

     resp.sendRedirect(req.getContextPath() + "/success/allTeachers");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      doGet(req,resp);
    }

}
