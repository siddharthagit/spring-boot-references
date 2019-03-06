package com.blogspot.blogger;

public class BlogStoryModel {

  private String uniqueName;
  private String name;
  private String summary;
  private String description;
  private String authorFullName;
  
  
  public BlogStoryModel(String un, String n, String s, String d) {
    this.uniqueName = un;
    this.name = n;
    this.summary = s;
    this.description = d;
    this.authorFullName = "Siddharthagit";
  }
  
  public String getUniqueName() {
    return uniqueName;
  }
  public void setUniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getAuthorFullName() {
    return authorFullName;
  }

  public void setAuthorFullName(String authorFullName) {
    this.authorFullName = authorFullName;
  }


}
