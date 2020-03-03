package com.trip.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.api.request.TripRequest;
import com.trip.api.response.TripResponse;
import com.trip.api.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

	
	@Autowired
	private TripService tripService;
	
	@PostMapping
	public TripResponse getListPoints(@Valid @RequestBody TripRequest tripRequest) {

		return tripService.getListPoints(tripRequest);
	}

}
