package Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Customization {
	static WebDriver driver;

	@SuppressWarnings("static-access")
	public Customization(WebDriver driver) {

		this.driver = driver;
	}
	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}
	public void Entity() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='icon-text']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		Javascriptclick(By.xpath("//li[normalize-space()=\"Entities\"]"));

		System.out.println("Clicked on Entities in profile completed");

	}
	public void ClickEntityAction(String EntityName) throws Exception {
		Thread.sleep(20000);
		String xpath = String.format(
				"//div[@class='el-table__fixed']//div[contains(text(),'%s')]/ancestor::tr//span[normalize-space()=\"Actions\"]",
				EntityName);
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement] //li[normalize-space()='Edit']"));
		System.out.println("Click on Edit Action Done successfully");
	}
	public void UpdateNextClick() throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
		//div[@class="el-notification__closeBtn el-icon-close"]
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
	}
	public void CustomizationAdd(String Name)throws Exception{
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter customization label\"]"),Name);
		
	}
	public void CustomizationCreation()throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Create New']"));
		
			
	}
	public void ActiveLayoutButton()throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@id=\"tab-activeLayout\"]"));
	}
	public void ProfileLayoutCustomization()throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Profile']"));
		
		
	}
	public void CoverLayoutCustomization()throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Cover']"));	
		}
	public void CustomizationSave()throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Save']"));
		
	}
	
	public void ButtonsCustomization()throws Exception{
		Thread.sleep(5000);
		
	}

}
