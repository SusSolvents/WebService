package com.sussol.domain.options;
public class XMeansOptions extends OptionsManager 
{
	public XMeansOptions() 
	{
		options = new String[6];
		initializeOptions();
	}

	/* XMeans
	
	max iterations		 	: maximum number of overall iterations, default = 1.		
	min clusters 			: minimum number of clusters, default = 2.			
	max clusters			: maximum number of clusters, default = 4.   	

	*/
	public void initializeOptions()
	{		
		options[0] = "-I";		// max iterations
		options[1] = "1";
		options[2] = "-L";		// min clusters
		options[3] = "2";
		options[4] = "-H";		// max clusters
		options[5] = "4";
	}
}
