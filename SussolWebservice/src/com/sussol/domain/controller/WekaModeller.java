package com.sussol.domain.controller;


import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.sussol.domain.model.InputProcessor;
import com.sussol.domain.model.PostProcessor;
import com.sussol.domain.model.data.JsonModel.Model;
import com.sussol.domain.options.OptionsManager;
import com.sussol.domain.utilities.Globals.Algorithm;
import com.sussol.domain.utilities.LiatoLogger;

import weka.clusterers.Canopy;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;
import weka.clusterers.Cobweb;
import weka.clusterers.EM;
import weka.clusterers.SelfOrganizingMap;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class WekaModeller 
{	
	public Model makeModel(Algorithm algorithm, OptionsManager optionsManager, String trainingFileName)
	{		
		Model wekaModel = new Model();
		wekaModel.setAlgorithm(algorithm);
		wekaModel.setDate(new Date().toString());
		wekaModel.setDataSet(trainingFileName);
		
		Instances trainInstances = InputProcessor.getTrainInstances();
		Instances testInstances = InputProcessor.getTestInstances();	
		Clusterer clusterer = null;
		String STORAGE_PATH = System.getenv("OPENSHIFT_DATA_DIR") == null ? "/uploads/" : System.getenv("OPENSHIFT_DATA_DIR");
		LiatoLogger.getInstance().info(optionsManager.getOptionsForLogging());	
		try 
		{
			switch (algorithm)
			{
				case CANOPY:
					clusterer = new Canopy();
					((Canopy) clusterer).setOptions(optionsManager.getOptions());
					break;
				case COBWEB:
					clusterer = new Cobweb();
					((Cobweb) clusterer).setOptions(optionsManager.getOptions());
					break;
//				case DBSCAN:
//					clusterer = new DBScan();
//					((DBScan) clusterer).setOptions(optionsManager.getOptions());
//					break;
				case EM:
					clusterer = new EM();
					((EM) clusterer).setOptions(optionsManager.getOptions());
					break;
				case KMEANS:
					clusterer = new SimpleKMeans();
					((SimpleKMeans) clusterer).setOptions(optionsManager.getOptions());
					break;
				case SOM:
					clusterer = new SelfOrganizingMap();
					((SelfOrganizingMap) clusterer).setOptions(optionsManager.getOptions());
					break;
//				case XMEANS:
//					clusterer = new XMeans();
//					((XMeans) clusterer).setOptions(optionsManager.getOptions());
//					break;

				default:
					break;
			}																

			clusterer.buildClusterer(trainInstances);
			 
			ClusterEvaluation evaluation = new ClusterEvaluation();
			evaluation.setClusterer(clusterer);                           // the clusterer to evaluate
			evaluation.evaluateClusterer(testInstances);                  // data to evaluate the clusterer on			

			String modelFileName = trainingFileName.substring(0, trainingFileName.indexOf('.'));
			wekaModel.setModelPath(STORAGE_PATH + modelFileName + " Canopy.model");
			switch (algorithm)
			{
				case CANOPY:
					wekaModel.setClusters(PostProcessor.processClusters(evaluation));
										
					// Serialize the model to disk.		
					SerializationHelper.write(STORAGE_PATH  + modelFileName + " Canopy.model", clusterer);
					System.out.println(STORAGE_PATH);
					break;
				case COBWEB:
					PostProcessor.ProcessClustersCobWeb(evaluation);
					
					// Serialize the model to disk.		
					SerializationHelper.write(STORAGE_PATH  + modelFileName + " CobWeb.model", clusterer);
					break;
				case DBSCAN:					
					break;
				case EM:
					wekaModel.setClusters(PostProcessor.processClusters(evaluation));
					
					// Serialize the model to disk.		
					SerializationHelper.write(STORAGE_PATH  + modelFileName + " EM.model", clusterer);
					break;
				case KMEANS:
					wekaModel.setClusters(PostProcessor.processClusters(evaluation));
					
					// Serialize the model to disk.		
					SerializationHelper.write(STORAGE_PATH  + modelFileName + " KMeans.model", clusterer);
					break;
				case SOM:
					wekaModel.setClusters(PostProcessor.processClusters(evaluation));
					
					// Serialize the model to disk.		
					SerializationHelper.write(STORAGE_PATH  + modelFileName + " SOM.model", clusterer);
					break;
				case XMEANS:
					break;
				default:
					break;
			}	
			
			PostProcessor.ProcessClusterAssignments(evaluation, algorithm, wekaModel);
			
			return wekaModel;

		} 
		catch (Exception e) { e.printStackTrace(); }				
		return null;
	}
	
	
}
