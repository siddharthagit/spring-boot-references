package com.bootng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ResttemplateApplication {

	private static final Logger log = LoggerFactory.getLogger(ResttemplateApplication.class);

	public static void main(String args[]) {
		log.info("about to call ResttemplateApplication.run()");
		SpringApplication.run(ResttemplateApplication.class, args);
		log.info("completed executing ResttemplateApplication.run()");
	}

}
