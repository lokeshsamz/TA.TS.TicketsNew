package test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import AutomationFramework.BrowserUtils;
import AutomationFramework.FunctionUtils;
import AutomationFramework.WebBrowserHooks;
import pages.HomePage;
import pages.MoviesPage;

public class HomePageTest extends WebBrowserHooks{
	private HomePage homePage;
	private BrowserUtils browserUtils;
	private MoviesPage moviePage;
	private FunctionUtils functionUtils;
	
	private HomePageTest() 
	{
		homePage = new HomePage();
		browserUtils = new BrowserUtils();
		moviePage = new MoviesPage();
		functionUtils = new FunctionUtils();
	}

	@Test
	public void SelectMovie() throws InterruptedException
	{
		List<String> theatres = new ArrayList<String>();
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		Thread.sleep(3000);
		this.browserUtils.MaximixeScreen();
		Thread.sleep(2000);
		this.homePage.ClickMovieName("Friendship");
		Thread.sleep(3000);
		
		System.out.println("Available dates : ");
		moviePage.GetAvailableDates().forEach(x -> System.out.println(x));
		
		System.out.println("Available Theatres : ");
		theatres = moviePage.GetAvailableTheatres();
		theatres.forEach(x -> System.out.println(x));
		
		int randomNumber = functionUtils.GenerateRandomNumber(theatres.size());
		System.out.println("Random Theatre: " + theatres.get(randomNumber));
		List<String> theatreTimings = moviePage.GetAvailableTheatreTimingDetails(theatres.get(randomNumber));
		System.out.println("Available Theatres Timings: ");
		theatreTimings.forEach(x -> System.out.println(x));
	}
}
