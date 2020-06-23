package com.bootng.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.bootng" })
@SpringBootApplication
public class RestApplication {
	public static void main(String args[]) {
		SpringApplication.run(RestApplication.class, args);
	}
}
