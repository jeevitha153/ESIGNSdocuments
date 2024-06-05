package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recieverfieldsfill {

	WebDriver driver;

	public Recieverfieldsfill(WebDriver driver) {

		this.driver = driver;

	}

	public void loginmail() throws Exception {

		By otp = By.xpath("//input[@placeholder='Enter 6 letters code']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cli = hold.until(ExpectedConditions.elementToBeClickable(otp));
		cli.sendKeys("meplac");

		// driver.findElement(By.xpath("")).sendKeys("mnwu68");
		Thread.sleep(10000);
		By btn = By.xpath("//div[@class='el-form-item__content']//span[contains(text(),'Submit')]");
		WebDriverWait time = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement btcl = time.until(ExpectedConditions.elementToBeClickable(btn));
		btcl.click();
		// driver.findElement(By.xpath("//button[@class='el-button manage-recipient
		// ml-2 el-button--default is-plain']")).click();

		//driver.findElement(By.xpath("//span[@class='el-checkbox__input']")).click();

		//driver.findElement(By.xpath("//button[@class='el-button el-button--danger el-button--mini is-disabled']")).click();
		//driver.findElement(By.xpath("//button[contains(@class,'el-button el-button--primary el-button--mini')]")).click();
//		driver.findElement(By.xpath("//div[@class=\"el-tooltip tooltip el-input default\"]//input")).sendKeys("PemmaMohan ReddyMeghana");
		By btn2 = By.xpath("//div[@class=\"req-item\"]//textarea");
		WebDriverWait time2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement btc2 = time2.until(ExpectedConditions.elementToBeClickable(btn2));
		btc2.sendKeys("PemmaMohan ReddyMeghana");
		Thread.sleep(10000);
		By btn3 = By.xpath("//div[@class=\"el-tooltip tooltip el-input default\"]//input");
		WebDriverWait time3 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement btc3 = time3.until(ExpectedConditions.elementToBeClickable(btn3));
		btc3.sendKeys("ytfsgvdhsdbfvduhfgeu");
		Thread.sleep(10000);
		By btn4 = By.xpath("//span[normalize-space()=\"FINISH\"]");
		WebDriverWait time4 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement btc4 = time4.until(ExpectedConditions.elementToBeClickable(btn4));
		btc4.click();
		
		
//		driver.findElement(By.xpath("//div[@class=\"req-item\"]//textarea")).sendKeys("HallMark");
		Thread.sleep(10000);

	}
	public boolean Verifydocumentcompletion() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement documentco = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='clr-green fw-normal']")));
		System.out.println("document completed");
		return documentco.isDisplayed();

	}
}// input@placeholder='Enter value']