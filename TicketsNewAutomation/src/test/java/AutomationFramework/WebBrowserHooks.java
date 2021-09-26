package AutomationFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import AutomationFramework.TestHooks.ReportHooks;

public class WebBrowserHooks extends ReportHooks{

	@Parameters("browser")
	@BeforeClass
	public void BrowserSetup(String browser)
	{
		try 
		{
			WebBrowser.BrowserInstance(browser);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void CloseBrowserSetup()
	{
		WebBrowser.CloseBrowser();
	}
}
