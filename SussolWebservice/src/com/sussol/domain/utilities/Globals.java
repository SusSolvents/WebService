package com.sussol.domain.utilities;

import java.util.ArrayList;
import java.util.List;

public class Globals
{
	public enum Algorithm {CANOPY, COBWEB, DBSCAN, EM, KMEANS, SOM, XMEANS}
	public enum SortKey {CLUSTER, SOLVENT}
	
	public static String trainingFileName = "";
	
	public static String pathToArffFile = "";
	public static String pathToArffFileOnlyData = "";
	public static String pathToArffFileData = "";
	public static List<String> featureNames;
}
