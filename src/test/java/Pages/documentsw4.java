package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class documentsw4 {
	WebDriver driver;

	public documentsw4(WebDriver driver) {

		this.driver = driver;
	}
	
	



	public void Recipients() throws Exception {
		By ad =(By.xpath("//span[contains(text(),'Add Recipient')]"));
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
			add.click();
	 
			driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']")).click();
	 
			By ad1 = By.xpath("//div[@x-placement]//ul//li[36]");
			WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add1 = hold1.until(ExpectedConditions.elementToBeClickable(ad1));
			add1.click();
	 
			driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();
			driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[normalize-space()='Save Users']")).click();
		}
public void addfields () throws Exception {
		
		By af =(By.xpath("//span[normalize-space()='Add fields']"));
		WebDriverWait AF = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement adf = AF.until(ExpectedConditions.elementToBeClickable(af));
		adf.click();
	}

	
	
//	public void textclear () throws Exception {
//		
//		By clr =(By.xpath("(//div[@class="el-tooltip tooltip el-input default"])[2]"));
//		WebDriverWait clear = new WebDriverWait(driver, Duration.ofMinutes(3));
//		WebElement txtclr = clear.until(ExpectedConditions.elementToBeClickable(clr));
//		txtclr.clear();
//	}
	public void DradAndDropAtTwo() throws Exception {
		 
		Thread.sleep(10000);
		
		By selectrecipient=(By.xpath("//input[@placeholder='Select a Recipient']"));
		WebDriverWait sel = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement selrec = sel.until(ExpectedConditions.elementToBeClickable(selectrecipient));
		selrec.click();
		Thread.sleep(10000);
		By select=(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		WebDriverWait sel1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement SEL = sel1.until(ExpectedConditions.elementToBeClickable(select));
		SEL.click();
		
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);//singleLine Text
		WebElement ST = driver.findElement(By.id("singleLineTextEle"));
		Thread.sleep(10000);
		actions.clickAndHold(ST).moveToElement(Target).release().build().perform();
		
		By senddoc =(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		WebDriverWait sd = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement SD = sd.until(ExpectedConditions.elementToBeClickable(senddoc));
		SD.click();
	}
	
	public void docfinal() throws Exception {
		 
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");
 
		By ele2 = By.xpath("//textarea[@placeholder=\"Type your text here\"]");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
 
	}

	public void docsettings() throws Exception {
		By settings =(By.xpath("//span[normalize-space()='Save & Send']"));
		WebDriverWait docsettings = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement docset = docsettings.until(ExpectedConditions.elementToBeClickable(settings));
		docset.click();
	}
	
public void viewdoc () throws Exception {
		
		By vd =(By.xpath("//span[normalize-space()='View Document']"));
		WebDriverWait VD = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement viewdoc = VD.until(ExpectedConditions.elementToBeClickable(vd));
		viewdoc.click();
	}
public void textclear () throws Exception {

By clr =(By.xpath("(//input[@placeholder=\"Enter Value\"])[2]"));
	WebDriverWait clear = new WebDriverWait(driver, Duration.ofMinutes(3));
	WebElement txtclr = clear.until(ExpectedConditions.elementToBeClickable(clr));
	txtclr.clear();
	By ok=(By.xpath("//span[normalize-space()='OK']"));
	WebDriverWait OK= new WebDriverWait(driver, Duration.ofMinutes(3));
	WebElement okclk =OK.until(ExpectedConditions.elementToBeClickable(ok));
	okclk.click();
	
	By fin =(By.xpath("//span[normalize-space()='FINISH']"));
	WebDriverWait FIN = new WebDriverWait(driver, Duration.ofMinutes(3));
	WebElement finish = FIN.until(ExpectedConditions.elementToBeClickable(fin));
	finish.click();
}




}
