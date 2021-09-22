package AutomationFramework.TestHooks;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AutomationFramework.WebBrowser;

public class ExtentReportUtils {
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	static Object timestamp = sdf1.format(new Timestamp(System.currentTimeMillis()));
	public static ExtentReports extent;
	public static ExtentTest test;
	private static String projectPath = System.getProperty("user.dir");
	static File reportDirectory = new File( projectPath + "/Reports/TestReport/" + timestamp );

	//Create New Directory and attach report.
	public static void AttachReport()
	{
		System.out.println(reportDirectory);
		if (!reportDirectory.exists()){
			reportDirectory.mkdirs();
		}
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(reportDirectory + "/index.html");
		spark.config().setReportName("Sample Extent Report");
		extent.attachReporter(spark);
		
		test = extent.createTest("MyFirstTest");			
	}
	
	//Create New Test Node to the report.
	public static ExtentTest CreateTestNode(String stepName)
	{	
		return test.createNode(stepName);		
	}
	
	//Add Screenshot to the created node.
	public static ExtentTest AddScreenshotToNode(boolean takeScreenshot, String stepName)
	{
		ExtentTest node = CreateTestNode(stepName);
		if (takeScreenshot)
		{
			String image = TakeScreenshot();
			node.addScreenCaptureFromPath(image);
		}
		
		return node;
	}

	public static void NodePassed(String stepName)
	{
		AddScreenshotToNode(true, stepName).pass(MarkupHelper.createLabel(stepName, ExtentColor.BLUE));
	}
	
	public static void NodePassed(String stepName, boolean attachScreenshot)
	{
		AddScreenshotToNode(attachScreenshot, stepName).pass(MarkupHelper.createLabel(stepName, ExtentColor.BLUE));
	}
	
	public static void NodePassed(String stepName, boolean attachScreenshot, String logs)
	{
		if(logs.isEmpty()) 
		{
			NodePassed(stepName,attachScreenshot);
		}
		else
		{
			AddScreenshotToNode(attachScreenshot, stepName).pass(MarkupHelper.createLabel(logs, ExtentColor.BLUE));
		}
	}
	
	public static void NodeFailed(String stepName, Throwable e)
	{
        AddScreenshotToNode(true, stepName).fail(e);
	}
	
	public static String TakeScreenshot()
	{
		String filePath = null;
		try
		{
			Object timeStamp = sdf1.format(new Timestamp(System.currentTimeMillis()));
			TakesScreenshot screenShot =((TakesScreenshot)WebBrowser.driver);
			byte[] screenShotFile = screenShot.getScreenshotAs(OutputType.BYTES);
			
			File screenshotsFolder = new File( reportDirectory + "/Screenshots");
			if (!screenshotsFolder.exists()){
				screenshotsFolder.mkdirs();
			}
			
			filePath = screenshotsFolder + "\\SS_" + timeStamp + ".png";
			
			File tempFile = new File(filePath);
			tempFile.createNewFile();
			
			InputStream inputStream = new ByteArrayInputStream(screenShotFile);
			BufferedImage bufferedImage = ImageIO.read(inputStream);
			ImageIO.write(bufferedImage, "png", tempFile);
			System.out.println(filePath);
		}
		catch (Exception e) 
		{
			test.fail("Failed to take screenshot. Exception Recieved: " + e.toString());
		}
		
		return filePath;
	}

	public static void closeReport()
	{
		extent.flush();
	}
}
