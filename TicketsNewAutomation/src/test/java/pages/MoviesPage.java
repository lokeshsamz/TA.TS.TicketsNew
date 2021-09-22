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
			ReportHooks.NodePassed("I retrieve the Available Dates", false, String.join(", ", availableDates));
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to retrieve the Available Dates", e);
		}
		
		return availableDates;
	}

	public List<String> GetAvailableTheatres()
	{
		List<String> availableTheatres = null;
		try 
		{
			browserUtils.MoveToElement(IElementRepo.Txt_MoviePage_AvailableTheatres);
			availableTheatres = browserUtils.GetTextFromElements(IElementRepo.Txt_MoviePage_AvailableTheatres);
			ReportHooks.NodePassed("I retrieve the Available Theatres", false, String.join(", ", availableTheatres));
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to retrieve the Available Theatres", e);
		}
		
		return availableTheatres;
	}
	
	public List<String> GetAvailableTheatreTimingDetails(String theatreName)
	{
		List<String> availableTheatreTimings = null;
		try 
		{
			browserUtils.MoveToElement(By.xpath(IElementRepo.Txt_MoviePage_AvailableTheatreTimingDetails.replace("M_TheatreName", theatreName)));
			availableTheatreTimings = browserUtils.GetTextFromElements(By.xpath(IElementRepo.Txt_MoviePage_AvailableTheatreTimingDetails.replace("M_TheatreName", theatreName)));
			ReportHooks.NodePassed("I retrieve the Available timings of '" + theatreName + "'", true, String.join(", ", availableTheatreTimings));
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to retrieve the Available timings of '" + theatreName + "'", e);
		}
		
		return availableTheatreTimings;
		
	}	
}
