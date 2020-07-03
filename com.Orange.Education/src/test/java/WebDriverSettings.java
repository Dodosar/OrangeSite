

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverSettings {	
		
		public WebDriver driver;
		
		@BeforeClass
		public static void setupClass() {
			ChromeDriverManager.getInstance().setup();
		}

		@BeforeTest
		public void setUp() throws Exception {
			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// WebDriverWait wait = new WebDriverWait(driver, 30,500);	
			driver.manage().window().maximize();
				}
		
		@AfterTest
		public void Teardown() {
			if (driver != null) {
				driver.quit();
			}
		}
}
