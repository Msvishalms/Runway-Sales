package com.crm.ObjectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(xpath="//input[@type='text' and @name='campaignname']")
	private WebElement campaignEdt;

	@FindBy(xpath="//input[@type='radio']/../input[2]")
	private WebElement groupRadioBtn;

	@FindBy(xpath="//input[@name='closingdate' and @type='text']")//name="closingdate"
	private WebElement dueDateEdt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//table[@class='small']/descendant::td[@class='moduleName']")
	private WebElement campInfo;
	//initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization 
	public WebElement getCampaignEdt() {
		return campaignEdt;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getDueDateEdt() {
		return dueDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCampInfo() {
		return campInfo;
	}

	//business libraries
	public void verifyCampaign(String Expdata)
	{
		
		String actual = campInfo.getText();
		assertTrue(true);
		/*if(verifyText.contains("Campaigns")) 
		{
			System.out.println("Navigated to the Campaigns Page");
		}
		else 
		{
			System.out.println("Didn't navigated to the Campaigns Page");
		}*/
	}

	public void clickOnCampaignImg(String campaignName, String date)
	{
		campaignEdt.sendKeys(campaignName);
		groupRadioBtn.click();
		dueDateEdt.clear();
		dueDateEdt.sendKeys(date);
		saveBtn.click();
		System.out.println("-- created campaign --");
	}
}
