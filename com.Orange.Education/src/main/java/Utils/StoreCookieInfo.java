package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class StoreCookieInfo {

	public static void StoreCookie(WebDriver driver) {

		File f = new File("browser.data");
		try {
			f.delete();
			f.createNewFile();
			FileWriter fos = new FileWriter(f);
			BufferedWriter bos = new BufferedWriter(fos);
			for (Cookie ck : driver.manage().getCookies()) {
				bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				bos.newLine();
			}
			bos.flush();
			bos.close();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
