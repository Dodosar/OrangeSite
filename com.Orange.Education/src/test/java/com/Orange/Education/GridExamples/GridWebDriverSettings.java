package com.Orange.Education.GridExamples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GridWebDriverSettings {
	
	public RemoteWebDriver driver;	
	
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
			dr.setPlatform(Platform.WINDOWS);
			}
		else {
			dr = DesiredCapabilities.internetExplorer();
			dr.setBrowserName("IE");
			dr.setPlatform(Platform.WINDOWS);
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterTest
	public void TearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
