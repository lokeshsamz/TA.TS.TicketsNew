package pages;

import java.util.List;

import org.openqa.selenium.By;

import AutomationFramework.BrowserUtils;
import ObjectRepository.IElementRepo;

public class MoviesPage extends BrowserUtils{
	
	private BrowserUtils browserUtils;
	
	public MoviesPage() 
	{
		browserUtils = new BrowserUtils();
	}	
	
	public List<String> GetAvailableDates()
	{
		browserUtils.MoveToElement(IElementRepo.tab_MoviePage_AvailableDates);
		return browserUtils.GetTextFromElements(IElementRepo.tab_MoviePage_AvailableDates);
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
