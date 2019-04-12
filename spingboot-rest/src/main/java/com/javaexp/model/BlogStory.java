package com.javaexp.model;

import java.util.ArrayList;
import java.util.List;

public class BlogStory {

  private Integer id;
  private String name;
  private String summary;
  private String description;
  private List<String> paragraphs;

  public BlogStory() {

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


  public List<String> getParagraph() {
    return paragraphs;
  }

  public void setParagraph(List<String> paragraph) {
    this.paragraphs = paragraph;
  }

  public void setParagraph(String paragraph) {
    if (this.paragraphs == null)
      this.paragraphs = new ArrayList<String>();
    this.paragraphs.add(paragraph);
  }


  @Override
  public String toString() {
    return "name=" + this.name;
  }

  public List<String> getParagraphs() {
    return paragraphs;
  }

  public void setParagraphs(List<String> paragraphs) {
    this.paragraphs = paragraphs;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
