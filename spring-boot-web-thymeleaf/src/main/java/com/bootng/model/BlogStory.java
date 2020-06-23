package com.bootng.model;

public class BlogStory {

	private String id;
	private String name;
	private String summary;
	private String description;
	private String authorFullName;

	public BlogStory(String un, String n, String s, String d) {
		this.id = un;
		this.name = n;
		this.summary = s;
		this.description = d;
		this.authorFullName = "admin";
	}

	public String getUniqueName() {
		return id;
	}

	public void setUniqueName(String uniqueName) {
		this.id = uniqueName;
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
