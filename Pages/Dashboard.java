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

public class Dashboard {
	static WebDriver driver;

	public Dashboard(WebDriver driver) {
		Dashboard.driver = driver;
	}

	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);
	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void Alldoc() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//p[text()=\"All Documents\"]"));
	}

//	public boolean VerifyAlldocClick() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
//
//		WebElement name = wait.until(
//				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class=\"fw-medium blue-dark mb-3 fs-6\"]")));
//		System.out.println("click on all documents done Sucessfully");
//		return name.isDisplayed();
//	}
	public void waitingForMe() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//p[text()=\"Waiting for Me\"]"));
	}

	public boolean VerifywaitingForMeClick() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Documents Waiting for Me \"]")));
		System.out.println("Click on Waiting for others documents done Sucessfully");
		return name.isDisplayed();
	}

	public void waitOthers() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//p[text()=\"Waiting for Others\"]"));
	}

	public boolean VerifyWaitingForOthersClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[text()=\" Documents Waiting for Others \"]")));
		System.out.println("Click on Waiting for others documents done Sucessfully");
		return name.isDisplayed();
	}

	public void Draft() throws Exception {
		Thread.sleep(10000);
		WebElement d = driver.findElement(By.xpath("//p[text()=\"Draft\"]"));
		highlight(d);
		d.click();
	}

	public boolean VerifyDraftsClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Draft Documents \"]")));
		System.out.println("Click on drafts done Sucessfully");
		return name.isDisplayed();
	}

	public void expSoon() throws Exception {
		Thread.sleep(20000);
		WebElement exp = driver.findElement(By.xpath("//p[text()=\"Expiring Soon\"]"));
		highlight(exp);
		exp.click();
	}

	public boolean VerifyExpSoonClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Expiring Soon Documents \"]")));
		System.out.println("click on expiring soon done Sucessfully");
		return name.isDisplayed();
	}

	public void completed() throws Exception {
		Thread.sleep(10000);
		WebElement cmplte = driver.findElement(By.xpath("//p[text()=\"Completed\"]"));
		highlight(cmplte);
		cmplte.click();
	}

	public boolean VerifyCompleteClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Completed Documents \"]")));
		System.out.println("click on completed documents done Sucessfully");
		return name.isDisplayed();
	}

	// Hover on document to click on an action
	public void hover1() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}


	public void Overlay() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		By overlayLocator = By.xpath("(//div[@class=\"el-loading-mask\"])[1]");
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}
	}
	public void Overlay1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		By overlayLocator = By.xpath("(//div[@class=\"el-loading-mask\"])[2]");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

	}

	public void sendDocument() {
		waitEle(By.xpath("//button[@class=\"el-button fs-7 el-button--danger\"]"));
	}
	// Warning while Sending the document
	// You have set auto finish mode on. please fill below fields to auto completed
	// sender. Otherwise press send document for sender to complete the fields.
	public void warning() {
		try {
			waitEle(By.xpath("//span[normalize-space()=\"Send document\"]"));
		} catch (Exception e) {
			System.out.println("Warning popup not found");
		}
	}

	// All documents
	// correct doc
	public void correctDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder=\"Select a Recipient\"]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		VerifyCorrectDoc();
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions1 = new Actions(driver);
		WebElement sig = driver.findElement(By.id("signatureEle"));
		actions1.clickAndHold(sig).moveToElement(Target).release().build().perform();
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));

		sendDocument();
		warning();
	}

	public boolean VerifyCorrectDoc() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@placeholder=\"Enter Template Title\"]")));
		System.out.println("click on correct document done Sucessfully");
		return name.isDisplayed();
	}

	// Resend
	public void resend() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]"));

		System.out.println("click Resend document done Sucessfully");
		waitEle(By.xpath("//span[normalize-space()=\"Resend\"]"));
	}

	public boolean VerifyResendDoc() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("Resend document done Sucessfully");
		return name.isDisplayed();
	}

	// Save as Template
	public void saveAsTemplate() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[3]"));
		System.out.println("click on Save As Template done Sucessfully");
	}

	public boolean VerifyClickSaveAsTemplate() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("Document Saved As Template Sucessfully");
		return name.isDisplayed();
	}

	// Void document
	public void voidDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		System.out.println("Click on Void Document done Sucessfully");
		waitEle(By.xpath("//span[normalize-space()=\"Yes\"]"));
	}

	public boolean VerifyVoidDoc() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("voided document Sucessfully");
		return name.isDisplayed();
	}

	// rename
	public void rename() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]"));
		System.out.println("Click on Rename done Successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By clearName = By.xpath("//input[@placeholder=\"Document Name\"]");
		WebElement CN = wait.until(ExpectedConditions.elementToBeClickable(clearName));
		CN.clear();
		CN.sendKeys("Meghana");

		waitEle(By.xpath("//span[normalize-space()=\"Confirm\"]"));
	}

	public boolean VerifyRenameDoc() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("Document Renamed Sucessfully");
		return name.isDisplayed();
	}

	// Document Settings
	public void docSettings() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]"));

		System.out.println("Click on Document settings Done Sucessfully");
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
//		waitEle(By.xpath("//span[normalize-space()=\"Secure E-Sign\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Send Email\"]"));

		waitEle(By.xpath("//div[@class=\"d-flex w-100 align-items-center\"]//span[@class=\"el-checkbox__input\"]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ExpDateClear = By.xpath("//input[@placeholder='0'  and @min='1']");
		WebElement inputDays = wait.until(ExpectedConditions.elementToBeClickable(ExpDateClear));
		inputDays.clear();
		inputDays.sendKeys("1");

		waitEle(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]"));

	}

	public boolean VerifyDocSettings() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("Document Settings completed Sucessfully");
		return name.isDisplayed();
	}

	// Delete Document
	public void deleteDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[7]"));

		System.out.println("click on Delete Document is successfull");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));

	}

	public boolean VerifyDeleteDoc() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"el-notification right\"]")));
		System.out.println("Document Deleted Sucessfully");
		return name.isDisplayed();
	}
	// Download Original

	public void downloadOriginal() throws Exception {
		hover1();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By clickDwldOrgnl = By.xpath("(//ul[@x-placement=\"top-end\"]//li)[8]");
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(clickDwldOrgnl));
		download.click();
		System.out.println("Download original Document Done Sucessfully");
	}

	// Drafts
	// Actions
	// send Document
	public void DSendDoc() throws Exception {
		hover1();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(4));
		By clickSendDoc = By.xpath("(//ul[@x-placement=\"top-end\"]//li)[1]");
		WebElement CSendDoc = wait.until(ExpectedConditions.elementToBeClickable(clickSendDoc));
		CSendDoc.click();
		Thread.sleep(30000);
		sendDocument();
	}

	// Save As Template
	public void draftSaveAsTemplate() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]"));
	}

	// Rename Document
	public void DraftsRename() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[3]"));

		System.out.println("Click on Rename done Successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By clearName = By.xpath("//input[@placeholder=\"Document Name\"]");
		WebElement CN = wait.until(ExpectedConditions.elementToBeClickable(clearName));
		CN.clear();
		CN.sendKeys("Meghana");
		waitEle(By.xpath("//span[normalize-space()=\"Confirm\"]"));

	}

	// Document Settings
	public void DraftDocSettings() throws Exception {
		hover1();
		Thread.sleep(10000);

		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]"));

		System.out.println("Click on Document settings Done Sucessfully");
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[@class=\"el-switch__core\"]"));

		waitEle(By.xpath("//span[normalize-space()=\"Send Email\"]"));

		waitEle(By.xpath("//div[@class=\"d-flex w-100 align-items-center\"]//span[@class=\"el-checkbox__input\"]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By ExpDateClear = By.xpath("//input[@placeholder='0'  and @min='1']");
		WebElement inputDays = wait.until(ExpectedConditions.elementToBeClickable(ExpDateClear));
		inputDays.clear();
		inputDays.sendKeys("1");

		waitEle(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]"));
	}

	// Delete Document
	public void DraftdeleteDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]"));

		System.out.println("Click on Delete Document Done Sucessfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
	}

	// Download original
	public void DraftdownloadOriginal() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]"));

		System.out.println("Download original Document Done Sucessfully");
	}

	// completed
	// Actions
	// completed-Download original
	public void comDownloadOriginal() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[2]"));
		System.out.println("Download original Document Done Sucessfully");
	}

	// completed-Download Document
	public void comDownloadDoc() throws Exception {
		hover1();

		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[1]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//div[@class=\"el-dialog__wrapper\"]//i[@class=\"el-icon-download\"]"));
	}

	// completed-Save as Template
	public void comsaveAsTemplate() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[1]"));
		System.out.println("click on Save As Template done Sucessfully");
	}

	// completed-Rename
	public void completedDocRename() throws Exception {
		hover1();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]"));

		System.out.println("Click on Rename done Successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		By clearName = By.xpath("//input[@placeholder=\"Document Name\"]");
		WebElement CN = wait.until(ExpectedConditions.elementToBeClickable(clearName));
		CN.clear();
		CN.sendKeys("Meghana");
		waitEle(By.xpath("//span[normalize-space()=\"Confirm\"]"));

	}

	// completed-Share with Users
	// Completed-Clone DOcument
	public void CompletedClonedoc() throws Exception {
		hover1();
		waitEle(By.xpath("//ul[@x-placement]//a[4]"));
		Overlay();
		Overlay1();
		Thread.sleep(30000);
		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));

	}

	public boolean VarifyCompletedClonedoc() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Clone Document Successful");
		return Success.isDisplayed();
	}
	// Completed-Download Document
	public void compDocDownloadDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]"));

		System.out.println("Click on Delete Document Done Sucessfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//i[@class='el-icon-download' and @style='cursor: pointer;']"));

		System.out.println("DOcument Download done successfully");
	}
	// Completed-Delete Document
	public void CompleteddeleteDoc() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]"));

		System.out.println("Click on Delete Document Done Sucessfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
	}
	// Completed-Download Original

	public void completeddownloadOriginal() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[7]"));

		System.out.println("Download original Document Done Sucessfully");
	}
	// Completed-Send to Mail
	public void CompletedSendToMail() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[8]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By click = By.xpath("//input[@class=\"el-select__input\"]");
		WebElement c = wait.until(ExpectedConditions.elementToBeClickable(click));
		c.click();
		c.sendKeys("n180894@rguktn.ac.in");
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Send\"]"));
	}

	// expiring soon
	// Actions
	// correct Document
	public void expSooncorrectDocument() throws Exception {
		Thread.sleep(10000);
		correctDoc();
	}

	// Resend Document
	public void resendDocument() throws Exception {
		Thread.sleep(10000);
		resend();
	}

	// Save As Template
	public void expSoonSaveAsTemplate() throws Exception {
		Thread.sleep(10000);
		saveAsTemplate();
	}

	// void Document
	public void expSoonvoidDocument() throws Exception {
		Thread.sleep(10000);
		voidDoc();
	}

	// Rename Document
	public void expSoonRename() throws Exception {
		Thread.sleep(10000);
		rename();
	}

	// Document Settings
	public void expSoonDocSettings() throws Exception {
		Thread.sleep(10000);
		docSettings();
	}

	// Delete Document
	public void expSoondeleteDoc() throws Exception {
		Thread.sleep(10000);
		deleteDoc();
	}

	// Download original
	public void expSoondownloadOriginal() throws Exception {
		Thread.sleep(10000);
		downloadOriginal();
	}

	// Waiting for me
	// Actions
	// download original
	public void wFMdownloadOriginal() throws Exception {
		hover1();
		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[1]"));
		System.out.println("DOcument download original done Successfully");
	}

	// Waiting For me
	// Actions
	// Correct Document
	public void WFMCorrectDoc() throws Exception {
		try {
			correctDoc();
		} catch (Exception e) {
			System.out.println("unable to correct the document");

		}
	}

	// Resend
	public void WFMresend() throws Exception {
		try {
			resend();
		} catch (Exception e) {
			System.out.println("unable to Resend the document");
		}
	}

	// Save As Template
	public void WFMSaveAsTemplate() throws Exception {
		try {
			saveAsTemplate();
		} catch (Exception e) {
			System.out.println("unable to save the document As Template");
		}
	}

//	 Void Document
	public void WFMVoidDoc() throws Exception {
		try {
			voidDoc();
		} catch (Exception e) {
			System.out.println("unable to Void the document");
		}
	}

//	 Rename Document
	public void WFMRenameDoc() throws Exception {
		try {
			rename();
		} catch (Exception e) {
			System.out.println("unable to Rename the document");
		}
	}

//	Document Settings
	public void WFMDocSettings() throws Exception {
		try {
			docSettings();
		} catch (Exception e) {
			System.out.println("unable to change the Document Settings");
		}
	}

//	Delete Document
	public void WFMDelDoc() throws Exception {
		try {
			deleteDoc();
		} catch (Exception e) {
			System.out.println("unable to Delete the document");
		}
	}

//	Download Original
	public void WFMdownloadDoc() throws Exception {
		try {
			downloadOriginal();
		} catch (Exception e) {
			System.out.println("unable to Download the document");
		}
	}

}
