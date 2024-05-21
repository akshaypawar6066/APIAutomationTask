package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String readPropData(String propertyToRead) throws IOException {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(new File(filePath));
		prop.load(file);
		return prop.getProperty(propertyToRead);
	}

}
