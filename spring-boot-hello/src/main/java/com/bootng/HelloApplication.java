package com.bootng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({ "com.bootng" })
@SpringBootApplication
public class HelloApplication {

	private static final Logger log = LoggerFactory.getLogger(HelloApplication.class);

	public static void main(String args[]) {
		log.info("about to call HelloApplication.run()");
		SpringApplication.run(HelloApplication.class, args);
		log.info("completed executing HelloApplication.run()");
	}

}
