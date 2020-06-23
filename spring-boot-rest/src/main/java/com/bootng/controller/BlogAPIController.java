package com.bootng.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;
import com.bootng.model.BlogStory;
import com.bootng.service.BlogService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Controller which is used to CRUD operation on BlogStory objects. It
 * uses @RestController, and returns ResponseEntity<BlogStory>
 *
 */
@RestController
@RequestMapping("/blogapi")
public class BlogAPIController {

	private static final Logger log = LoggerFactory.getLogger(BlogAPIController.class);

	@Autowired
	BlogService blogService;

	@RequestMapping(value = { "/v1/blogs" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogStory> addBlogStory(@RequestBody String input) {
		log.info("inside blog POST method" + input);
		ObjectMapper mapper = new ObjectMapper();
		BlogStory newStory = new BlogStory();
		try {
			JsonNode jsonNode = mapper.readTree(input);
			if (jsonNode.get("id") != null) {
				newStory.setId(jsonNode.get("id").asText());
			}
			if (jsonNode.get("name") != null) {
				newStory.setName(jsonNode.get("name").asText());
			}
			if (jsonNode.get("category") != null) {
				newStory.setCategory(jsonNode.get("category").asText());
			} else {
				newStory.setCategory("Finance");
			}
			if (jsonNode.get("summary") != null) {
				newStory.setSummary(jsonNode.get("summary").asText());
			}
			if (jsonNode.get("description") != null) {
				newStory.setDescription(jsonNode.get("description").asText());
			}

			blogService.addBlogStory(newStory);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		ResponseEntity<BlogStory> apiResponse = new ResponseEntity<BlogStory>(newStory, HttpStatus.CREATED);
		return apiResponse;
	}

	@RequestMapping(value = { "/v1/blogs" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BlogStory>> getBlogStories() {
		ResponseEntity<List<BlogStory>> apiResponse;
		try {
			List<BlogStory> blogStory = blogService.getBlogStories();
			apiResponse = new ResponseEntity<List<BlogStory>>(blogStory, HttpStatus.OK);
		} catch (AppException e) {
			apiResponse = new ResponseEntity<List<BlogStory>>(HttpStatus.INTERNAL_SERVER_ERROR);
			log.error(e.getMessage());
		}
		return apiResponse;
	}

	@RequestMapping(value = {
			"/v1/blogs/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogStory> getBlogStory(@PathVariable(value = "") String id) {
		ResponseEntity<BlogStory> apiResponse;
		BlogStory blogStory;
		try {
			blogStory = blogService.getBlogStory(id);
			apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.OK);
		} catch (NotFoundException e) {
			apiResponse = new ResponseEntity<BlogStory>(HttpStatus.NOT_FOUND);
			e.printStackTrace();
		} catch (AppException e) {
			apiResponse = new ResponseEntity<BlogStory>(HttpStatus.INTERNAL_SERVER_ERROR);
			log.error(e.getMessage());
		}
		return apiResponse;
	}

	@RequestMapping(value = {
			"/v2/blogs/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogStory> getBlogStoryV2(@PathVariable(value = "") String id)
			throws AppException, NotFoundException {
		BlogStory blogStory = blogService.getBlogStory(id);
		return new ResponseEntity<BlogStory>(blogStory, HttpStatus.OK);
	}
}
