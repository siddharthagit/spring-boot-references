package example.restapi.controller;
/*
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootng.model.Dish;
import com.bootng.service.DishService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Path("/api")
public class DishJerceyController {

	private static final Logger log = LoggerFactory.getLogger(DishJerceyController.class);

	
	@Autowired
	DishService repo;
	
	//DishRepository repo;
	
	
	
	
	@PostMapping("/dishes")
	@Produces("application/json")
	@Consumes("application/json")
	public ResponseBody addDish2(Dish data) throws Exception {
		log.info("--------------addDish----------------");
		try {
		//Dish dishDb = repo.createDish(data);
		throw new Exception ("xx");
		//return Response.ok(dishDb).build();
		}catch (Exception e) {
			
		}
		throw new Exception ("xx");
		//return Response.ok("").build();
	}
	
}

*/
