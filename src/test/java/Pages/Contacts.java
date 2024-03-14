package Pages;

import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts {
	WebDriver driver;

	public Contacts(WebDriver driver) {

		this.driver = driver;
	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void contactsclick() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Contacts']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

	}

	public boolean VerifyContactsclickSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Contacts']")));
		System.out.println("Contacts opened Sucessfully");
		return name.isDisplayed();

	}

	public void contactssearch() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//label[@class=\"search-icon-wrapper\"]"));

		By context = By.xpath("//input[@data-v-4ec12b42]\r\n" + "");
		WebDriverWait cotime2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl2 = cotime2.until(ExpectedConditions.elementToBeClickable(context));
		cocl2.sendKeys("jeevitha");
		System.out.println("Contacts search done");

	}

	public void addcontacts() throws Exception {
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--mini is-plain\"]"));

	}

	public boolean contacttypespage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class=\"all-documents-view\"]")));

		System.out.println("Contact Types is present on the page");

		return element.isDisplayed();

		// driver.findElement(By.xpath("//input[@placeholder=\"Enter contact type\"]"));

	}

	public void entercontacttype() throws Exception {
		Thread.sleep(10000);
		By contype = By.xpath("//input[@placeholder=\"Enter contact type\"]");
		WebDriverWait cotime7 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl7 = cotime7.until(ExpectedConditions.elementToBeClickable(contype));
		cocl7.sendKeys("January");
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Submit\"]"));

	}

	public boolean VerifyContacttypeCreation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Contact Type is created successfully");

		return element.isDisplayed();

	}

	public void Contacttypedelete() throws Exception {
		waitEle(By.xpath("(//i[@class=\"el-icon-delete\"])[2]"));

	}

	public void Contacttypedeleteconfirm() throws Exception {

		waitEle(By.xpath("(//span[normalize-space()='OK'])"));
	}

	public boolean VerifyContacttypedeletion() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification__content\"]")));

		System.out.println("Contact Type is deleted successfully");

		return element.isDisplayed();

	}

	public void Contacttypeedit() throws Exception {

		waitEle(By.xpath("(//i[@class=\"el-icon-edit\"])[1]"));

	}

	public void updatecontacttype() throws Exception {
		Thread.sleep(10000);
		By updatecontype = By.xpath("//input[@placeholder=\"Enter contact type\"]");
		WebDriverWait update = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement updatecon = update.until(ExpectedConditions.elementToBeClickable(updatecontype));
		updatecon.clear();
		Thread.sleep(10000);
		By updatecontype1 = By.xpath("//input[@placeholder=\"Enter contact type\"]");
		WebDriverWait update1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement updatecon1 = update1.until(ExpectedConditions.elementToBeClickable(updatecontype1));
		updatecon1.sendKeys("FEB2");
	}

	public void Contacttypeupdateconfirm() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Update\"]"));

	}

	public boolean VerifyContacttypeupdating() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Contact Type is updated successfully");

		return element.isDisplayed();

	}

	public void backtocontactspage() throws Exception {

		waitEle(By.xpath("//i[@class=\\\"el-icon-arrow-left\\\"]"));

	}

	public boolean VerifyContactBack() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\\\"fw-medium blue-dark mb-3 fs-6\\\"]")));

		System.out.println("Back to the contacts page");

		return element.isDisplayed();

		// driver.findElement(By.xpath("//input[@placeholder=\"Enter contact type\"]"));

	}

	public void selectcontacts() throws Exception {
		waitEle(By.xpath("//div[@class='actions-wrapper contacts-page']//div[@class='el-select filter-contact-type']"));
		waitEle(By.xpath("//div[@x-placement='bottom-start']//li[2]"));

	}

	public boolean VerifySelectContact() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"contact-title\"]")));

		System.out.println("Contact is selected");

		return element.isDisplayed();

	}

	public void createcontacts() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Create Contact\"]"));
	}

	public void fielddetails() throws Exception {
		Thread.sleep(10000);
		By contactcreate1 = (By.xpath("(//input[@type=\"text\"])[3]"));
		WebDriverWait cotime6 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl6 = cotime6.until(ExpectedConditions.elementToBeClickable(contactcreate1));
		cocl6.sendKeys("Meghana");

		By contactlastname = (By.xpath("(//input[@type=\"text\"])[4]"));
		WebDriverWait Conlast = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement lastname = Conlast.until(ExpectedConditions.elementToBeClickable(contactlastname));
		lastname.sendKeys("Pemma");

		By contactemail = (By.xpath("(//input[@type=\"text\"])[5]"));
		WebDriverWait Conemail = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement email = Conemail.until(ExpectedConditions.elementToBeClickable(contactemail));
		email.sendKeys("MeghanaP@gmail.com");

		By contactmiddlename = (By.xpath("(//input[@type=\"text\"])[6]"));
		WebDriverWait MN = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement middlename = MN.until(ExpectedConditions.elementToBeClickable(contactmiddlename));
		middlename.sendKeys("reddy");

		By contactphno = (By.xpath("(//input[@type=\"text\"])[6]"));
		WebDriverWait phno = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement phoneno = phno.until(ExpectedConditions.elementToBeClickable(contactphno));
		phoneno.sendKeys("9014783209");

	}

	public void fieldvalidations() throws Exception {

		By contactcreate1 = (By.xpath("(//input[@type=\"text\"])[3]"));
		WebDriverWait cotime6 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl6 = cotime6.until(ExpectedConditions.elementToBeClickable(contactcreate1));
		cocl6.sendKeys("#$%^&789797");

		By contactlastname = (By.xpath("(//input[@type=\"text\"])[4]"));
		WebDriverWait Conlast = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement lastname = Conlast.until(ExpectedConditions.elementToBeClickable(contactlastname));
		lastname.sendKeys(
				"87897898787&*&*(&*(&*(&*(*(&*(&ghvhvjhbhjgijhkjhchkjhkxlhkxzhijkzhkjchxcgxhjghjxgjghjcxgsxhsihiugsxbbvcvjchjxbmbnhjgy*&(*)&(*&*&^*YHtY^%$%ERDT%$WEDGFDFGHFJVGFCVN");

		By contactemail = (By.xpath("(//input[@type=\"text\"])[5]"));
		WebDriverWait Conemail = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement email = Conemail.until(ExpectedConditions.elementToBeClickable(contactemail));
		email.sendKeys("87899uijhjbnhjbnm");

		waitEle(By.xpath("//span[normalize-space()='Save Contact']"));

	}

	public boolean fieldvalidation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//h3[@class=\"\r\n" + "              bg-light\r\n" + "              text-center\r\n"
						+ "              fw-medium\r\n" + "              blue-dark\r\n" + "              fs-5\r\n"
						+ "              py-3\r\n" + "              px-4\r\n" + "              mb-0\r\n"
						+ "              text-uppercase\r\n" + "            \"]")));

		System.out.println("invalid details");

		return element.isDisplayed();

	}

	public void phnovalidations() throws Exception {
		Thread.sleep(10000);
		By contactcreate1 = (By.xpath("(//input[@type=\"text\"])[3]"));
		WebDriverWait cotime6 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl6 = cotime6.until(ExpectedConditions.elementToBeClickable(contactcreate1));
		cocl6.sendKeys("Jeevitha");

		By contactlastname = (By.xpath("(//input[@type=\"text\"])[4]"));
		WebDriverWait Conlast = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement lastname = Conlast.until(ExpectedConditions.elementToBeClickable(contactlastname));
		lastname.sendKeys("Nikki");

		By contactemail = (By.xpath("(//input[@type=\"text\"])[5]"));
		WebDriverWait Conemail = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement email = Conemail.until(ExpectedConditions.elementToBeClickable(contactemail));
		email.sendKeys("jeevithanikki@gmail.com");

		By contactphno = (By.xpath("(//input[@type=\"text\"])[6]"));
		WebDriverWait phno = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement phoneno = phno.until(ExpectedConditions.elementToBeClickable(contactphno));
		phoneno.sendKeys("ghbhjjk&^&*(&(*");

	}

	public void addcontacttype() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//i[@class=\"el-icon-circle-plus-outline\"]"));
		waitEle(By.xpath("//a[@class=\"el-link el-link--primary\"]"));
		waitEle(By.xpath("(//input[@placeholder='Contact type'])[2]"));
		waitEle(By.xpath("//div[@x-placement]//ul//li[7]"));

		waitEle(By.xpath("//span[normalize-space()='Confirm']"));
	}

	public void multiplecontactsincreation() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Create Contact\"]"));

	}

	public void Contactcreatessave() throws Exception {
		waitEle(By.xpath("//span[normalize-space()='Save Contact']"));

	}

	public boolean VerifyCreateContact() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Contact is created successfully");

		return element.isDisplayed();

	}

	public void delcontacts() throws Exception {

		waitEle(By.xpath("(//div[@class=\"el-table__fixed-right\"]//ul[1]//li[3])[1]"));
		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean VerifydeleteContact() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Contact is deleted successfully");

		return element.isDisplayed();

	}

	public void editcontacts() throws Exception {
		waitEle(By.xpath("(//div[@class=\"el-table__fixed-right\"]//ul[1]//li[2])[1]"));

		By emailedit = By.xpath("(//input[@type=\\\"text\\\"])[5]");
		WebDriverWait editemail = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Email = editemail.until(ExpectedConditions.elementToBeClickable(emailedit));
		Email.clear();

		By Emailenter = By.xpath("(//div[@class=\"el-table__fixed-right\"]//ul[1]//li[2])[1]");
		WebDriverWait Enteremail = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement EE = Enteremail.until(ExpectedConditions.elementToBeClickable(Emailenter));
		EE.sendKeys("Meghanameghu@gmail.com");

	}

	public void updatecontactclick() throws Exception {
		waitEle(By.xpath("//span[normalize-space()='Update Contact']"));

	}

	public boolean VerifyUpdateContact() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Contact is updated successfully");

		return element.isDisplayed();

	}

	public void viewdoc() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		int pageNumber = 1;
		do {
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@class='el-table__fixed-right']//div[normalize-space()='jeevitha.patnana@nimbleaccounting.com']/ancestor::tr//button[@title='View Document']")));
				element.click();

				System.out.println("Element found on page " + pageNumber);
                break;
			} catch (Exception e) {
				System.out.println("Element not found on page " + pageNumber);
			}

			try {
				WebElement nextPageButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-next']")));
				nextPageButton.click();
				pageNumber++;
			} catch (Exception e) {
				System.out.println("Next page button not found or timeout, ending loop.");
				break;
			}
		} while (true);

	}

//	public void viewdocument() throws Exception {
//		Thread.sleep(10000);
//		By viewdoc = By.xpath("//div[@class='el-table__fixed-right']//tr[5]//li[1]");
//		WebDriverWait cotime10 = new WebDriverWait(driver, Duration.ofMinutes(3));
//		WebElement cocl10 = cotime10.until(ExpectedConditions.elementToBeClickable(viewdoc));
//		cocl10.click();
//
//	}

	public boolean VerifyViewDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\\\"title fw-normal text-dark mb-0 ls-05\\\"]")));

		System.out.println("Documents opened");

		return element.isDisplayed();

	}

	public void documentstatus() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Status\"]"));

	}

	public void viewdocumentselectsent() throws Exception {
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

	}

	public boolean VerifySentDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\"title fw-normal text-dark mb-0 ls-05\"]")));

		System.out.println("sent documents opened successfully");

		return element.isDisplayed();

	}
	// Hover on document to click on an action

	public void actionshover() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}

	public void viewdocumentrename() throws Exception {

		actionshover();

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[1]"));
		act1.click(sentaction).perform();
		Thread.sleep(10000);

		By sentrename = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait sr1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement renamesent = sr1.until(ExpectedConditions.elementToBeClickable(sentrename));
		renamesent.clear();
		Thread.sleep(10000);

		By sentrename1 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait sr2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement renamesent1 = sr2.until(ExpectedConditions.elementToBeClickable(sentrename1));
		renamesent1.sendKeys("Archieved");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[1]"));

	}

	public boolean VerifyRenameDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Document title updated successfully");

		return element.isDisplayed();

	}

	public void Voiddoc() throws Exception {

		actionshover();
		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act1.click(sentaction).perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By sentvoid = By.xpath("//span[text()[normalize-space()='Yes']]");
		WebDriverWait sentvoid1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement voidsent = sentvoid1.until(ExpectedConditions.elementToBeClickable(sentvoid));
		voidsent.click();
		Thread.sleep(10000);

	}

	public boolean VerifyVoidDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Document Voided successfully");

		return element.isDisplayed();

	}

	public void delaction() throws Exception {
		actionshover();

		Actions act1 = new Actions(driver);
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act1.click(sentaction).perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("//span[text()[normalize-space()='OK']]"));

	}

	public boolean VerifyDelDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Document Deleted successfully");

		return element.isDisplayed();

	}

	// settings sent actions

	public void settingsaction() throws InterruptedException {

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(
				By.xpath("//div[@class=\"el-table__fixed-body-wrapper\"]//tr[1]//span[normalize-space()='Actions']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(sentaction).perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

	}

	// completed

	public void completeddoc() throws Exception {
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[8]"));
	}

	public boolean VerifyCompletedDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\"title fw-normal text-dark mb-0 ls-05\"]")));

		System.out.println("completed documents opened successfully");

		return element.isDisplayed();

	}

	public void completeddocact() throws Exception {
		actionshover();
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public void completeddocact1() throws Exception {
		actionshover();
		waitEle(By.xpath("//ul[@x-placement]//a[2]"));
		waitEle(By.xpath("(//span[text()[normalize-space()='Cancel']])[3]"));

	}

	// Archived
	public void archiveddoc() throws Exception {
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[8]"));

	}

	public boolean VerifyArchivedDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\\\"title fw-normal text-dark mb-0 ls-05\\\"]")));

		System.out.println("archived documents opened successfully");

		return element.isDisplayed();

	}

	public void archiveddocact() throws Exception {
		actionshover();
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("(//span[text()[normalize-space()='Cancel']])[3]"));

	}

	public void archiveddocact1() throws Exception {
		Thread.sleep(10000);
		WebElement elementTomove1 = driver.findElement(By.xpath("//span[normalize-space()='Actions']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove1).perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));
		waitEle(By.xpath("(//span[text()[normalize-space()='Cancel']])[3]"));

	}

//voided
	public void viewdocumentselectvoided() throws Exception {
		actionshover();
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[6]"));

	}

	public boolean VerifyVoidedDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\"title fw-normal text-dark mb-0 ls-05\"]")));

		System.out.println("voided documents opened successfully");

		return element.isDisplayed();

	}

	public void delvoidaction() throws Exception {
		actionshover();

		Actions act1 = new Actions(driver);
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]"));
		act1.click(sentaction).perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("(//span[text()[normalize-space()='Cancel']])[3]"));

	}

	public boolean VerifyDelVoidDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Document Deleted successfully");

		return element.isDisplayed();

	}

//declined
	public void viewdocumentselectdeclined() throws Exception {
		actionshover();
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

	}

	public boolean VerifydeclinedDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class=\"title fw-normal text-dark mb-0 ls-05\"]")));

		System.out.println("Declined documents opened successfully");

		return element.isDisplayed();

	}

	public void deldeclinedaction() throws Exception {
		actionshover();

		Actions act1 = new Actions(driver);
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]"));
		act1.click(sentaction).perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("(//span[text()[normalize-space()='Cancel']])[3]"));

	}

	public boolean VerifyDelDeclineDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=\"el-notification__title\"]")));

		System.out.println("Document Deleted successfully");

		return element.isDisplayed();

	}

	public void importcontacts() throws Exception {
		waitEle(By.xpath("//i[@class=\"el-icon-download\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Import from Spreadsheet\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Download Blank CSV\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Continue\"]"));

	}

	@SuppressWarnings("deprecation")
	public void importcontactsdraganddrop() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Import Contacts List\"]")).click();
		Runtime.getRuntime().exec("\"C:\\Users\\jeevitha.patnana\\OneDrive - Nimble Accounting\\Documents\\imp.exe\"");
		waitEle(By.xpath("(//button[@class=\"el-button el-button--danger\"])[2]"));

		System.out.println("contacts imported successfully");

		waitEle(By.xpath("(//button[@aria-label=\"Close\"])[6]"));

	}

	public void bulkdeletecontact() throws Exception {

		waitEle(By.xpath("//li[@class=\"number active\"]"));
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		waitEle(By.xpath("//div[@class=\"import-dropdown-btn el-dropdown\"]"));

	}

}
