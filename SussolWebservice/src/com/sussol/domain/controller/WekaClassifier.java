package com.sussol.domain.controller;

import java.util.ArrayList;

import com.sussol.domain.utilities.Globals.Algorithm;

import weka.clusterers.Clusterer;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.SerializationHelper;

public class WekaClassifier 
{
	private Clusterer model = null;	
	
	// attributes is een arraylist of Weka Attributes.
	// Used to define the metadata.
	private ArrayList<Attribute> attributes = null;
	
	// currentInstance is an object of Instance.
	// It is used to classify the current solvent.
	private Instance currentInstance;
	
	
	public WekaClassifier (Algorithm algorithm, String fileName)
	{
		// Initialise the classifier with the right model.
		try 
		{
			switch (algorithm)
			{
				case CANOPY:
					model = (Clusterer) SerializationHelper.read("models/Canopy/" + fileName + " Canopy.model");									
					break;
				case COBWEB:
					model = (Clusterer) SerializationHelper.read("models/CobWeb/" + fileName + " CobWeb.model");
					break;
				case DBSCAN:
					break;
				case EM:
					model = (Clusterer) SerializationHelper.read("models/EM/" + fileName + " EM.model");
					break;
				case KMEANS:
					model = (Clusterer) SerializationHelper.read("models/KMeans/" + fileName + " KMeans.model");
					break;
				case SOM:
					model = (Clusterer) SerializationHelper.read("models/SOM/" + fileName + " SOM.model");
					break;		
				case XMEANS:
					break;
				default:
					break;				
			}
		} 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public void initialiseSolventInstance(double[] featureValues)
	{
		attributes = new ArrayList<Attribute>();
		attributes.add(new Attribute("Boiling_Point_Minimum_°C"));
		attributes.add(new Attribute("Melting_Point_Minimum_°C"));
		attributes.add(new Attribute("Flash_Point_Minimum_°C"));
		attributes.add(new Attribute("Vapour_Pressure_25°C_mmHg"));
		attributes.add(new Attribute("Density_25°C_Minimum_kg/L"));
		attributes.add(new Attribute("Viscosity_25°C_Minimum_mPa.s"));

		currentInstance = new DenseInstance(6);
		
		currentInstance.setValue(0, featureValues[0]);
		currentInstance.setValue(1, featureValues[1]);
		currentInstance.setValue(2, featureValues[2]);
		currentInstance.setValue(3, featureValues[3]);
		currentInstance.setValue(4, featureValues[4]);
		currentInstance.setValue(5, featureValues[5]);
				
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
