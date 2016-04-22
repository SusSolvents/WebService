package com.sussol.domain.options;
public class SOMOptions extends OptionsManager 
{
	public SOMOptions() 
	{
		options = new String[10];
		initializeOptions();
	}
	
	/* SOM
	
	learning rate 		: initial amount the weights are updated.		
	ordering epochs		: number of epochs in ordering phase.			
	converging epochs	: number of epochs in converging phase.				
	height				: the height of the lattice.
	width				: the width of the lattice.
	
	*/
	public void initializeOptions()
	{		
		options[0] = "-L";		// learning rate 
		options[1] = "1.0";
		options[2] = "-O";		// ordering epochs
		options[3] = "2000";
		options[4] = "-C";		// converging epochs
		options[5] = "1000";
		options[6] = "-H";		// height
		options[7] = "2";
		options[8] = "-W";		// width
		options[9] = "2";
		
	}
}
