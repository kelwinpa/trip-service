package com.trip.api.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timestamp", "odometer", "fuelLevel", "positionLat", "positionLong" })
public class Datum {

	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("odometer")
	private String odometer;
	
	@Min(0)
	@Max(100)
	@JsonProperty("fuelLevel")
	private int fuelLevel;
	
	@JsonProperty("positionLat")
	private String positionLat;
	@JsonProperty("positionLong")
	private String positionLong;

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("odometer")
	public String getOdometer() {
		return odometer;
	}

	@JsonProperty("odometer")
	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	@JsonProperty("fuelLevel")
	public int getFuelLevel() {
		return fuelLevel;
	}

	@JsonProperty("fuelLevel")
	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	@JsonProperty("positionLat")
	public String getPositionLat() {
		return positionLat;
	}

	@JsonProperty("positionLat")
	public void setPositionLat(String positionLat) {
		this.positionLat = positionLat;
	}

	@JsonProperty("positionLong")
	public String getPositionLong() {
		return positionLong;
	}

	@JsonProperty("positionLong")
	public void setPositionLong(String positionLong) {
		this.positionLong = positionLong;
	}
}