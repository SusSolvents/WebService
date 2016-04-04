package com.sussol.domain.options;

public class OptionsManager 
{	
	protected String[] options;
	
	public OptionsManager() 
	{		
    }		
	
	public void setOption(String option, String value)
	{
		for (int i=0; i < options.length; i++)
		{
			if (options[i].equalsIgnoreCase(option))
			{
				options[i + 1] = value; 
			}
		}
	}
	
	public String getOptionValue(String option)
	{
		for (int i=0; i < options.length; i++)
		{
			if (options[i].equalsIgnoreCase(option))
			{
				return options[i + 1]; 
			}
		}
		return "0";
	}
	
	// Utility Methods
	public String getOptionsForLogging()
	{
		String temp = "\nParameter Values\n\n";
		
		for (int i=0; i < options.length - 1; i += 2)
		{
			temp += options[i] + "\t" + options[i + 1] + "\n";
		}
		
		return temp;
	}
	
	public String[] getOptions() { return options; }
	
}
