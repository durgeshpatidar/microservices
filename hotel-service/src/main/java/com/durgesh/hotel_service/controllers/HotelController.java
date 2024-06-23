package com.durgesh.hotel_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.hotel_service.entities.Hotel;
import com.durgesh.hotel_service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.ok(hotelService.saveHotel(hotel));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels(){
		return ResponseEntity.ok(hotelService.getAllHotel());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
}
