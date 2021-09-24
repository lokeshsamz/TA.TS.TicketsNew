package pages;

import java.util.List;
import org.openqa.selenium.By;
import AutomationFramework.BrowserUtils;
import AutomationFramework.Enums.Enums.SelectBy;
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
	
	public void SelectFromAmenities(String text, boolean moveToElement) 
	{
		try 
		{
			browserUtils.SelectFromDropdown(SelectBy.VISIBLETEXT, IElementRepo.Dd_MoviePage_Amenities, text, moveToElement);
			ReportHooks.NodePassed("I selected '" + text + "' from Amenities dropdown", true, text);
		} 
		catch (Exception e) 
		{
			ReportHooks.NodeFailed("Failed to select " + text + "' from Amenities dropdown", e);
			e.printStackTrace();
		}
	}
	
	public void SelectFromExperience(String text, boolean moveToElement) 
	{
		try 
		{
			browserUtils.SelectFromDropdown(SelectBy.VISIBLETEXT, IElementRepo.Dd_MoviePage_Experience, text, moveToElement);
			ReportHooks.NodePassed("I selected '" + text + "' from Experience dropdown", true, text);
		} 
		catch (Exception e) 
		{
			ReportHooks.NodeFailed("Failed to select " + text + "' from Experience dropdown", e);
			e.printStackTrace();
		}
	}
	
	public void ClickTheatreTime(String theatreName, String time)
	{
		try 
		{
			browserUtils.ClickElement(By.xpath(IElementRepo.Txt_MoviePage_TheatreTime.replace("M_TheatreName", theatreName).replace("M_Time", time)));
			ReportHooks.NodePassed("I clicked " + time + " of '" + theatreName + "'", false, "Selected - " + time);
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to click " + time + " of '" + theatreName + "'", e);
		}
	}
}
