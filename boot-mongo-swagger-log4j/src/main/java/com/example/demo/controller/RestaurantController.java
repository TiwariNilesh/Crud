package com.example.demo.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Restaurant;
import com.example.demo.service.RestaurantService;
@RestController
@RequestMapping("/abc")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	private static final Logger logger = LogManager.getLogger(RestaurantController.class);
	
	
	@PostMapping(value="/save/restaurant" 
			, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> save(@RequestBody Restaurant restaurat){
		System.out.println("rst -------" + restaurat);
		
		
		Restaurant rst = restaurantService.save(restaurat);
		
		if(rst == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		logger.debug("restaurant saved succesfully");
		return ResponseEntity.ok("Restaurant saved");
	}
	
	@GetMapping(value="/get/restaurant/{id}" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findRestaurant(long id){
		
		Restaurant rst = restaurantService.find(id).get();
		
		if(rst == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(rst);
	}
	
	@GetMapping(value="/getAll/restaurant/" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findAll(){
		
		List<Restaurant> rst = restaurantService.findAll();
		
		if(rst == null || rst.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
		return ResponseEntity.ok(rst);
	}
	
	@PutMapping(value="/update/restaurant" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody Restaurant restaurant){
		
		Restaurant rst = restaurantService.find(restaurant.getId()).get();
		
		if(rst == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		restaurantService.save(rst);
		return ResponseEntity.ok("Restaurant updated");
	}
	
	@DeleteMapping(value="/delete/restaurant/{id}" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> delete(@PathVariable long id){
		
		Restaurant rst = restaurantService.find(id).get();
		
		if(rst == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		restaurantService.delete(rst);
		
		return ResponseEntity.ok("Restaurant deleted");
	}
	
	
	
	
	
}
