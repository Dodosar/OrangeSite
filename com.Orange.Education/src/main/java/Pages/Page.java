package Pages;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public Page then() {
		return this;
	}

	public boolean isTextPresentInThePage(String text) {
		WebElement eText = driver.findElement(By.xpath("//*[.='" + text + "']"));
		try {
		if (eText != null) {
			System.out.println("Element is present");
			return true;			
		}
		}
		catch (NoSuchElementException e){
			e.getMessage();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return false;		
		
	}

	public boolean isTextPresentInThePageBody(String text) {
		try {
			boolean result = driver.getPageSource().contains(text);
			return result;
		}
		catch(Exception e) {
			return false;
		}		
	}
	
	public void isTextPresentInTheTag(String text) {
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains(text));		
	}
	
	public String isTextPresentInThePageToString(String text) {
		Boolean result = false;
		WebElement eText = driver.findElement(By.xpath("//*[.='" + text + "']"));
		try {
		if (eText != null) {
			System.out.println("Element is present");
			result = true;	
			return result.toString();
		}
		}
		catch (NoSuchElementException e){
			e.getMessage();
		}
		catch (Exception e) {
			e.getMessage();
		}
		result = false;	
		return result.toString();
		
	}
	
	public static List<Object[][]> parameters(){
		Object [][][] pData = new Object [2][2][2];
		pData[0][0][0]="Tom";
		pData[0][0][1]=30;
		pData[0][1][0]="Harry";
		pData[0][1][1]=40;
		return Arrays.asList(pData);
		
	}

}
