package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;

public class HoverPracticeTest extends BaseClass{
	
	@Test
	public void hoverTest() {
		WebDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
		WebElement checkbox=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		System.out.println(checkbox.getAttribute("title"));
	}

}
