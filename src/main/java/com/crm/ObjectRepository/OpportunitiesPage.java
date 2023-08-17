package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	//declaration
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement oppotunityLookupImg;
	
	//initialization
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOppotunityLookupImg() {
		return oppotunityLookupImg;
	}
	
	// business libraries
	public void clickOnOpportunityImg()
	{
		oppotunityLookupImg.click();
	}
}
