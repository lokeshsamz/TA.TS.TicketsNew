package AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebBrowser {
	
	public static WebDriver driver;
	
	public static void BrowserInstance(String browser) throws Exception
	{
		if(driver == null)
		{
			String currentDir = System.getProperty("user.dir");
			
			switch (browser.toUpperCase())
			{
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", currentDir + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver", currentDir + "/Drivers/IEDriver/IEdriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", currentDir + "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			default:
				throw new Exception ("Invalid browser name given");
			}
		}
	}
	
	public static void CloseBrowser()
	{
		driver.quit();
	}

}
