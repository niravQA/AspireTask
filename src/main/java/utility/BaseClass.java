package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApp(driver, "Chrome");
		
	}
	

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		BrowserFactory.quitApp(driver);
	}
}
