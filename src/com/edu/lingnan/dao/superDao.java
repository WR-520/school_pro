package com.edu.lingnan.dao;
import com.edu.lingnan.dto.*;
import com.edu.lingnan.util.DataAccess;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class superDao {
  //删除一个教师
  public boolean deleATeacherByID(int id) {
    boolean flag = false;

    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    System.out.println("哈哈哈哈 删除被调用");
    System.out.println("要删除的是 '"+id+"'");
    try {
      conn = DataAccess.getConnection();
      prep = (PreparedStatement) conn.prepareStatement("select admin from teacher where tid = ?");
      prep.setInt(1,id);
      //查找这个人
      rs = prep.executeQuery();
      while(rs.next()) {
        System.out.println("找到了");
        int admin = rs.getInt("admin");
        //不能删除管理员
        if (admin == 1) {
          System.out.println("警告 这是管理员 不能删除");
          flag = false;
        }
         else{
          prep = (PreparedStatement) conn.prepareStatement("delete from teacher where tid =?");
          prep.setInt(1, id);
          prep.addBatch();
          prep.executeUpdate();
          flag = true;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DataAccess.closeConnection(conn, prep,rs);
    }
    return flag;
  }

  //查找一个教师
  public teacher findATeacher(int tid){
      teacher s = new teacher();
      Connection conn = null;
      PreparedStatement stat = null;
      ResultSet rs = null;
      try{
        conn = DataAccess.getConnection();
        stat = conn.prepareStatement("select * from teacher where tid = ?");
        stat.setInt(1,tid);
        rs = stat.executeQuery();
        while(rs.next()){
          s.setTid(rs.getInt("tid"));
          s.setTname(rs.getString("tname"));
          s.setPass(rs.getString("pass"));
          s.setAdmin(rs.getInt("admin"));
          s.setEducation(rs.getString("education"));
          s.setSpeciality(rs.getString("speciality"));
          s.setRank(rs.getString("rank"));
          s.setSex(rs.getString("sex"));
          s.setInfo(rs.getString("info"));

        }

      }catch (SQLException e){
        e.printStackTrace();
      }catch(NullPointerException e){
        e.printStackTrace();
      } finally{
        DataAccess.closeConnection(conn,stat,rs);
      }
     return s;
  }

  //审批通过或是不通过
  public boolean passOrNot(int proid,int pass){
    boolean flag = false;
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      stat = conn.prepareStatement("update myproject set pass = ?  where proid = ?");
      stat.setInt(1,pass);
      stat.setInt(2,proid);
      stat.executeUpdate();
      flag = true;

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,stat,rs);
    }
     return flag;
  }

  //删除新闻
  public boolean deleNewsByID(int id){
    boolean flag = false;
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    System.out.println("删除新闻被调用");
    System.out.println("要删除的是 '"+id+"'");
    try {
      conn = DataAccess.getConnection();
      prep = (PreparedStatement) conn.prepareStatement("delete from news where id = ?");
      prep.setInt(1,id);
      prep.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DataAccess.closeConnection(conn, prep);
    }
    return flag;
  }

  //删除项目
  public boolean deleProjectByID(int id){
    boolean flag = false;
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    try {
      conn = DataAccess.getConnection();
      prep = (PreparedStatement) conn.prepareStatement("delete from projects where id = ?");
      prep.setInt(1,id);
      prep.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DataAccess.closeConnection(conn, prep);
    }
    return flag;
  }


  //添加新闻
  public void addNews(String title, String content){
    System.out.println("addNews.java被调用");
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String now = df.format(new Date());
    try{
      System.out.println(title + content + now);
      conn = DataAccess.getConnection();
      stat = conn.createStatement();
      stat.executeUpdate("insert into news (title, content,datetime) values('"
        + title + "','" + content + "','"+ now+ "')");
//     // prep.setInt(1,null);
//      prep.setString(1,title);
//      prep.setString(2,content);
//
//      System.out.println(now);
//      System.out.println(now);// new Date()为获取当前系统时间
//      prep.setString(3,now);
//      prep.executeUpdate();

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,stat,rs);
    }
  }

  //添加科研通知
  public void addProject(String title, String content,String ddl){
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      stat = conn.createStatement();
      stat.executeUpdate("insert into projects (title, content,ddl) values('"
        + title + "','" + content + "','"+ ddl+ "')");

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,stat,rs);
    }
  }

  //管理员的消息通知
  public Vector<notice> myNotice(){
    Vector<notice>  v = new Vector<notice>();
  Connection conn = null;
  PreparedStatement stat = null;
  ResultSet rs = null;
  System.out.println("管理员的消息通知");
    try{
    conn = DataAccess.getConnection();
    stat = conn.prepareStatement(
      "select projects.id,teacher.tid,projects.title," +
        "myproject.proid,teacher.tname from myproject inner join projects " +
        "ON myproject.id = projects.id inner Join teacher ON teacher.tid = myproject.tid " +
        "where myproject.pass = 0;"
    );
    rs = stat.executeQuery();
    while(rs.next()){
      notice n = new notice();
      n.setId(rs.getInt("id"));
      System.out.println(rs.getInt("id"));
      n.setTid(rs.getInt("tid"));
      n.setProid(rs.getInt("proid"));
      n.setTitle(rs.getString("title"));
      n.setTname(rs.getString("tname"));
      v.add(n);
    }

  }catch (SQLException e){
    e.printStackTrace();
  }catch(NullPointerException e){
    e.printStackTrace();
  } finally{
    DataAccess.closeConnection(conn,stat,rs);
  }
    return v;
}


  //编辑项目
  public editProject editProject(int id){

    Connection conn = null;
    java.sql.PreparedStatement prep = null;
    ResultSet rs = null;
    editProject en = new editProject();
    try{
      conn = DataAccess.getConnection();
      String sql = "select * from projects where id = ?";
      prep = conn.prepareStatement(sql);
      prep.setInt(1,id);
      rs = prep.executeQuery();

      //如果有该用户
      if(rs.next()){

        en.setId( rs.getInt("id") );
        en.setTitle(rs.getString("title"));
        en.setContent(rs.getString("content"));
        en.setDdl(rs.getString("ddl"));
     //   System.out.println("title"+ en.getTitle());
      }
    }catch(SQLException e){
      e.printStackTrace();
    }finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return en;
  }

  //编辑新闻
  public editNews edit(int id){

    Connection conn = null;
    java.sql.PreparedStatement prep = null;
    ResultSet rs = null;
    editNews en = new editNews();
    try{
      conn = DataAccess.getConnection();
      String sql = "select * from news where id = ?";
      prep = conn.prepareStatement(sql);
      prep.setInt(1,id);
      rs = prep.executeQuery();

      //如果有该用户
      if(rs.next()){

        en.setId( rs.getInt("id") );
        en.setTitle(rs.getString("title"));
        en.setContent(rs.getString("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String now = df.format(new Date());
        en.setDatetime(now);
        System.out.println("title"+ en.getTitle());
      }
    }catch(SQLException e){
      e.printStackTrace();
    }finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return en;
  }


  public boolean toEdit(int id,String title,String content) {
    boolean flag = false;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String now = df.format(new Date());
    Connection conn = null;
    PreparedStatement prep = null;
    try {
      conn = DataAccess.getConnection();
      //prep = conn.prepareStatement("update news set title = '"+title+"', content = '"+content+"',datetime='"+now+"' where id = '"+id+"' ");
      prep = conn.prepareStatement("update news set title = ?, content = ?,datetime=? where id = ?");
      prep.setString(1,title);
      prep.setString(2,content);
      prep.setString(3,now);
      prep.setInt(4,id);
      prep.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DataAccess.closeConnection(conn, prep);
    }
    return flag;
  }


  //编辑科研通知
  public boolean eidtOrNot(int id,String title,String content,String ddl) {
    boolean flag = false;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String now = df.format(new Date());
    Connection conn = null;
    PreparedStatement prep = null;
    try {
      conn = DataAccess.getConnection();
      //prep = conn.prepareStatement("update news set title = '"+title+"', content = '"+content+"',datetime='"+now+"' where id = '"+id+"' ");
      prep = conn.prepareStatement("update projects set title = ?, content = ?,ddl=? where id = ?");
      prep.setString(1,title);
      prep.setString(2,content);
      prep.setString(3,ddl);
      prep.setInt(4,id);
      prep.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DataAccess.closeConnection(conn, prep);
    }
    return flag;
  }
}
