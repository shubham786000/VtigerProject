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

public class TC_44_SearchLeadByClickingOnAssignedto extends BaseClass {
	
	@Test(groups = "RegressionSuites")
	public void LeadByClickingOnwebsiteTest() throws Throwable
	{
		
		
		String OrganizationName = eLib.getExcelData("Lead", 1, 0);
		String assign = eLib.getExcelData("Lead", 1, 4);
		String assignValue = eLib.getExcelData("Lead", 2, 4);
		
		//navigate to leads page
				HomePage hp = new HomePage(driver);
				hp.clickOnLeads();
		
				//search by phone number in lead page 
				LeadPage lPage = new LeadPage(driver);
				lPage.clickOnSearch(assign);
				lPage.dropDownbyValue(assignValue);
				lPage.clickOnSearchButton();
				
				// validation
				String seachedemailString= lPage.getSearchAssignedNo();
				Assert.assertTrue(seachedemailString.contains(assign));
				System.out.println(seachedemailString);
			}
}