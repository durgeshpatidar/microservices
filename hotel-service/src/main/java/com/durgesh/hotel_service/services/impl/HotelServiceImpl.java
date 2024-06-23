package com.durgesh.hotel_service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.hotel_service.entities.Hotel;
import com.durgesh.hotel_service.repositories.HotelRepository;
import com.durgesh.hotel_service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel saveHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElse(null);
	}

}
