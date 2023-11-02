package Pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class InputText {

	WebDriver driver;
	String GivenjsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, "
			+ "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, "
			+ "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, "
			+ "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, "
			+ "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

	public InputText(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void InsertData() {

		driver.findElement(By.xpath("//textarea[@id='jsondata']")).clear();

		WebElement inputField = driver.findElement(By.xpath("//textarea[@id='jsondata']"));

		inputField.sendKeys(GivenjsonData);
	}

	@FindBy(xpath = "//button[@id='refreshtable']")
	WebElement RefreshButton;

	public WebElement RefreshButton() {
		return RefreshButton;
	}

	public void getTableData() {

		WebElement table = driver.findElement(By.xpath("//table[@id='dynamictable']"));

		List<Map<String, String>> tableDataList = new ArrayList<>();
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (!cells.isEmpty()) {
				Map<String, String> rowData = new HashMap<>();
				rowData.put("Name", cells.get(0).getText());
				rowData.put("Age", cells.get(1).getText());
				rowData.put("Gender", cells.get(2).getText());

				tableDataList.add(rowData);

			}
		}
		Gson gson = new Gson();
		String jsonData = gson.toJson(tableDataList);
		System.out.println(jsonData);
		

	}


}
