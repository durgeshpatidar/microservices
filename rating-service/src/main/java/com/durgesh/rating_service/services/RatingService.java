package com.durgesh.rating_service.services;

import java.util.List;

import com.durgesh.rating_service.entities.Rating;

public interface RatingService {
	Rating getRating(String ratingId);
	List<Rating> getAllRatings();
	Rating createRating(Rating rating);
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);
}
