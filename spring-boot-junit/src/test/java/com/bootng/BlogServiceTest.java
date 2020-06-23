package com.bootng;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.bootng.beans.AppException;
import com.bootng.model.BlogStory;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BlogService.class })
public class BlogServiceTest {

	@Autowired
	BlogService service;

	@Test
	public void test_getBlogStory() {

		List<BlogStory> list;
		try {
			list = service.getBlogStory();
			Assertions.assertNotNull(list, "list should not be null");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test_getBlogStory_with_id() {

		BlogStory data;
		try {
			data = service.getBlogStory("Java_11");
			Assertions.assertNotNull(data, "data should not be null");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
