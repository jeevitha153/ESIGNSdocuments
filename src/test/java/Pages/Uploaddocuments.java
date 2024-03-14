package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uploaddocuments {
	WebDriver driver;

	public Uploaddocuments(WebDriver driver) {
		this.driver = driver;

	}

	@SuppressWarnings("deprecation")
	public void Fileupload() throws InterruptedException, Exception {
		Thread.sleep(10000);

		By Element = By.xpath("//h4[@class='fw-normal blue pb-2']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime().exec("\"C:\\Users\\jeevitha.patnana\\OneDrive - Nimble Accounting\\Desktop\\WFour.exe\"");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

	}

	public boolean VerifyUpload() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		System.out.println("Upload Sucessfull");
		return name.isDisplayed();

	}
}
