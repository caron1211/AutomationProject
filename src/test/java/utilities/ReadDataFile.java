package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadDataFile {

	public static String readDataFile(String key) {
		String value="";
		try {
			Properties prop= new Properties();
			InputStream input = new FileInputStream("./src/test/java/Data/Configuration.properties");
			prop.load(input);
			value=prop.getProperty(key);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return value;
	}
}
