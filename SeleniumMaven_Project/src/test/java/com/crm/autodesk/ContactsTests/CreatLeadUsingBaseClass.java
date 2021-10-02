package com.crm.autodesk.ContactsTests;

import org.testng.Assert;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadPage;

public class CreatLeadUsingBaseClass extends BaseClass{
	
	public void creatContactWithOrganization() throws Throwable 
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

		// logout from app
     //   lPage.signOut(driver);
        
        // close the browser
      //   wLib.closeBrowser(driver);
	}
}
