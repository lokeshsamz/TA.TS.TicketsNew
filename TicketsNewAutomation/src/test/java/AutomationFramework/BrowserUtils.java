package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils extends WebBrowser{

	public void NavigateToUrl(String url)
	{
		WebBrowser.driver.get(url);
	}
	
	public void MaximixeScreen()
	{
		WebBrowser.driver.manage().window().maximize();
	}
	
	public void ClickElement(By locator)
	{
		WebBrowser.driver.findElement(locator).click();
	}
	
	public void TypeInElement(By locator, String text) 
	{
		WebBrowser.driver.findElement(locator).sendKeys(text);
	}
	
	public void TypeInElement(By locator, String text, Boolean clearContents) 
	{
		if (clearContents)
		{
			WebBrowser.driver.findElement(locator).clear();
			WebBrowser.driver.findElement(locator).sendKeys(text);
		}
		else
		{
			WebBrowser.driver.findElement(locator).sendKeys(text);
		}
	}
	
	public boolean IsPageLoaded(By locator)
	{
		try
		{
			WebBrowser.driver.findElement(locator);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public void MoverHoverandClickElement(By mouseHoverlocator, By locatorToClick)
	{
		Actions actions = new Actions(WebBrowser.driver);
		WebElement element = WebBrowser.driver.findElement(mouseHoverlocator);
		actions.moveToElement(element).moveToElement(WebBrowser.driver.findElement(locatorToClick)).click().build().perform();
	}
}
