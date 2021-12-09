package com.edu.lingnan.dto;

public class news {
  private int id;
  private String title;
  private String content;
  private String datetime;


  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getDatetime() {
    return datetime;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }
}
