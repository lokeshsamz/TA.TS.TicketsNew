package AutomationFramework.TestHooks;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReportHooks extends ExtentReportUtils{
	
	@BeforeTest
	public void AddReport()
	{
		ExtentReportUtils.AttachReport();
	}
	
	@AfterTest
	public void FlushReport()
	{
		ExtentReportUtils.closeReport();
	}
}
