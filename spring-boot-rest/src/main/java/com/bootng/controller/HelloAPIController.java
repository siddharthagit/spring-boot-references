package com.bootng.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAPIController {

	@RequestMapping(value = {
			"helloapi/welcome" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> wecome1() {
		return ResponseEntity.ok().body("Hello User, Good Morning");
	}

	@RequestMapping(value = {
			"helloapi/welcome2" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> wecome2() {
		return ResponseEntity.ok().body("Hello Smarty, Good Afternoon");
	}

	@RequestMapping(value = {
			"helloapi/welcome3" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> wecom3() {
		return ResponseEntity.ok().body("Good User, Good Evening");
	}

}
