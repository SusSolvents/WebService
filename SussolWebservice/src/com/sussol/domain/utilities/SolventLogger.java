package com.sussol.domain.utilities;
import java.io.File;
import java.net.URL;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolventLogger 
{
	private static SolventLogger instance = null;
	private Logger logger = null;
	   
    private SolventLogger() 
    {
    	logger = LoggerFactory.getLogger("Solvents");     
    }
	   
    public static SolventLogger getInstance() 
    {
       if (instance == null) 
       {
    	   instance = new SolventLogger();
       }
       return instance;
    }
	
    public void info(String message)	{Globals.log += message;logger.info(message);}	
    public void debug(String message)	{Globals.log += message;logger.debug(message);}
    public void warn(String message)	{Globals.log += message;logger.warn(message);}
    public void error(String message)	{Globals.log += message;logger.error(message);}
    
    public void closeLogger()
    {
    	//logger = null;
    	Globals.log = "";
    }
    
    public java.io.File getLogFile()
    {
    	URL url = getClass().getResource("../logging/Solvents.log");
    	File file = new File(url.getPath());	
    	return file;
    }
}
