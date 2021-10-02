package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class DeleatFromOrganizationMIddle {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;

		// Read data from json file
		JSONFileUtility jfu = new JSONFileUtility();
		String BROWSER = jfu.readDataFromJSON("browser");
		String USERNAME = jfu.readDataFromJSON("username");
		String PASSWORD = jfu.readDataFromJSON("password");
		String EMAIL = jfu.readDataFromJSON("Email");
		String URL = jfu.readDataFromJSON("url");

		// Choose the broswer to run the test
		if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();

		} else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();

		} else {
		System.out.println("invalid browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);

		//Locators
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();


		//Click on all check boxes
		   List<WebElement> List = driver.findElements(By.xpath("//table//input[@name='selected_id']"));
		   
		   for(WebElement wb : List) {
		  wb.click();
		   }
		   // UnCheck the 5th Box (index starts from 0)
		  List.get(4).click();
		   
		   //Click on the last checkBox
		  List.get(List.size()-1).click();
		  List<WebElement> List1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]//a[@title='Organizations']"));
		 
		  for(WebElement wb : List1) {
		String data = wb.getText();
		 System.out.println(data);
		 
		  List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/a[text()='del']"));


		  list2.get(4).click();
		  Alert alt = driver.switchTo().alert();
		  System.out.println(alt.getText());
		  alt.accept();
		  driver.findElement(By.linkText("Go Back.")).click();

		}
		}
		}


