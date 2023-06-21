package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class Properties_F {
	
	
public static String promp(String value) throws IOException {
	
	Properties prop = new Properties();
	
	String path = System.getProperty("user.dir")+"";
	
	
    File f = new File(path);
	FileInputStream fis = new FileInputStream(f);
	prop.load(fis);
	 
	String valueprop = prop.getProperty(value);
	return valueprop;
}

}
