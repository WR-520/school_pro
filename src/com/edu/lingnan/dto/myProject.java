package com.edu.lingnan.dto;

public class myProject {
   int id;
   int tid;
   int proid;
  String title;
  String content;
  String members;
  int pass;

  public int getProid() {
    return proid;
  }

  public void setProid(int proid) {
    this.proid = proid;
  }

 public void setPass(int pass){
    this.pass = pass;
 }

  public int getPass() {
    return pass;
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getMembers() {
    return members;
  }

  public void setMembers(String members) {
    this.members = members;
  }
}
