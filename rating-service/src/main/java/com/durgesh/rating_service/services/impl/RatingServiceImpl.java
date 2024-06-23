package com.durgesh.rating_service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.rating_service.entities.Rating;
import com.durgesh.rating_service.repositories.RatingRepository;
import com.durgesh.rating_service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating getRating(String ratingId) {
		return ratingRepository.findById(ratingId).orElse(null);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating createRating(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
