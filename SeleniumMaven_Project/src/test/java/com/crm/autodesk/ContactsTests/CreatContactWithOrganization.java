package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;

// Creat contact with Organization

public class CreatContactWithOrganization {
	WebDriver driver;
	@Test
	public void creatContactWithOrganization() throws Throwable 
	{
		//read all necessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		String URL = jsonLib.readDataFromJSON("url");
		String BROWSER  = jsonLib.readDataFromJSON("browser");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
		String ContactName = eLib.getExcelData("sheet1", 1, 3);
		String orgName = eLib.getExcelData("sheet1", 1, 4);
		
		//Launch the Browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
		System.out.println("Invalid browser");
		}
		wLib.waitUntilPageLoad(driver);
		wLib.maximizeBrowser(driver);
		driver.get(URL);
		
		// login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
		// click on contacts		
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys("Sam");
				driver.findElement(By.cssSelector("img[title='Select']")).click();
				
				wLib.switchToWindow(driver, "Accounts");
				
				
				
				
				
				
				
				

}
}