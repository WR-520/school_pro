package com.edu.lingnan.test;
import com.edu.lingnan.dao.commonDao;
public class commonTest {
  public static void main(String []args) {
     commonDao test = new commonDao();
     System.out.println( test.findTeacherByNameAndPassword(1,"123456") );

  }
}
