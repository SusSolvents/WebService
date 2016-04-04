package com.sussol.domain.options;

public class CobWebOptions extends OptionsManager 
{
	public CobWebOptions() 
	{
		options = new String[8];
		initializeOptions();
	}

	/* CobWeb
	
	acuity 				: minimum standard deviation for numeric attributes, default value is 0.1.
	cuttoff 			: the category utility threshold by which to prune nodes, default value is 0.3.
	seed 				: the random number seed to be used.
	output-debug-info	: send additional information to console.

	*/
	public void initializeOptions()
	{
		options[0] = "-A";						// acuity 
		options[1] = "1.0";
		options[2] = "-C";						// cutoff
		options[3] = "0.05";
		options[4] = "-S";						// seed
		options[5] = "100";
		options[6] = "-output-debug-info";		// additional information to console
		options[7] = "";
	}
}
