package Properties;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;	
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import Pages.Page;

public class TestUtils extends Page{
	
	private static String screenshotName;

	public TestUtils(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static void captureScreenshot(ITestResult result) {
		
	try {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" +result.getName()  + screenshotName));
	}
	catch(IOException e) {
		e.getMessage();
	}
	}

}
