package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void Signin() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("n180894@rguktn.ac.in");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);
	}
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("pmmeghana2001@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);
	}

	public void VerifyLoginSucess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='fw-large blue-dark mb-3 fs-10']")));

		Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
		System.out.println("Login Successful");
	}

}
