package Pages;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Properties.TestData;
import interfaces.EnterValue;
import io.qameta.allure.Step;

public class MainPage extends Page implements EnterValue {

	static WebDriver driver;
	
	

	protected static String url = "https://opensource-demo.orangehrmlive.com/";

	public MainPage(WebDriver driver) {
		super(driver);
		MainPage.driver = driver;
		MainPage.driver.get(url);
		// driver.manage().deleteAllCookies();
		

	}

	public boolean CheckTheTextInMainPage(String element, String textForElement, String attribute) {
		try {
			CheckTheText(element, textForElement, attribute);
			return true;
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return false;
	}

	@Step("Enter username {0} and check attribute {2} ")
	public MainPage EnterUserName(String string, String value, String attribute) {
		// TODO Auto-generated method stub
		try {
			isAttributePresent(string, attribute);
			getElement(string).sendKeys(value);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}

	@Step("Enter password {0} and check attribute {2} ")
	public MainPage EnterPassword(String string, String value, String attribute) {
		try {
			isAttributePresent(string, attribute);
			getElement(string).sendKeys(value);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}

	public MainPage then() {
		return this;
	}

	public static boolean isUrlValid(String url) {
		try {
			URL obj = new URL(url);
			obj.toURI();
			return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (URISyntaxException e) {
			return false;
		}
	}

	public void logIn() {
		EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
				.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().ClickDashBoard("loginbtn");
	}

	@Override
	@Step("Enter value {0} and check attribute {2} ")
	public MainPage EnterValue(String string, String value, String attribute) {
		// TODO Auto-generated method stub
		try {
			isAttributePresent(string, attribute);
			getElement(string).sendKeys(value);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}

	public MainPage ClearCookie() {
		driver.manage().deleteAllCookies();
		return this;
	}

	public static WebElement getRelevantElemnet(WebDriver rw, String type, String searchTxt) {

		/// enter the value
		List<WebElement> sb = driver.findElements(By.xpath(getXpath(type)));
		if (!sb.isEmpty()) {
			for (int i = 0; i < sb.size(); i++) {
				WebElement el = sb.get(i);
				if (el.isDisplayed()) {

					Object val = ((JavascriptExecutor) rw).executeScript(
							"var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) "
									+ "{items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value };"
									+ " return items;",
							el);
					System.out.println(val.toString().toLowerCase());
					if (val.toString().toLowerCase().contains(searchTxt.toLowerCase())) {
						System.out.println(el.getText());

						return el;
					}
				}
			}
		}

		return null;
	}

	public static void isDisplayed(String string) {
		// TODO Auto-generated method stub
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getXpath(string))));
		getElement(string).isDisplayed();
	}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
	}


}
