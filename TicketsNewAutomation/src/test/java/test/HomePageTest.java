package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;
import AutomationFramework.BrowserUtils;
import AutomationFramework.FunctionUtils;
import AutomationFramework.WebBrowserHooks;
import pages.HomePage;
import pages.MoviesPage;
import pages.SeatSelectionsPage;

public class HomePageTest extends WebBrowserHooks{
	private HomePage homePage;
	private BrowserUtils browserUtils;
	private MoviesPage moviePage;
	private SeatSelectionsPage seatSelectionsPage;
	
	private HomePageTest() 
	{
		homePage = new HomePage();
		browserUtils = new BrowserUtils();
		moviePage = new MoviesPage();
		seatSelectionsPage = new SeatSelectionsPage();
	}

	@Test
	public void SelectMovie() throws InterruptedException
	{
		List<String> theatres = new ArrayList<String>();
		List<String> seatsNames = new ArrayList<String>();
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		Thread.sleep(3000);
		this.browserUtils.MaximizeScreen();
		Thread.sleep(2000);
		this.homePage.ClickMovieName("jungle cruise");
		Thread.sleep(3000);
		
		moviePage.SelectFromAmenities("F&B", true);
		Thread.sleep(3000);
		
		//moviePage.SelectFromExperience("Sofa", true);
		Thread.sleep(3000);
		
		System.out.println("Available dates : ");
		moviePage.GetAvailableDates().forEach(x -> System.out.println(x));
		
		System.out.println("Available Theatres : ");
		theatres = moviePage.GetAvailableTheatres();
		theatres.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		theatres.forEach(x -> System.out.println(x));
		
		int randomNumber = FunctionUtils.GenerateRandomNumber(theatres.size());
		System.out.println("Random Theatre: " + theatres.get(randomNumber));
		List<String> theatreTimings = moviePage.GetAvailableTheatreTimingDetails(theatres.get(randomNumber));
		System.out.println("Available Theatres Timings: ");
		theatreTimings.forEach(x -> System.out.println(x));
		
		moviePage.ClickTheatreTime(theatres.get(randomNumber), theatreTimings.stream().findFirst().get());
		Thread.sleep(3000);
			
		System.out.println("Available Seat Names : ");
		seatsNames = seatSelectionsPage.GetAvailableSeats();
		Thread.sleep(3000);
		seatsNames.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		seatsNames.forEach(System.out::println);
		
		seatSelectionsPage.ClickSeats(seatsNames.stream().filter(x -> x.contains("C")).collect(Collectors.toList()));
		System.out.println("Selected seat : " + seatsNames.get(randomNumber));
		Thread.sleep(3000);
		
		seatSelectionsPage.ClickContinueButton();
		Thread.sleep(3000);
	}
}
