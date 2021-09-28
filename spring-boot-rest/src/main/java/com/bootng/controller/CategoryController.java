package com.bootng.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;
import com.bootng.model.BlogCategory;
import com.bootng.service.BlogService;

/**
 * Controller used to create and retrieve BlogCategory A Controller
 * with @Controller @ResponseBody and ResponseEntity
 *
 */
@Controller
@RequestMapping("/blogapi/v1")
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	BlogService blogService;

	/**
	 * Controller method that returns list of all categories wrapped in
	 * ResponseEntity object.
	 * 
	 * @return List of all BlogCategory
	 */
	@RequestMapping(value = {
			"/categories" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<BlogCategory>> getBlogCats() {
		ResponseEntity<List<BlogCategory>> apiResponse;
		try {
			List<BlogCategory> categories = blogService.getBlogCategories();
			apiResponse = new ResponseEntity<List<BlogCategory>>(categories, HttpStatus.OK);
		} 
		catch (AppException e) {
			apiResponse = new ResponseEntity<List<BlogCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
			log.error(e.getMessage());
		}

		return apiResponse;
	}

	/**
	 * Controller method that returns a specific BlogCategory wrapped in
	 * ResponseEntity object.
	 * 
	 * @return BlogCategory
	 */
	@RequestMapping(value = {
			"/categories/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogCategory> getBlogStory(@PathVariable(value = "") String id) {
		ResponseEntity<BlogCategory> apiResponse;
		BlogCategory blogCategory;
		try {
			blogCategory = blogService.getBlogCategory(id);
			apiResponse = new ResponseEntity<BlogCategory>(blogCategory, HttpStatus.OK);
		} catch (NotFoundException e) {
			apiResponse = new ResponseEntity<BlogCategory>(HttpStatus.NOT_FOUND);
			e.printStackTrace();
		} catch (AppException e) {
			apiResponse = new ResponseEntity<BlogCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
			log.error(e.getMessage());
		}
		return apiResponse;
	}

	/**
	 * Controller method adds a BlogCategory object.
	 * 
	 * @return Newly created BlogCategory object.
	 */
	@RequestMapping(value = { "/categories" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BlogCategory> addCats(@RequestBody BlogCategory input) {
		try {
			log.info("payload: " + input);
			blogService.addBlogCategories(input);
			return ResponseEntity.ok().body(input);
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
