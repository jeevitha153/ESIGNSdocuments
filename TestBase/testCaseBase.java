package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCaseBase {
	protected WebDriver driver;
	public void setUp() {


//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		driver = new ChromeDriver(options);
//	driver.manage().window().maximize();
//	driver.get("https://dev.esigns.io/signin");
	

		ChromeOptions options = new ChromeOptions();
		 
		driver = new ChromeDriver(options);
 
		driver.manage().window().maximize();
 
		driver.get("https://dev.esigns.io/signin");
		
	}
}
