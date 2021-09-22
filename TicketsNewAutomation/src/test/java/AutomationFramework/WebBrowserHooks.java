package AutomationFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import AutomationFramework.TestHooks.ReportHooks;

public class WebBrowserHooks extends ReportHooks{

	@BeforeClass
	public void BrowserSetup()
	{
		WebBrowser.BrowserInstance();
	}
	
	@AfterClass
	public void CloseBrowserSetup()
	{
		WebBrowser.CloseBrowser();
	}
}
