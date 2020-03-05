package com.trip.api.restDriver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trip.api.model.GeocodeModel;
import com.trip.api.request.TripRequest;
import com.trip.api.response.Break;
import com.trip.api.response.TripResponse;
import com.trip.api.util.CustomException;
import com.trip.api.util.ExceptionUtils;

@Component
public class MockResponse {

	@Value("${endpoint.url}")
	private String endpointUrl;

	public TripResponse mockResponse(TripRequest tripRequest) {
		TripResponse tripResponse = new TripResponse();
		tripResponse.setVin(tripRequest.getVin());
		tripResponse.setConsumption("5.5");

		Break breaks = new Break();
		breaks.setStartTimestamp(1559137020);
		breaks.setEndTimestamp(1559137050);
		breaks.setPositionLat((float) 49.4521);
		breaks.setPositionLong((float) 11.0767);
		List<Break> listBreak = new ArrayList<Break>();
		tripResponse.setBreaks(listBreak);

		Break refuelStops = new Break();
		refuelStops.setStartTimestamp(1559145620);
		refuelStops.setEndTimestamp(1559145650);
		refuelStops.setPositionLat((float) 48.7665);
		refuelStops.setPositionLong((float) 48.7665);
		listBreak.clear();
		listBreak.add(refuelStops);
		tripResponse.setRefuelStops(listBreak);

		StringBuilder url = new StringBuilder(endpointUrl);
		url.append(tripRequest.getData().get(0).getPositionLat());
		url.append(",");
		url.append(tripRequest.getData().get(0).getPositionLong());
		url.append("?json=1");
		RestTemplate restTemplate = new RestTemplate();

		GeocodeModel geocodeModel;

		try {
			ResponseEntity<GeocodeModel> response = restTemplate.getForEntity(url.toString(), GeocodeModel.class);
			geocodeModel = response.getBody();
			tripResponse.setDeparture(geocodeModel.getCity());
			tripResponse.setDestination("München");
			return tripResponse;
		} catch (Exception e) {
			throw new CustomException(ExceptionUtils.NOT_RET_GEO, e);
		}
	}
}