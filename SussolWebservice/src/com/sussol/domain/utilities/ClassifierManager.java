package com.sussol.domain.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sussol.domain.controller.WekaClassifier;
import com.sussol.domain.model.InputProcessor;
import com.sussol.domain.model.data.Cluster;
import com.sussol.domain.model.data.JsonModel.ClassifiedInstance;

public class ClassifierManager {
	
	public static ClassifiedInstance classifySolvent(String path, String featureValues)
	{
		WekaClassifier classifier = new WekaClassifier();
		classifier.setModel(path);
		ObjectMapper mapper = new ObjectMapper();
		 
		double[] values;
		try {
			
			values = mapper.readValue(featureValues, double[].class);
			String fileName = path.substring(path.lastIndexOf("/")+1);
			
			
			
			classifier.initialiseSolventInstance(InputProcessor.getSolventAttributes(fileName), values);
			int clusterNumber =classifier.classifyInstance();
			
			
			List<Cluster> clusters = mapper.readValue(new File(path + ".json"), new TypeReference<List<Cluster>>() {
			});
			
			Cluster classifiedCluster = null;
			for (Cluster cluster : clusters) {
				System.out.println(cluster.getNumber());
				if(cluster.getNumber() == clusterNumber)
				{
					classifiedCluster = cluster;
				}
			}
			
			
			ClassifiedInstance classifiedInstance = new ClassifiedInstance(clusterNumber, MathManager.getEuclideanDistance(Globals.convertDoubles(classifiedCluster.getFeatureValues()), values));
			return classifiedInstance;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
