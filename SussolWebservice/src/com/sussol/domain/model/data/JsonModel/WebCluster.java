package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebCluster implements Serializable
{
	private int clusterNumber;
	private Map<Integer, Double> distanceToCluster;
	private List<WebSolvent> solvents;
	
	
	
	public WebCluster(int clusterNumber, Map<Integer, Double> distanceToCluster, List<WebSolvent> solvents) {
		super();
		this.clusterNumber = clusterNumber;
		this.distanceToCluster = distanceToCluster;
		this.solvents = solvents;
	}
	
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	public Map<Integer, Double> getDistanceToCluster() {
		return distanceToCluster;
	}
	public void setDistanceToCluster(Map<Integer, Double> distanceToCluster) {
		this.distanceToCluster = distanceToCluster;
	}
	public List<WebSolvent> getSolvents() {
		return solvents;
	}
	public void setSolvents(List<WebSolvent> solvents) {
		this.solvents = solvents;
	}
	
	public void addSolvent(WebSolvent solvent)
	{
		solvents.add(solvent);
	}
	public void addClusterWithDistance(Integer cluster, double distance)
	{
		distanceToCluster.put(cluster, distance);
	}
	
}
