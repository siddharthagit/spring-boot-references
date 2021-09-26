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
import org.springframework.web.multipart.MultipartFile;

import com.bootng.service.DishService;

import example.restapi.dto.CustomPageResponse;
import example.restapi.model.Dish;
import example.restapi.repository.DishRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.hateoas.ResourceSupport;

@RestController
@RequestMapping("api/v2")
public class DishSBControllerV2 {

	private static final Logger log = LoggerFactory.getLogger(DishSBControllerV2.class);

	@Autowired
	DishRepository repo;
	
	@PostMapping(value="/dishes",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addDish2(@RequestParam("file") MultipartFile file) throws Exception {
		log.info("--------------addDish----------------");
		//log.info(" in data " + file.g);
		//Dish dishDb = repo.save(data);
		log.info("--------------addDish Finished----------------");
		FileInfo fi = new FileInfo();
		fi.fname = file.getName();
		fi.orignalName = file.getOriginalFilename();
		fi.contentType = file.getContentType();
		return ResponseEntity.ok(fi);
	}
	
	class FileInfo {
		String fname;
		String orignalName;
		String contentType;
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getOrignalName() {
			return orignalName;
		}
		public void setOrignalName(String orignalName) {
			this.orignalName = orignalName;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		
		
	}
}
