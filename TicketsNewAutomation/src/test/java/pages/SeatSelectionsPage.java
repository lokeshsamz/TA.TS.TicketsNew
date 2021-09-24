package pages;

import java.util.List;

import org.openqa.selenium.By;

import AutomationFramework.BrowserUtils;
import AutomationFramework.TestHooks.ReportHooks;
import ObjectRepository.IElementRepo;

public class SeatSelectionsPage extends ReportHooks{

	private BrowserUtils browserUtils;

	public SeatSelectionsPage()
	{
		browserUtils = new BrowserUtils();
	}

	public List<String> GetAvailableSeats()
	{
		List<String> availableSeats = null;
		try 
		{
			//browserUtils.MoveToElement(IElementRepo.Txt_SeatSelectionPage_AvailableSeatNames);
			availableSeats = browserUtils.GetTextFromElements(IElementRepo.Txt_SeatSelectionPage_AvailableSeatNames, "data-seatname");
			ReportHooks.NodePassed("I retrieve the Available Seats", true, String.join(", ", availableSeats));
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to retrieve the Available Seats", e);
		}
		
		return availableSeats;
	}
	
	public void ClickSeats(List<String> seatNames)
	{
		try 
		{
			seatNames.forEach(seat -> browserUtils.ClickElement(By.xpath(IElementRepo.Icon_SeatSelectionPage_AvailableSeat.replace("M_SeatName", seat.trim()))));
			ReportHooks.NodePassed("I click on '" + String.join(",", seatNames) + "' seat(s)", true, String.join(",", seatNames));
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to click given seat(s)", e);
		}	
	}

	
	public void ClickContinueButton()
	{
		try 
		{
			browserUtils.ClickElement(IElementRepo.Btn_SeatSelectionPage_Continue);
			ReportHooks.NodePassed("I click on continue button", false, "clicked continue button");
		}
		catch(Exception e)
		{
			ReportHooks.NodeFailed("Failed to click the continue button", e);
		}	
	}

}
