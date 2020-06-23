package com.bootng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({ "com.bootng" })
@SpringBootApplication
public class HelloApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(HelloApplication.class);

	public static void main(String[] args) {
		var app = new SpringApplication(HelloApplication.class);
		// app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Autowired
	HelloService service;

	@Override
	public void run(String... args) throws Exception {
		log.info(service.hello());
	}
}
