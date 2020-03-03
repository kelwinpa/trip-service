package com.trip.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "startTimestamp", "endTimestamp", "positionLat", "positionLong" })
public class Break {

	@JsonProperty("startTimestamp")
	private int startTimestamp;
	@JsonProperty("endTimestamp")
	private int endTimestamp;
	@JsonProperty("positionLat")
	private float positionLat;
	@JsonProperty("positionLong")
	private float positionLong;

	@JsonProperty("startTimestamp")
	public int getStartTimestamp() {
		return startTimestamp;
	}

	@JsonProperty("startTimestamp")
	public void setStartTimestamp(int startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	@JsonProperty("endTimestamp")
	public int getEndTimestamp() {
		return endTimestamp;
	}

	@JsonProperty("endTimestamp")
	public void setEndTimestamp(int endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	@JsonProperty("positionLat")
	public float getPositionLat() {
		return positionLat;
	}

	@JsonProperty("positionLat")
	public void setPositionLat(float positionLat) {
		this.positionLat = positionLat;
	}

	@JsonProperty("positionLong")
	public float getPositionLong() {
		return positionLong;
	}

	@JsonProperty("positionLong")
	public void setPositionLong(float positionLong) {
		this.positionLong = positionLong;
	}
}