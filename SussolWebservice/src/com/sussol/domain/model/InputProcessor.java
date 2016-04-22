package com.sussol.domain.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.sussol.domain.model.data.SolventData;
import com.sussol.domain.utilities.Globals;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class InputProcessor 
{
	public static Instances getTrainInstances()
	{
		DataSource source = null;
		Instances instances = null;
		
		try 
		{
			source = new DataSource(Globals.pathToArffFileData);
			instances = source.getDataSet();					
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return instances;
	}
	
	public static Instances getTestInstances()
	{
		DataSource source = null;
		Instances instances = null;
		
		try 
		{						
			source = new DataSource(Globals.pathToArffFileData);
			instances = source.getDataSet();
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return instances;		
	}
	
	public static ArrayList<SolventData> getSolventData()
	{
		ArrayList<SolventData> solvents = new ArrayList<>();
		
		int solventCounter = 0;
		try
		{
			File file = new File(Globals.pathToArffFileOnlyData);	
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		    		   
		    String line;
		    String[] solventString;
		    while((line = bufferedReader.readLine()) != null)
		    {
		    	solventString = line.split(Pattern.quote("|"));
		    	solvents.add(new SolventData(solventCounter++, solventString));
		    }
		    
		    bufferedReader.close();		    
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); } 
		catch (IOException e) 			{ e.printStackTrace(); }
		
	    return solvents;
	}
}
