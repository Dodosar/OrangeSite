import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Test;
import Pages.Orangehrmlive;


import Data.DataValues;
import junit.framework.Assert;

public class TestTask extends WebDriverSettings{
	
	Orangehrmlive Orangehrmlive;

	
	private String Amazone = "Most wished for in Video Games";
	
	private String Amazone1 = "Most wished for in Video Games1";
	

	@Test(priority = 0)
	public void CheckTheText() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().then().isTextPresentInThePage(Amazone1);
		
	}
	
	@Test(priority = 3)
	public void checkteTextNew() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().then().isTextPresentInThePage(Amazone);
	}
	
	@Test(priority = 2)
	public void checkteTextBody() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().then().isTextPresentInThePageBody(Amazone1);
	}
	
	@Test(priority = 1)
	public void checkteTextBody1() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().then().isTextPresentInTheTag(Amazone1);
	}
	
	@Test(priority = 4)
	public void checkteTextNewFromMainPage() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().CheckTheTextInMainPage();
		
	}
	
	
}