package com.sussol.domain.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Globals
{
	public enum Algorithm {CANOPY, COBWEB, DBSCAN, EM, KMEANS, SOM, XMEANS}
	public enum SortKey {CLUSTER, SOLVENT}
	public enum AttributeType {NUMERIC, STRING}
	public static String trainingFileName = "";
	
	public static String pathToArffFile = "";
	public static String pathToArffFileOnlyData = "";
	public static String pathToArffFileData = "";
	public static List<String> featureNames;

	public static double[] convertDoubles(List<Double> doubles)
	{
	    double[] ret = new double[doubles.size()];
	    Iterator<Double> iterator = doubles.iterator();
	    int i = 0;
	    while(iterator.hasNext())
	    {
	        ret[i] = iterator.next();
	        i++;
	    }
	    return ret;
	}
}
