package com.sussol.domain.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import com.sussol.domain.model.data.Cluster;
import com.sussol.domain.model.data.Result;
import com.sussol.domain.model.data.SolventData;
import com.sussol.domain.model.data.webmodel.WekaModel;
import com.sussol.domain.model.data.webmodel.WekaResult;
import com.sussol.domain.utilities.Globals.Algorithm;
import com.sussol.domain.utilities.Globals.SortKey;
import com.sussol.domain.utilities.MathManager;
import com.sussol.domain.utilities.SolventLogger;

import weka.clusterers.ClusterEvaluation;

public class PostProcessor 
{
	private static ArrayList<Cluster> clusters;
	private static final int numberOfFeatures = 6;
	
	// TODO : bestudeer de code van
	// http://www.programcreek.com/java-api-examples/index.php?example_code_path=weka-weka.clusterers-ClusterEvaluation.java
	// om de resultaten van CobWeb te laten zien, per class/cluster.
	public static void ProcessClustersCobWeb(WekaResult wekaResult, ClusterEvaluation evaluation)
	{							
		String clusterResults = evaluation.clusterResultsToString();
		SolventLogger.getInstance().info(clusterResults);		
						
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
				featureValues.add(new Double(1));
			}
		
			clusters.add(new Cluster(i, featureValues));
		}			
		wekaResult.setClusters(clusters);
		wekaResult.setGeneralResultInformation(clusterResults);
	}	
	
	public static void processClusters(WekaResult wekaResult,ClusterEvaluation evaluation)
	{								
		String clusterResults = evaluation.clusterResultsToString();
		
		SolventLogger.getInstance().info(clusterResults);		
		
		String clustersString = clusterResults.substring(clusterResults.indexOf("SOLVENTCLUSTERS") + 16, clusterResults.lastIndexOf("SOLVENTCLUSTERS"));
		String[] clustersAsString = clustersString.split("\n");		
		
		clusters = new ArrayList<Cluster>();
		for (int i = 0; i < clustersAsString.length; i++)
		{
			ArrayList<Double> featureValues = new ArrayList<Double>();
			String[] doubleValues = clustersAsString[i].split("\t");

			// j starts at 1, because index 0 is the label "Cluster n".
			for (int j = 1; j < doubleValues.length; j++)
			{
			
				
				doubleValues[j] = doubleValues[j].replaceAll(",", ".");
				featureValues.add(new Double(doubleValues[j]));
			}
		
			clusters.add(new Cluster(i, featureValues));
		}
		wekaResult.setClusters(clusters);
		wekaResult.setGeneralResultInformation(clusterResults);
	}
	
	public static void ProcessClusterAssignments(ClusterEvaluation evaluation, Algorithm algorithm)
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
				
		SolventLogger.getInstance().info("-----------------------------------------------------------------------");
		SolventLogger.getInstance().info("Sorted Solvents per Cluster :");
		SolventLogger.getInstance().info("-----------------------------------------------------------------------\n");
		SolventLogger.getInstance().info("Number\tName\tCasNr\tCluster\tDistanceToClusterCenter");
		
		for (int i = 0; i < results.size(); i++)
		{
			SolventData solvent = results.get(i).getSolventData();						
			Cluster cluster = clusters.get(results.get(i).getClusterNumber());			
			double distance = MathManager.getEuclideanDistance(solvent.getFeatureValues(), cluster.getFeatureValues());	
			
			// String formattedString = String.format("%4d\t%100s\t%20s\t%2d", i, tempMetaData.getName(), tempMetaData.getCasNr(), results.get(i).getClusterNumber());
			String formattedString = String.format("%d\t%s\t%s\t%d\t%f", i, solvent.getName(), solvent.getCasNr(), results.get(i).getClusterNumber(), distance);
			SolventLogger.getInstance().info(formattedString);			
		}
		
		for (int i=0; i < results.size(); i++)
		{
			results.get(i).setSortKey(SortKey.SOLVENT);
		}
		Collections.sort(results);
				
		SolventLogger.getInstance().info("\n-----------------------------------------------------------------------");
		SolventLogger.getInstance().info("Sorted Solvents per SolventNumber (~csv file order) :");
		SolventLogger.getInstance().info("-----------------------------------------------------------------------\n");
		SolventLogger.getInstance().info("Number\tName\tCasNr\tCluster\tDistanceToClusterCenter");
		
		for (int i = 0; i < results.size(); i++)
		{
			SolventData solvent = results.get(i).getSolventData();						
			Cluster cluster = clusters.get(results.get(i).getClusterNumber());			
			double distance = MathManager.getEuclideanDistance(solvent.getFeatureValues(), cluster.getFeatureValues());	
			
			// String formattedString = String.format("%4d\t%100s\t%20s\t%2d", i, tempMetaData.getName(), tempMetaData.getCasNr(), results.get(i).getClusterNumber());
			String formattedString = String.format("%d\t%s\t%s\t%d\t%f", i, solvent.getName(), solvent.getCasNr(), results.get(i).getClusterNumber(), distance);
			SolventLogger.getInstance().info(formattedString);			
		}
				
		SolventLogger.getInstance().info("\n-----------------------------------------------------------------------");
		SolventLogger.getInstance().info("Cluster distances (copy/paste to Excel) :");
		SolventLogger.getInstance().info("-----------------------------------------------------------------------\n");
		
		ProcessClusterDistances();
	}
	
	public static void ProcessClusterDistances()
	{
		Cluster cluster1 = null;
		Cluster cluster2 = null;
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
		
		for (int i = 0; i < clusters.size(); i++)
		{
			logString += String.format("%s", i);
			logString += "\t";

			cluster1 = clusters.get(i);
			for (int j=0; j < clusters.size(); j++)
			{
				cluster2 = clusters.get(j);
				distance = MathManager.getEuclideanDistance(cluster1.getFeatureValues(), cluster2.getFeatureValues());
				
				logString += String.format("%s", doubleFormat.format(distance));
				if (j < clusters.size() - 1)
				{	
					logString += "\t";
				}
			}
			logString += "\n";
		}

		SolventLogger.getInstance().info(logString);
	}
}
