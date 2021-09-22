package AutomationFramework.TestHooks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AutomationFramework.FunctionUtils;
import AutomationFramework.WebBrowser;

public class ReportHooks {

	public static ExtentReports extent;
	public static ExtentTest test;
	private static String projectPath = System.getProperty("user.dir");
	static File reportDirectory = new File( projectPath + "/Reports/TestReports_" + FunctionUtils.RandomNumber(1000));
	
	@BeforeTest
	public void AttachReport()
	{
		extent = new ExtentReports();
		test = extent.createTest("MyFirstTest");
		System.out.println(reportDirectory);
		if (!reportDirectory.exists()){
			reportDirectory.mkdirs();
		}
		ExtentSparkReporter spark = new ExtentSparkReporter(reportDirectory + "index.html");
		extent.attachReporter(spark);
	}
	
	public static ExtentTest CreateTestNode(String stepName)
	{	
		return test.createNode(stepName);		
	}

	public static void NodePassed(String stepName) throws IOException
	{
		String image = TakeScreenshot();
		CreateTestNode(stepName)
			.addScreenCaptureFromPath(image)
	        .pass(MediaEntityBuilder.createScreenCaptureFromPath(image).build());
	}
	
	public static void NodeFailed(String stepName)
	{
		CreateTestNode(stepName);
		String filePath = reportDirectory + "/Screenshots/SS_" + FunctionUtils.RandomNumber(1000) + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
	}
	
	public static String TakeScreenshot() throws IOException
	{
		TakesScreenshot screenShot =((TakesScreenshot)WebBrowser.driver);
		byte[] screenShotFile = screenShot.getScreenshotAs(OutputType.BYTES);
		File screenshotsFolder = new File( reportDirectory + "/Screenshots");
		if (!screenshotsFolder.exists()){
			screenshotsFolder.mkdirs();
		}	
		String filePath = screenshotsFolder + "\\SS_" + FunctionUtils.RandomNumber(1000) + ".png";
		File filesc = new File(filePath);
		filesc.createNewFile();
		InputStream is = new ByteArrayInputStream(screenShotFile);
		 BufferedImage bi = ImageIO.read(is);
		ImageIO.write(bi, "png", filesc);
		System.out.println(filePath);
		return filePath;
	}
}
