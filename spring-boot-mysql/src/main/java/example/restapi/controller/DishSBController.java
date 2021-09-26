package example.restapi.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootng.service.DishService;

import example.restapi.dto.CustomPageResponse;
import example.restapi.model.Dish;
import example.restapi.repository.DishRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.hateoas.ResourceSupport;

@RestController
public class DishSBController {

	private static final Logger log = LoggerFactory.getLogger(DishSBController.class);

	
	//@Autowired
	//DishService repo;
	
	@Autowired
	DishRepository repo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return name;
	}
	
		
	@GetMapping(value="/dishes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Dish> getDish() throws Exception {
		log.info("-------------------------------");
		Iterable<Dish> result =  repo.findAll();
		log.info("-------------------------------" + result);
		List<Dish> output2 = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
		return output2;
	}
	
	
	
	@GetMapping(value="/dishes3",produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Dish> getDish3(@RequestParam int pageNo , @RequestParam int pageSize) throws Exception {
		log.info("-------------------------------");
		Sort sort = Sort.by("name");
		Pageable page =  PageRequest.of(pageNo, pageSize, sort);
		Page<Dish> result =  repo.findAll(page);
		return result;
	}
	
	@GetMapping(value="/dishes4",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomPageResponse> getDish4(@RequestParam int pageNo , @RequestParam int pageSize) throws Exception {
		log.info("-------------------------------");
		Sort sort = Sort.by("name");
		Pageable page =  PageRequest.of(pageNo, pageSize, sort);
		Page<Dish> result =  repo.findAll(page);
		CustomPageResponse response = new CustomPageResponse(result.getContent(), page.getPageSize(), page.getPageNumber());
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping(value="/dishes",produces = MediaType.APPLICATION_JSON_VALUE)
	public Dish addDish2(@RequestBody Dish data) throws Exception {
		log.info("--------------addDish----------------");
		Dish dishDb = repo.save(data);
		log.info("--------------addDish Finished----------------");
		return dishDb;
	}
	
}
