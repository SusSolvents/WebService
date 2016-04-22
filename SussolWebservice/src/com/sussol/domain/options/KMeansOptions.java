package com.sussol.domain.options;

public class KMeansOptions extends OptionsManager 
{
	public KMeansOptions() 
	{
		options = new String[20];
		initializeOptions();
	}

	/* KMeans
	
	initialisation method 	: 0 = random, 1 = k-means++, 2 = canopy, 3 = farthest first, default = 0.		
	max candidates 			: maximum number of candidate canopies to retain in memory.			
	periodic pruning		: how often to prune low density canopies when using canopy clustering. 
  	min density				: minimum canopy density below which a canopy will be pruned during periodic pruning.
  	T2 distance				: the T2 distance.
	T1 distance				: the T1 distance.
  	num of clusters			: must be specified, default = 2.		
  	distance function		: distance function.		
  	max iterations			: maximum number of iterations.
  	seed 					: the random number seed to be used.		

	*/
	public void initializeOptions()
	{		
		options[0] = "-init";				// initialisation method
		options[1] = "0";
		options[2] = "-max-candidates";		// max candidates
		options[3] = "10000";
		options[4] = "-periodic-pruning";	// periodic pruning
		options[5] = "10000";
		options[6] = "-min-density";		// min density 
		options[7] = "2.0";
		options[8] = "-t2";					// T2 distance
		options[9] = "-1.0";
		options[10] = "-t1";				// T1 distance
		options[11] = "-1.25";
		options[12] = "-N";					// num of clusters 
		options[13] = "4";
		options[14] = "-A";					// distance function
		options[15] = "weka.core.EuclideanDistance -R first-last";
		options[16] = "-I";					// max iterations
		options[17] = "500";
		options[18] = "-S";					// seed
		options[19] = "10";
	}
}
