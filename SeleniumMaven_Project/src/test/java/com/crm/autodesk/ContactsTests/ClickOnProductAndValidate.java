package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class ClickOnProductAndValidate {
	WebDriver driver;
//	String ab = "Shubham123";
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
		
		String ProductName = eLib.getExcelData("sheet1", 2, 2);
		String partName = eLib.getExcelData("sheet1", 2, 3);
		
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
		//wLib.maximizeBrowser();
		driver.get(URL);
		wLib.maximizeBrowser(driver);
		
		// login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
	 // click on products
				
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(ProductName);
				System.out.println("Hi");
				driver.findElement(By.xpath("//input[@id='productcode']")).sendKeys(partName);
				driver.findElement(By.name("button")).click();
				
		//click on again product
				
				driver.findElement(By.linkText("Products")).click();		
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(partName);
				WebElement list = driver.findElement(By.name("search_field"));
				
				// creat obj of select class
				Select s = new Select(list);
				s.selectByVisibleText("Part Number");
				driver.findElement(By.name("submit")).click();
				
			//	WebElement buttonElement = driver.findElement(By.className("small"));
			//	wLib.waitForElementVisibility(driver, buttonElement);
				Thread.sleep(4000);
				
				String partNumString = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[16]/td[4]")).getText().trim();
				
				if(partNumString.equals(partName)) {
					System.out.println("part number validated");
				}
				else {
					System.out.println("Not validate Fail");
				}
	
				// sign out from application
		
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wLib.mouseOver(driver, element);
				driver.findElement(By.linkText("Sign Out")).click();
				
				//close the browser
				wLib.closeBrowser(driver);
				
				
				
	}
}