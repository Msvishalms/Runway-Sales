package com.crm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement selectCampaignImg;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectCampaignImg() {
		return selectCampaignImg;
	}
	
	//business libraries
	
	public void clickOnCampaign()
	{
		selectCampaignImg.click();
	}
}
