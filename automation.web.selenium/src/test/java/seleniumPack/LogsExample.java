package seleniumPack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogsExample {

	static Logger log = Logger.getLogger(LogsExample.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("./log4j.properties");
		log.info("from info log");
		log.error("this is debug line");
	}

}
