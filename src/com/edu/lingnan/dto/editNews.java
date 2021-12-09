package com.edu.lingnan.dto;

public class editNews {
  private int id;
  private String title;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private String content;
  private String datetime;

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

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }
}

