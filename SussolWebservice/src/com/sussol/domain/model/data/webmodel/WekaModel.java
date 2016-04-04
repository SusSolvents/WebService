package com.sussol.domain.model.data.webmodel;

import java.io.Serializable;
import java.util.Date;

import com.sussol.domain.utilities.Globals.Algorithm;

public class WekaModel implements Serializable {


	public String dataSet;
	public String date;
	public Algorithm algorithm;
	public String[] parameters;
	public WekaResult wekaResult;
	public String fulLog;
	


	public WekaModel() {
		
	}



	public WekaModel(String dataSet, String date, Algorithm algorithm, String[] parameters) {
		super();
		this.dataSet = dataSet;
		this.date = date;
		this.algorithm = algorithm;
		this.parameters = parameters;
	}



	public String getDataSet() {
		return dataSet;
	}



	public WekaResult getWekaResult() {
		return wekaResult;
	}



	public void setWekaResult(WekaResult wekaResult) {
		this.wekaResult = wekaResult;
	}



	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Algorithm getAlgorithm() {
		return algorithm;
	}



	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}



	public String[] getParameters() {
		return parameters;
	}



	
	public String getFulLog() {
		return fulLog;
	}



	public void setFulLog(String fulLog) {
		this.fulLog = fulLog;
	}



	public void setOptions(String[] parameters) {
		this.parameters = parameters;
	}
	
	
	
}
