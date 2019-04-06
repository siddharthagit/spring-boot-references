package com.javaexp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class BlogStory {

  private String uniqueName;
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



  public String getUniqueName() {
    return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
  }

  public List<String> getParagraphs() {
    return paragraphs;
  }

  public void setParagraphs(List<String> paragraphs) {
    this.paragraphs = paragraphs;
  }


}
