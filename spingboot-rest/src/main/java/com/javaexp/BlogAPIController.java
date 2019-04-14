package com.javaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class BlogAPIController {

  private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

  @Autowired
  BlogService blogService;

  @RequestMapping(value = {"/blog"}, method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object addBlogStory(@RequestBody String input) {
    log.info("inside blog POST method");
    ObjectMapper mapper = new ObjectMapper();
    BlogStory response = new BlogStory();
    try {
      JsonNode jsonNode = mapper.readTree(input);
      if (jsonNode.get("id") != null) {
        response.setId(jsonNode.get("id").asInt());
      } else if (jsonNode.get("summary") != null) {
        response.setSummary(jsonNode.get("summary").asText());
      } else if (jsonNode.get("name") != null) {
        response.setName(jsonNode.get("name").asText());
      } else if (jsonNode.get("description") != null) {
        response.setDescription(jsonNode.get("description").asText());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    ResponseEntity<BlogStory> apiResponse = new ResponseEntity<BlogStory>(response, HttpStatus.OK);
    return apiResponse;
  }

  @RequestMapping(value = {"/blog"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object getBlogStories() {
    log.info("inside blog GET method");
    BlogStory blogStory = blogService.getBlogStory();
    ResponseEntity<BlogStory> apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.OK);
    return apiResponse;
  }
}
