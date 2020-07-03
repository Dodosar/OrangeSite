package Pages;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Data.Elements;

public class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public Page then() {
		return this;
	}
	
	public Page CheckTheText(String element, String textForElement, String Attribute) {
		isAttributePresent(element, Attribute);		
		Assert.assertEquals(getElement(element).getText(), textForElement);
		return this;
	}
	
	private WebElement getElement(String element) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(getXpath(element)));
	}


	private String getXpath(String element) {
		// TODO Auto-generated method stub
		return Elements.getEntryForElementName(element).getXpath();
	}


	private boolean isAttributePresent(String element, String attribute) {
		// TODO Auto-generated method stub
		Boolean result = false;
		try {
			String value = getElement(element).getAttribute(attribute);
			if(value!=null) {
				System.out.println("Attribute is present : " + attribute.toUpperCase());
				result =true;
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return result;
	}

	public void CheckTheTitle(String title) {
		try {
			Assert.assertEquals(driver.getTitle(), title);
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
	}

}
