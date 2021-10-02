package com.crm.autodesk.GenericUtils;
/*
 * this class contains generic methods to read and write data from excelsheet
 * @author Shubham
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class ExcelFileUtility {
	
	/*this method will read the data from excel sheet to write row number and cell number
	 * @throws throwable
	 * 
	 */
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelSheetPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = (Sheet) workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		
		String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;
		
	}	
		
		
	}
	


