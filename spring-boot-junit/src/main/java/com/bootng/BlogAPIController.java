package com.bootng;

import java.util.List;
import javax.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootng.beans.AppException;
import com.bootng.model.BlogStory;

@RestController
@RequestMapping("/blogapi")
public class BlogAPIController {

	private static final Logger log = LoggerFactory.getLogger(BlogAPIController.class);

	@Autowired
	BlogService blogService;

	@RequestMapping(value = { "/blogs" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BlogStory>> getBlogStories() {
		log.info("inside getBlogStories GET method");
		List<BlogStory> blogStory = null;
		ResponseEntity<List<BlogStory>> apiResponse;
		try {
			blogStory = blogService.getBlogStory();
			apiResponse = new ResponseEntity<List<BlogStory>>(blogStory, HttpStatus.OK);
		} catch (AppException e) {
			apiResponse = new ResponseEntity<List<BlogStory>>(blogStory, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return apiResponse;
	}

	@RequestMapping(value = { "/blogs" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<BlogStory> getBlogStory(@PathParam(value = "") String id) {
		log.info("inside blog GET method");
		BlogStory blogStory = null;
		ResponseEntity<BlogStory> apiResponse;
		try {
			blogStory = blogService.getBlogStory(id);
			if (blogStory == null)
				apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.NOT_FOUND);
			else
				apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.OK);
		} catch (AppException e) {
			apiResponse = new ResponseEntity<BlogStory>(blogStory, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return apiResponse;
	}
}
