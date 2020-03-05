package com.trip.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "state", "latt", "city", "prov", "country", "region", "postal", "longt" })
public class GeocodeModel {

	@JsonProperty("state")
	private String state;
	@JsonProperty("latt")
	private String latt;
	@JsonProperty("city")
	private String city;
	@JsonProperty("prov")
	private String prov;
	@JsonProperty("country")
	private String country;
	@JsonProperty("region")
	private String region;
	@JsonProperty("postal")
	private String postal;
	@JsonProperty("longt")
	private String longt;

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("latt")
	public String getLatt() {
		return latt;
	}

	@JsonProperty("latt")
	public void setLatt(String latt) {
		this.latt = latt;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("prov")
	public String getProv() {
		return prov;
	}

	@JsonProperty("prov")
	public void setProv(String prov) {
		this.prov = prov;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("postal")
	public String getPostal() {
		return postal;
	}

	@JsonProperty("postal")
	public void setPostal(String postal) {
		this.postal = postal;
	}

	@JsonProperty("longt")
	public String getLongt() {
		return longt;
	}

	@JsonProperty("longt")
	public void setLongt(String longt) {
		this.longt = longt;
	}

}