package com.trip.api.interfaces;

import com.trip.api.request.TripRequest;
import com.trip.api.response.TripResponse;

public interface TripInterface {
	
	 TripResponse getListPoints(TripRequest tripRequest);

}
