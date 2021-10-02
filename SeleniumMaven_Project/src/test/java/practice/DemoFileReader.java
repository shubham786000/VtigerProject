package practice;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class DemoFileReader {
	
	public static void main(String[] args) throws Throwable {
		
		JSONFileUtility jsonLib = new JSONFileUtility();
		String val = jsonLib.readDataFromJSON("url");
		String val1 = jsonLib.readDataFromJSON("username");
		String val2 = jsonLib.readDataFromJSON("password");
		String val3 = jsonLib.readDataFromJSON("browser");
		System.out.println(val);
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		
	}

}
