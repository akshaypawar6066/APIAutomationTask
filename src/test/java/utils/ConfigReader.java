package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static final String EXCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	private static final String SHEET_NAME = "Sheet1";

	public static String readExcelDataByKey(String key) throws IOException {
		ExcelReader excelReader = new ExcelReader(EXCEL_PATH, SHEET_NAME);
		String data = excelReader.getDataByKey(key);
		excelReader.close();
		return data;
	}
	
	public static String readPropData(String propertyToRead) throws IOException {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(new File(filePath));
		prop.load(file);
		return prop.getProperty(propertyToRead);
	}
}
