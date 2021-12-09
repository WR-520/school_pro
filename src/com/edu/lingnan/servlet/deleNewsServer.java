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

//删除新闻
@WebServlet("/deleteNews")
public class deleNewsServer extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    commonDao cd = new commonDao();
    superDao sp = new superDao();
    String id = req.getParameter("id");
    String all = req.getParameter("flag");
    System.out.println("sid = " + id);
    boolean flag = false;
    if(all!=null){  //批量删除
        String []temp = id.split(",");
        for(String tt : temp){
          sp.deleNewsByID(Integer.parseInt(tt));
        }
        flag = true;
    }else{//单个删除
        flag = sp.deleNewsByID(Integer.parseInt(id) );
    }
    if(flag){
      resp.sendRedirect(req.getContextPath() + "/list.jsp");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doGet(req,resp);
  }

}

