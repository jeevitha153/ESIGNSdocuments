package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCaseBase {
	protected WebDriver driver;

	public void setup() {

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/?type=all-documents");
		//driver.get("https://preprod.esigns.io/?type=all-documents");

	}
}
