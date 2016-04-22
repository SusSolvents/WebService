package com.sussol.domain.options;
public class DBScanOptions extends OptionsManager 
{
	public DBScanOptions() 
	{
		options = new String[4];
		initializeOptions();
	}

	/* DBSCan
	
	epsilon 			: radius of the epsilon-range-queries, default value is 0.9.
	min points 			: minimum number of DataObjects required in an epsilon-range-query, default value is 6.	

	*/
	public void initializeOptions()
	{
		options[0] = "-E";						// epsilon 
		options[1] = "0.9";
		options[2] = "-M";						// min points
		options[3] = "6";		
	}
}
