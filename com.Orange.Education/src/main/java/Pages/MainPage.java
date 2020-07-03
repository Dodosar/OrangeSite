package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{	
	
	protected String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	protected String url1= "https://www.amazon.com/";
	
	protected String Amazone = "Most wished for in Video Games";
	
	public MainPage(WebDriver driver) {
		super(driver);
		driver.get(url);		
	}
	
	public boolean CheckTheTextInMainPage() {
		return isTextPresentInThePage(Amazone);
	}
	
}
