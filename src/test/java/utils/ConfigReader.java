package utils;

import java.io.IOException;

public class ConfigReader {
	private static final String EXCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	private static final String SHEET_NAME = "Sheet1";

	public static String readExcelDataByKey(String key) throws IOException {
		ExcelReader excelReader = new ExcelReader(EXCEL_PATH, SHEET_NAME);
		String data = excelReader.getDataByKey(key);
		excelReader.close();
		return data;
	}
}
