package com.bootng;

import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service Class which contains methods those are invoked from our controller
 * class.
 * 
 * @author SiddB
 *
 */
@Service
public class HelloService {

	private static final Logger log = LoggerFactory.getLogger(HelloService.class);

	public String hello() {
		return "Hello Spring Boot!";
	}

	public String bye() {
		String msg = "Bye..... Have a nice day!";
		log.info(msg);
		return msg;
	}

	@PreDestroy
	public void onDestroy() throws Exception {
		log.info("Spring Container is destroyed!");
		bye();
	}

}
