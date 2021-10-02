package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class CreatOrganizationPage extends WebDriverUtility{

	WebDriver driver;
	
	 // constructor
	public CreatOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Locate all the webElements
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]'")
	private WebElement saveBtn;

	// provide getters
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	// bussines logic
	/*
	 * this methos will creat organization with mandatory fields
	 * @param OrgName
	 */
	
	public void creatOrganization(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/*
	 * this method will creat Organization by choosing an industry type
	 * @param OrgName 
	 * @param indType
	 */
	
	public void creatOrganizationWithIndustry(String OrgName, String indType)
	{
		orgNameEdt.sendKeys(OrgName);
		selectbyvalue(industrydropdown, indType);
		saveBtn.click();
	}
	
	
	
}
