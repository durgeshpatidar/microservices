package com.durgesh.rating_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.rating_service.entities.Rating;
import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
