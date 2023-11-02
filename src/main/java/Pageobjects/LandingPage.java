
package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath = "//summary[contains(text(),'Table Data')]")
	WebElement TableData;
	
	public WebElement TableData() {
		String ActualText = TableData.getText();
		//System.out.println(ActualText);		
		Assert.assertEquals(ActualText, "Table Data");
		return TableData;
		
	}
	
	@FindBy(xpath = "//summary[contains(text(),'Table Data')]")
	WebElement ClickButton;
	
	public WebElement ClickButton() {
		return ClickButton;
		
	}
	
	

}

