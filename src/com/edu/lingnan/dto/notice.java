package com.edu.lingnan.dto;

public class notice {
  int id;
  int tid;
  String title;
  String tname;
  int proid;

  public int getProid() {
    return proid;
  }

  public void setProid(int proid) {
    this.proid = proid;
  }

  public int getId() {
    return id;
  }

  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }

  public int getTid() {
    return tid;
  }



  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }
}
