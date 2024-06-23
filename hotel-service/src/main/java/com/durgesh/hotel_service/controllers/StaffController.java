package com.durgesh.hotel_service.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<List<String>> getStaffNames(){
		return ResponseEntity.ok(List.of("Rahul","Rakesh","Ramesh"));
	}
}
