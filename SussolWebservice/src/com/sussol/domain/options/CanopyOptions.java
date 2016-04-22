package com.sussol.domain.options;
public class CanopyOptions extends OptionsManager 
{
	public CanopyOptions()
	{
		options = new String[14];
		initializeOptions();
	}
	
	/* Canopy
	
	number of clusters 	: -1 for no prior choice.
	max candidates 		: maximum number of candidates to keep in memory.
	periodic pruning 	: how often to prune low density candidates during training.
	minimum density 	: the minimum density below which a canopy will be pruned.
	T2 distance			: the T2 distance.
	T1 distance			: the T1 distance.	
	seed				: the randomnumber seed to be used.
	
	*/
	public void initializeOptions()
	{
		options[0] = "-N";						// number of clusters 
		options[1] = "-1";
		options[2] = "-max-candidates";			// max candidates
		options[3] = "100";
		options[4] = "-periodic-pruning";		// periodic pruning
		options[5] = "10000";
		options[6] = "-min-density";			// minimum density
		options[7] = "2.0";
		options[8] = "-t2";						// T2 distance
		options[9] = "-1.0";
		options[10] = "-t1";					// T1 distance
		options[11] = "-1.25";
		options[12] = "-S";						// Seed
		options[13] = "1";

	}
}
