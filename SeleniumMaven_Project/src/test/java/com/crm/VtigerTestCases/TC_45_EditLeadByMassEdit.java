package com.crm.VtigerTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadPage;
//@Listeners(com.crm.autodesk.GenericUtils.Listeners.class)
public class TC_45_EditLeadByMassEdit extends BaseClass {
	
	
	@Test(groups = "RegressionSuites",retryAnalyzer =  com.crm.autodesk.GenericUtils.RetryAnalyser.class)
	public void LeadByClickingOnEditLeadByMassEditTest() throws Throwable
	{
		
		String OrganizationName = eLib.getExcelData("Lead", 0, 1);
		String phoneNo = eLib.getExcelData("Leaaad", 1, 1);
		//String website = eLib.getExcelData("Lead", 3, 2);
		
		
				//navigate to leads page
				HomePage hp = new HomePage(driver);
				hp.clickOnLeads();
				
				//click on mass edit in lead page
				LeadPage lPage = new LeadPage(driver);
				lPage.getClickOnMassEdit();
				
				lPage.cancelAlert(driver);
				
	}
}