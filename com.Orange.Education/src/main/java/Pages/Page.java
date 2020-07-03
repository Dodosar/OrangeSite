package Pages;



import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Data.DataValues;

public class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public Page then() {
		return this;
	}
	
	public boolean CheckTheText(WebElement element, DataValues text) {
		try {
			return element.getText().contains(text.get());
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		return false;
	}
	
	public void CheckTheActiveButton() {
		// TODO Auto-generated method stub
		
	}

}
