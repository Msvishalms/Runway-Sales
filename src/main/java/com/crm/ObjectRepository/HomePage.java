package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {

	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement calendarLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppLink;
	
	@FindBy(name="Campaigns")
	private WebElement campgnLink;
	
	@FindBy(linkText="Sales Order")
	private WebElement salesLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreMHover;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getOppLink() {
		return oppLink;
	}

	public WebElement getCampgnLink() {
		return campgnLink;
	}

	public WebElement getSalesLink() {
		return salesLink;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	public WebElement getMoreMHover() {
		return moreMHover;
	}

	//business libraries
	public void clickOnCalendarlink()
	{
		calendarLink.click();
	}
	public void clickOnOpplink()
	{
		oppLink.click();
	}
	public void clickOnCampgnLink()
	{
		campgnLink.click();
	}
	public void clickOnSaleslink()
	{
		salesLink.click();
	}
	public void clickOnAdminImg(WebDriver driver)
	{
		mouseHover(driver, adminImage);
	}
	public void clickOnsignOutBTN()
	{
		signOutBtn.click();
	}
	
	public void clickOnMore(WebDriver driver)
	{
		mouseHover(driver, moreMHover);
	}


}

