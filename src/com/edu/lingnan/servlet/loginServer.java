package com.edu.lingnan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import com.edu.lingnan.dao.*;
import com.edu.lingnan.dto.teacher;
public class loginServer extends HttpServlet {
//  GET 调用用于获取服务器信息，并将其做为响应返回给客户端。
//  当经由Web浏览器或通过HTML、JSP直接访问Servlet的URL时，一般用GET调用。
//  GET调用在URL里显示正传送给SERVLET的数据，这在系统的安全方面可能带来一些问题，
//  比如用户登录，表单里的用户名和密码需要发送到服务器端， 若使用Get调用，就会在浏览器的URL中显示用户名和密码。
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {



    //1 获取用户提交的参数 获取页面传递的数据
    int tid = Integer.parseInt(req.getParameter("tid"));
    String pass = req.getParameter("pass");
    System.out.println("页面参数获取成功,用户名和密码分别为" +tid +" " + pass);
    //2 处理这些参数，通过调用业务逻辑来处理，有可能要访问数据库
    commonDao  t = new commonDao();
//    T为该用户对象
    teacher T = t.findTeacherByNameAndPassword(tid,pass);
    int superuser = -1;
    if(T!=null) {
      System.out.println("找到该用户");
      superuser = T.getAdmin();
      //登录之后需要HttpSession
      HttpSession session = req.getSession();
      //session key-value
      session.setAttribute("tid",tid);
      session.setAttribute("admin",T.getAdmin());
      session.setAttribute("education",T.getEducation());
      session.setAttribute("rank",T.getRank());
      session.setAttribute("tname",T.getTname() );
      session.setAttribute("info",T.getInfo());
      session.setAttribute("sex",T.getSex());
      session.setAttribute("speciality",T.getSpeciality());
      //3 给出一个响应 或者返回到某一特定的页面
    }
    if (superuser != -1) {
      System.out.println("superuser:" + superuser);
      resp.sendRedirect(req.getContextPath() + "/success.jsp");
    }
    else
      resp.sendRedirect(req.getContextPath() + "/fail.html");

  }
//  它用于客户端把数据传送到服务器端，也会有副作用。但好处是可以隐藏传送给服务器的任何数据。Post适合发送大量的数据。
  @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1.调用请求对象 读取【请求头】参数信息
    String userName = req.getParameter("userName");
    String credential  = req.getParameter("credential");
    //2.开卡
    Cookie card1 =  new Cookie("userName",userName);
    Cookie card2 = new Cookie("credential",credential);
    //3. 发卡 将Cookie写入到响应头交给浏览器
    resp.addCookie(card1);
    resp.addCookie(card2);
    //4.通知Tomcat将【点餐页面内容】写入到响应体交给浏览器(请求转发)
    req.getRequestDispatcher("").forward(req,resp);
    doGet(req,resp);

  }
}
