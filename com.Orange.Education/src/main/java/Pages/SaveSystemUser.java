package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import interfaces.EnterValue;
import io.qameta.allure.Step;

public class SaveSystemUser extends Page implements EnterValue {

	protected WebDriver driver;

	private String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser";

	SaveSystemUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.get(url);
	}

	public SaveSystemUser CreateNewUser(String roleElement, String selectedRole, String element, String empname,
			String nameElement, String name, String attrName, String statusElement, String stValue, String pasElement,
			String password, String conPasElm, String conpasw) {
		// TODO Auto-generated method stub
		Select(roleElement, selectedRole);
		EnterValue(element, empname, attrName);
		EnterValue(nameElement, name, attrName);
		Select(statusElement, stValue);
		EnterValue(pasElement, password, attrName);
		EnterValue(conPasElm, conpasw, attrName);
		try {
			Assert.assertEquals(password, conpasw);
		} catch (Exception e) {
			e.getMessage();
		}
		return this;
	}

	private SaveSystemUser Select(String element, String selectedRole) {
		// TODO Auto-generated method stub
		Actions builder = new Actions(driver);
		try {
			builder.moveToElement(getElement(element)).click();
			driver.findElement(By.xpath((getXpath(element) + "//option[text()='" + selectedRole + "']"))).click();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

		return this;
	}

	@Override
	@Step("Enter value {0} and check attribute {2} ")
	public SaveSystemUser EnterValue(String string, String value, String attribute) {
		// TODO Auto-generated method stub
		try {
			isAttributePresent(string, attribute);
			getElement(string).clear();
			System.out.println(value);
			getElement(string).sendKeys(value);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}

	public void ClickSave(String element) {
		try {
			// TODO Auto-generated method stub
			getElement(element).click();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		try {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getXpath("addbtn"))));
			Assert.assertEquals(getElement("addbtn").getText(), "Add");
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}
}
