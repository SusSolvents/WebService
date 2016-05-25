package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;
import java.util.List;

public class WebSolvent implements Serializable {
	private String casNumber;
	private String name;
	private List<Feature> features;
	private double distanceToCluster;
	private String predictLabel;
	private String iD_Name_1;
	
	private String iD_CAS_Nr_1;
	private String iD_EG_Nr;
	private String iD_EG_Annex_Nr;
	private String input;
	
	
	
	
	
	public WebSolvent(String casNumber, String name, List<Feature> features, double distanceToCluster,
			String predictLabel, String iD_Name_1, String iD_CAS_Nr_1, String iD_EG_Nr, String iD_EG_Annex_Nr,
			String input) {
		super();
		this.casNumber = casNumber;
		this.name = name;
		this.features = features;
		this.distanceToCluster = distanceToCluster;
		this.predictLabel = predictLabel;
		this.iD_Name_1 = iD_Name_1;
		this.iD_CAS_Nr_1 = iD_CAS_Nr_1;
		this.iD_EG_Nr = iD_EG_Nr;
		this.iD_EG_Annex_Nr = iD_EG_Annex_Nr;
		this.input = input;
	}



	public String getiD_Name_1() {
		return iD_Name_1;
	}



	public void setiD_Name_1(String iD_Name_1) {
		this.iD_Name_1 = iD_Name_1;
	}



	public String getiD_CAS_Nr_1() {
		return iD_CAS_Nr_1;
	}



	public void setiD_CAS_Nr_1(String iD_CAS_Nr_1) {
		this.iD_CAS_Nr_1 = iD_CAS_Nr_1;
	}



	public String getiD_EG_Nr() {
		return iD_EG_Nr;
	}



	public void setiD_EG_Nr(String iD_EG_Nr) {
		this.iD_EG_Nr = iD_EG_Nr;
	}



	public String getiD_EG_Annex_Nr() {
		return iD_EG_Annex_Nr;
	}



	public void setiD_EG_Annex_Nr(String iD_EG_Annex_Nr) {
		this.iD_EG_Annex_Nr = iD_EG_Annex_Nr;
	}



	public String getInput() {
		return input;
	}



	public void setInput(String input) {
		this.input = input;
	}



	public String getPredictLabel() {
		return predictLabel;
	}


	public void setPredictLabel(String predictLabel) {
		this.predictLabel = predictLabel;
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
