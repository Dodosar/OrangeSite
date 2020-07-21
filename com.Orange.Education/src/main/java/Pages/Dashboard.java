package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Dashboard extends Page {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@SuppressWarnings("finally")
	public MainPage logout(String element) {
		try {
			getElement("userpanel").isDisplayed();
			Actions action = new Actions(driver);
			action.moveToElement(getElement("userpanel")).click().build().perform();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		try {
			getElement(element).click();
		} catch (ElementNotVisibleException e) {
			e.getMessage();
		} finally {
			return new MainPage(driver);
		}
	}

	@SuppressWarnings("finally")
	public MainPage logoutJSExecutor(String element) {
		try {
			getElement("userpanel").isDisplayed();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("alert('Welcome to Guru99');");
			js.executeScript("arguments[0].click()", getElement(element));
		} catch (NoSuchElementException e) {
			e.getMessage();
		} finally {
			return new MainPage(driver);
		}
	}

}
