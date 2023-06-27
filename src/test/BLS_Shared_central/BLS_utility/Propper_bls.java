package BLS_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propper_bls {
	public static String promp(String value) throws IOException {
		
		Properties prop = new Properties();
		
		String path = System.getProperty("user.dir")+"//src//test//resource//config.properties";
		
		
	    File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		 
		String valueprop = prop.getProperty(value);
		return valueprop;
	}
}
