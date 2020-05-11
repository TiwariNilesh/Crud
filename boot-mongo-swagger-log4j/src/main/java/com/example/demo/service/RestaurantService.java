package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Restaurant;
import com.example.demo.repo.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	public Restaurant save(Restaurant restaurant) 
	{
		return restaurantRepository.save(restaurant);
	}
	public Restaurant update(Restaurant restaurant) {
		
		
		return restaurantRepository.save(restaurant);
	}

	public Optional<Restaurant> find(long id) {
		return restaurantRepository.findById(id);
	}
	
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	

	public void  delete(Restaurant restaurant) {
		restaurantRepository.delete(restaurant);
	}
	
	
}
