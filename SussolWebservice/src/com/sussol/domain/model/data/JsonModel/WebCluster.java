package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebCluster implements Serializable
{
	private int clusterNumber;
	private List<ClusterCenterDistance> distanceToCluster;
	private List<WebSolvent> solvents;
	private ArrayList<Double> vectorData;
	
	
	public WebCluster(int clusterNumber, ArrayList<Double> vectorData ,ArrayList<ClusterCenterDistance> arrayList2, ArrayList<WebSolvent> arrayList) {
		super();
		this.clusterNumber = clusterNumber;
		this.distanceToCluster = arrayList2;
		this.solvents = arrayList;
		this.vectorData = vectorData;
	}
	
	
	public ArrayList<Double> getVectorData() {
		return vectorData;
	}


	public void setVectorData(ArrayList<Double> vectorData) {
		this.vectorData = vectorData;
	}


	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	
	public List<ClusterCenterDistance> getDistanceToCluster() {
		return distanceToCluster;
	}

	public void setDistanceToCluster(List<ClusterCenterDistance> distanceToCluster) {
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
		distanceToCluster.add(new ClusterCenterDistance(cluster, distance));
	}
	
}
