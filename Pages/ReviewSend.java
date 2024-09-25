
package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewSend {
	WebDriver driver;

	public ReviewSend(WebDriver driver){

		this.driver = driver;

	}
	public void submit() throws Exception {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen =wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder=\"Type your message here\"]");
		WebElement sen2 =wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(10000);
		By ele3 = By.xpath("//span[normalize-space()='Send Document']");
		WebElement sen3 =wait.until(ExpectedConditions.elementToBeClickable(ele3));
		sen3.click();
	}
	public boolean Verifysubmit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[text()=\"Document Sent \"]")));
		System.out.println("Sent Document Sucessfully");
		return name.isDisplayed();
	}
}
