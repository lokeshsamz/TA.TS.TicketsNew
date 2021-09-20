package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserUtils extends WebBrowser{

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
}
