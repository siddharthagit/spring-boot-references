package com.javaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexp.model.BlogStory;


@Controller
@RequestMapping("/api/blog")
public class BlogAPIController {
  
  private static final Logger log = LoggerFactory.getLogger(RestApplication.class);
  
  @RequestMapping(value = {"/blog"}, method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object addTags(@RequestBody String input) {
    log.info("inside /blog POST method");
    ObjectMapper mapper = new ObjectMapper();
    BlogStory response = new BlogStory();
    try {
      JsonNode fc = mapper.readTree(input);
    } catch (Exception e) {
      e.printStackTrace();
    }

    ResponseEntity<BlogStory> apiResponse =
        new ResponseEntity<BlogStory>(response, HttpStatus.OK);
    return apiResponse;
  }
}
