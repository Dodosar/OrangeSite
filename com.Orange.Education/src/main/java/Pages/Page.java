package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.w3c.css.sac.CSSException;

import Data.Elements;

public class Page {
	protected static WebDriver driver;

	public Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		Page.setDriver(driver);
	}

	public Page then() {
		return this;
	}

	public Page CheckTheText(String element, String textForElement, String Attribute) {
		isAttributePresent(element, Attribute);
		Assert.assertEquals(getElement(element).getText(), textForElement);
		return this;
	}

	public static WebElement getElement(String element) {
		// TODO Auto-generated method stub
		return getDriver().findElement(By.xpath(getXpath(element)));
	}

	public static String getXpath(String element) {
		// TODO Auto-generated method stub
		return Elements.getEntryForElementName(element).getXpath();
	}

	public boolean isAttributePresent(String element, String attribute) {
		// TODO Auto-generated method stub
		Boolean result = false;
		try {
			String value = getElement(element).getAttribute(attribute);
			if (value != null) {
				System.out.println("Attribute is present : " + attribute.toUpperCase() + "=" + value);
				result = true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	public void CheckTheTitle(String title) {
		try {
			Assert.assertEquals(getDriver().getTitle(), title);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	public Page CheckTheColor(String element, String color) {
		try {
			Assert.assertEquals(getElement(element).getCssValue("color"), color);
		} catch (CSSException e) {
			e.getMessage();
		}
		return this;
	}

	public void CheckActiveElement(String element) {
		// TODO Auto-generated method stub
		try {
			getElement(element).isEnabled();
		} catch (ElementNotInteractableException e) {
			e.getMessage();
		}
	}

	public ViewSystemUser ClickAdmin(String element) {
		try {
			getElement(element).click();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return new ViewSystemUser(getDriver());
	}

	public Dashboard ClickDashBoard(String element) {
		try {
			getElement(element).click();
			// new WebDriverWait(driver, 10)
			// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getXpath("admintab"))));
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		try {
			Assert.assertEquals(getElement("admintab").getText(), "Admin");
			System.out.println("true");
		} catch (NoSuchElementException e) {
			Assert.assertEquals(getElement("invalidcredentials").getText(), "Invalid credentials");
		}
		return new Dashboard(getDriver());
	}

	public Object EnterText(String element, String empname) {
		// TODO Auto-generated method stub
		getElement(element).sendKeys(empname);
		return this;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Page.driver = driver;
	}

}
