package com.bootng.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.beans.AppException;
import com.bootng.beans.DataException;
import com.bootng.beans.NotFoundException;
import com.bootng.model.BlogStory;
import com.bootng.service.BlogService;

/**
 * Controller which is used to CRUD operation on BlogStory objects. It
 * uses @RestController, and returns ResponseEntity<BlogStory>
 *
 */
@RestController
@RequestMapping("/blogapi/v2/")
public class BlogControllerV2 {

	private static final Logger log = LoggerFactory.getLogger(BlogControllerV2.class);

	@Autowired
	BlogService blogService;

	@PostMapping(value = "blogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogStory> addBlogStory(@RequestBody BlogStory newStory) throws AppException, DataException {
		log.info("inside blog POST method" + newStory);
		blogService.addBlogStory(newStory);
		ResponseEntity<BlogStory> apiResponse = new ResponseEntity<BlogStory>(newStory, HttpStatus.CREATED);
		return apiResponse;
	}

	@GetMapping(value = "blogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BlogStory>> getBlogStories() throws AppException {
		List<BlogStory> blogStory;
		blogStory = blogService.getBlogStories();
		return ResponseEntity.ok(blogStory);
	}

	@GetMapping(value = "blogs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogStory> getBlogStory(@PathVariable(value = "") String id)
			throws AppException, NotFoundException {
		ResponseEntity<BlogStory> apiResponse;
		BlogStory blogStory;
		blogStory = blogService.getBlogStory(id);
		apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.OK);
		return apiResponse;
	}

}
