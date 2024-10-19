package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailTemplates {
	
	
		WebDriver driver;

		public EmailTemplates(WebDriver driver) {

			this.driver = driver;
		
		}
		public void waitEle(By by) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		}

		
		public void emailtemplatesclick() throws Exception {
			Thread.sleep(10000);
			waitEle(By.xpath("//div[@class='icon-text']"));
			waitEle(By.xpath("//ul[@x-placement]//a[5]"));
			
		}
		public void selectemailtemplate() throws Exception {
			waitEle(By.xpath("(//div[@class=\"el-input el-input--suffix\"])[3]"));
			waitEle(By.xpath("//div[@x-placement='bottom-start']//li[1]"));

		}
		public void selectentities() throws Exception {
			waitEle(By.xpath("//input[@placeholder=\"Select Entities\"]"));
			waitEle(By.xpath("//div[@x-placement='bottom-start']//li[25]"));
		}
		public void emailsearch() throws Exception {
			Thread.sleep(10000);
			
			By context = By.xpath("//input[@placeholder=\"Search\"]");
			WebDriverWait cotime2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement cocl2 = cotime2.until(ExpectedConditions.elementToBeClickable(context));
			cocl2.sendKeys("pfa");
			System.out.println("emailtemplates search done");

		}
		
		
		
		public void selectemailtemplate1() throws Exception {
			By prevemail =By.xpath("(//div[@class=\"el-input el-input--suffix\"])[3]");
			WebDriverWait prev = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement Prev = prev.until(ExpectedConditions.elementToBeClickable(prevemail));
			Prev.clear();
			waitEle(By.xpath("//div[@x-placement='bottom-start']//li[2]"));

		}
		public void selectemailtemplate2() throws Exception {
			waitEle(By.xpath("(//div[@class=\"el-input el-input--suffix\"])[3]"));
			waitEle(By.xpath("//div[@x-placement='bottom-start']//li[3]"));

		}
		public void createentityemailtemplate() throws Exception {
			waitEle(By.xpath("//div[@class=\"right-create-button\"]"));
			By entertemplatename = By.xpath("//input[@placeholder=\"Enter Template Name\"]");
			WebDriverWait etn = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement ETN = etn.until(ExpectedConditions.elementToBeClickable(entertemplatename));
			ETN.sendKeys("MAR13");
			waitEle(By.xpath("//input[@placeholder=\"Select Entities\"]"));
			waitEle(By.xpath("//div[@x-placement='bottom-start']//li[22]"));
			By Description = By.xpath("//input[@placeholder=\"Enter Description\"]");
			WebDriverWait des = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement DES = des.until(ExpectedConditions.elementToBeClickable(Description));
			DES.sendKeys("Hello please find this message as wishing everyone Happy Women's day");
			By subject = By.xpath("//input[@placeholder=\"Enter Subject\"]");
			WebDriverWait sub = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement SUB = sub.until(ExpectedConditions.elementToBeClickable(subject));
			SUB.sendKeys("Wishes");
			waitEle(By.xpath("//span[normalize-space()='Save']"));
			
		}
		
		public void createheader_footer() throws Exception {
			waitEle(By.xpath("//i[@class=\"el-icon-circle-plus-outline\"]"));
			By entertemplatename = By.xpath("//input[@placeholder=\"Enter Template Name\"]");
			WebDriverWait etn = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement ETN = etn.until(ExpectedConditions.elementToBeClickable(entertemplatename));
			ETN.sendKeys("13MAR");
			By subject = By.xpath("//input[@placeholder=\"Enter Subject\"]");
			WebDriverWait sub = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement SUB = sub.until(ExpectedConditions.elementToBeClickable(subject));
			SUB.sendKeys("Wishes");
			WebElement iframe =driver.findElement(By.className("cke_wysiwyg_frame cke_reset"));
			driver.switchTo().frame(iframe);
		}
		}

			
		

