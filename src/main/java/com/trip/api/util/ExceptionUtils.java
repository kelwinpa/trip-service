package com.trip.api.util;

public class ExceptionUtils {

	public static final int BAD_REQ = 800;
	public static final int NOT_RET_GEO = 801;
	
	public static String getMessage(int errorCode) {
		switch (errorCode) {
		case BAD_REQ:
			return "Body not valid";
		case NOT_RET_GEO:
			return "Error: no possible to retrieve the feed";
		default:
			return "Error";
		}
	}

}
