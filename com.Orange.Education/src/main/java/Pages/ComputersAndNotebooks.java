package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputersAndNotebooks extends Page{
	
	String url = "https://rozetka.com.ua/computers-notebooks/c80253/";
	
	@FindBy(xpath = "")
	private String element;
	

	public ComputersAndNotebooks(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driver.get(url);
		PageFactory.initElements(driver, this);
	}

	public boolean CheckTheElement() {
		@SuppressWarnings("unused")
		WebElement img = ((new WebDriverWait(driver,20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))));
		return true;
	}
}
