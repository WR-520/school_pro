package com.edu.lingnan.dto;

public class teacher {
  private int tid;
  private String pass;
  private String tname;
  private String sex;
  private String education;
  private String info;
  private String speciality;
  private String rank;
  //private String department;
  private int admin;

 // public String getDepartment() {
 //   return department;
  //}

 // public void setDepartment(String department) {
  //  this.department = department;
  //}

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }

  public String getTname() {
    return tname;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String birthday) {
    this.info= birthday;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public int getAdmin() {
    return admin;
  }

  public void setAdmin(int admin) {
    this.admin = admin;
  }

}
