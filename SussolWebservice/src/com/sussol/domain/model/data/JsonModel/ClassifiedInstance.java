package com.sussol.domain.model.data.JsonModel;

public class ClassifiedInstance {
	private int clusterNumber;
	private double distanceToCluster;
	
	
	public ClassifiedInstance(int clusterNumber, double distanceToCluster) {
		super();
		this.clusterNumber = clusterNumber;
		this.distanceToCluster = distanceToCluster;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	public double getDistanceToCluster() {
		return distanceToCluster;
	}
	public void setDistanceToCluster(double distanceToCluster) {
		this.distanceToCluster = distanceToCluster;
	}
	
}
