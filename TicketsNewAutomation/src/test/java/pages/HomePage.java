package pages;

import org.openqa.selenium.By;

import AutomationFramework.BrowserUtils;
import AutomationFramework.TestHooks.ReportHooks;
import ObjectRepository.IElementRepo;

public class HomePage extends ReportHooks{
	
	private BrowserUtils browserUtils;
	
	public HomePage()
	{
		browserUtils = new BrowserUtils();
	}
	
	public void LaunchHomePage(String url)
	{
		try
		{
			this.browserUtils.NavigateToUrl(url);
			ReportHooks.NodePassed("I have navigated to the home page", false);		
		}
		catch (Exception e)
		{
			ReportHooks.NodeFailed("Failed to navigate to the home page", e);
		}
	}
		
	public void ClickMovieName(String movieName)
	{
		try
		{
			String locatorToClick = IElementRepo.Txt_HomePage_MovieName.replace("M_MovieName", movieName);
			this.browserUtils.MouseHoverandClickElement(IElementRepo.tab_HomePage_Movies, By.xpath(locatorToClick));
			ReportHooks.NodePassed("I clicked the Movie name '" + movieName + "'");
		}
		catch (Exception e)
		{
			ReportHooks.NodeFailed("Failed to click the Movie name '" + movieName + "'", e);
		}
	}
	

}
