package com.trip.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.api.interfaces.TripInterface;
import com.trip.api.model.MockResponse;
import com.trip.api.request.Datum;
import com.trip.api.request.TripRequest;
import com.trip.api.response.TripResponse;

@Service
public class TripService implements TripInterface {

	@Autowired
	private MockResponse mockResponse;

	@Override
	public TripResponse getListPoints(TripRequest tripRequest) {

		if (tripRequest.getData() == null) {
			return new TripResponse();
		} else if (tripRequest.getData().isEmpty()) {
			return new TripResponse();
		} else {
			for (Datum data : tripRequest.getData()) {
				if (data.getFuelLevel() < 0 || data.getFuelLevel() > 100) {
					return new TripResponse();
				}
			}
		}

		return mockResponse.mockResponse(tripRequest);
	}

}
