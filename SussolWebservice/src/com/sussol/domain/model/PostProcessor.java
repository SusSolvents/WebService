package com.sussol.domain.model;


import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sussol.domain.model.data.Cluster;
import com.sussol.domain.model.data.Result;
import com.sussol.domain.model.data.SolventData;
import com.sussol.domain.model.data.JsonModel.VectorData;
import com.sussol.domain.model.data.JsonModel.ClusterCenterDistance;
import com.sussol.domain.model.data.JsonModel.Feature;
import com.sussol.domain.model.data.JsonModel.Model;
import com.sussol.domain.model.data.JsonModel.WebCluster;
import com.sussol.domain.model.data.JsonModel.WebSolvent;
import com.sussol.domain.utilities.Globals.Algorithm;
import com.sussol.domain.utilities.Globals.SortKey;
import com.sussol.domain.utilities.Globals;
import com.sussol.domain.utilities.LiatoLogger;
import com.sussol.domain.utilities.MathManager;

import weka.clusterers.ClusterEvaluation;

public class PostProcessor 
{
	private static ArrayList<Cluster> clusters;
	private static List<WebCluster> webmodelClusters;
	private static final int numberOfFeatures = 6;
	
	// TODO : bestudeer de code van
	// http://www.programcreek.com/java-api-examples/index.php?example_code_path=weka-weka.clusterers-ClusterEvaluation.java
	// om de resultaten van CobWeb te laten zien, per class/cluster.
	public static void ProcessClustersCobWeb(ClusterEvaluation evaluation)
	{							
		String clusterResults = evaluation.clusterResultsToString();
		LiatoLogger.getInstance().info(clusterResults);		
						
//			SolventLogger.getInstance().info("" + evaluation.getNumClusters());
//			for (int i=0; i < evaluation.getNumClusters(); i++)
//			{
//				SolventLogger.getInstance().info("number = " + i + "\t" + evaluation.getClusterAssignments()[i]);
//			}				
				
//			String clustersString = clusterResults.substring(clusterResults.indexOf("Cluster"), clusterResults.indexOf("Clustered Instances") - 2);
//			String[] clustersAsString = clustersString.split("\n");
				
		// Convert clustervalues from String to Double and pass them to the next Cluster.
		clusters = new ArrayList<Cluster>();
		double [] clusterAssignments = evaluation.getClusterAssignments();
		for (int i = 0; i < clusterAssignments.length; i++)
		{
			// TODO : now we pass empty featureValues per cluster, because they are not in the logging ?
			// That is why the distance to the cluster center is always ??.
			ArrayList<Double> featureValues = new ArrayList<Double>();
//				String onlyValues = clustersAsString[i].substring(clustersAsString[i].indexOf(':') + 2, clustersAsString[i].indexOf('{') - 1);		
//				String[] doubleValues = onlyValues.split(",");
		
			for (int j = 0; j < numberOfFeatures; j++)
			{
//				doubleValues[j] = doubleValues[j].replaceAll(",",".");
				featureValues.add(new Double(1));
			}
		
			clusters.add(new Cluster(i, featureValues));
		}			
	}	
	
	public static List<com.sussol.domain.model.data.JsonModel.WebCluster> processClusters(ClusterEvaluation evaluation, Model wekaModel)
	{								
		String clusterResults = evaluation.clusterResultsToString();
		
		LiatoLogger.getInstance().info(clusterResults);		
		
		String clustersString = clusterResults.substring(clusterResults.indexOf("SOLVENTCLUSTERS") + 16, clusterResults.lastIndexOf("SOLVENTCLUSTERS"));
		String[] clustersAsString = clustersString.split("\n");		
		
		clusters = new ArrayList<Cluster>();
		webmodelClusters = new ArrayList<>();
		for (int i = 0; i < clustersAsString.length; i++)
		{
			ArrayList<Double> featureValues = new ArrayList<Double>();
			String[] doubleValues = clustersAsString[i].split("\t");
			ArrayList<VectorData> centroids = new ArrayList<>();
			// j starts at 1, because index 0 is the label "Cluster n".
			for (int j = 1; j < doubleValues.length; j++)
			{
				doubleValues[j] = doubleValues[j].replaceAll(",",".");
			
				featureValues.add(new Double(doubleValues[j]));
			}
			
			clusters.add(new Cluster(i, featureValues));
			
			for (int u=0; u<featureValues.size(); u++) {
				
				centroids.add(new VectorData(featureValues.get(u), Globals.featureNames.get(u)));
			}
			webmodelClusters.add(new com.sussol.domain.model.data.JsonModel.WebCluster(i, new ArrayList<ClusterCenterDistance>(), new ArrayList<WebSolvent>(), centroids));
		}
		writeClustersToFile(clusters, wekaModel);
		return webmodelClusters;
	}
	
	private static void writeClustersToFile(ArrayList<Cluster> clusters2, Model wekaModel) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(wekaModel.getModelPath() + ".json"), clusters2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public static void ProcessClusterAssignments(ClusterEvaluation evaluation, Algorithm algorithm, Model wekaModel)
	{
		/*
			clusterAssignments bevat de lijst van clusters die de evaluation heeft gemaakt, tellen vanaf 0.
			Elk assignment komt overeen met een solvent, in de volgorde van aanbieding.
			
			solventData bevat de lijst van solventen, ook in de volgorde van aanbieding/inlezing.
			
			Dan wordt een lijst van Result objecten aangemaakt, met het i-de solvent en de i-de assignment.
			Die lijst van results wordt gesorteerd volgens de sortkey.
			Daarna worden de solventen gelogd.
		
		*/
		
		// Bug : Canopy, EM, Kmeans en SOM geven de clusterAssignments beginnend te tellen vanaf 0.
		// CobWeb begint te tellen vanaf 1 !! Je moet het maar weten.
		// Vandaar de if-clause bij het maken van de Result objecten.
		
		double[] clusterAssignments = evaluation.getClusterAssignments();
		ArrayList<SolventData> solventData = InputProcessor.getSolventData();
		
		ArrayList<Result> results = new ArrayList<Result>();
		int clusterAssignment = 0;
		for (int i = 0; i < clusterAssignments.length; i++)
		{			
			if (algorithm == Algorithm.COBWEB)
			{
				clusterAssignment = (int)clusterAssignments[i] - 1;			
			}
			else
			{
				clusterAssignment = (int)clusterAssignments[i];
				
			}
			Result result = new Result(solventData.get(i), clusterAssignment);
			result.setSortKey(SortKey.CLUSTER);
			results.add(result);
		}
		Collections.sort(results);
				
		LiatoLogger.getInstance().info("-----------------------------------------------------------------------");
		LiatoLogger.getInstance().info("Sorted Solvents per Cluster :");
		LiatoLogger.getInstance().info("-----------------------------------------------------------------------\n");
		LiatoLogger.getInstance().info("Number\tName\tCasNr\tCluster\tDistanceToClusterCenter");
		
		for (int i = 0; i < results.size(); i++)
		{
			SolventData solvent = results.get(i).getSolventData();						
			Cluster cluster = clusters.get(results.get(i).getClusterNumber());			
			double distance = MathManager.getEuclideanDistance(solvent.getFeatureValues(), cluster.getFeatureValues());	
			
			// String formattedString = String.format("%4d\t%100s\t%20s\t%2d", i, tempMetaData.getName(), tempMetaData.getCasNr(), results.get(i).getClusterNumber());
			String formattedString = String.format("%d\t%s\t%s\t%d\t%f", i, solvent.getID_Name_1(), solvent.getID_CAS_Nr_1(), results.get(i).getClusterNumber(), distance);
			LiatoLogger.getInstance().info(formattedString);
			
			List<Feature> features = new ArrayList<>();
			for (int j = 0; j < solvent.getFeatureValues().size(); j++) {
				Feature feature = new Feature(Globals.featureNames.get(j), solvent.getFeatureValues().get(j));
				features.add(feature);
			}
			com.sussol.domain.model.data.JsonModel.WebCluster cluster2 = wekaModel.getClusterWithNumber(results.get(i).getClusterNumber());
			WebSolvent webSolvent = new WebSolvent(solvent.getID_CAS_Nr_1(), solvent.getID_Name_1(), features ,distance, solvent.getLabel(), solvent.getID_Name_1(), solvent.getID_CAS_Nr_1(), solvent.getID_EG_Nr(), solvent.getID_EG_Annex_Nr(), solvent.getInput());
			webSolvent.setPredictLabel(solvent.getLabel());
			
			cluster2.addSolvent(webSolvent);
		}
		
		for (int i=0; i < results.size(); i++)
		{
			results.get(i).setSortKey(SortKey.SOLVENT);
		}
		Collections.sort(results);
				
		LiatoLogger.getInstance().info("\n-----------------------------------------------------------------------");
		LiatoLogger.getInstance().info("Sorted Solvents per SolventNumber (~csv file order) :");
		LiatoLogger.getInstance().info("-----------------------------------------------------------------------\n");
		LiatoLogger.getInstance().info("Number\tName\tCasNr\tCluster\tDistanceToClusterCenter");
		
		for (int i = 0; i < results.size(); i++)
		{
			SolventData solvent = results.get(i).getSolventData();						
			Cluster cluster = clusters.get(results.get(i).getClusterNumber());			
			double distance = MathManager.getEuclideanDistance(solvent.getFeatureValues(), cluster.getFeatureValues());	
			
			// String formattedString = String.format("%4d\t%100s\t%20s\t%2d", i, tempMetaData.getName(), tempMetaData.getCasNr(), results.get(i).getClusterNumber());
			String formattedString = String.format("%d\t%s\t%s\t%d\t%f", i, solvent.getID_Name_1(), solvent.getID_CAS_Nr_1(), results.get(i).getClusterNumber(), distance);
			LiatoLogger.getInstance().info(formattedString);			
		}
				
		LiatoLogger.getInstance().info("\n-----------------------------------------------------------------------");
		LiatoLogger.getInstance().info("Cluster distances (copy/paste to Excel) :");
		LiatoLogger.getInstance().info("-----------------------------------------------------------------------\n");
		
		ProcessClusterDistances(wekaModel);
	}
	
	public static void ProcessClusterDistances(Model wekaModel)
	{
		Cluster cluster1 = null;
		Cluster cluster2 = null;
		com.sussol.domain.model.data.JsonModel.WebCluster webCluster1 = null;
		com.sussol.domain.model.data.JsonModel.WebCluster webCluster2 = null;
		double distance = 0.0;
		
		DecimalFormat doubleFormat = new DecimalFormat("####.###");
		doubleFormat.setRoundingMode(RoundingMode.HALF_UP);	

		String logString = "";
		logString += "\t";
		
		for (int i = 0; i < clusters.size(); i++)
		{
			logString += String.format("%s", i);
			if (i < clusters.size() - 1)
			{	
				logString += "\t";
			}
		}
		logString += "\n";
		List<com.sussol.domain.model.data.JsonModel.WebCluster> webClusters = wekaModel.getClusters();
		for (int i = 0; i < clusters.size(); i++)
		{
			logString += String.format("%s", i);
			logString += "\t";

			cluster1 = clusters.get(i);
			webCluster1 = webClusters.get(i);
			for (int j=0; j < clusters.size(); j++)
			{
				cluster2 = clusters.get(j);
				distance = MathManager.getEuclideanDistance(cluster1.getFeatureValues(), cluster2.getFeatureValues());
				webCluster1.addClusterWithDistance(j, distance);
				logString += String.format("%s", doubleFormat.format(distance));
				if (j < clusters.size() - 1)
				{	
					logString += "\t";
				}
			}
			logString += "\n";
		}

		LiatoLogger.getInstance().info(logString);
	}
}
