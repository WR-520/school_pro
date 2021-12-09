package com.edu.lingnan.dto;

public class course {
  private int cid;
  private int tid;
  private String cname;
  private String provide_course;
  private float credit;

  public String getProvide_course() {
    return provide_course;
  }

  public void setProvide_course(String provide_course) {
    this.provide_course = provide_course;
  }

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public float getCredit() {
    return credit;
  }

  public void setCredit(float credit) {
    this.credit = credit;
  }
}
