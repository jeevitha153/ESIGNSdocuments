package extentreports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsFile {

	@Test
	public void extentTest() {
		 
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html"); //htel file will be generated spark.config().setTheme (Theme. DARK); T
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("ExtenReportdemo"); 
		
		
		ExtentTest test=extent.createTest("contactsclick"); //Create a test node in the report
		 
		test.pass("Login Test started successfully");
		 
		test.info("URL is loaded"); 
		test.info("Values entered");
		 
		test.pass("Login Test completed successfully");
		
		
		ExtentTest test1= extent.createTest("HomePage Test"); //Create a test node in the report test.pass("Homepage Test started successfully"); //Create a test step node in the report
		test.pass("Home page started successfully");
 
		test1.info("URL is loaded"); 
		test1.info("Values entered");
		 
		test1.fail("HomePage Test failed miserably");
		
		
		extent.flush();
	}
}
