package com.Orange.Education.GridExamples;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GridWebDriverSettings {
	
	public WebDriver driver;	
	
	@BeforeTest
	@Parameters("myBrowser")	
	public void setUpRemote(String myBrowser) throws MalformedURLException {
		DesiredCapabilities dr = null;
		if (myBrowser.equals("firefox")) {
			dr = DesiredCapabilities.firefox();
			dr.setBrowserName("firefox");
			dr.setPlatform(Platform.WINDOWS);
			//dr.setCapability(capabilityName, value);

		} else if(myBrowser.equals("chrome")){
			dr =DesiredCapabilities.chrome();
			dr.setBrowserName("chrome");
			dr.setCapability("video", true);
			dr.setPlatform(Platform.WINDOWS);
			}
		else {
			/*System.setProperty("webdriver.ie.driver",
					"D:\\SERVER\\IEDriverServer.exe");*/
			dr =new DesiredCapabilities().internetExplorer();
			dr.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dr.setBrowserName("IE");
			dr.setPlatform(Platform.WINDOWS);
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot)driver).
		getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println(scrFile.getAbsolutePath());
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + myBrowser + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@AfterTest
	public void TearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
