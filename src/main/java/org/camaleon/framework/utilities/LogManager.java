package org.camaleon.framework.utilities;

import org.apache.log4j.Logger;

public class LogManager {
	
	static Logger log = Logger.getLogger(LogManager.class.getName());
	 
	public static void info(String message){
		   log.info(message);
	}
	   public static void warn(String message){
		   log.warn(message);
	   }
	   
	   public static void error(String message){
		   log.error(message);
	   }
}
