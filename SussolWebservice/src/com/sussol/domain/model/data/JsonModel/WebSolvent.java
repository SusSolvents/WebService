package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;
import java.util.List;

public class WebSolvent implements Serializable {
	private String casNumber;
	private String name;
	private List<Feature> features;
	private double distanceToCluster;
	
	public WebSolvent(String casNumber, String name, List<Feature> features, double distanceToCluster) {
		super();
		this.casNumber = casNumber;
		this.name = name;
		this.features = features;
		this.distanceToCluster = distanceToCluster;
	}
	public WebSolvent() {
		super();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCasNumber() {
		return casNumber;
	}
	public void setCasNumber(String casNumber) {
		this.casNumber = casNumber;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public double getDistanceToCluster() {
		return distanceToCluster;
	}
	public void setDistanceToCluster(double distanceToCluster) {
		this.distanceToCluster = distanceToCluster;
	}
	
}
