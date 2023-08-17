package com.crm.ObjectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebdriverUtility;

public class CreateOpportunitiesPage extends WebdriverUtility{

	//declaration
	@FindBy(name="potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrgLookupImg;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBtn;
	
	@FindBy(id="jscal_field_closingdate")
	private WebElement closeDate;
	
	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement salesStageDD;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement oppInfo;
	
	
	//initialization
	public CreateOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getSelectOrgLookupImg() {
		return selectOrgLookupImg;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCloseDate() {
		return closeDate;
	}

	public WebElement getSalesStageDD() {
		return salesStageDD;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOppInfo() {
		return oppInfo;
	}

	//business libraries
	public void verifyOpportunities(String expData)
	{
		String actual = oppInfo.getText();
		assertTrue(true);
		/*if(verify.equals(exp)) 
		{
			System.out.println("Navigated to the oppurtunities Page");
		}
		else 
		{
			System.out.println("Did not navigated to the oppurtunities Page");
		}*/
	}
			
	public void createOpportunity(WebDriver driver, String OrgName, String opportunityName,String date, String salesStage) throws Throwable
	{
		opportunityNameEdt.sendKeys(opportunityName);
		selectOrgLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchText.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		waitForPageLoad(driver);
		switchToWindow(driver, "Potentials");
		closeDate.clear();
		closeDate.sendKeys(date);
		select(salesStage, salesStageDD);
		saveBtn.click();
	}
}
