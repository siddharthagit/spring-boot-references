package com.javaexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({"com.javaexp"})
@SpringBootApplication
public class RestApplication {

  private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

  public static void main(String args[]) {
    log.info("about to call RestApplication.run()");
    SpringApplication.run(RestApplication.class, args);
    log.info("completed executing RestApplication.run()");
  }

}
