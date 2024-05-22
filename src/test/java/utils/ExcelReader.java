package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
	private Workbook workbook;
	private Sheet sheet;

	public ExcelReader(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(new File(filePath));
		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheet(sheetName);
	}

	public String getDataByKey(String key) {
		DataFormatter dataFormatter = new DataFormatter();
		Map<String, String> dataMap = new HashMap<>();

		for (Row row : sheet) {
			String cellKey = dataFormatter.formatCellValue(row.getCell(0));
			String cellValue = dataFormatter.formatCellValue(row.getCell(1));
			dataMap.put(cellKey, cellValue);
		}
		return dataMap.get(key);
	}

	public void close() throws IOException {
		workbook.close();
	}
}
