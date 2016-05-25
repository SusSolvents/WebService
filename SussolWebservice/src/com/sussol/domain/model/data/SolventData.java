package com.sussol.domain.model.data;

import java.util.ArrayList;

public class SolventData 
{
	private int number;	

	private String input;
	private String iD_Name_1;
	private String label;
	private String iD_CAS_Nr_1;
	private String iD_EG_Nr;
	private String iD_EG_Annex_Nr;
	
	ArrayList<Double> featureValues;
	
	public SolventData(int number, String[] features) 
	{		
		this.number = number;
		
		this.input = features[0];
		this.iD_Name_1 = features[1];
		this.label = features[2];
		this.iD_CAS_Nr_1 = features[3];
		this.iD_EG_Nr = features[4];
		this.iD_EG_Annex_Nr = features[5];
		
		featureValues = new ArrayList<Double>();		
		for (int i = 6; i < features.length; i++)
		{
			featureValues.add(new Double(features[i]));
		}
	}
		
	public int getNumber() 											{ return number; }
	public void setNumber(int number)								{ this.number = number; }
	public String getInput() 										{ return input; }
	public void setInput(String input) 								{ this.input = input; }
	public String getID_Name_1() 									{ return iD_Name_1; }
	public void setID_Name_1(String iD_Name_1) 						{ this.iD_Name_1 = iD_Name_1; } 
	public String getLabel() 										{ return label; }
	public void setLabel(String label) 								{ this.label = label; }
	public String getID_CAS_Nr_1() 									{ return iD_CAS_Nr_1; }
	public void setID_CAS_Nr_1(String iD_CAS_Nr_1)					{ this.iD_CAS_Nr_1 = iD_CAS_Nr_1; }
	public String getID_EG_Nr() 									{ return iD_EG_Nr; }
	public void setID_EG_Nr(String iD_EG_Nr) 						{ this.iD_EG_Nr = iD_EG_Nr; }
	public String getID_EG_Annex_Nr() 								{ return iD_EG_Annex_Nr; }
	public void setID_EG_Annex_Nr(String iD_EG_Annex_Nr) 			{ this.iD_EG_Annex_Nr = iD_EG_Annex_Nr; }
	public ArrayList<Double> getFeatureValues() 					{ return featureValues; }
	public void setFeatureValues(ArrayList<Double> featureValues)	{ this.featureValues = featureValues; }
}
