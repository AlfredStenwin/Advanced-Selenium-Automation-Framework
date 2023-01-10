package logsetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log{

	public static Logger log = LogManager.getLogger(Log.class.getName());
	
    public static void info(String logMessage) {
        log.info(logMessage);
    }

    public static void error(String msg, Throwable throwable) {               
        log.error(msg, throwable);      
    }
    
    public static void error(String msg) {               
        log.error(msg);      
    }
}
