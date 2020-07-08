package Pages;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;


public class MainPage extends Page {
	
	WebDriver driver;
	
	
	protected static String url = "https://opensource-demo.orangehrmlive.com/";

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.driver.get(url);
		//driver.manage().deleteAllCookies();
		
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
			isAttributePresent(string,attribute);
			getElement(string).sendKeys(value);
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}
	
	@Step("Enter password {0} and check attribute {2} ")
	public MainPage EnterPassword(String string, String value, String attribute) {
		try {
			isAttributePresent(string,attribute);
			getElement(string).sendKeys(value);
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		return this;
	}
	
	public MainPage then() {
		return this;
	}
	@Override
	public Dashboard Click(String element) {
		getElement(element).click();
		return new Dashboard(driver);
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


}
