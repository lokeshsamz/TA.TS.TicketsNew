package pages;

import java.util.List;

import org.openqa.selenium.By;

import AutomationFramework.BrowserUtils;
import AutomationFramework.TestHooks.ReportHooks;
import ObjectRepository.IElementRepo;

public class MoviesPage extends ReportHooks{
	
	private BrowserUtils browserUtils;
	
	public MoviesPage() 
	{
		browserUtils = new BrowserUtils();
	}	
	
	public List<String> GetAvailableDates()
	{
		List<String> availableDates = null;
		try 
		{
			browserUtils.MoveToElement(IElementRepo.tab_MoviePage_AvailableDates);
			availableDates = browserUtils.GetTextFromElements(IElementRepo.tab_MoviePage_AvailableDates);
			ReportHooks.NodePassed("I retrieve the Available Dates");
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to retrieve the Available Dates");
		}
		
		return availableDates;
	}

	public List<String> GetAvailableTheatres()
	{
		browserUtils.MoveToElement(IElementRepo.Txt_MoviePage_AvailableTheatres);
		return browserUtils.GetTextFromElements(IElementRepo.Txt_MoviePage_AvailableTheatres);
	}
	
	public List<String> GetAvailableTheatreTimingDetails(String theatreName)
	{
		browserUtils.MoveToElement(By.xpath(IElementRepo.Txt_MoviePage_AvailableTheatreTimingDetails.replace("M_TheatreName", theatreName)));
		return browserUtils.GetTextFromElements(By.xpath(IElementRepo.Txt_MoviePage_AvailableTheatreTimingDetails.replace("M_TheatreName", theatreName)));
	}	
}
