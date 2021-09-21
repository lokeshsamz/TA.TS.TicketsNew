package test;

import org.testng.annotations.Test;

import AutomationFramework.BrowserUtils;
import AutomationFramework.WebBrowserHooks;
import pages.HomePage;

public class HomePageTest extends WebBrowserHooks{
	private HomePage homePage;
	private BrowserUtils browserUtils;
	
	private HomePageTest() 
	{
		homePage = new HomePage();
		browserUtils = new BrowserUtils();
	}

	@Test
	public void SelectMovie() throws InterruptedException
	{
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		this.browserUtils.MaximixeScreen();
		Thread.sleep(2000);
		this.homePage.ClickMovieName("Friendship");
		Thread.sleep(3000);
	}
}
