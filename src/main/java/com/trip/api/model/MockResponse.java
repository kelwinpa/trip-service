package com.trip.api.model;

import org.springframework.stereotype.Component;

import com.trip.api.request.TripRequest;
import com.trip.api.response.TripResponse;

@Component
public class MockResponse {

	public TripResponse mockResponse(TripRequest tripRequest) {

		TripResponse tripResponse = new TripResponse();
		
		tripResponse.setVin(tripRequest.getVin());
		tripResponse.setConsumption("5.5");
		
		
		
		return tripResponse;
	}

}
