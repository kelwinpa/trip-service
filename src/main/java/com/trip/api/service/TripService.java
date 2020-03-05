package com.trip.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.api.interfaces.TripInterface;
import com.trip.api.request.Datum;
import com.trip.api.request.TripRequest;
import com.trip.api.response.TripResponse;
import com.trip.api.restDriver.MockResponse;
import com.trip.api.util.CustomException;
import com.trip.api.util.ExceptionUtils;

@Service
public class TripService implements TripInterface {

	@Autowired
	private MockResponse mockResponse;

	@Override
	public TripResponse getListPoints(TripRequest tripRequest) {

		if (tripRequest.getData() == null) {
			throw new CustomException(ExceptionUtils.BAD_REQ);
		} else if (tripRequest.getData().isEmpty()) {
			throw new CustomException(ExceptionUtils.BAD_REQ);
		} else {
			for (Datum data : tripRequest.getData()) {
				if (data.getFuelLevel() < 0 || data.getFuelLevel() > 100) {
					throw new CustomException(ExceptionUtils.BAD_REQ);
				}
			}
		}
		return mockResponse.mockResponse(tripRequest);
	}

}
