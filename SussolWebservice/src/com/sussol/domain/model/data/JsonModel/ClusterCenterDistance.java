package com.sussol.domain.model.data.JsonModel;

public class ClusterCenterDistance {
	private int clusterId;
	private double distance;
	public ClusterCenterDistance(int clusterId, double distance) {
		super();
		this.clusterId = clusterId;
		this.distance = distance;
	}
	public int getClusterId() {
		return clusterId;
	}
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
}
