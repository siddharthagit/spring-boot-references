package com.javaexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

@Component
@Order(1)
public class LoadGithubRepo implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

  @Override
  public void run(String... args) throws Exception {
    RestTemplate restTemplate = new RestTemplateBuilder().build();
    ResponseEntity<JsonNode> quote = restTemplate
        .getForEntity("https://api.github.com/users/siddharthagit/repos", JsonNode.class);
    log.info(quote.toString());
  }
}