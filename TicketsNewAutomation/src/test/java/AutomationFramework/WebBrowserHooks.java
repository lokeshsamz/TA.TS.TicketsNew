package AutomationFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebBrowserHooks {

	@BeforeClass
	public void BrowserSetup()
	{
		WebBrowser.BrowserInstance();
	}
	
	@AfterClass
	public void CloseBrowserSetup()
	{
		//WebBrowser.CloseBrowser();
	}
}
