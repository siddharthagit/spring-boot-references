package com.bootng;

import java.util.Iterator;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * This Class List all the endpoints from URL https://api.github.com
 *
 */
@Component
@Order(1)
public class LoadAllGithubEndpoints implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ResttemplateApplication.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("about to call LoadAllEndpoint.run()");
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		ResponseEntity<JsonNode> apis = restTemplate.getForEntity("https://api.github.com", JsonNode.class);

		StringBuilder result = new StringBuilder("\nList of Public API's");

		apis.getBody().fields().next().getValue();
		Iterator<Entry<String, JsonNode>> it = apis.getBody().fields();
		while (it.hasNext()) {
			result.append("\n").append(it.next().getValue().asText());
		}

		log.info(result.toString());
	}
}
