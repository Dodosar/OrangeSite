package Pages;

import org.openqa.selenium.WebDriver;

public class Orangehrmlive {

	protected WebDriver driver;

	public Orangehrmlive(WebDriver driver) {
		this.driver = driver;
	}

	public MainPage mainPage() {
		return new MainPage(driver);
	}

	public Dashboard dashboard() {
		return new Dashboard(driver);
	}

	public SaveSystemUser saveUser() {
		return new SaveSystemUser(driver);
	}

	public ViewSystemUser viewUsers() {
		return new ViewSystemUser(driver);
	}
}
