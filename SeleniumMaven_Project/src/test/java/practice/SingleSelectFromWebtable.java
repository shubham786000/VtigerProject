package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class SingleSelectFromWebtable {
	WebDriver driver = null;
	@Test
	public void handlingDynamicWebtable() throws Throwable{
		
		JSONFileUtility jsonlib =  new JSONFileUtility();
		
		// fetch the common data from external resource
		String BROWSER  = jsonlib.readDataFromJSON("browser");
		String URL = jsonlib.readDataFromJSON("url");
		String USERNAME = jsonlib.readDataFromJSON("username");
		String PASSWORD = jsonlib.readDataFromJSON("password");
		
		//choose the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new OperaDriver();
		}
		
		// load the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		// login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// click on organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on first checkbox
		driver.findElement(By.name("selected_id")).click();
}
}