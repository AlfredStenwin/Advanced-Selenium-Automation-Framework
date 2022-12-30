package logsetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*Singleton design pattern is used since a single instance of logger is to be used*/

public class LogUtility{

	private static LogUtility instance = null;
	private static Logger log = LogManager.getLogger("LOG");

		
	//private constructor - instantiation is not possible		
	private LogUtility() {
	}
	
	public static LogUtility getInstance( ){
        if(instance  == null){
            instance  = new LogUtility();
        }
        
        return instance;
    }
	
    public static void info(String logMessage) {
        log.info(logMessage);

    }

    public void error(String msg, Throwable throwable) {               
        log.error(msg, throwable);      
    }
    
    public void error(String msg) {               
        log.error(msg);      
    }

}
