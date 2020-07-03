package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Data.DataValues;

public class MainPage extends Page{	
	
	@FindBy(xpath="//*[@id='logInPanelHeading']")
	WebElement login;
	
	protected String url = "https://opensource-demo.orangehrmlive.com/";
	

	public MainPage(WebDriver driver) {
		super(driver);
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public boolean CheckTheTextInMainPage() {
		return CheckTheText(login, DataValues.LoginText);
	}
	
	public void CheckTheTitle() {
		try {
			Assert.assertEquals(driver.getTitle(), DataValues.TitleMainPage.get());
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
	}


	
}
