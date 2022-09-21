package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author User
 *
 */
public class FileUtility {
	
	public String getDataFromPropertyFile(String propertyFilePath, String key) {
		 FileInputStream fis=null;
		try {
			fis=new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		Properties properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value=properties.getProperty(key).trim();
		return value;
	}
		
		/**
		 * This method is used to initialize the property file
		 * @throws IOException 
		 */
		
		public void initializePropertyFile(String propertyFilePath) throws IOException {
			FileInputStream fis=new FileInputStream(propertyFilePath);
			Properties properties = new Properties();
			properties.load(fis);
		
	}

}
