package com.bootng;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

/*
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.bootng.beans.AppException;
import com.bootng.beans.NotFoundException;
import com.bootng.controller.BlogControllerV1;
import com.bootng.model.BlogStory;
import com.bootng.service.BlogService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BlogControllerV1.class, BlogService.class })
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlogAPIControllerTest {

	@Mock
	BlogService blogService;

	@InjectMocks
	private BlogControllerV1 controller;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void test_getBlogStories_success() throws AppException {

		when(blogService.getBlogStories()).thenReturn(new ArrayList<BlogStory>());

		ResponseEntity<List<BlogStory>> object = controller.getBlogStories();

		Assertions.assertEquals(HttpStatus.OK, object.getStatusCode(), "OK Status");

	}

	@Test
	public void test_getBlogStory_Not_found() throws AppException, NotFoundException {

		when(blogService.getBlogStory("444")).thenThrow(NotFoundException.class);

		ResponseEntity<BlogStory> object = controller.getBlogStory("444");

		Assertions.assertEquals(HttpStatus.NOT_FOUND, object.getStatusCode(), "OK Status");

	}

}
