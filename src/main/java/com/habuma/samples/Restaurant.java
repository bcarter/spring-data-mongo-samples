package com.habuma.samples;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Restaurant {

	@Id
	private String id;
	
	private String name;
	
	@GeoSpatialIndexed
	private double[] location;
	
	@PersistenceConstructor
	Restaurant(String name, double[] location) {
		this.name = name;
		this.location = location;    
	}
	
	public Restaurant(String name, double latitude, double longitude) {
		this.name = name;
		this.location = new double[] {longitude, latitude};
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

}
