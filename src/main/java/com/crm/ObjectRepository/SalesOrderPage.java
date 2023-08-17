package com.crm.ObjectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebdriverUtility;

public class SalesOrderPage extends WebdriverUtility {

	//declaration
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement inDropdown;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[text()='edit']")
	private WebElement editLink;
	
	@FindBy(name="subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//a[text()='Sales Order'])[3]")
	private WebElement salesOrderInfo;
	
	//initialization
	public SalesOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getInMdropdown() {
		return inDropdown;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getEditLink() {
		return editLink;
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSalesOrderInfo() {
		return salesOrderInfo;
	}

	//business libraries
	public void searchSalesOrder(String existValue, String subjectName)
	{
		searchEdt.sendKeys(existValue);
		select(subjectName, inDropdown);
		searchNowBtn.click();
	}
	
	public void editSalesOrder(String updateValue)
	{
		editLink.click();
		subjectEdt.clear();
		subjectEdt.sendKeys(updateValue);
		saveBtn.click();
	}
		
	public void verifyUpdatedSalesOrder(String expData)
	{
		String actual = salesOrderInfo.getText();
		assertEquals(actual, expData);;
		/*if(text.contains("Sales Order"))
		{
			System.out.println("updated sales order is visible");
		}
		else
		{
			System.out.println("sales order is not updated");
		}*/
	}	
}
