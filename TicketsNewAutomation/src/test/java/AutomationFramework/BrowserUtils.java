package AutomationFramework;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import AutomationFramework.Enums.Enums.SelectBy;

public class BrowserUtils extends WebBrowser{

	/**
	 * Navigates to the given URL.
	 * @param url The URL to be loaded.
	 */
	public void NavigateToUrl(String url)
	{
		WebBrowser.driver.get(url);
	}
	
	
	/**
	 * Maximizes the screen.
	 */
	public void MaximizeScreen()
	{
		WebBrowser.driver.manage().window().maximize();
	}
	
	/**
	 * Clicks the element that is found.
	 * @param locator The XPath of the element to be given to find that element.
	 */
	public void ClickElement(By locator)
	{
		WebBrowser.driver.findElement(locator).click();
	}
	
	/**
	 * Types the text in the element that is found.
	 * @param locator The XPath of the element to be given to find that element.
	 * @param text The string to entered in that element.
	 */
	public void TypeInElement(By locator, String text) 
	{
		WebBrowser.driver.findElement(locator).sendKeys(text);
	}
	
	/**
	 * Types the text in the element that is found and Clears the exiting text present in it.
	 * @param locator The XPath of the element to be given to find that element.
	 * @param text The string to entered in that element.
	 * @param clearContents if true clear the contents in that element, otherwise enters text directly.
	 */
	public void TypeInElement(By locator, String text, boolean clearContents) 
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
	
	/**
	 * Types the text in the element that is found and Clears the exiting text present in it.
	 * @param locator The XPath of the element to be given to find that element.
	 * @return elementFound It returns true if the given element is found, otherwise false.  
	 */
	public boolean IsPageLoaded(By locator)
	{
		boolean elementFound;
		try
		{
			WebElement element = WebBrowser.driver.findElement(locator);
			elementFound = element.equals(null) ? false : true;
		}
		catch(Exception e)
		{
			elementFound = false;
		}
		
		return elementFound;
	}
	
	public void MouseHoverandClickElement(By mouseHoverlocator, By locatorToClick)
	{
		Actions actions = new Actions(WebBrowser.driver);
		WebElement element = WebBrowser.driver.findElement(mouseHoverlocator);
		actions.moveToElement(element).moveToElement(WebBrowser.driver.findElement(locatorToClick)).click().build().perform();
	}
	
	public List<String> GetTextFromElements(By locator)
	{
		List<String> ListOfTexts = WebBrowser.driver.findElements(locator).stream().map(x -> x.getText())
																		 .collect(Collectors.toList());
		return ListOfTexts;
	}
	
	public List<String> GetTextFromElements(By locator, String attribute)
	{
		List<String> ListOfTexts = WebBrowser.driver.findElements(locator).stream().map(x -> x.getAttribute(attribute))
																		 .collect(Collectors.toList());
		return ListOfTexts;
	}
	
	public String GetTextFromElement(By locator)
	{
		return WebBrowser.driver.findElement(locator).getText();
	}
	
	public void MoveToElement(By locator)
	{
		Actions actions = new Actions(WebBrowser.driver);
		WebElement element = WebBrowser.driver.findElement(locator);
		actions.moveToElement(element).sendKeys(Keys.DOWN).build().perform();
	}
	
	public void SelectFromDropdown(SelectBy option, By locator, String textOrIndex) throws Exception 
	{
		Select select = new Select(WebBrowser.driver.findElement(locator));
		switch (option) 
		{
		case VISIBLETEXT: select.selectByVisibleText(textOrIndex.trim());
		break;
		case INDEX: select.selectByIndex(Integer.parseInt(textOrIndex.trim()));
		break;
		case VALUE: select.selectByValue(textOrIndex.trim());
		break;
		default:
			throw new Exception("Invalid Input given");
		}
	}
	
	public void SelectFromDropdown(SelectBy option, By locator, String textOrIndex, boolean moveToElement) throws Exception 
	{
		if (moveToElement)  
		{
			this.MoveToElement(locator);
		}
		
		this.SelectFromDropdown(option, locator, textOrIndex);
	}
	
}
