
package TestBase;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCaseBase {

	protected WebDriver driver;

	public void setup() {

		// driver = new FirefoxDriver();

//		ChromeOptions options = new ChromeOptions();

//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("----no-sandbox");
//		// options.setCapability("pageLoadStrategy", "eager");
//		driver = new ChromeDriver();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setCapability("pageLoadStrategy", "eager");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://dev.esigns.io/signin");
		
	}

	public void waitEle(By by) throws Exception {

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		wait.until(ExpectedConditions.elementToBeClickable(by)).click();

	}

}
