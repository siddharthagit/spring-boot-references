package com.javaexp;

import org.springframework.stereotype.Service;
import com.javaexp.model.BlogStory;

@Service
public class BlogService {

  public BlogStory getBlogStory() {
    BlogStory blogStory = new BlogStory();
    blogStory.setId(10001);
    blogStory.setName("Blog One");
    blogStory.setSummary("Blog Summary");
    blogStory.setDescription("Blog Description");
    return blogStory;
  }
}
