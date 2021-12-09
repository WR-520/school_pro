package com.edu.lingnan.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityFilter implements Filter {
 @Override
 public void destroy(){
   System.out.println("销毁......");
 }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
    //1.从session获取登录用户的权限
    HttpServletRequest req = (HttpServletRequest)request;
    System.out.println("来到过滤器");
    HttpSession session =  req.getSession();
    Integer superuser = (Integer)session.getAttribute("admin");
    System.out.println("The superuser's value in Authority is:" + superuser);
    //2.根据权限去到相应的页面
    HttpServletResponse resp = (HttpServletResponse)response;
    if(superuser!=null) {
      System.out.println("管理员权限为："+superuser);
      if (superuser == 1) {
        //过滤通过，去往该去的页面
        //请求和响应继续往后传 进行下一步的过滤或者资源请求
        chain.doFilter(request,response);
      }
      //superuser==0时
      else{
        System.out.println("req.getContextPath():" + req.getContextPath()+"/authority.html");
       resp.sendRedirect(req.getContextPath() + "/authority.html ");
      }
    }else{
      //没有登录，连普通用户都不是，直接去往登录页面
      resp.sendRedirect(req.getContextPath()+"/login.html");
    }
    //chain.doFilter(request,response);
    //3.

  }
  public void init(FilterConfig arg0)throws ServletException{
   System.out.println("初始化......");
  }
}
