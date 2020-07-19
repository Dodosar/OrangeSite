package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoadCookieInfo {
	
	//see book Selenium WebDriver Practical Guide
	//D:\books\WebDriver Page 75
	
	//In this site did not work Load Cookie ((
	//If start POM Testng.xml and ParameterXml.xml Login from ParametersXML by cookie did not work. Need Username and Password

	@SuppressWarnings("deprecation")
	public static void LoadCookie(WebDriver driver) {
		try {
			File f = new File("browser.data");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {				
				StringTokenizer str = new StringTokenizer(line, ";");
				while (str.hasMoreTokens()) {
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					if (!(dt = str.nextToken()).equals("null")) {
						expiry = new Date(dt);
					}
					boolean isSecure = new Boolean(str.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.manage().addCookie(ck);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
