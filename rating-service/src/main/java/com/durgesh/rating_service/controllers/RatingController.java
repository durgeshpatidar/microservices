package com.durgesh.rating_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.rating_service.entities.Rating;
import com.durgesh.rating_service.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId) {
		return ResponseEntity.ok(ratingService.getRating(ratingId));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.ok(ratingService.createRating(rating));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
}
