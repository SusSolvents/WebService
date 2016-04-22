package com.sussol.domain.utilities;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiatoLogger 
{
	private static LiatoLogger instance = null;
	private Logger logger = null;
	   
    private LiatoLogger() 
    {
    	logger = LoggerFactory.getLogger("Solvents");     
    }
	   
    public static LiatoLogger getInstance() 
    {
       if (instance == null) 
       {
    	   instance = new LiatoLogger();
       }
       return instance;
    }
	
    public void info(String message)	{logger.info(message);}	
    public void debug(String message)	{logger.debug(message);}
    public void warn(String message)	{logger.warn(message);}
    public void error(String message)	{logger.error(message);}
    
    public void closeLogger()
    {
    	logger = null;
    }
}
