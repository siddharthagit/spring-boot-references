package com.javaexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class StartApplication {

  private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

  public static void main(String args[]) {
    SpringApplication.run(StartApplication.class, args);
  }

}
