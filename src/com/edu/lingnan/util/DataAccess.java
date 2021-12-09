package com.edu.lingnan.util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DataAccess {

    private static  Connection conn = null;
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
//    private static String xmlPath = "out//production//MyProject//database.conf.xml";
//    private static String xsdPath= "out//production//MyProject//database.conf.xsd";
    private static String xmlPath = "database.conf.xml";
    private static String xsdPath = "database.conf.xsd";

    static{
//      当前线程的类加载器获取当前资源的当前路径
      String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
      xmlPath = basePath + xmlPath;
      xsdPath = basePath + xsdPath;
//     验证为真开始解析
      if(XmlValidate.validate(xmlPath,xsdPath) ){
        try {
          HashMap<String,String> hm = XmlParser.parser(xmlPath);
          driver = hm.get("driver");
          url = hm.get("url");
          user = hm.get("user");
          password = hm.get("password");
          System.out.println(driver + " " + url + " " + user + " " + password );
        } catch (ParserConfigurationException e) {
          e.printStackTrace();
        } catch (SAXException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }

    //返回这个数据库的连接
    public static Connection getConnection() {
           try {
               Class.forName(driver);
               conn = DriverManager.getConnection(url,user,password);
               return conn;
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       return null;
    }

    //关闭数据库连接的方法
    public static void closeConnection
    (Connection conn,Statement stat, ResultSet rs){
       try{
           if(rs != null)
               rs.close();
           if(stat != null)
               stat.close();
           if(conn != null)
               conn.close();
       }catch(SQLException e){
           e.printStackTrace();
       }
    }

    public static void closeConnection
            (Connection conn, PreparedStatement prep, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (prep != null)
                prep.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection
            (Connection conn,PreparedStatement prep){
        try{
            if(prep!=null)
                prep.close();
            if(conn !=null)
                conn.close();
        }catch( SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeRsandPrep(PreparedStatement prep,ResultSet rs){
        try{
            if(rs!=null)
                rs.close();
            if(prep!=null)
                prep.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

