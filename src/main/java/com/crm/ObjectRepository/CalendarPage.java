package com.crm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.GenericUtility.WebdriverUtility;

public class CalendarPage  extends WebdriverUtility{

	@FindBy(xpath="//a[text()='Month']")
	private WebElement monthLink;

	@FindBy(xpath="//a[text()='To Dos']")
	private WebElement todosLink;

	@FindBy(xpath="//td[@class='calAddButton']")
	private WebElement calAddBtn;

	@FindBy(xpath="//a[text()='To Do']")
	private WebElement todoLink;

	@FindBy(name="task_subject")
	private WebElement todoEdt;

	@FindBy(name="task_description")
	private WebElement descriptionEdt;

	@FindBy(name="taskstatus")
	private WebElement statusDrpdown;

	@FindBy(xpath="//b[.='Status']//ancestor::td[@align='left']//../following-sibling::tr[1]/descendant::select[@name='taskpriority']")
	private WebElement priorityDropdown;

	@FindBy(xpath="//b[.='Assigned To']/../../../../descendant::tr[2]/td[3]//input[2]")
	private WebElement groupRadioBtn;

	@FindBy(id="task_date_start")
	private WebElement startDate;

	@FindBy(id="task_due_date")
	private WebElement endDate;

	@FindBy(name="todosave")
	private WebElement saveBtn;

	//initialization
	public CalendarPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getMonthLink() {
		return monthLink;
	}

	public WebElement getTodosLink() {
		return todosLink;
	}

	public WebElement getCalAddBtn() {
		return calAddBtn;
	}

	public WebElement getTodoLink() {
		return todoLink;
	}

	public WebElement getTodoEdt() {
		return todoEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getStatusDrpdown() {
		return statusDrpdown;
	}

	public WebElement getPriorityDropdown() {
		return priorityDropdown;
	}

	public WebElement getASTdropdown() {
		return groupRadioBtn;
	}

	public WebElement getCalendarLookImg() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}	

	//business libraries 
	public void clickonLinks(WebDriver driver)
	{
		monthLink.click();
		todosLink.click();
		mouseHover(driver, calAddBtn);
		todoLink.click();
	}

	public void enterDetails(String todoName, String description, String status, String priority, String date, WebDriver driver) 
	{
		todoEdt.sendKeys(todoName);
		descriptionEdt.sendKeys(description);
		select(status, statusDrpdown);
		select(priority, priorityDropdown);
		groupRadioBtn.click();
		startDate.clear();
		startDate.sendKeys(date);
		saveBtn.click();
	}
	
}
