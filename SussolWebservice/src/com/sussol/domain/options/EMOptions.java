package com.sussol.domain.options;
public class EMOptions extends OptionsManager 
{
	public EMOptions() 
	{
		options = new String[20];
		initializeOptions();
	}
	
	/* Expectancy maximisation
	
	max iterations 				: maximum number of iterations.			
	number of clusters 			: if omitted or -1, then cross validation is used to select the number of clusters.			
	number of folds 			: number of folds to use when cross-validating to find the best number of clusters.				
	max number of clusters		: maximum number of clusters to consider during cross-validation.
	min improvement increase	: in cross-validated log likelihood required to consider increasing the number of clusters.
	min improvement iteration	: in log likelihood required to perform another iteration of the E and M steps.
	min standard deviation		: minimum allowable standard deviation for normal density computation.
	number of k-means runs		: number of runs of k-means to perform.
	number of execution slots	: determines parallellism, default = 1, no parallellism.
	seed 						: the random number seed to be used.
	
	*/
	public void initializeOptions()
	{		
		options[0] = "-I";			// max iterations 
		options[1] = "100";
		options[2] = "-N";			// number of clusters
		options[3] = "-1";
		options[4] = "-X";			// number of folds
		options[5] = "10";
		options[6] = "-max";		// max number of clusters
		options[7] = "-1";
		options[8] = "-ll-cv";		// min improvement increase
		options[9] = "1.0E-6";
		options[10] = "-ll-iter";	// min improvement iteration
		options[11] = "1.0E-6";
		options[12] = "-M";			// min standard deviation
		options[13] = "1.0E-6";
		options[14] = "-K";			// number of k-means runs
		options[15] = "10";
		options[16] = "-num-slots";	// number of execution slots
		options[17] = "1";
		options[18] = "-S";			// seed
		options[19] = "100";
	}

}
