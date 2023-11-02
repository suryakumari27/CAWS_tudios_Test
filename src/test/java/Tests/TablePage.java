package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.InputText;
import Pageobjects.LandingPage;
import Resources.Base;

public class TablePage extends Base {
	
	WebDriver driver;
	String actualResult;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void HomePage() {

		LandingPage landp = new LandingPage(driver);
		landp.TableData();
		
		landp.ClickButton().click();
		
		InputText It = new InputText(driver);
		It.InsertData();
		It.RefreshButton().click();
		
		It.getTableData();
		
		}
	
	@AfterMethod()
	public void closure() {
		driver.close();
	}
}
