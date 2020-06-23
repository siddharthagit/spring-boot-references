package com.bootng.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bootng.beans.AppException;
import com.bootng.beans.DataException;
import com.bootng.beans.NotFoundException;
import com.bootng.model.BlogCategory;
import com.bootng.model.BlogStory;

/**
 * Service Class to create, retrieve different Objects
 * 
 * @author SiddB
 *
 */
@Service
public class BlogService {

	List<BlogCategory> categories = new ArrayList<BlogCategory>();

	List<String> tags = new ArrayList<String>();

	List<BlogStory> stories = new ArrayList<BlogStory>();

	{
		stories.add(new BlogStory("Java 11", "Technical", "Java 11 Blog"));
		stories.add(new BlogStory("Java 14", "Technical", "Java 14 Blog"));
		stories.add(new BlogStory("Asia Travel", "Travel", "Places to visit in Asia"));
		stories.add(new BlogStory("Europe Travel", "Travel", "Places to visit in Europe"));
		stories.add(new BlogStory("Japan Travel", "Travel", "Places to visit in Japan"));
		stories.add(new BlogStory("Asian Food", "Food", "Asian Food......"));

		categories = new ArrayList<BlogCategory>(Arrays.asList(new BlogCategory("1", "Technical"),
				new BlogCategory("2", "Travel"), new BlogCategory("3", "Food"), new BlogCategory("4", "Finance"),
				new BlogCategory("5", "Entertainment")));
		tags = Arrays.asList("Java", "Spring", "GCP", "Big Data", "BigQuery");
	}

	public List<BlogStory> getBlogStories() throws AppException {
		return stories;
	}

	public BlogStory getBlogStory(String id) throws AppException, NotFoundException {
		BlogStory ret = stories.stream().filter(story -> id.equals(story.getId())).findAny().orElse(null);
		if (ret == null)
			throw new NotFoundException("Blog with id " + id + " Not Found");
		return ret;
	}

	public void addBlogStory(BlogStory newStory) throws AppException, DataException {
		if (newStory == null)
			throw new DataException("BlogStory cannot be null");
		this.stories.add(newStory);
	}

	public List<String> getBlogTags() throws AppException {
		return tags;
	}

	public List<BlogCategory> getBlogCategories() throws AppException {
		return categories;
	}

	public BlogCategory getBlogCategory(String id) throws AppException, NotFoundException {
		BlogCategory ret = categories.stream().filter(story -> id.equals(story.getId())).findAny().orElse(null);
		if (ret == null)
			throw new NotFoundException("BlogCategory with id " + id + " Not Found");
		return ret;
	}

	public void addBlogCategories(BlogCategory cat) throws AppException, DataException {
		if (cat == null)
			throw new DataException("Cannot add null Category");
		if (categories.contains(cat))
			throw new DataException("Category already exists");
		this.categories.add(cat);
	}

	public List<String> getData() throws AppException {
		throw new AppException("Method Discontinued");
	}

}
