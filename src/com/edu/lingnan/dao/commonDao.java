package com.edu.lingnan.dao;
import com.edu.lingnan.dto.*;
import com.edu.lingnan.util.DataAccess;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class commonDao {
  //登录方法
  public teacher findTeacherByNameAndPassword(int _tid, String _password){
    teacher t = null;
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      String sql = "select * from teacher where tid = ? and pass = ? ";
      prep = conn.prepareStatement(sql);
      prep.setInt(1,_tid);
      prep.setString(2,_password);
      rs = prep.executeQuery();
      System.out.println("commonDao 账号密码分别为" +_tid+_password);
      //如果有该用户
      if(rs.next()){
        System.out.println("commonDao找到该用户");
        t = new teacher();
        t.setTid(rs.getInt("tid"));
        t.setSex(rs.getString("sex"));
        t.setAdmin(rs.getInt("admin"));
        t.setInfo(rs.getString("info"));
        t.setRank(rs.getString("rank"));
        t.setTname(rs.getString("tname"));
        t.setPass(rs.getString("pass"));
        t.setEducation(rs.getString("education"));
        t.setSpeciality(rs.getString("speciality"));

      }
    }catch(SQLException e){
      e.printStackTrace();
    }finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return t;
  }

  //注册新用户
  public int register(String password,String tname,String sex,String education,String info,String speciality,String rank){
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    int tid = 0;
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("select count(tid) from teacher");
      rs = prep.executeQuery();
      while(rs.next()){
        tid = rs.getInt(1) + 1;
      }
      prep = conn.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?)");
      prep.setInt(1,tid);
      prep.setString(2,password);
      prep.setString(3,tname);
      prep.setString(4,sex);
      prep.setString(5,education);
      prep.setString(6,info);
      prep.setString(7,speciality);
      prep.setString(8,rank);
      prep.setInt(9,0);
      prep.executeUpdate();
    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return tid;
  }

  //查找所有的教师的信息
  public Vector<teacher> findAllTeachers(){
    Vector<teacher>  v = new Vector<teacher>();
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      stat = conn.createStatement();
      String sql = "select * from teacher";
      rs = stat.executeQuery(sql);
      while(rs.next()){
        teacher s = new teacher();
        s.setTid(rs.getInt("tid"));
        s.setTname(rs.getString("tname"));
        s.setPass(rs.getString("pass"));
        s.setAdmin(rs.getInt("admin"));
        s.setEducation(rs.getString("education"));
        s.setSpeciality(rs.getString("speciality"));
        s.setRank(rs.getString("rank"));
        s.setSex(rs.getString("sex"));
        s.setInfo(rs.getString("info"));
        v.add(s);
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

  //查找一个用户的project
  public myProject findUserProject(int proid){
    myProject s = new myProject();
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      stat = conn.prepareStatement("select * from myproject where proid = ?");
      stat.setInt(1,proid);
      rs = stat.executeQuery();
      while(rs.next()){
        s.setTid(rs.getInt("tid"));
        s.setTitle(rs.getString("title"));
        s.setMembers(rs.getString("members"));
        s.setContent(rs.getString("content"));
        s.setProid(rs.getInt("proid"));
        s.setId(rs.getInt("id"));
        s.setPass(rs.getInt("pass"));
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

  //查找所有新闻
  public Vector<news> findAllNews(){
    System.out.println("findAllNews被调用");
    Vector<news>  v = new Vector<news>();
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("select * from news");
      rs = prep.executeQuery();
      while(rs.next()){
        news s = new news();
        s.setId(rs.getInt("id"));
        s.setTitle(rs.getString("title"));
        s.setContent(rs.getString("content"));
        s.setDatetime(rs.getString("datetime"));
        v.add(s);
      }

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return v;
  }

  //查找所有的项目
  public Vector<project> findAllProjects(){
    System.out.println("findAllProjects被调用");
    Vector<project>  v = new Vector<project>();
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("select * from projects");
      rs = prep.executeQuery();
      while(rs.next()){
        project s = new project();
        s.setId(rs.getInt("id"));
        s.setTitle(rs.getString("title"));
        s.setContent(rs.getString("content"));
        s.setDdl(rs.getString("ddl"));
        v.add(s);
      }

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return v;
  }

  //查找一个项目
  public project findAProject(int id){
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    project p= new project();
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("select * from projects where id = ?");
      prep.setInt(1,id);
      rs = prep.executeQuery();
      while(rs.next()){
        p.setId(id);
        p.setTitle(rs.getString("title"));
        p.setContent(rs.getString("content"));
        System.out.println("项目的ddl"+rs.getString("ddl"));
        p.setDdl(rs.getString("ddl"));
      }

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return p;
  }


  //按关键词搜索
  public Vector<news> searchByKeywords(String keywords){
    Vector<news>  v = new Vector<news>();
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    System.out.println("关键词:"+keywords);
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("SELECT * FROM news WHERE title like ? OR content like ?  ");
      prep.setString(1,"%"+keywords+"%");
      prep.setString(2,"%"+keywords+"%");
      rs = prep.executeQuery();
      while(rs.next()){
        System.out.println("有找到");
        news s = new news();
        s.setId(rs.getInt("id"));
        s.setTitle(rs.getString("title"));
        s.setContent(rs.getString("content"));
        s.setDatetime(rs.getString("datetime"));
        v.add(s);
      }

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return v;
  }

  //修改密码:0.失败(修改的密码和原来密码一样) 1.成功
  public int ChangePass(int tid, String password){
    int flag = 0;
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    try {
      conn = DataAccess.getConnection();
      String sql1 = "select tid = '"+tid+"' from teacher";
      rs = stat.executeQuery(sql1);
      rs.next();

      //修改的密码和原来密码一样
      if(  rs.getInt("pass") == tid )
        return flag;

      //修改成功
      else {
        String sql2 = "set pass = '" + password + "' where tid = '" + tid + "'";
        stat.executeQuery(sql2);
        flag = 1;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flag;
  }

  //申报详情
  public myProject applyDetail(int proid){
    myProject mp = new myProject();
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      prep = conn.prepareStatement("select * from myproject where proid = ?");
      prep.setInt(1,proid);
      rs = prep.executeQuery();
      while(rs.next()){
        mp.setId(rs.getInt("id"));
        mp.setTid(rs.getInt("tid"));
        mp.setMembers(rs.getString("members"));
        mp.setPass(rs.getInt("pass"));
        mp.setTitle(rs.getString("title"));
        mp.setContent(rs.getString("Content"));
        mp.setProid(rs.getInt("proid"));
      }

    }catch (SQLException e){
      e.printStackTrace();
    }catch(NullPointerException e){
      e.printStackTrace();
    } finally{
      DataAccess.closeConnection(conn,prep,rs);
    }
    return mp ;

  }

  //我的未获批或我的在研项目或我的申报
  public Vector<myProject> findAllMyProjects(int tid,int pass){
    Vector v = new Vector<myProject>();
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    try{
      conn = DataAccess.getConnection();
      System.out.println("tid:"+tid);
      System.out.println("pass:"+pass);
      stat = conn.prepareStatement("select * from myproject where tid = ? and pass = ?");
      stat.setInt(1,tid);
      stat.setInt(2,pass);
      rs = stat.executeQuery();
      while(rs.next()){
        System.out.println("找到");
        myProject mp = new myProject();
        mp.setTid(rs.getInt("tid"));
        mp.setProid(rs.getInt("proid"));
        mp.setId(rs.getInt("id"));
        mp.setPass(rs.getInt("pass"));
        mp.setContent(rs.getString("content"));
        mp.setMembers(rs.getString("members"));
        mp.setTitle(rs.getString("title"));
        v.add(mp);
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

   //提交申报
  public boolean apply(int id,int tid,String title,String content,String members ){
    Connection conn = null;
     PreparedStatement prep = null;
    ResultSet rs = null;
    boolean flag = false;
    try{
    conn = DataAccess.getConnection();
    prep = conn.prepareStatement("insert into myproject values(?,?,null,?,?,?,?)");
    prep.setInt(1,id);
    prep.setInt(2,tid);
    prep.setString(3,title);
    prep.setString(4,content);
    prep.setString(5,members);
    prep.setInt(6,0);
    prep.executeUpdate();
    System.out.println("申报插入成功");
    flag =true;
  }catch (SQLException e){
    e.printStackTrace();
  }catch(NullPointerException e){
    e.printStackTrace();
  } finally{
    DataAccess.closeConnection(conn,prep,rs);
  }
    return flag;
}

}
