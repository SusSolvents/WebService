package com.sussol.domain.model.data;

import java.util.ArrayList;

public class Cluster 
{
	private int number;	
	private ArrayList<Double> featureValues;
	
	public Cluster(int number, ArrayList<Double> featureValues) 
	{
		this.number = number;
		
		this.featureValues = featureValues;
	}
	
	public int getNumber() 											{ return number; }
	public void setNumber(int number) 								{ this.number = number; }
	public ArrayList<Double> getFeatureValues() 					{ return featureValues; }
	public void setFeatureValues(ArrayList<Double> featureValues)	{ this.featureValues = featureValues; }
}
