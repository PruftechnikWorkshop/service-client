package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Signal {

	private final Date timestamp;
	
	private final Float value;

	@JsonCreator
	public Signal(@JsonProperty("timestamp") Date timestamp, @JsonProperty("signalValue") Float value) {
		this.timestamp = timestamp;
		this.value = value;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public Float getValue() {
		return value;
	}
	
}
