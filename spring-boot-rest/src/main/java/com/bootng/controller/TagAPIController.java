package com.bootng.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.beans.AppException;
import com.bootng.service.BlogService;

/**
 * Controller to handle Blog Tags.
 * Contains methods with different implementation
 * techniques but same result.
 *
 */
@RestController
@RequestMapping("/blogapi")
public class TagAPIController {

	private static final Logger log = LoggerFactory.getLogger(TagAPIController.class);

	@Autowired
	BlogService blogService;

	/**
	 * Returns ResponseEntity<List<String>> from the method
	 */

	@RequestMapping(value = { "v1/tags" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getTagsV1() {
		try {
			List<String> tags = blogService.getBlogTags();
			return ResponseEntity.ok().body(tags);
		} catch (AppException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Returns Tags with additional headers
	 * 
	 * @return
	 */
	@RequestMapping(value = {
			"v2/tags" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getTagsWithHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("API_CALL_LIMIT_PER_DAY", "500");
		headers.add("API_CALL_LIMIT_PER_MONTH", "10000");

		try {
			List<String> tags = blogService.getBlogTags();
			return new ResponseEntity<List<String>>(tags, headers, HttpStatus.OK);
		} catch (AppException e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<String>>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Returns List<String> from the method
	 */
	@RequestMapping(value = { "v3/tags" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getTagsV3() {
		List<String> tags = null;
		try {
			tags = blogService.getBlogTags();
		} catch (AppException e) {
			log.error(e.getMessage());
		}
		return tags;
	}

}
