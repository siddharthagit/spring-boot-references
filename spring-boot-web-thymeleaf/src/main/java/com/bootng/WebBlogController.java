package com.bootng;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootng.model.BlogStory;

/**
 * Controller Class for the BlogHome. It is mapped to path /blog. and populates
 * model object with List of BlogStory objects and returns blog-post-list
 * template page
 * 
 * @author SiddB
 *
 */
@Controller
public class WebBlogController {

	@GetMapping("/blog")
	public String blogHome(Model model) {
		List<BlogStory> posts = new ArrayList<BlogStory>();
		posts.add(new BlogStory("post101", "Blog about Earth", "Earth blog ", "Admin"));
		posts.add(new BlogStory("post102", "Blog about Moon", "Moon blog ", "Admin"));
		posts.add(new BlogStory("post102", "Blog about Sun", "Sun blog ", "Admin"));
		posts.add(new BlogStory("post102", "Blog about Java", "Java blog ", "Admin"));
		model.addAttribute("RootPosts", posts);
		return "blog-post-list";
	}

}
