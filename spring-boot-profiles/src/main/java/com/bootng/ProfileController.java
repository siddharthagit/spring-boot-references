package com.bootng;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller list all the active profile and prints them.
 * 
 * @author SiddB
 *
 */
@RestController
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	private Environment environment;

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> paymentInfo() {

		logger.info("Inside GET profile");
		
		String result = "Currently active profile - ";
		for (String profileName : environment.getActiveProfiles()) {
			result += " " + profileName;
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
