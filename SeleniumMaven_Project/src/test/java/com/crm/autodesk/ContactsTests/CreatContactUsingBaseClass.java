package com.crm.autodesk.ContactsTests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadPage;

public class CreatContactUsingBaseClass extends BaseClass {
	
	

	@Test
	public void creatContactWithOrganization() throws Throwable 
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

		// logout from app
		
	//	lPage.waitUntilPageLoad(driver);
	//	lPage.closeBrowser(driver);
     //   lPage.signOut(driver);
       
       
         
	}
}
