package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is a non static
 * @author Vaibhav
 *
 */

public class FileLibrary {
	
	public String ReadDataFromProperty(String key) throws IOException { //
		
		FileInputStream fis = new FileInputStream("./TestData/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
		
	}
	/**
	 * This method is a non-static method ,used to read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ReadDataFromExcelFile(String sheetname,int row, int cell ) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./TestData/ACTITIME TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetname).getRow(1).getCell(2).getStringCellValue();
		return value;
	}
	

}
