package Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ViewSystemUser extends Page {
	private WebDriver driver;

	private String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";

	public ViewSystemUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.get(url);

	}

	public SaveSystemUser ClickAdd(String element) {
		// TODO Auto-generated method stub
		try {
			getElement(element).click();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return new SaveSystemUser(driver);
	}

	public void ExistInTable(String element, String search) {
		try {
			WebElement htmltable = getElement(element);
			List<WebElement> names = htmltable.findElements(By.xpath("//td[2]//a"));
			for (WebElement nm : names) {
				System.out.println("Name: " + nm.getText());
				if (nm.getText().equals(search)) {
					Assert.assertEquals(nm.getText(), search);
				}
			}
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

}
