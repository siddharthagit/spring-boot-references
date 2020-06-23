package com.bootng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;
import com.bootng.service.BlogService;

/**
 * Controller Class to handle comments This Controller uses @RestController
 * annotation
 * 
 * @author SiddB
 */
@RestController
@RequestMapping("/blogapi")
public class CommentsAPIController {

	@Autowired
	BlogService blogService;

	@GetMapping(value = "/v1/comments", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllComments() throws AppException {
		throw new AppException("Feature not available");
	}

	@GetMapping(value = "/v1/comments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCommentById(@PathVariable(value = "") String id) throws NotFoundException, AppException {
		// if comments not found with id throw notfound exception
		throw new AppException("Feature not available");
	}

	@PostMapping(value = "/v1/comments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	// @RequestMapping(value = {"/v1/comments"}, method = RequestMethod.POST,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	public String add(@RequestBody String newComment) throws AppException {
		throw new AppException("Feature not available");
	}

	@GetMapping(value = "/v1/comments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody String newComment, @PathVariable(value = "") String id) throws AppException {
		return "Feature not available";
	}

}
