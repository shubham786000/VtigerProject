package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class LeadPage  extends WebDriverUtility{
	
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(className = "txtBox")
	private WebElement searchText;
	
	@FindBy(xpath ="//select[@name='search_field']")
	private WebElement searchField;
	
	@FindBy(name = "submit")
	private WebElement sumbitBtn;
	
	@FindBy(xpath = "//*[@id=\"row_40\"]/td[7]/a")
	private WebElement searchWebsiteNo;
	
	@FindBy(xpath = "//*[@id=\"massdelete\"]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[2]")
	private WebElement clickmassElement;
	
	

	

	@FindBy(xpath = "//*[@id=\"row_40\"]/td[6]")
	private WebElement searchPhoneNo;
	
	@FindBy(xpath = "//*[@id=\"row_40\"]/td[8]/a")
	private WebElement searchEmail;
	
	@FindBy(xpath = "/html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/div/table/tbody/tr[6]/td[9]")
	private WebElement searchAssignedTo;
	
	
	

	
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement SignOutDropdown;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	

	

	// generate getter
	
	public WebElement getSignOutDropdown() {
		return SignOutDropdown;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	public WebElement getSearchText() {
		return searchText;
	}
	
	public WebElement getSearchPhoneNo() {
		return searchPhoneNo;
	}
	
	public WebElement getSearchWebsiteNo() {
		return searchWebsiteNo;
	}
	

	public WebElement getSearchEmail() {
		return searchEmail;
	}
	
	public WebElement getSearchAssignedTo() {
		return searchAssignedTo;
	}
	
	public WebElement getClickmassElement() {
		return clickmassElement;
	}

	
	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSumbitBtn() {
		return sumbitBtn;
	}
	
	// provide business logic
	
	public void clickOnSearch(String num) {
		getSearchText().sendKeys( num);
		
	}
	

	public void dropDown(String valueString)
	{
		selectbyvalue(getSearchField(), "Assigned To");
		//selectbyvalue(getSearchField(), valueString);
		//getSearchField().sendKeys("phone");
	}
	public void dropDownbyValue(String Value)
	{
		selectbyvalue(getSearchField(), Value);
	}
	
	public void dropDown1(String valueString)
	{
		selectbyvalue(getSearchField(), "email");
	
	}
	
	public void dropDown2(String valueString)
	{
		selectbyvalue(getSearchField(),"assigned_user_id");
	
	}
	
	
	
	
	public void clickOnSearchButton()
	{
		sumbitBtn.click();
	}
	
	public String getsearchedPhoneNo() {
		return getSearchPhoneNo().getText();
	}
	
	public String getsearchedWebsiteNo() {
		return getSearchWebsiteNo().getText();
	}
	
	public String getSearchEmailNo() {
		return getSearchEmail().getText();
	}
	
	public void getClickOnMassEdit()
	{
		clickmassElement.click();
	}
	
	
	public String getSearchAssignedNo()
	{
		return  getSearchAssignedTo().getText();
	}
	
	
	
	public void signOut(WebDriver driver)
	{
		waitForElementVisibility(driver, SignOutDropdown);
		mouseOver(driver, SignOutDropdown);
		//waitForElementVisibility(driver, signoutBtn);
		getSignoutBtn().click();
		
		
	}
	
}
