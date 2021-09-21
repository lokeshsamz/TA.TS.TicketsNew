package pages;

import org.openqa.selenium.By;

import AutomationFramework.BrowserUtils;
import ObjectRepository.IElementRepo;

public class HomePage {
	
	private BrowserUtils browserUtils;
	
	public HomePage()
	{
		browserUtils = new BrowserUtils();
	}
	
	public void LaunchHomePage(String url)
	{
		this.browserUtils.NavigateToUrl(url);
	}
		
	public void ClickMovieName(String movieName)
	{
		String locatorToClick = IElementRepo.Txt_HomePage_MovieName.replace("M_MovieName", movieName);
		this.browserUtils.MouseHoverandClickElement(IElementRepo.tab_HomePage_Movies, By.xpath(locatorToClick));
	}

}
