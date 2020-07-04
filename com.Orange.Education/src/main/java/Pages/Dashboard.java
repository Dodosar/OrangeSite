package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class Dashboard extends Page {
	
	WebDriver driver;	

	Dashboard(WebDriver driver){
		super(driver);
		this.driver=driver;
	}

	public MainPage logout(String element) {
		try {
		getElement("userpanel").isDisplayed();
		Actions action = new Actions(driver);
		action.moveToElement(getElement("userpanel")).click().build().perform();
		getElement(element).click();
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		finally{
			return new MainPage(driver);
		}
	}
}
