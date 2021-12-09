package com.edu.lingnan.test;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

public class ServletTest extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Hello world!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Hello World!!!</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
