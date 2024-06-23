package com.durgesh.user_service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.durgesh.user_service.entities.Hotel;
import com.durgesh.user_service.entities.Rating;
import com.durgesh.user_service.entities.User;
import com.durgesh.user_service.exceptions.ResourceNotFoundException;
import com.durgesh.user_service.external.services.HotelService;
import com.durgesh.user_service.repositories.UserRepository;
import com.durgesh.user_service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		var randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found on server by id" + userId));
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(),
				Rating[].class);
		List<Rating> list = Arrays.stream(ratings).map(rating -> {
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).toList();

		user.setRatings(list);
		return user;
	}

}
