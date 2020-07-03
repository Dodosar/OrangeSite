

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;

public class TestHttpRequestAndResponse {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Start the BrowserMob proxy
		  BrowserUpProxy server = new BrowserUpProxyServer();
		  server.start();
		  int port = server.getPort();

		server.addResponseInterceptor(new HttpResponseInterceptor()
		{
		    @Override
		    public void process(HttpResponse response, HttpContext context)
		        throws HttpException, IOException
		    {
		        System.out.println(response.getStatusLine());
		    }
		});

		// Get selenium proxy
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);


		// Configure desired capability for using proxy server with WebDriver
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		// Set up driver
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://stackoverflow.com/questions/6509628/webdriver-get-http-response-code");

		// Close the browser
		driver.quit();
	}
*/
}
