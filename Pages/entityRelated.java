package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Entities {
	WebDriver driver;

	public Entities(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public void switchToNewWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}

	public void entity() throws Exception {

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Entities\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

	}

	public void ClickCreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateEntity() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("Bug");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='GENERAL']"));
		System.out.println("Clicked on GENERAL Successfully");
		waitEle(By.xpath("//h4[text()=\"Create from excel\"]"));
		System.out.println("Clicked on Create from excel successfully");

	}

	public void confirmButton() throws Exception {
		waitEle(By.xpath("//span[text()=\"Confirm\"]"));
	}

	public boolean VerifyconfirmSucess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Drag & Drop Excel file here\"]")));
		System.out.println("click on confirm done Sucessfully");
		return name.isDisplayed();

	}

	public boolean VerifyNext() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-col el-col-24 el-col-md-21 el-col-lg-19\"]")));
		System.out.println("Click on Next Done successfully");
		return name.isDisplayed();

	}

	@SuppressWarnings("deprecation")
	public void uploadFile() throws Exception {
		Thread.sleep(10000);

		By ele = By.xpath("//p[text()=\"Drag & Drop Excel file here\"]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
		c.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileuploadexcel.exe\"s");
		System.out.println("Excel is imported successfully from PC");
	}

	public void nextButton() throws Exception {
		waitEle(By.xpath("//span[text()=\"Next\"]"));
	}

	public void actionView() throws Exception {
		Thread.sleep(20000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), 'teacher-bug')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View']"));
		System.out.println("Click on View Action Done successfully");
	}

	public void addNewData() throws Exception {
//		Thread.sleep(10000);
//		waitEle(By.xpath("//div[@class='right-block float-right']//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));
//		
//		System.out.println("Click on Add New Data Icon done successfully");
		By ad = By.xpath(
				"//div[@class='right-block float-right']//button[@class='el-button el-tooltip entity-add-btn el-button--primary']");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("clicked on add new data using JS.");
		} catch (Exception e) {

			System.out.println("Add new data not clickable or not found");
		}
	}

	public void clickOnLayout() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//i[@class=\"el-icon-more\"]"));
		System.out.println("Click on layout dots done successfully");

	}

	public void layoutTable() throws Exception {
		waitEle(By.xpath("//p[text()=\" Table \"]"));
		System.out.println("Click on layout Table done successfully");
	}

	public void layoutBoard() throws Exception {
		waitEle(By.xpath("//p[text()=\" Board \"]"));
		System.out.println("Click on layout Board done successfully");
	}

	public void layoutChart() throws Exception {
		waitEle(By.xpath("//p[text()=\" Charts \"]"));
		System.out.println("Click on layout Chart done successfully");
	}

	public void layoutCards() throws Exception {
		waitEle(By.xpath("//p[text()=\" Cards \"]"));
		System.out.println("Click on layout Cards done successfully");
	}

	public void tools() throws Exception {
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--mini\"]"));
		System.out.println("Click on tools icon done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		System.out.println("selected fields to view successfully");
		waitEle(By.xpath("(//span[text()=\"Apply\"])[1]"));
	}

	public void bulkDel() throws Exception {
		waitEle(By.xpath(
				"//div[contains(@class,'el-table__header-wrapper')]//span[contains(@class,'el-checkbox__inner')]"));
		System.out.println("Selected the checkbox for bulk Delete successfully");
		waitEle(By.xpath("//span[text()=\" Actions \"]"));
		System.out.println("Click on Actions for bulk Delete Done successfully");
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Delete']"));
		confirmButton();
		System.out.println("Bulk Delete Done Successfully");
	}

	public void selectFormTemplate() throws Exception {
		waitEle(By.xpath("(//input[@placeholder=\"Select form template\"])[1]"));
		System.out.println("Clicked on select Form Template");
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		System.out.println("selected Form Template");
		waitEle(By.xpath("(//input[@placeholder=\"Select field\"])[1]"));
		System.out.println("Clicked on Select Feild");
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		System.out.println("selected Feild");

	}

	public void plusIcon() throws Exception {
		waitEle(By.xpath("(//i[@class=\"el-icon-circle-plus\"])[1]"));
		System.out.println("Clicked On Plus Icon to create a new Form Template");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By Title = By.xpath("//input[@placeholder=\"Enter template name\"]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("Testing2");

	}

	public void Selectfeild() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		waitEle(By.xpath("(//input[@placeholder=\"Select field\"])[1]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		System.out.println("selected Feild");
	}

	public void primaryFeillsSelectCheckBox() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		System.out.println("Clicked on Primary Feild CheckBox");
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
	}

	public void reviewImport() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Import\"]"));
		System.out.println("Click on Import done successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Done\"]"));
	}

	public void fillFeilds() throws Exception {

		waitEle(By.xpath("//input[@placeholder=\"Parent Name\"]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Teacher Name\"]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By Sl = By.xpath("//textarea[@placeholder=\"Feedback\"]");
		WebElement sl1 = wait.until(ExpectedConditions.elementToBeClickable(Sl));
		sl1.sendKeys("Test7");
		System.out.println("Filled multi line text");

	}

	public void details() throws Exception {
		waitEle(By.xpath("//div[normalize-space()=\"Details\"]"));
		System.out.println("Click on details done successfully");

	}

	public void SaveButton() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void saveAndNew() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save & New\"]"));
		System.out.println("Click on save&new done successfully");
	}

	public void filter() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		System.out.println("Click on filter done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"Apply\"]"));
		System.out.println("Adding filter done successfully");

	}

	public void bulkUpdate() throws Exception {
		waitEle(By.xpath(
				"//div[contains(@class,'el-table__header-wrapper')]//span[contains(@class,'el-checkbox__inner')]"));
		System.out.println("Selected the checkbox for bulk Delete successfully");
		waitEle(By.xpath("//span[text()=\" Actions \"]"));
		System.out.println("Click on Actions for bulk Delete Done successfully");
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Bulk Update']"));
		waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@placeholder=\"Select\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));
		waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		waitEle(By.xpath("//span[normalize-space()=\"Update\"]"));
		System.out.println("Bulk update done successfully");

	}

	public void EyeIcon() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class='el-table__fixed-right'] //tr[1]//button/span/i"));
		System.out.println("Click on Eye Icon done successfully");
	}

	public void editButton() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Edit\"]"));
		System.out.println("Click on Edit done successfully");

	}

	public void EntityType() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Type']"));
		System.out.println("Click on selct to select entity type done successfully");

	}

	public void BusinessEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected Business Entity");
	}

	public void contacts() throws Exception {
		waitEle(By.xpath("//div[@id=\"tab-contacts\"]"));
		System.out.println("click on contact done successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Create Contact\"]"));
		System.out.println("click on Create contact done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[1]"),
				"mohan");
		System.out.println("Entered first name successfully");
		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[2]"),
				"pemma");
		System.out.println("Entered Last name successfully");
		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[3]"),
				"mohanpemma@gmail.com");
		System.out.println("Entered Email successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Save Contact\"]"));
		System.out.println("Click on Save contact successfully");
		waitEle(By.xpath("//div[@class=\"el-dialog__body\"]//span[text()=\"Cancel\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Yes\"]"));

	}

//Create from Scratch
	public void FormTemplate() throws Exception {
//		Thread.sleep(10000);
//
//		waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));
		WebElement elementToHover = driver.findElement(By.xpath("//span[@class='el-icon-arrow-down text-white']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		waitEle(By.xpath("//li[normalize-space()=\"Form Template\"]"));

		System.out.println("Clicked on Form template in profile completed");

	}

	// drag and drop
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
//		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-parent\"]"));
//		WebElement Ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@src=\"/assets/img/fields/SingleLineText.svg\"])[1]")));
//		Actions actions = new Actions(driver);
//		actions.clickAndHold(Ele).moveToElement(Target).release().build().perform();

	public void CreateFormtemplate() throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked create FormTemplate using JS.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

//		waitEle(By.xpath("//button[normalize-space()='Create Template']"));
		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys("Bug4776");

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

	}

	public void submit() throws Exception {
		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
		System.out.println("Click on submit done successfully");

	}

	private void waitAndClick1(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Addbasicfields() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("Name");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

	}

	public void IndividualEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		System.out.println("Selected Individual Entity");

	}

	public void GeneralEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected General Entity");
	}

	public void CreateEntityScratch() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "student-bug");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[3]"));

		waitEle(By.xpath("//h4[contains(text(),\"Start from scratch\")]"));

		System.out.println("Create entity successfull");

	}

	public void entityTwo() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "teacher-bug");
	}

	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void addtemplatesScratch() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"student-bug\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void addSecondtemplatesScratch() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"teacher-bug\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void primaryFeild() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='el-scrollbar__view'])[2]//ul//li[1]")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='el-scrollbar'])[4]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("primary feild Drag and Drop Done");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void updateAndNext() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Done() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()=\"Done\"]"));
	}

	// span[normalize-space()="Done"]
	public void Relationship() throws Exception {

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[contains(text(),\"MANY\")]"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//span[normalize-space()=\"student-bug\"]"));
		waitEle(By.xpath("(//input[@placeholder='Select'])[5]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[contains(text(),\"ONE\")]"));

		waitEle(By.xpath("//span[normalize-space()='Add Relationship']"));

		System.out.println("Relationship added successfully");

		Thread.sleep(3000);

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Customization() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Customize']"));
		waitEle(By.xpath("//div[@id=\"tab-tabs\"]"));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Please Enter Label\"]"), "students");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Feature\"]"));
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[1]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//span[contains(text(),\" Add\")]"));

		System.out.println("Customization updated successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Bug4798() throws Exception {
		waitEle(By.xpath("(//div[@class=\"el-tabs__item is-top\"])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add New\"]"));
		contactDetails1();
		waitEle(By.xpath("//span[normalize-space()=\"Add student-bug\"]"));

	}

	public void contactDetails() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "bannu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "pmmeghana2001@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Save & Next\"]"));
		System.out.println("Entered contact details successfully");
	}
	public void contactDetails2() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "Meghana");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "PS");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "n180894@rguktn.ac.in");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		System.out.println("Entered contact details successfully");
	}
	public void contactDetails3() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "bannu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "meghana@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Save & Next\"]"));
		System.out.println("Entered contact details successfully");
	}
	public void contactDetails1() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "junnu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "junnu@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Add student-bug\"]"));

	}

	public void back() throws Exception {
		waitEle(By.xpath("//i[@class=\"el-icon-back\"]"));
	}

	public void validSuccessBug4798() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class=\"el-message el-message--success\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("4798 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4798 Bug reproduced");
		}
	}

	public void formBuilder() throws Exception {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Form Builder\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on FormBuilder in profile completed");

	}

	public void clickAddFormBuilder() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Add Form Builder\"]"));

	}

	public void createFormBuilder() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"Form builder name\"]"), "Bug4798");
		waitEle(By.xpath("//input[@placeholder=\"Select user type\"]"));
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[3]"));
		waitEle(By.xpath("//input[@placeholder=\"Select Users\"]"));
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save and Next\"]"));

	}

	public void addTemplate() throws Exception {
		waitEle(By.xpath("(//div[normalize-space()=\"bug4796_2\"])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save Steps\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save Form builder\"]"));
	}

	public void viewAction4796() throws Exception {
		waitEle(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-none']//tr[contains(@class, 'el-table__row') and .//span[@class='workflow-name' and text()='Bug4796']]//span[normalize-space()=\"Actions\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//i)[1]"));

	}

	public void sendFormBuilder() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//input[@class=\"el-select__input\"]"));
		By ad = By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[2]");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Email selected using JS.");
		} catch (Exception e) {

			System.out.println("send form bilder  not clickable");
		}
		By ad1 = By.xpath("//span[normalize-space()=\"Send Form\"]");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad1));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("clicked on Send form using JS.");
		} catch (Exception e) {

			System.out.println("send form bilder  not clickable");
			Thread.sleep(90000);
		}
	}

	public void detailedView() throws Exception {
		waitEle(By.xpath("//a[normalize-space()=\"Detailed View\"]"));
	}

	public void validSuccessBug4796() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("(//div[contains(text(),\"data:image/png;base64\")])[1]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4796 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4796 Bug Not reproduced");
		}
	}

	public void viewAction4790() throws Exception {
//		try {
//			waitEle(By.xpath("//div[@class='el-table__fixed']//div[contains(text(), 'Bug4790')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));
//		}catch(Exception e) {
//			System.out.println("Not able to click on Action");
//		}
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4790')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//i)[1]"));	
	}

	public void filter4790() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		try {
			Thread.sleep(5000);
			waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[4]"));
			System.out.println("4790 Bug not reproduced");
		} catch (Exception e) {
			System.out.println("4790 Bug reproduced");
		}
	}

	public void templateTwo4776() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter template name\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter template name\"]"), "Bug4776 ");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void entity4776() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4776");
	}

	public void configureFeilds() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-dialog__body\"]//span[text()=\"Confirm\"]"));
	}

	public void captchaFeild() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		WebElement captcha = driver.findElement(By.xpath("//img[@src=\"/assets/img/fields/Captcha.svg\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", captcha);
		Thread.sleep(1000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, captcha, Target);
		System.out.println("Captcha feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("CaptchaFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public void captchaFill() throws Exception {
		waitEle(By.xpath("//input[@class=\"custom-checkbox\"]"));
		Thread.sleep(5000);
		WebElement copy = driver.findElement(By.xpath("//div[@class=\"captcha-box el-col el-col-18\"]"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		waitEle(By.xpath("//div[@class=\"scrollable-element el-scrollbar\"]//input[@type=\"text\"]"));
		WebElement paste = driver
				.findElement(By.xpath("//div[@class=\"scrollable-element el-scrollbar\"]//input[@type=\"text\"]"));

		actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("v") // Press v key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");

	}

	public void entity4775() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4775");
	}

	public void template4775() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4775");
	}

	public void addtemplate4775() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4775\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void viewAction4775() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4775')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void templateActionEdit() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"(//tr[@class=\"el-table__row\"]//span[contains(text(), 'Bug4776')]/ancestor::tr//span[normalize-space()=\"Actions\"])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[2]"));

	}

	public void verify4776() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()=\"Error\"]")));

			Assert.assertNotNull(welcomeMessage, "");
			System.out.println("4776 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4776 Bug Not reproduced");
		}
	}

	public void scrollDown() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath("//div[@class=\"scrollable-container\"]"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		System.out.println("ScrollDown done successfully");
	}

	public void template3959() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3959");
	}

	public void passwordFeild() throws Exception {
		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("passwordFeild");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"])//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void entity3959() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3959");
	}

	public void addtemplates3959() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3959\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction3959() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug3959')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void fillPasswordFeild() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"passwordFeild\"]"), "Meghana");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void validBug3959() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"(//tr[@class=\"el-table__row\"]//div[@class=\"cell\"]//p[contains(text(),'Meghana')])[1]")));

			Assert.assertNotNull(password, "Password is displaying");
			System.out.println("3959 Bug reproduced");
		} catch (Exception e) {
			System.out.println("3959 Bug Not reproduced");
		}
	}

	public void template4758() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4758");

	}

	public void dateTimerangeDateRange() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement daterange = driver.findElement(By.xpath("(//span[normalize-space()=\"Date Range\"])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", daterange);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, daterange, Target);
		System.out.println("DateRange feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRangeFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

//		WebElement dateTimeRange = driver.findElement(By.xpath("(//span[normalize-space()=\"Date Time Range\"])[1]"));
//		Actions actions2 = new Actions(driver);
//		waitAndClick1(actions2, dateTimeRange, Target);
//		System.out.println("Date Time Range Element Drag and Drop Done");
//
//		Set<String> windowHandles2 = driver.getWindowHandles();
//		for (String handle : windowHandles2) {
//			driver.switchTo().window(handle);
//		}
//		Thread.sleep(10000);
//		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"DateTimeRangeFeild");
//		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
//		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void entity4758() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4758");
	}

	public void addtemplates4758() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4758\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4758() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4758')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void fillDateRange() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath("(//span[normalize-space()=\"5\"])[1]"));
		waitEle(By.xpath("(//span[normalize-space()=\"10\"])[2]"));
		
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}
	public void fillDateRange4758() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("(//input[@placeholder=\"EntityFeild\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}
	public void addData() throws Exception {
		waitEle(By.xpath("//span[text()=\"Add Data\"]"));
		
	}
	public void save() throws Exception {
		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void template4758_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4758_1");
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		
	}

	public void entityVariable() throws Exception {

		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		Thread.sleep(5000);
		WebElement entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entity);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, entity, Target);
		System.out.println("Entityfeild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityFeild");
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		}

		WebElement entityVariable = driver.findElement(By.xpath("//span[text()=\"Entity Variable\"]"));
		Actions actions2 = new Actions(driver);
		waitAndClick1(actions2, entityVariable, Target);
		System.out.println("Entity Variable feild Drag and Drop Done");

		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String handle2 : windowHandles2) {
			driver.switchTo().window(handle2);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityVariableFeild");
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[4]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

			waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
			
		}

	}

	public void entity4758_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4758_1");
	}

	public void addtemplates4758_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4758_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4758_1() throws Exception {
		Thread.sleep(20000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4758_1')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void validSuccessBug4758() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("(//p[contains(text(),\" 02-05-2024 To 03-10-2024 \")])[1]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4758 Bug not reproduced");
		} catch (Exception e) {
			System.out.println("4758 Bug reproduced");
		}
	}

	public void layout() throws Exception {
		waitEle(By.xpath("//img[@src=\"/img/layoutselect.584aef61.svg\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//li[text()=\"Standard\"]"));
	}

	public void validSuccessBug4760() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),\"18:30:00.000Z\")]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4760 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4760 Bug not reproduced");
		}
	}

	public void template3994() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3994");
	}

	public void documentFeild() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, document, Target);
		System.out.println("Document feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DocumentFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}
	public void repeatableTempPrimaryFeild() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Field\"]"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		submit();
		
	}
	public void x() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
	}

	public void entity3994() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3994");
	}

	public void addtemplates3994() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3994\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void template3994_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3994_1");
	}

	public void entity3994_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3994_1");
	}

	public void addtemplates4746_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4746_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}
	public void addtemplates3994_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3994_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction3994_1() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug3994_1')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		System.out.println("click on view action done");
	}

	public void valid3994() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[text()=\"-\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("3994 Bug reproduced");
		} catch (Exception e) {
			System.out.println("3994 Bug not reproduced");
		}
	}

	public void inspect1() throws Exception {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);

		// Perform Ctrl+Shift+C
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("c").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
	}

	public void template4660() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4660");
	}

	public void weekdayFeild() throws Exception {

//		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement weekday = driver
				.findElement(By.xpath("//div[@class=\"dragArea-field-element\"]//span[text()=\"Week Days\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", weekday);
		Thread.sleep(5000);
		WebElement weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, weekdays, Target);
		System.out.println("WeekDay feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "WeekDayFeild");
			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
			waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
			
		}
	}

	public void entity4660() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4660");
	}

	public void addtemplates4660() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4660\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4660() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4660')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}

	public void filterWeekday() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		System.out.println("Click on filter done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Value type\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		sendKeysToElement(By.xpath("//div[@class=\"el-input el-input--mini\"]//input[@class=\"el-input__inner\"]"),
				"b");
		waitEle(By.xpath("//span[text()=\"Apply\"]"));
		Thread.sleep(5000);
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		Thread.sleep(5000);
		try {
			waitEle(By.xpath("//div[@x-placement]//span[text()=\"Equals (Case-insensitive)\"]"));
			System.out.println("4660 Bug Reproduced");
		} catch (Exception e) {
			System.out.println("4660 Bug Not Reproduced");
		}
	}
	public void template4746() throws Exception {	
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4746");
		waitEle(By.xpath("//label[@class=\"el-checkbox\"]"));
		
	}
	public void entity4746() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4746");
	}
	public void addtemplates4746() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4746\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}
	public void veiwAction4746() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4746')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}
	public void Feild4746() throws Exception {
		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		WebElement dataTable = driver.findElement(By.xpath("//span[text()=\"Data Table\"]"));
		WebElement Target1 = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions1 = new Actions(driver);
		waitAndClick1(actions1, dataTable, Target1);
		System.out.println("Data Table feild Drag and Drop Done");

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DataTableFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		
	
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, document, Target);
		System.out.println("Document feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DocumentFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	@SuppressWarnings("deprecation")
	public void uploadFile4746() throws Exception {
		Thread.sleep(5000);

		waitEle(By.xpath("//th//button[@type=\"button\"]"));

		By ele = By.xpath("(//div[@class=\"avatar-uploader\"])[1]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
		c.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileuploadexcel.exe\"s");
		System.out.println("Document uploaded successfully");
		Thread.sleep(5000);

		waitEle(By.xpath("//th//button[@type=\"button\"]"));

		By ele2 = By.xpath("(//div[@class=\"avatar-uploader\"])[2]");
		WebElement c2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		c2.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileuploadexcel.exe\"s");
		System.out.println("Document uploaded successfully");
		
	}
	public void validSuccessBug4746() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("(//div[@class=\"avatar-uploader\"])[1]")));

			Assert.assertNotNull(welcomeMessage, "Document Uploaded");
			System.out.println("4746 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4746 Bug reproduced");
		}
	}
	public void template4042() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4042");
	}
	public void radioGroupFeild() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement radioGroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioGroup);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, radioGroup, Target);
		System.out.println("Radio Group feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "RadioGroupFeild");
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"),"a");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"),"b");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"),"c");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"),"d");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}
	public void clickAction() throws Exception {
		waitEle(By.xpath("(//div[@class=\"el-step__icon is-text\"])[5]"));
		
	}
	public void entity4042() throws Exception {
//		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4042");
	}
	public void addtemplates4042() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4042\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}
	public void clickTemplate() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Templates\"]"));
//		By ad = By.xpath("//span[text()=\"Templates\"]");
//		try {
//			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
//
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", add);
//			System.out.println("Clicked On Template using JS successfully");
//
//		} catch (Exception e) {
//
//			System.out.println("Element not clickable or not found: ");
//		}
	}
	public void createTemplate() throws Exception {
		waitEle(By.xpath("//span[text()=\"Create Template\"]"));
		waitEle(By.xpath("//span[text()=\"Blank template\"]"));
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter template name\"]"),"4042" );
		waitEle(By.xpath("//span[text()=\"Continue\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder=\"Select Contact type\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()=\"Bug4042\"]"));
		waitEle(By.xpath("//span[text()=\"Add\"]"));
		waitEle(By.xpath("//span[text()=\"Save Users\"]"));
		
		
	}
	public void addRecipient() throws Exception {

		Thread.sleep(100000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
	}
	public void radioFeildDragInTemplate() throws Exception {
		waitEle(By.xpath("//div[text()=\"Bug4042\"]"));

		Thread.sleep(5000);
		WebElement radioGroup = driver.findElement(By.xpath("//div[text()=\" RadioG... \"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioGroup);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, radioGroup, Target);
		System.out.println("Radio Group feild Drag and Drop Done");
		waitEle(By.xpath("//span[text()=\"Save Template\"]"));
		waitEle(By.xpath("//i[@class=\"el-icon-back\"]"));
		
	}
	public void CreateDocFromTemp() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//img[@src=\"/img/create_document.7fc4ce52.svg\"]"));
		waitEle(By.xpath("//img[@src=\"/img/templates.268560de.svg\"]"));
		waitEle(By.xpath("(//a[normalize-space()=\"4042\"])[1]"));
		waitEle(By.xpath("//span[text()=\"Continue\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		System.out.println("click on send Doc after drag and drop done successfully");

		
	}
	public void Senddoc() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder=\"Type your message here\"]");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}
	public void receiver() throws Exception {

		waitEle(By.xpath("(//input[@placeholder=\"Search with Email\"])[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("//span[text()=\" Save Users \"]"));
	}
	public void veiwAction4042() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4042')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}
	public void companyProfile() throws Exception {
		waitEle(By.xpath("(//label[@class=\"el-checkbox\"])[2]"));
		waitEle(By.xpath("//span[text()=\" Add to company profile \"]"));
		
	}
	public void template4022() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4022");
	}
	public void entity4022() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4022");
	}
	public void addtemplates4022() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4022\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}
	public void hyperLinkfields() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("hyperlink");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[5]"));
		
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}
	public void veiwAction4022() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4022')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}
	public void validSuccessBug4022() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//input[@placeholder=\"hyperlink\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("4022 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4022Bug reproduced");
		}
	}
	public void entity4004() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4004(");
	}
	public void validSuccessBug4004() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h2[text()=\"Error\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("Bug 4004 reproduced");
		} catch (Exception e) {
			System.out.println("4004Bug Not reproduced");
		}
	}
}
package Pages;

public class entityRelated {

}
