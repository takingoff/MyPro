package log4;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestLog
{
	
	static Logger logger = Logger.getLogger(TestLog.class);

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(logger.getName());
		logger.log(Level.INFO,"come from logFunction");
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
		logger.fatal("fatal message");
	}

}
