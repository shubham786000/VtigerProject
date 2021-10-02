package com.crm.VtigerTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;

public class TC_42_SearchLeadByClickingOnWebsite extends BaseClass {
	
	@Test(groups = "SmokeSuites")
	public void LeadByClickingOnwebsiteTest() throws Throwable
	{
		String OrganizationName = eLib.getExcelData("Lead", 1, 0);
		String website = eLib.getExcelData("Lead", 1, 3);
		String websiteValue = eLib.getExcelData("Lead", 2, 3);
		
		
		//navigate to leads page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeads();

		//search by phone number in lead page 
		LeadPage lPage = new LeadPage(driver);
		lPage.clickOnSearch(website);
		lPage.dropDownbyValue(websiteValue);
		lPage.clickOnSearchButton();
		
		// validation
		String seachedwebsiteString= lPage.getsearchedWebsiteNo();
		Assert.assertTrue(seachedwebsiteString.contains(website));
		System.out.println(seachedwebsiteString);
		}
}
