package com.sussol.domain.model.data;

import java.util.ArrayList;

public class SolventData 
{
	private int number;
	private String name;
	private String label;
	private String casNr;
	ArrayList<Double> featureValues;
	
	public SolventData(int number, String[] features) 
	{		
		this.number = number;
		this.name = features[0];
		this.label = features[1];
		this.casNr = features[2];
		
		featureValues = new ArrayList<Double>();		
		for (int i = 3; i < features.length; i++)
		{
			featureValues.add(new Double(features[i]));
		}
	}
		
	public int getNumber() 											{ return number; }
	public void setNumber(int number) 								{ this.number = number; }
	public String getName()											{ return name; }
	public void setName(String name) 								{ this.name = name; }
	public String getLabel() 										{ return label; }
	public void setLabel(String label) 								{ this.label = label; }
	public String getCasNr() 										{ return casNr; }
	public void setCasNr(String casNr) 								{ this.casNr = casNr; }
	public ArrayList<Double> getFeatureValues() 					{ return featureValues; }
	public void setFeatureValues(ArrayList<Double> featureValues) 	{ this.featureValues = featureValues; }		
}
