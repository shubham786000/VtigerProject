package com.crm.autodesk.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.math3.stat.descriptive.summary.Product;

/* this class contains generic method to read the data from property file 
	@author Shubham
 * 
 */

public class PropertyFileUtility {
	
	// this method contains method to read data from property file 
	
	public String getPropertyFileData(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./Excelsheet/Product.xlsx");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
}
