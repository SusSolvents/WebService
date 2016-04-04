package com.sussol.domain.model.data.webmodel;

import java.util.ArrayList;

import com.sussol.domain.model.data.Cluster;

public class WekaResult {
	public String generalResultInformation;
	public ArrayList<Cluster> clusters;
	public String fulLog;
	
	public WekaResult() {
		super();
	}
	
	public String getGeneralResultInformation() {
		return generalResultInformation;
	}
	
	public void setGeneralResultInformation(String generalResultInformation) {
		this.generalResultInformation = generalResultInformation;
	}
	
	public ArrayList<Cluster> getClusters() {
		return clusters;
	}
	
	public void setClusters(ArrayList<Cluster> clusters) {
		this.clusters = clusters;
	}
	
	
}
