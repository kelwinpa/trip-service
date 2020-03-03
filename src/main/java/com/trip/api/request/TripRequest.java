package com.trip.api.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "vin", "breakThreshold", "gasTankSize", "data" })
public class TripRequest {

	@JsonProperty("vin")
	private String vin;
	@JsonProperty("breakThreshold")
	private String breakThreshold;
	@JsonProperty("gasTankSize")
	private String gasTankSize;
	@JsonProperty("data")
	private List<Datum> data;

	@JsonProperty("vin")
	public String getVin() {
		return vin;
	}

	@JsonProperty("vin")
	public void setVin(String vin) {
		this.vin = vin;
	}

	@JsonProperty("breakThreshold")
	public String getBreakThreshold() {
		return breakThreshold;
	}

	@JsonProperty("breakThreshold")
	public void setBreakThreshold(String breakThreshold) {
		this.breakThreshold = breakThreshold;
	}

	@JsonProperty("gasTankSize")
	public String getGasTankSize() {
		return gasTankSize;
	}

	@JsonProperty("gasTankSize")
	public void setGasTankSize(String gasTankSize) {
		this.gasTankSize = gasTankSize;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}
}