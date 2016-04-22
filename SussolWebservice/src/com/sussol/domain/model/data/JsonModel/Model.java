package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sussol.domain.utilities.Globals.Algorithm;

public class Model implements Serializable {

	private String dataSet;
	private String date;
	private Algorithm algorithm;
	private String modelPath;
	private List<WebCluster> clusters;
	
	
 

	public Model() {
		
	}
	public Model(String dataSet, String date, Algorithm algorithm, List<WebCluster> clusters) {
		super();
		this.dataSet = dataSet;
		this.date = date;
		this.algorithm = algorithm;
		this.clusters = clusters;
	}


	public List<WebCluster> getClusters() {
		return clusters;
	}


	public void setClusters(List<WebCluster> clusters) {
		this.clusters = clusters;
	}


	public String getDataSet() {
		return dataSet;
	}




	public String getModelPath() {
		return modelPath;
	}
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
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


	public WebCluster getClusterWithNumber(int number)
	{
		WebCluster cluster;
		for (int i = 0; i < clusters.size(); i++) {
			if(clusters.get(i).getClusterNumber() == number)
			{
				return clusters.get(i);
			}
		}
		return null;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}



	
	
}
