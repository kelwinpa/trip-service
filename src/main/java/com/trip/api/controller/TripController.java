package com.trip.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.api.request.TripRequest;
import com.trip.api.service.TripService;
import com.trip.api.util.BaseResponse;
import com.trip.api.util.CustomException;
import com.trip.api.util.ResponseUtils;

@RestController
@RequestMapping("/trip")
public class TripController {

	@Autowired
	private TripService tripService;

	@PostMapping
	public ResponseEntity<BaseResponse<?>> getListPoints(@Valid @RequestBody TripRequest tripRequest) {
		try {
			return ResponseUtils.buildSuccessOperationResponse(tripService.getListPoints(tripRequest));
		} catch (CustomException ce) {
			return ResponseUtils.buildErrorResponse(ce);
		} catch (Exception e) {
			return ResponseUtils.buildFailedOperationResponse(500, "Internal Error");
		}
	}
}
