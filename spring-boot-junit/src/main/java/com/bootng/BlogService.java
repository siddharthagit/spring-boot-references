package com.bootng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bootng.beans.AppException;
import com.bootng.model.BlogStory;

@Service
public class BlogService {

	List<String> category = Arrays.asList("Technical", "Travel", "Food", "Finance", "Entertainment");

	List<BlogStory> stories = new ArrayList<BlogStory>();

	{
		stories.add(new BlogStory("Java 11", "Technical", "Java 11 Blog"));
		stories.add(new BlogStory("Java 14", "Technical", "Java 14 Blog"));
		stories.add(new BlogStory("Asia Travel", "Travel", "Places to visit in Asia"));
		stories.add(new BlogStory("Europe Travel", "Travel", "Places to visit in Europe"));
		stories.add(new BlogStory("Japan Travel", "Travel", "Places to visit in Japan"));
		stories.add(new BlogStory("Asian Food", "Food", "Asian Food......"));
	}

	public BlogStory getBlogStory(String id) throws AppException {
		return stories.stream().filter(story -> id.equals(story.getId())).findAny().orElse(null);
	}

	public List<BlogStory> getBlogStory() throws AppException {
		return stories;
	}

	public List<String> getBlogTags() throws AppException {
		return category;
	}
}
