package calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebdriverUtility;
import com.crm.ObjectRepository.CalendarPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMonthlyBasedToDoWithAllFieldsTest extends BaseClass{

	@Test(groups="system")
	public void createMonthlyBasedToDoWithAllFieldsTest() throws Throwable 
	{
		/*//DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib= new JavaUtility();
		WebdriverUtility wLib= new WebdriverUtility();*/

		int random = jLib.getRandomNum();
 
		/*String Url = fLib.getPropertyFile("url");
		String Browser = fLib.getPropertyFile("browser");
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");*/

		String todoName = eLib.readDataFromExcel("Calendar", 0, 1)+random;
		String description = eLib.readDataFromExcel("Calendar", 1, 1);
		String status = eLib.readDataFromExcel("Calendar", 2, 1);
		String priority = eLib.readDataFromExcel("Calendar", 3, 1);
		String date = eLib.readDataFromExcel("Calendar", 4, 1);
		//String date1= eLib.readDataFromExcel("Calendar", 5, 1);
		
		/*WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		wLib.maximize(driver);

		driver.get(Url);

		wLib.waitForPageLoad(driver);
		
		//login to application 
		LoginPage lp= new LoginPage(driver);
		lp.login(Username, Password);*/

		//click on calendar link
		HomePage hp=new HomePage(driver);
		hp.clickOnCalendarlink();

		//click actions on links
		CalendarPage cp= new CalendarPage(driver);
		cp.clickonLinks(driver);

		//create to do from calendar 
		cp.enterDetails(todoName, description, status, priority, date, driver);

		//Sign-Out
		//hp.clickOnAdminImg(driver);
		//hp.clickOnsignOutBTN();
		
		//driver.quit();
	}
}
