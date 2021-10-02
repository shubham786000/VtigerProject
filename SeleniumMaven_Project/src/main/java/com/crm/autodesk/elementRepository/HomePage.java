package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLnk;

	// generate getter
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadLnk() {
		return leadLnk;
	}
	
	// provide business logic
	
	public void clickOnOrganizations()
	{
		organizationLnk.click();
	}
	
	public void clickOnContacts()
	{
		contactsLnk.click();
	}
	
	public void singOut(WebDriver driver)
	{  
		waitForElementVisibility(driver, administatorImg);
		
		mouseOver(driver, administatorImg);
		signoutLnk.click();
	}
	
	public void clickOnLeads()
	{
		leadLnk.click();
	}
	
	public void clickOnProduct()
	{
		productLnk.click();
	}
	
	public void clickOnEmailLink()
	{
		emailLnk.click();
	}
	
	public void clickOnOpportunities()
	{
		opportunitiesLnk.click();
	}
	
}
