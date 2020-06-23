package com.bootng.model;

/**
 * Model to represent Blog Category
 */
public class BlogCategory {

	private String id;
	private String name;

	public BlogCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{id:" + this.id + " name: " + this.name + "}";
	}

	@Override
	public boolean equals(Object obj) {
		BlogCategory in = (BlogCategory) obj;
		return this.id.equals(in.id);
	}

}
