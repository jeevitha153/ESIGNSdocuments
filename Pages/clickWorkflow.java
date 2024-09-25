package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clickWorkflow {
	static WebDriver driver;

	@SuppressWarnings("static-access")
	public clickWorkflow(WebDriver driver) {
		clickWorkflow.driver = driver;
	}

	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);
	}
	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public void Overlay1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("(//div[@class=\"el-loading-mask\"])[2]");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

	}
	// click on Workflow
	public void clickWF() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Workflows']"));
	}

	public boolean VerifyClickWF() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\"fw-medium blue-dark mb-3 fs-6\"]")));
		System.out.println("Click on WorkFlow done Sucessfully");
		return name.isDisplayed();
	}

	// Create WorkFlow
	public void createWF() throws Exception {

		waitEle(By.xpath("//span[text()=\" Create Workflow \"]"));

	}

	public boolean VerifyClickCreateWF() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()=\"Workflow Name\"]")));
		System.out.println("Click on Create WorkFlow done Sucessfully");
		return name.isDisplayed();
	}

	public void WFDetails() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));
		highlight(w);
		w.sendKeys(("TestingWF"));

		waitEle(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));
	}
	public boolean VerifyWFDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class=\"head pt-1 pb-1\"]")));
		System.out.println("Enter details of workflow done Sucessfully");
		return name.isDisplayed();
	}

	public void AddFiles() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		waitEle(By.xpath("//div[text()=\" Evaluation form (1) \"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Save & send']"));
		Thread.sleep(10000);
	}
	public boolean VerifyAddFiles() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-steps document-flow el-steps--horizontal\"]")));
		System.out.println("Adding templates done Sucessfully");
		return name.isDisplayed();
	}

	public void AddRecipient() throws Exception {

		waitEle(By.xpath("//div[@id=\"user_1\"]//input[@placeholder=\"Search with Email\"]"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));

	}

	public void AddMULRecipient() throws Exception {
		waitEle(By.xpath("//div[@id=\"user_0\"]//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id=\"user_1\"]//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		waitEle(By.xpath("//div[@id=\"user_2\"]//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
	}
	public boolean VerifyAddRecipients() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-steps document-flow el-steps--horizontal\"]")));
		System.out.println("Adding Recipients done Sucessfully");
		return name.isDisplayed();
	}

	public void sendWF() throws Exception {

        Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()=\"Send\"])[2]"));
	}
	public boolean VerifySendWF() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[normalize-space()=\"Workflow sent successfully\"]")));
		System.out.println("Sent WorkFlow Sucessfully");
		return name.isDisplayed();
	}
	public void sendDocument() {
		waitEle(By.xpath("//span[normalize-space()=\"Send\"]"));
	}
	// Check Status
	public void status() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Status\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Inactive\"]"));
	}

	// Search
	public void search() {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
		highlight(search);
		search.sendKeys("hbh");
	}

	// Actions
	// Edit
	public void actionEdit() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement elementToHover = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Edit']"));

		WebElement element = driver
				.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"));
		element.clear();
		element.sendKeys("Workflow Expiration and Remainders");
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Settings\"]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
//		waitEle(By.xpath("//span[normalize-space()=\"Secure E-Sign\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Send Email\"]"));

		waitEle(By.xpath("//div[@class=\"d-flex w-100 align-items-center\"]//span[@class=\"el-checkbox__input\"]"));

		By ExpDateClear = By.xpath("//input[@placeholder='0'  and @min='1']");
		WebElement inputDays = wait.until(ExpectedConditions.elementToBeClickable(ExpDateClear));
		inputDays.clear();
		inputDays.sendKeys("1");

		waitEle(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]"));

	}
	public boolean VerifyEditSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));
		System.out.println("WorkFlow Action Edit done Sucessfully");
		return name.isDisplayed();

	}
	// Rename

	public void actionRename() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Rename']"));

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));
		highlight(w);
		w.clear();
		w.sendKeys("TestingWF");

		waitEle(By.xpath("//div[@class=\"el-dialog__wrapper rename-workflow-popup\"]//span[normalize-space()=\"Confirm\"]"));

	}


	public boolean VerifyRenameSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));
		System.out.println("WorkFlow Action Rename done Sucessfully");
		return name.isDisplayed();

	}

	// View Workflow Data

	public void actionViewData() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View Workflow Data']"));

	}

	public boolean VerifyViewWFDataSuccess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class=\"all-templates-view\"]")));
		System.out.println("WorkFlow Action View Workflow Data done Sucessfully");
		return name.isDisplayed();
	}

	// Inactive
	public void actionInactive() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Inactive']"));

	}

	public boolean VerifyInactiveSuccess() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement name = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));
			System.out.println("WorkFlow Action inactive done Sucessfully");
			return name.isDisplayed();
		}

		catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement name = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h3[@class=\"fw-medium blue-dark mb-3 fs-6\"]")));
			System.out.println("WorkFlow Action inactive done Sucessfully");
			return name.isDisplayed();
		}
	}
	// Preview click add data and send

	public void previewWF() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Prev\"]"));

		WebElement feild1 = driver
				.findElement(By.xpath("//input[@class=\"el-input__inner\"][@placeholder=\"Enter Template Title\"]"));
		highlight(feild1);
		feild1.sendKeys("N180894");
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
		waitEle(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));
	}

	// Add group while creating workflow and check in groups module

	public void addGroup() throws Exception {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));
		highlight(w);
		w.sendKeys(("TestingWF"));

		waitEle(By.xpath("//i[@class=\"el-tooltip el-icon-circle-plus-outline\"]"));

		WebElement groupTitle = driver.findElement(By.xpath("//input[@placeholder=\"Enter Title\"]"));
		highlight(groupTitle);
		groupTitle.sendKeys("testingpp");

		waitEle(By.xpath("//i[@class='el-icon-check']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));
	}

	// test enforce while adding multiple contacts
	public void enforce() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Enforce Workflow Order\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Prev\"]"));

		waitEle(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

	}

	// Primary Users
	public void primaryUser() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\" PERMANENT ADDRESS_N180894 \"]"));

		waitEle(By.xpath("//div[text()=\" address \"]"));

		waitEle(By.xpath("//div[text()=\" practice \"]"));

		waitEle(By.xpath("//span[normalize-space()='Save & send']"));

		AddMULRecipient();
		VerifyAddRecipients();
		waitEle(By.xpath("(//div[@id=\"user_1\"]//label)[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
	}

	// Select Group
	// Add recipient
	public void selectGroup() throws Exception {
		createWF();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));
		highlight(w);
		w.sendKeys(("TestingWF"));
		waitEle(By.xpath("//input[@class=\"el-select__input\"]"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		waitEle(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		AddFiles();

		AddRecipient();
		sendWF();
	}

}
