package com.sussol.domain.controller;

import java.util.ArrayList;

import com.sussol.domain.model.data.SolventAttribute;

import weka.clusterers.Clusterer;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.SerializationHelper;

public class WekaClassifier 
{
	private Clusterer model = null;	
	
	// attributes is an arraylist of Weka Attributes.
	// Used to define the metadata.
	private ArrayList<Attribute> attributes = null;
	
	// currentInstance is an object of Instance.
	// Used to classify the current solvent.
	private Instance currentInstance;
		
	public WekaClassifier ()
	{
	}
	
	public void setModel(String filePath)
	{
		try
		{
			model = (Clusterer) SerializationHelper.read(filePath);
		} 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public void initialiseSolventInstance(ArrayList<SolventAttribute> solventAttributes, double[] featureValues)
	{
		attributes = new ArrayList<Attribute>();
				
		for (SolventAttribute solventAttribute : solventAttributes)
		{
			attributes.add(new Attribute(solventAttribute.getAttributeName()));
		}
		
		currentInstance = new DenseInstance(solventAttributes.size());
				
		for (int i=0; i < featureValues.length; i++)
		{
			currentInstance.setValue(i, featureValues[i]);
		}			
	}

	public int classifyInstance()
	{
		try 
		{
			return model.clusterInstance(currentInstance);
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return -1;
	}
}
