package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.ProjectSpecificMethods;

public class ReadFromExcel extends ProjectSpecificMethods {

	public String[][] readExcel(String filename) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/" + filename + ".xlsx");

		XSSFSheet ws = wb.getSheetAt(0);

		int rowCount = ws.getLastRowNum();

		int cellCount = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = cellValue;
			}
		}

		wb.close();

		return data;

	}

	public ArrayList<String> readIncidentNumber() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/IncidentManagement.xlsx");

		XSSFSheet ws = wb.getSheetAt(0);

		int rowCount = ws.getLastRowNum();

		int cellCount = ws.getRow(0).getLastCellNum();

		ArrayList<String> incidentNumbers = new ArrayList<String>();

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				incidentNumbers.add(cellValue);
			}
		}

		return incidentNumbers;

	}

	public void writeToExcel(ArrayList<String> incidentNo) throws IOException {

		String filename = "./data/IncidentManagement.xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("IncidentNumbers");

		XSSFRow rowhead = sheet.createRow((short) 0);

		rowhead.createCell(0).setCellValue("Incident Number");

		int count = 0;
		System.out.println(incidentNo.size());

		for (int i = 1; i <= incidentNo.size(); i++) {
			sheet.createRow(i).createCell(0).setCellValue(incidentNo.get(count));
			count = count + 1;
		}

		FileOutputStream fileOut = new FileOutputStream(filename);

		workbook.write(fileOut);

		fileOut.close();

		workbook.close();

	}

}
