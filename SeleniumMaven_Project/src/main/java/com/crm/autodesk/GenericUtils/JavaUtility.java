package com.crm.autodesk.GenericUtils;

import java.util.Random;

/*
	this class contains generic methods pertaining to java
	@author Shubham
*/

public class JavaUtility {
	
	// this method generates random numbers
	
	public int getRandom()
	{
		Random r = new Random();
		int num = r.nextInt(1000);
		return num;
		
	}
}
