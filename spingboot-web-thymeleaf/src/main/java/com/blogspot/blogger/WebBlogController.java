package com.blogspot.blogger;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebBlogController {

  @GetMapping("/blog")
  public String blogHome(Model model) {
    List<BlogStoryModel> posts = new ArrayList<BlogStoryModel>();
    posts.add(new BlogStoryModel("Post 1", " post 1 content", "post 1 content summary", "Siddhartha"));
    model.addAttribute("RootPosts", posts);
    return "blog-post-list";
  }

}
