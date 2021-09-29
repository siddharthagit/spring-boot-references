package com.bootng.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;
import com.bootng.model.BlogStory;
import com.bootng.service.BlogService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Hidden;

/**
 * Controller which is used to CRUD operation on BlogStory objects. It
 * uses @RestController, and returns ResponseEntity<BlogStory>
 *
 */
@Hidden

@Controller
@RequestMapping("/blogapi/v0/")
public class BlogControllerV0 {

	private static final Logger log = LoggerFactory.getLogger(BlogControllerV0.class);

	@Autowired
	BlogService blogService;

	
	@RequestMapping(value = { "blogs" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<BlogStory> getBlogStories() {
		List<BlogStory> apiResponse = new ArrayList<>();
		try {
			apiResponse = blogService.getBlogStories();
		} catch (AppException e) {
			log.error(e.getMessage());
		}
		return apiResponse;
	}
}
