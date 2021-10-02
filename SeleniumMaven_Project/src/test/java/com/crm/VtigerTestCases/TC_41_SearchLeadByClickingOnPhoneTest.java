package com.crm.VtigerTestCases;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadPage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_41_SearchLeadByClickingOnPhoneTest extends BaseClass {
	
	@Test(groups = "SmokeSuites")
	public void LeadByClickingOnPhoneTest() throws Throwable
	{
		String OrganizationName = eLib.getExcelData("Lead", 1, 0);
		String email = eLib.getExcelData("Lead", 1, 2);
		String emailValue = eLib.getExcelData("Lead", 2, 2);
		
		//navigate to leads page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeads();
 
		//search by phone number in lead page 
		LeadPage lPage = new LeadPage(driver);
		lPage.clickOnSearch(email);
		lPage.dropDownbyValue(emailValue);
		lPage.clickOnSearchButton();
		
		// validation
		String seachedemailString= lPage.getSearchEmailNo();
		Assert.assertTrue(seachedemailString.contains(email));
		System.out.println(seachedemailString);

       
		
	}
	
	
}
