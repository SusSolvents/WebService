package com.sussol.domain.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.sussol.domain.model.data.SolventAttribute;
import com.sussol.domain.model.data.SolventData;
import com.sussol.domain.utilities.Globals;
import com.sussol.domain.utilities.Globals.AttributeType;

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
	public static ArrayList<SolventAttribute> getSolventAttributes(String fileName)
	{
		String STORAGE_PATH = System.getenv("OPENSHIFT_DATA_DIR") == null ? "/uploads/" : System.getenv("OPENSHIFT_DATA_DIR");
		ArrayList<SolventAttribute> solventAttributes = new ArrayList<>();
		
		System.out.println(fileName);
		String newFileName = fileName.substring(0, fileName.lastIndexOf(" ")) + " Data.arff";
		System.out.println(newFileName);
		try
		{
			File file = new File(STORAGE_PATH + newFileName);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			
			String line = bufferedReader.readLine();
			line = bufferedReader.readLine();
			line = bufferedReader.readLine();
			line = bufferedReader.readLine();
			line = bufferedReader.readLine();	// Contains the number of features.
			
			line = line.substring(line.indexOf(':') + 2, line.length());
			int nrOfFeatures = Integer.parseInt(line);
			
			line = bufferedReader.readLine();
			
			String attributeName;
			String tempType;
			AttributeType attributeType;
			
			for (int i=0; i < nrOfFeatures; i++)
			{
				line = bufferedReader.readLine();
				
				attributeName = line.substring(11, line.lastIndexOf(' ') - 1);				
				tempType = line.substring(line.lastIndexOf(' ') + 1, line.length());
				switch (tempType)
				{
				case "numeric":
					attributeType = AttributeType.NUMERIC;
					break;
				case "string":
					attributeType = AttributeType.STRING;
					break;
				default:
					attributeType = AttributeType.NUMERIC;
					break;
				}
								
				solventAttributes.add(new SolventAttribute(attributeName, attributeType));
			}
			
			bufferedReader.close();	
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); } 
		catch (IOException e) 			{ e.printStackTrace(); }
		
		return solventAttributes;
	}
}
