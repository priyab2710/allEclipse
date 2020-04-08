package PackageA;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;


public class Demo1 {

	public static Logger Log = LogManager.getLogger(Demo1.class.getName());
	
	@Test
	public void LogTest()
	{
		// TODO Auto-generated method stub
       
        Log.debug("I am debugging 1");
        Log.fatal("This is fatal 1");
        Log.info("This is info 1");	
		Log.error("Object is smaller than 1");
		Log.debug("I am debugging 2");
	    Log.fatal("This is fatal 2");
	    Log.info("This is info 2");	
		Log.error("Object is smaller than 2");
		Log.debug("I am debugging 3");
		Log.fatal("This is fatal 3");
		Log.info("This is info 3");	
		Log.error("Object is smaller than 3");
		Log.debug("I am debugging 4");
		Log.fatal("This is fatal 4");
		Log.info("This is info 4");	
		Log.error("Object is smaller than 4");
		
	}

}
