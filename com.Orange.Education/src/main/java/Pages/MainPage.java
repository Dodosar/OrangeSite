package Pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class MainPage extends Page {
	
	WebDriver driver;

	protected String url = "https://opensource-demo.orangehrmlive.com/";

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


}
