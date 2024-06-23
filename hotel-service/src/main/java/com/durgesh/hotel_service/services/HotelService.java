package com.durgesh.hotel_service.services;

import java.util.List;

import com.durgesh.hotel_service.entities.Hotel;

public interface HotelService {
	public Hotel saveHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getHotel(String hotelId);
}
