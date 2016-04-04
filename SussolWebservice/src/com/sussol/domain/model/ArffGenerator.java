package com.sussol.domain.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sussol.domain.utilities.Globals;

public class ArffGenerator 
{
	private String pathToCsvFile;
	private String arffFileName;
		
	public ArffGenerator(String absolutePathToCsvFile, String fileName) 
	{		
		this.pathToCsvFile = absolutePathToCsvFile;
		this.arffFileName = "C:/arfffiles/" + fileName.substring(0, fileName.indexOf('.')) + ".arff";
		
	}

	public void generateSustainableSolventsArff()
	{
		try 
		{		
			BufferedReader csvStream = new BufferedReader(new FileReader(pathToCsvFile));
						
			File file = new File(arffFileName);
			if (! file.exists()) 
			{
				file.createNewFile();
			}
			BufferedWriter arffStream = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
					
			arffStream.write("% Sustainable solvents data.\n");
			arffStream.write("\n");
			arffStream.write("@Relation get_the_clusters");
			arffStream.write("\n\n");		
			
			String dataTypesLine = csvStream.readLine();		// Process attributes.
            String[] attributes = dataTypesLine.split("\t");

			arffStream.write("% NumberOfFeatures : " + (attributes.length - 3) + "\n\n");
			
            for (int i = 0; i < attributes.length; i++)
            {
                switch (i)
                {
                    case 0: // Input
                    case 3: // ID_EG_Nr
                    case 4: // ID_EG_Annex_Nr
                        break;
                    case 1: // ID_Name_1
                    case 2: // ID_CAS_Nr_1
                    	arffStream.write("@Attribute " + attributes[i] + " string\n");
                    	break;
                    default:
                    	arffStream.write("@Attribute " + attributes[i] + " numeric\n");
                        break;
                }
            }		
            
            csvStream.readLine();								// Skip datatypes line
            csvStream.readLine();								// Skip randomisation range line.
            
            arffStream.write("\n@Data\n\n");
								
			String line = csvStream.readLine();			
			while (line != null)
			{
				String[] values = line.split("\t");
				for (int featureNumber = 0; featureNumber < values.length; featureNumber++)
	            {
	                switch (featureNumber)
	                {
	                    case 0: // Input	                    
	                    case 3: // ID_EG_Nr
	                    case 4: // ID_EG_Annex_Nr
	                        break;
	                    case 1: // ID_Name_1
	                    case 2: // ID_CAS_Nr_1 
	                    	arffStream.write('"' + values[featureNumber] + '"' + "|");
	                    	break;	                    		                    		                   
	                    default:
	                    	switch (values[featureNumber])
                            {
                                case "":        // No value.                                       
                                case "NAV":     // Not available.
                                case "NAP":     // Not applicable.
                                	if (featureNumber != values.length - 1)
        	                    	{
                                		arffStream.write("0|");
        	                    	}
        	                    	else
        	                    	{
        	                    		arffStream.write("0\n");
        	                    	}                                	
                                	break;
                                default:
                                	if (featureNumber != values.length - 1)
        	                    	{
        	                    		arffStream.write(values[featureNumber] + "|");
        	                    	}
        	                    	else
        	                    	{
        	                    		arffStream.write(values[featureNumber] + "\n");
        	                    	}
        	                        break;
                            }                                	                    		                   
	                }
	            }						
								
				line = csvStream.readLine();
			}
			
			Globals.pathToArffFile = arffFileName;
			
			csvStream.close();
			arffStream.close();
			
		} 
		catch (FileNotFoundException e) { System.out.println("File not found or could not be opened."); }
		catch (IOException e) { 
			e.printStackTrace();
			System.out.println(pathToCsvFile);
			System.out.println("Error reading from file."); 
			}
	}

	public void generateSubFiles()
	{
		try 
		{		
			// Source arff file
			BufferedReader arffStream = new BufferedReader(new FileReader(Globals.pathToArffFile));
						
			String arffOnlyData = Globals.pathToArffFile.substring(0, Globals.pathToArffFile.indexOf('.'));
			arffOnlyData += " OnlyData.arff";
			File file = new File(arffOnlyData);
			if (! file.exists()) 
			{
				file.createNewFile();
			}
			// Only data, for logging after the model has been made. Pipe separated.
			BufferedWriter arffStreamOnlyData = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

			String arffData = Globals.pathToArffFile.substring(0, Globals.pathToArffFile.indexOf('.'));
			arffData += " Data.arff";
			file = new File(arffData);
			if (! file.exists()) 
			{
				file.createNewFile();
			}
			// Only data (no Name and CasNr), for training and making the model. Comma-separated.
			BufferedWriter arffStreamData = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
					
			// Skip the first 4 lines.
			arffStreamData.write(arffStream.readLine() + "\n");
			arffStreamData.write(arffStream.readLine() + "\n");
			arffStreamData.write(arffStream.readLine() + "\n");
			arffStreamData.write(arffStream.readLine() + "\n");
			
			String tempLine = arffStream.readLine();			
			tempLine = tempLine.substring(tempLine.indexOf(':') + 2, tempLine.length());
			int nrOfFeatures = Integer.parseInt(tempLine);
			
			arffStreamData.write("% Number of features : " + (nrOfFeatures - 2) + "\n");
			
			arffStreamData.write(arffStream.readLine() + "\n");
			arffStream.readLine();
			arffStream.readLine();
			for (int i=0; i < nrOfFeatures -2; i++)
			{
				arffStreamData.write(arffStream.readLine() + "\n");
			}
			
			arffStreamData.write(arffStream.readLine() + "\n");			
			arffStreamData.write(arffStream.readLine() + "\n");	
			arffStreamData.write(arffStream.readLine() + "\n");	
			
			String line = arffStream.readLine();			
			while (line != null)
			{							
				arffStreamData.write(line.substring(line.lastIndexOf("\"") + 2).replace('|', ',') + "\n");
				arffStreamOnlyData.write(line + "\n");
				line = arffStream.readLine();
			}
			
			Globals.pathToArffFileOnlyData = arffOnlyData;
			Globals.pathToArffFileData = arffData;
			
			arffStream.close();
			arffStreamOnlyData.close();
			arffStreamData.close();
		}
		catch (FileNotFoundException e) { System.out.println("File not found or could nott be opened."); }
		catch (IOException e) { System.out.println("Error reading from file."); }
	}
}
