package Pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page{	
	
	protected String url = "https://opensource-demo.orangehrmlive.com/";
	

	public MainPage(WebDriver driver) {
		super(driver);
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public boolean CheckTheTextInMainPage(String element, String textForElement, String attribute) {
		try {
		CheckTheText(element,textForElement,attribute);
		return true;
		}
		catch( NoSuchElementException e) {
			e.getMessage();
		}
		return false;
	}

}
