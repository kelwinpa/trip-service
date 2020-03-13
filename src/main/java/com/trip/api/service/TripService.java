package com.trip.api.service;

import org.springframework.stereotype.Service;

import com.trip.api.interfaces.TripInterface;

@Service
public class TripService implements TripInterface {

	@Override
	public String getListPoints(String tripRequest) {

		return tripRequest;
	}

}
