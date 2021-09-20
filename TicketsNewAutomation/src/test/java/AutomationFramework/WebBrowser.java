package AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {
	
	public static WebDriver driver;
	
	public static void BrowserInstance()
	{
		if(driver == null)
		{
			String currentDir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currentDir + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	public static void CloseBrowser()
	{
		driver.quit();
	}

}
