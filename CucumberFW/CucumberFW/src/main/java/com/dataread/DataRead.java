package com.dataread;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataRead {
	
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	@Test
	public void getdata() throws InvalidFormatException, IOException {
		book = new XSSFWorkbook(new File("./Datas/DataFile.xlsx"));
		sheet = book.getSheetAt(1);
		
		int rowcount = sheet.getLastRowNum();
		for(int i=1;i<rowcount+1;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}
		}
	}

}
