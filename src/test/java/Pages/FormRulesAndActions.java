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

public class FormRulesAndActions {
	static WebDriver driver;

	@SuppressWarnings("static-access")
	public FormRulesAndActions(WebDriver driver) {

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

	public void FormTemplate() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='icon-text']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		Javascriptclick(By.xpath("//li[normalize-space()=\"Form Template\"]"));

		System.out.println("Clicked on Form template in profile completed");

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

	public void formtemplateview(String TemplateName) throws Exception {
		Thread.sleep(1000);

		String FormTemp = String.format("//span[@class='cursor-pointer'][normalize-space()='%s']", TemplateName);
		waitEle(By.xpath(FormTemp));
		System.out.println("Template opened Successfully");
	}

	public void hoverAndClick() throws Exception {
		// Locate the three dots element
		WebElement threeDots = driver
				.findElement(By.xpath("//div[contains(@class, 'el-dropdown-link vertical-three-dots')]"));

		// Perform the hover action
		Actions actions = new Actions(driver);
		actions.moveToElement(threeDots).perform();

		// Wait for the dropdown to appear
		Thread.sleep(1000); // You may want to use WebDriverWait here instead

		// Locate the element within the dropdown you want to click
		WebElement dropdownOption = driver.findElement(By.xpath("//span[text()='Form rules']"));

		// Click the desired option
		dropdownOption.click();
	}

	public void FormRuleApply(String Name, String SelectField, String operator, String ValueType,
			String SelectTemplateField, String SelectField2, String querytype, String datasource, String SelectOption)
			throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-dropdown-link vertical-three-dots el-dropdown-selfdefine\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement]//li[contains(text(), ' Form rules ')]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Form Rules']"));
		// input[@placeholder="Rule name"]
		sendKeysToElement(By.xpath("//input[@placeholder='Rule name']"), Name);
		// driver.findElement(By.xpath("//input[@placeholder='Rule
		// name']")).sendKeys("RETURN STATUS");
		Thread.sleep(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class=\"el-select el-select--mini\"]//input[@placeholder='Select field'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", SelectField);
		waitEle(By.xpath(SelectField1));
		System.out.println("Field Select done Successfully");

		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(), ' Return Date
		// ')]"));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Operator']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String Operator1 = String.format("//div//ul//span[contains(text(), '%s')]", operator);
		waitEle(By.xpath(Operator1));
		System.out.println("Operator Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li//span[contains(text(), 'Less
		// Than or Equal(<=)')]"));
		Thread.sleep(1000);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Value type']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String valuetype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", ValueType);
		waitEle(By.xpath(valuetype));
		System.out.println("value type Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(), ' TEMPLATE
		// ')]"));
		Thread.sleep(1000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select template field']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String tempfield = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", SelectTemplateField);
		waitEle(By.xpath(tempfield));
		System.out.println("Template Field Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(), 'Due
		// Date')]"));
		Thread.sleep(1000);
		WebElement element4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Select field'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);

		String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", SelectField2);
		waitEle(By.xpath(contacttype));
		System.out.println("Field Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(), ' Loan Status
		// ')]"));
		Thread.sleep(1000);
		WebElement element5 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Query type'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);

		String Query = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", querytype);
		waitEle(By.xpath(Query));
		System.out.println("query type Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(), ' Update
		// ')]"));
		Thread.sleep(1000);
		WebElement element6 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Data source']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element6);

		String DS = String.format("//div[@x-placement]//ul//li//span[text()='%s']", datasource);
		waitEle(By.xpath(DS));
		System.out.println("DS Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li//span[text()='From field']"));
		Thread.sleep(1000);
		WebElement element7 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Select option\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element7);

		String Option = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", SelectOption);
		waitEle(By.xpath(Option));
		System.out.println("Option Select done Successfully");
		// waitEle(By.xpath("//div[@x-placement]//ul//li[contains(text(),'Returned')
		// ]"));
		waitEle(By.xpath(
				"//div//button[@class=\"el-button el-button--primary el-button--mini\"]//span[normalize-space()='Save']"));
	}

	public void Entity() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='icon-text']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		Javascriptclick(By.xpath("//li[normalize-space()=\"Entities\"]"));

		System.out.println("Clicked on Entities in profile completed");

	}

	public void EnitityActionRelationalEntity(String RelationalEntity) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@placeholder=\"Select relational entity\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]",
				RelationalEntity);
		waitEle(By.xpath(SelectField1));
		System.out.println("Relational Entity Select done Successfully");
	}

	public void ClickEntityViewAction(String EntityName) throws Exception {
		Thread.sleep(20000);
		String xpath = String.format(
				"//div[@class='el-table__fixed']//div[contains(text(),'%s')]/ancestor::tr//span[normalize-space()=\"Actions\"]",
				EntityName);
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement] //li[normalize-space()='View']"));
		System.out.println("Click on View Action Done successfully");
	}

	public void AddingDataToEntity() throws Exception {
		Thread.sleep(1000);
		waitEle(By.xpath("//button[@class=\"el-tooltip btn btn-outline-success btn-sm m-lr-1\"]"));

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

	public void EntityActionStepTasksNotification(String Name) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-step__main\"]//div[contains(text(), 'Actions')]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Add new action']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Action Name']"), Name);

	}

	public void EntityActionWhenPoint(String WhenPoint) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm\"]//i"));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"When point\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", WhenPoint);
		waitEle(By.xpath(SelectField1));
		System.out.println("point Select done Successfully");
	}

	public void ActionStep() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Action step']"));
	}

	public void EntityWorkflowActionType(String actiontype) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		waitEle(By.xpath("//input[@placeholder=\"Action type\"]"));

		String SelectField2 = String.format("//div[@x-placement]//ul//li[1]//span[contains(text(), '%s')]", actiontype);
		waitEle(By.xpath(SelectField2));
		System.out.println("action-type Select done Successfully");
//		Thread.sleep(3000);
//		waitEle(By.xpath("//button[@class=\"el-button email-config-button el-button--default\"]"));

	}

	public void EntityActionSelectEntity(String SelectEntity) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

//		WebElement element = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"center-container\"]//div[@class=\"step-box\"]//span[normalize-space()='Action step']")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		Thread.sleep(20000);
//		waitEle(By.xpath("//span[normalize-space()='Action step']"));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Select entity\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", SelectEntity);
		waitEle(By.xpath(SelectField2));
		System.out.println("action-type Select done Successfully");
		Thread.sleep(3000);

	}

	public void ConfigureActionsTaskAllocation(String UpdateWith, String TeamLead, String HoursAllocated,
			String Enddate) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(3000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[contains(., 'Task ID')]/following-sibling::td//input[@placeholder='Update with']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", UpdateWith);
		waitEle(By.xpath(SelectField1));
		System.out.println(" done Successfully");
		Thread.sleep(3000);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//td[contains(., 'Assigned Team Leader ')]/following-sibling::td//input[@placeholder='Update with']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", TeamLead);
		waitEle(By.xpath(SelectField2));
		System.out.println(" done Successfully");
		Thread.sleep(3000);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//td[contains(., 'Hours/Days Allocated')]/following-sibling::td//input[@placeholder='Update with']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String SelectField3 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]",
				HoursAllocated);
		waitEle(By.xpath(SelectField3));
		System.out.println(" done Successfully");
		Thread.sleep(3000);
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[contains(., 'End Date')]/following-sibling::td//input[@placeholder='Update with']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Enddate);
		waitEle(By.xpath(SelectField4));
		System.out.println(" done Successfully");
		// td[contains(., 'Assigned Team Leader
		// ')]/following-sibling::td//input[@placeholder='Update with']
		waitEle(By.xpath("//div[@class=\"dialog-footer\"]//span[normalize-space()='Save']"));
	}

	public void EntityWorkflowEmailConfigure(String Subject, String Email, String Text) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@class=\"el-button email-config-button el-button--default\"]"));
		Thread.sleep(2000);
		waitEle(By.xpath("//div[@class=\"el-col el-col-12\"]//p[text()=' Email Subject ']"));
		System.out.println("Email Select done Successfully");
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Enter Subject\"]"), Subject);
		Thread.sleep(5000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"User Types Emails\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Email);
		waitEle(By.xpath(SelectField4));
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframeElement);
		Thread.sleep(3000);
		waitEle(By.xpath("//body/p"));
		sendKeysToElement(By.xpath("//body/p"), Text);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.ARROW_DOWN).perform();  // Move down to the first item
//		actions.sendKeys(Keys.ARROW_DOWN).perform();  // Move to the second item (if needed)
//		actions.sendKeys(Keys.ARROW_DOWN).perform(); 
		actions.sendKeys(Keys.ENTER).perform();
		System.out.println("field Select done Successfully");
		// ul[@id="cke_83"]//li[@id="cke_1727"]
		Thread.sleep(10000);
		WebElement element7 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class=\"dialog-footer\"]//span[normalize-space()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element7);
		element7.click();
		// waitEle(By.xpath("//div[@class=\"dialog-footer\"]//span[normalize-space()='Save']"));
		System.out.println("Email configuration done successfully");
		Thread.sleep(3000);
		waitEle(By.xpath("//span[normalize-space()='Done']"));
	}

	public void EntityWorkflowActionStep(String Name, String WhenPoint, String actiontype, String Fieldtype,
			String updatewith) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-step__main\"]//div[contains(text(), 'Actions')]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Add new action']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Action Name']"), Name);
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm\"]//i"));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"When point\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", WhenPoint);
		waitEle(By.xpath(SelectField1));
		System.out.println("point Select done Successfully");
		waitEle(By.xpath("//span[normalize-space()='Action step']"));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Action type\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li[1]//span[contains(text(), '%s')]", actiontype);
		waitEle(By.xpath(SelectField2));
		System.out.println("action-type Select done Successfully");
		Thread.sleep(1000);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Update field\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String SelectField3 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Fieldtype);
		waitEle(By.xpath(SelectField3));
		System.out.println("Update Field Select done Successfully");
		Thread.sleep(1000);
		WebElement element3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Update with\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", updatewith);
		waitEle(By.xpath(SelectField4));
		System.out.println("Update Field Select done Successfully");
		waitEle(By.xpath("//span[normalize-space()='Done']"));

	}
	public void UpdateNextClick() throws Exception{
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
		//div[@class="el-notification__closeBtn el-icon-close"]
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
	}

	public void EntityWorkflowConditionStep() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-step__main\"]//div[contains(text(), 'Actions')]"));
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(3000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"el-steps document-flow el-steps--horizontal\"]//div[contains(text(),\"Actions\")]")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
		Thread.sleep(10000);
	}

	public void ActionCreation(String Name) throws Exception {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element3 = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"el-icon-circle-plus-outline\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		//waitEle(By.xpath("//span[normalize-space()='Add new action']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Action Name']"), Name);
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm\"]//i"));
	}

	public void ActionOnAdd(String WhenPoint) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"When point\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", WhenPoint);
		waitEle(By.xpath(SelectField1));
		System.out.println("point Select done Successfully");
	}

	public void ConditionStepClick() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Condition step']"));
	}

	public void EntityActionCondition(String Condition) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Condition\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", Condition);
		waitEle(By.xpath(SelectField2));
		System.out.println("Condition Select done Successfully");
	}

	public void EntityActionPlusButton() throws Exception {
		Thread.sleep(1000);
		waitEle(By.xpath("//button[@class=\"el-button left-add el-button--default el-button--mini is-circle\"]"));
	}

	public void ActionTypeNotification(String ActionType) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Action type\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String SelectField3 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", ActionType);
		waitEle(By.xpath(SelectField3));
		System.out.println("Action Select done Successfully");
	}

	public void ConfigButton() throws Exception {
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@class=\"el-button email-config-button el-button--default\"]"));
	}

	public void NotificationConfiguration(String Subject) throws Exception {

		Thread.sleep(2000);
		waitEle(By.xpath("//div[@class=\"el-col el-col-12\"]//p[text()=' Email Subject ']"));
		System.out.println("Email Select done Successfully");
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Enter Subject\"]"), Subject);
	}

	public void NotificationConfigurationEmail(String Email) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"User Types Emails\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Email);
		waitEle(By.xpath(SelectField4));
	}

//		Thread.sleep(2000);
//		waitEle(By.xpath("//div[@class=\"el-col el-col-12\"]//p[text()=' Email Subject ']"));
//		System.out.println("Email Select done Successfully");
//		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Enter Subject\"]"), Subject);
	public void EmailConfigurationFieldSelection(String Text) throws Exception {
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframeElement);
		Thread.sleep(3000);
		waitEle(By.xpath("//body/p"));
		sendKeysToElement(By.xpath("//body/p"), Text);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move down to the first item
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move to the second item (if needed)
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		System.out.println("field Select done Successfully");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	}

	public void EmailConfigurationFieldSelection2(String Text2) throws Exception {
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframeElement);
		Thread.sleep(3000);
		waitEle(By.xpath("//body/p"));
		sendKeysToElement(By.xpath("//body/p"), Text2);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move down to the first item
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move to the second item (if needed)
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		System.out.println("field Select done Successfully");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	}

	public void NotificationConfigurationSave() throws Exception {
		WebElement save = driver
				.findElement(By.xpath("//button[@class=\"el-button mr-3 el-button--primary\"]//span[normalize-space()='Save']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();
		System.out.println("Email configuration saved successfully");
	}

	public void DoneClick() throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Done']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
		Thread.sleep(10000);
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

	public void EntityWorkflowConditionStep2(String Name, String WhenPoint, String Condition, String ActionType,
			String UpdateField, String Select) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-step__main\"]//div[contains(text(), 'Actions')]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Add new action']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Action Name']"), Name);
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm\"]//i"));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"When point\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", WhenPoint);
		waitEle(By.xpath(SelectField1));
		System.out.println("point Select done Successfully");
		waitEle(By.xpath("//span[normalize-space()='Condition step']"));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Condition\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", Condition);
		waitEle(By.xpath(SelectField2));
		System.out.println("Condition Select done Successfully");
		Thread.sleep(1000);
		waitEle(By.xpath("//button[@class=\"el-button left-add el-button--default el-button--mini is-circle\"]"));
		Thread.sleep(1000);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Action type\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String SelectField3 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", ActionType);
		waitEle(By.xpath(SelectField3));
		System.out.println("Action Select done Successfully");
		Thread.sleep(1000);
		WebElement element3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Update field\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", UpdateField);
		waitEle(By.xpath(SelectField4));
		System.out.println("UpdateField Select done Successfully");
		Thread.sleep(1000);
		WebElement element4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Select\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);

		String SelectField5 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Select);
		waitEle(By.xpath(SelectField5));
		System.out.println(" Select done Successfully");
		Thread.sleep(3000);
		waitEle(By.xpath("//span[normalize-space()='Done']"));

	}

	public void FormRulesVerification() throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
//		WebElement element1 = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Due Date\"]")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		waitEle(By.xpath("//input[@placeholder=\"Due Date\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//div[@class=\"el-picker-panel__content\"]//tr[5]//td[2]"));
		System.out.println("Due-Date Selected Successfully");
		Thread.sleep(10000);
//		WebElement element2 = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Return Date\"]")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
		waitEle(By.xpath("//input[@placeholder=\"Return Date\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//div[@class=\"el-picker-panel__content\"]//tr[6]//td[5]"));
		System.out.println("Return Date Selected Successfully");

	}

	public void ClickEntityAction2(String EntityName) throws Exception {
		Thread.sleep(20000);
		String xpath = String.format(
				"//div[@class='el-table__fixed']//div[contains(text(),'%s')]/ancestor::tr//span[normalize-space()=\"Actions\"]",
				EntityName);
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement] //li[normalize-space()='View']"));
		System.out.println("Click on Edit Action Done successfully");
	}

	public void DataAddEntity() throws Exception {
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@class=\"el-tooltip btn btn-outline-success btn-sm m-lr-1\"]"));
	}

	public void EntityVariableDataAdd(String LoanID) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Loan ID\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", LoanID);
		waitEle(By.xpath(SelectField4));
		System.out.println("LoanID Select done Successfully");
	}

	public void EntityAddSave() throws Exception {
		Thread.sleep(3000);
		waitEle(By.xpath("//span[normalize-space()='Save']"));
		System.out.println("Entity Data saved Successfully");
	}

	public void Outlooklogin(String email, String password) throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
//		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), email);
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}
		Thread.sleep(3000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), password);
		waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//input[@id=\"idBtn_Back\"]"));
		System.out.printf("%s Login successfull", email);
	}

	public void clickEmail(String Subject) throws Exception {
		
		Thread.sleep(10000);
		String xpath = String.format("//span[contains(text(),'%s')]", Subject);
		waitEle(By.xpath(xpath));
		System.out.println("click on email done successfully");
	}
	
	public void paymentclick(String Number,String UPI) throws Exception{
		Thread.sleep(10000);
		
		//waitEle(By.xpath("//a[text()=\"Pay ₹400.00\"]"));
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(1000);
		WebElement element3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"paymentBox\"]//div[@class=\"svg-btn\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
		//waitEle(By.xpath("//div[@class=\"svg-btn\"]"));
		//input[@placeholder="Mobile number"]
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("(//input[@placeholder=\"Mobile number\"])[1]"), Number);
		Thread.sleep(3000);
		waitEle(By.xpath("x"));
		Thread.sleep(3000);
		waitEle(By.xpath("(//span[normalize-space()='UPI'])[1]"));
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"example@okhdfcbank\"]"), UPI);
		Thread.sleep(5000);
		waitEle(By.xpath("//button[text()='Verify and Pay']"));

	}

	public void FormRulesAssertion() throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		// Locate the 'Overdue' option in the dropdown
		WebElement overdueOption = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Overdue']")));

		// Assert that the 'Overdue' option is displayed
		Assert.assertTrue(overdueOption.isDisplayed(), "'Overdue' option is not visible in the Loan Status dropdown.");

	}

}
