package Pages;

import org.openqa.selenium.WebDriver;

public class Orangehrmlive {
	
	protected WebDriver driver;
	
	public Orangehrmlive(WebDriver driver) {
		this.driver = driver;
	}	
	
	public MainPage mainPage() {return new MainPage(driver);}
	
	public ComputersAndNotebooks PcPage() {return new ComputersAndNotebooks(driver);};
}
