package com.bootng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({ "com.bootng", "com.bootng.service" })
@SpringBootApplication
public class RestApplication {

	private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

	public static void main(String args[]) {
		log.info("about to call RestApplication.run()");

		// set extra profile
		SpringApplication application = new SpringApplication(RestApplication.class);
		// application.setAdditionalProfiles("prod");

		application.run(args);

		log.info("completed executing RestApplication.run()");

	}

}
