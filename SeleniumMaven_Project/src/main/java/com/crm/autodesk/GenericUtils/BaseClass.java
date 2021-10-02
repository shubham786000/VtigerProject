package com.crm.autodesk.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.google.common.io.Files;

public class BaseClass {
	
	public DataBaseUtility dbLib = new DataBaseUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public  static WebDriver staticDriver;

	@BeforeSuite(groups = {"SmokeSuites","RegressionSuites"})
	public void connectDB()
	{
		System.out.println("======MakeDBConnection======");
	}
	//@Parameters("browser")
	@BeforeClass(groups = {"SmokeSuites","RegressionSuites"})
	public void launchBrowser() throws Throwable
	{
		System.out.println("=======launchBrowser=======");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		
		//Launch the Browser
		
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else {
				System.out.println("Invalid browser");
				}
		
				wLib.maximizeBrowser(driver);
				wLib.waitUntilPageLoad(driver);
				driver.get(URL);
				 staticDriver = driver;
				
	}
	
		@BeforeMethod(groups = {"SmokeSuites","RegressionSuites"})
		public void logintoApp() throws Throwable
		{
			System.out.println("======loginToApp======");
			String USERNAME = jsonLib.readDataFromJSON("username");
			String PASSWORD = jsonLib.readDataFromJSON("password");
		
			LoginPage lP = new LoginPage(driver);
			lP.login(USERNAME, PASSWORD);
			
	}
		  
		@AfterMethod(groups = {"SmokeSuites","RegressionSuites"})
		public void logoutFromApp() {
			System.out.println("====logoutfromApp=====");
			HomePage hp = new HomePage(driver);
			hp.singOut(driver);
			
		}
	
		@AfterClass(groups = {"SmokeSuites","RegressionSuites"})
		public void closeBrowser() {
			System.out.println("=====closeBrowser======");
			driver.close();
		}
	
		@AfterSuite(groups = {"SmokeSuites","RegressionSuites"})
		public void closeDB()
		{
			System.out.println("====closeDB====");
		}
		
		 public String getScreenshot(String name) throws IOException{
			 	File srcFile = ((TakesScreenshot) staticDriver).getScreenshotAs(OutputType.FILE);
			 	String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		    	File finaldest=new File(destfile);
		    	FileUtils.copyFile(srcFile, finaldest);
		    	return destfile;
		    	
		    }
}
