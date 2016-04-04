package com.sussol.domain.controller;


import java.util.Calendar;

import com.sussol.domain.model.InputProcessor;
import com.sussol.domain.model.PostProcessor;
import com.sussol.domain.model.data.webmodel.WekaModel;
import com.sussol.domain.model.data.webmodel.WekaResult;
import com.sussol.domain.options.OptionsManager;
import com.sussol.domain.utilities.Globals.Algorithm;
import com.sussol.domain.utilities.Globals;
import com.sussol.domain.utilities.SolventLogger;

import weka.clusterers.Canopy;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;
import weka.clusterers.Cobweb;
import weka.clusterers.EM;
import weka.clusterers.SelfOrganizingMap;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

public class WekaModeller 
{	
	public WekaModel makeModel(Algorithm algorithm, OptionsManager optionsManager)
	{		
		Instances trainInstances = InputProcessor.getTrainInstances();
		Instances testInstances = InputProcessor.getTestInstances();	
		Clusterer clusterer = null;
		
		String[] array = new String[optionsManager.getOptions().length];
		for (int i = 0; i < optionsManager.getOptions().length; i++) {
			array[i] = optionsManager.getOptions()[i];
		}
		WekaModel wekaModel = new WekaModel(Globals.fileName, Calendar.getInstance().getTime().toString(), algorithm, array);
		WekaResult wekaResult = new WekaResult();
		
		SolventLogger.getInstance().info(optionsManager.getOptionsForLogging());
		
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

			switch (algorithm)
			{
				case CANOPY:
					// PostProcessor.ProcessClustersCanopy(evaluation);
					PostProcessor.processClusters(wekaResult,evaluation);
					break;
				case COBWEB:
					PostProcessor.ProcessClustersCobWeb(wekaResult,evaluation);
					break;
				case DBSCAN:					
					break;
				case EM:
					// PostProcessor.ProcessClustersEM(evaluation);
					PostProcessor.processClusters(wekaResult, evaluation);
					break;
				case KMEANS:
					// PostProcessor.ProcessClustersKMeans(evaluation);
					PostProcessor.processClusters(wekaResult, evaluation);
					break;
				case SOM:
					// PostProcessor.ProcessClustersSOM(evaluation);
					PostProcessor.processClusters(wekaResult,evaluation);
					break;
				case XMEANS:
					break;
				default:
					break;
			}	
			
			PostProcessor.ProcessClusterAssignments(evaluation, algorithm);
			
			// Serialize the model to disk.		
			// SerializationHelper.write("models/model.model", clusterer);

			wekaModel.setWekaResult(wekaResult);
			wekaModel.setFulLog(Globals.log);
			SolventLogger.getInstance().closeLogger();
			return wekaModel;
		} 
		catch (Exception e) { e.printStackTrace(); }				
		SolventLogger.getInstance().closeLogger();
		return wekaModel;
	}
	
		
}
