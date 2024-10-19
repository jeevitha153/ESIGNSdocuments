package TestCase;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Entities;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import Pages.clickWorkflow;
import Pages.FormRulesAndActions;
import TestBase.testCaseBase;

public class TestCases_Prudhvi extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	Addrecipients addrecipients;
	Dragdrop dragdrop;
	ReviewaNdSend reviewaNdSend;
	RecevierSide recevierSide;
	Signup signup;
	Templatespage templatespage;
	Dashboard dashboard;
	DocumentsScenarios documentsScenarios;
	Entities entities;
	RecevierSide receiverSide;
	Templatespage template;
	clickWorkflow workflow;
	FormRulesAndActions formrulesandactions;

	@BeforeMethod
	public void Start() throws InterruptedException {
		setup();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments = new Uploaddocuments(driver);
		addrecipients = new Addrecipients(driver);
		dragdrop = new Dragdrop(driver);
		reviewaNdSend = new ReviewaNdSend(driver);
		recevierSide = new RecevierSide(driver);
		signup = new Signup(driver);
		templatespage = new Templatespage(driver);
		dashboard = new Dashboard(driver);
		documentsScenarios = new DocumentsScenarios(driver);
		entities = new Entities(driver);
		receiverSide = new RecevierSide(driver);
		template = new Templatespage(driver);
		workflow = new clickWorkflow(driver);
		formrulesandactions = new FormRulesAndActions(driver);
		// login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com","Nikki@1338");
//		login.Signin();
//		login.VerifyLoginSucess();

	}

//	 3a,Blank Doc – Sender signer & Receiver signer (With enforcement)send document with uploading blank doc for Sender & Receiver (Complete through login from
//	 sender & Complete through from mail receiver)
	@Test(priority = 1)
	public void BlankDocWithEnforcement() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		login.SigninNSUIMeghana();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 3bsend document with uploading blank doc for Sender & Receiver(Complete
	// through
	// login from sender & Complete through from mail receiver & sender autofill
	// enabled)
	@Test(priority = 2)
	public void BlankDocWithEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUIMeghana();
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 3c
	@Test(priority = 3)
	public void BlankDocWithEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUIMeghana();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 4a
	// Blank Doc – Sender signer & Receiver signer (With enforcement)send document
	// with uploading blank doc for Sender & Receiver (Complete through login from
	// sender & Complete through from mail receiver)
	@Test(priority = 4)
	public void BlankDocWithtEnforcement() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUIMeghana();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	
	// yes
	// 4b
	// send document with uploading blank doc for Sender & Receiver(Complete through
	// login from sender & Complete through from mail receiver & sender autofill
	// enabled)
	@Test(priority = 5)
	public void BlankDocWithoEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 6yes
	// 4c
	@Test(priority = 6)
	public void BlankDocWithoutEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 5a
	@Test(priority = 7)
	public void uploadpdfFile() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 8)
	public void uploadDoc() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 9)
	public void uploadPNG() throws Exception {
		String PNGfile = System.getProperty("user.dir") + "/src/test/resources/png.png";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(PNGfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 10)
	public void uploadjpg() throws Exception {
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/jpg.jpg";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 11)
	public void uploadTXT() throws Exception {
		String txtfile = System.getProperty("user.dir") + "/src/test/resources/Documents scenarios.txt";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(txtfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 12)
	public void uploadPDFandDoc() throws Exception {
		String pdffile = System.getProperty("user.dir") + "src/test/resources/TESTING.pdf";
		String Wordfile = System.getProperty("user.dir") + "src/test/resources/TestCases.docx";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 13)
	public void uploadDocandDoc() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		String Wordfile2 = System.getProperty("user.dir") + "/src/test/resources/Feautures.docx";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.uploadFileWithSendKeys(Wordfile2);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & TXT files and click on next it needs to
	// navigate users page
	@Test(priority = 14)
	public void uploadDOCandTXT() throws Exception {
		String txtfile = System.getProperty("user.dir") + "/src/test/resources/Documents scenarios.txt";
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.uploadFileWithSendKeys(txtfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF& PDF files and click on next it needs to
	// navigate users page
	@Test(priority = 15)
	public void uploadPDFandPDF() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		String pdffile2 = System.getProperty("user.dir") + "/src/test/resources/Test.pdf";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.uploadFileWithSendKeys(pdffile2);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & TXT files and click on next it needs to
	// navigate users page
	@Test(priority = 16)
	public void uploadPDFandTXT() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		String txtfile = System.getProperty("user.dir") + "/src/test/resources/Documents scenarios.txt";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.uploadFileWithSendKeys(txtfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & PNG files and click on next it needs to
	// navigate users page
	@Test(priority = 17)
	public void uploadDOCandPNG() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		String PNGfile = System.getProperty("user.dir") + "\\src\\test\\resources\\png.png";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.uploadFileWithSendKeys(PNGfile);
//		documentsScenarios.nextButton();
//		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 18)
	public void uploadPDFandDOC() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & JPG files and click on next it needs to
	// navigate users page
	@Test(priority = 19)
	public void uploadDOCandJPG() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/TestCases.docx";
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/jpg.jpg";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(Wordfile);
		documentsScenarios.uploadFileWithSendKeys(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & JPG files and click on next it needs to
	// navigate users page
	@Test(priority = 20)
	public void uploadPDFandJPG() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/jpg.jpg";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.uploadFileWithSendKeys(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test
	public void ValidDocScenarios() throws Exception {
		String a = "DocScenarios";
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(a);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(a);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		documentsScenarios.nsui();
		documentsScenarios.clickLogout();
		documentsScenarios.SigninNSUIJeevitha();
		documentsScenarios.loginAccountDocumentClick();
		recevierSide.signloginAccount();
	}

//	// OneDrive-signerand CC WithOut
//	// EnforceSignatureOrderWithSenderAutofill-receiver Email Login
	@Test(priority = 21)
	public void ValidDocscenarioOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "prudhvib200@outlook.com", " CC ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCCTwo();

	}

//GoogleDrive-signerand CC WithOut EnforceSignatureOrderWithSenderAutofill-receiver Email Login
	@Test(priority = 22)
	public void ValidDocscenariosGdrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenariosGdrive();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCCGdrive();

	}

	// Blankdoc-RearrangingOrderCCndSigner-Without enforce signature order & Without
	// sender autofill-receiver Email Login
	@Test(priority = 23)
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(3, 1);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// BlankDoc-MultipleSigners and cc-Without enforce signature order & Without
	// sender autofill-receiver Email Login
	@Test(priority = 24)
	public void ValidBlankDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//Onedrive-DocMultipleSigners-Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 25)
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// BlankDoc-RearrangingOrderFirstOtherSignersndThenSender-Without enforce
	// signature order & Without sender autofill-receiver Email Login
	@Test(priority = 26)
	public void ValidRearrangingOrderFirstOtherSignersandThenSender() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Rearranges(0, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// Onedrive-RearrangingOrderFirstOtherSignersndThenSenderOnedrive-Without
	// enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 27)
	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Rearranges(0, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// Blank DOc-SignerndApprover Without enforce signature order & Without sender
	// autofill-receiver Email Login
	@Test(priority = 28)
	public void ValidBlankdocSignerndApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//OneDrive-SignerndApproverOnedrive Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 29)
	public void ValidSignerndApproverOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// Blank Doc-RearrangingOrderFirstApproverthenSigner Without enforce signature
	// order & Without sender autofill-receiver Email Login
	@Test(priority = 30)
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Rearranges(2, 1);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 9.Blank Doc- (Signer , Approver & CC)Without enforce signature order &
	// Without sender autofill-receiver Email Login
	@Test(priority = 31)
	public void ValidBlankDocSignerApproverAndCCWithoutEnforceSignature() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
	// order & Without sender autofill--receiver Email Login
	@Test(priority = 32)
	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "meghanan180894@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
	// order & Without sender autofill--receiver Email Login
	@Test(priority = 33)
	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "meghanan180894@outlook.com", "CC");
		documentsScenarios.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 34)
	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "meghanan180894@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Recipient(5, "Receiver", "ramyas200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 10.Blankdoc-Rearranging order first Approver and then Signer &&CC-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 35)
	public void validBlankDocRearrangeorderApproverSignerAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(2, 1);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 11.Rearranging order first CC and then Signer && Approver Without enforce
	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 36)
	public void validBlankDocRearrangeorderCCSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(3, 1);
//		documentsScenarios.Signorder();
//		documentsScenarios.Saveuser();
//		documentsScenarios.SignatureAndFullNameFeilds();
//		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios.SubDocScenarios(doc);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		documentsScenarios.Viewdocument();
//		documentsScenarios.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & sign");
//		recevierSide.signaturefill();
//		recevierSide.clickFinish();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & Approve");
//		recevierSide.signaturefill();
//		recevierSide.clickApprove();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);

	}

	// 12.Rearranging order first Approver and then CC && Signer--receiver Email
	// Login
	@Test(priority = 37)
	public void validRearrangeorderApproverCCSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(2, 1);
		documentsScenarios.Rearranges(3, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 38)
	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(3, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 39)
	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearranges(3, 1);
		documentsScenarios.Rearranges(2, 3);
//		documentsScenarios.Signorder();
//		documentsScenarios.Saveuser();
//		documentsScenarios.SignatureAndFullNameFeilds();
//		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios.SubDocScenarios(doc);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		documentsScenarios.Viewdocument();
//		documentsScenarios.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & sign");
//		recevierSide.signaturefill();
//		recevierSide.clickFinish();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & Approve");
//		recevierSide.signaturefill();
//		recevierSide.clickApprove();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);

	}

	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature
	// order& Without sender autofill-receiver Email Login
	@Test(priority = 40)
	public void validBlankDocMulsignerApproverCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 16.Rearranging order first Other Signers and then Sender Signer
	// &&Approver-Without enforce signature order & Without sender autofill-receiver
	// Email Login
	@Test(priority = 41)
	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.Rearranges(0, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 17.Rearranging order first Approver and then Sender Signer && Other
	// Signers-receiver Email Login
	@Test(priority = 42)
	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.Rearranges(3, 2);
		documentsScenarios.scrollUp();
		documentsScenarios.Rearranges(0, 1);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 18.Rearranging order first Other Signers and then Approver && Sender
	// Signer--receiver Email Login
	@Test(priority = 43)
	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.Rearranges(0, 2);
		documentsScenarios.scrollDown();
		documentsScenarios.Rearranges(3, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 19.Rearranging order first Sender Signer and then Approver && Other
	// Signers-receiver Email Login
	@Test(priority = 44)
	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.Rearranges(3, 2);
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & Approve");
		recevierSide.signaturefill();
		recevierSide.clickApprove();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test(priority = 45)
	public void uploadVedio() throws Exception {
		String file = System.getProperty("user.dir") + "/src/test/resources/NEW SIGN.mp4";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(file);
		documentsScenarios.nextButton();
	}

	// 3.Reuploading a completed Esigns ID Generated DOC
	@Test(priority = 46)
	public void ReuploadingCompletedEsignsIDGeneratedDOC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String file = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(file);
		documentsScenarios.nextButton();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

//	(All These in Change Document also)
	@Test(priority = 47)
	public void changeDocument() throws InterruptedException, Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String file = System.getProperty("user.dir") + "/src/test/resources/Test.pdf";
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		documentsScenarios.DocScenario();
		documentsScenarios.uploadFileWithSendKeys(file);
		documentsScenarios.nextButton();
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.changeDoc();
		documentsScenarios.uploadFileTwoWithSendKeys(pdffile);
		documentsScenarios.clickContinue();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//	5.Attachment Downloads

	@Test(priority = 48)
	public void attachmentDownloads() throws Exception {
		String file = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(file);
		documentsScenarios.nextButton();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.dragRequestDocFeild();
		documentsScenarios.uploadFileWithSendKeys(pdffile);
		documentsScenarios.save();
		documentsScenarios.clickFinishDoc();
		documentsScenarios.viewDocandDownload();

	}

//	// drag and drop feilds after adding the form template to the company profile
	@Test(priority = 49)
	public void contentFeildsCompanyProfile() throws Exception {
		String feilds[] = { "paragraph", "ImageF...", "videoF...", "HTMLFe...", "division", "Headin...",
				"single_line_content", "horizontal_line", "Action..." };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		entities.FormTemplate();
//		entities.CreateFormtemplate(doc);
//		entities.templateContentFeilds();
//		entities.submit();
//		entities.contentFeildsDragAndDrop();
//		entities.companyProfile();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DragContentFeildsCompanyProfile();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test(priority = 50)
	public void BasicfeildsCompanyProfile() throws Exception {
		String feilds[] = { "RadioG...", "DateRa...", "Sign", "DateTi...", "YesorN...", "Weekda...", "Single...",
				"Date", "Docume...", "FixedT...", "list", "Time", "Number", "Multis...", "Phonon...", "Select",
				"Multil...", "Checkb..." };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		//String doc = "templateBasicFeilds";
		login.SigninNSUIMeghana();
		entities.FormTemplate();
		entities.CreateFormtemplate(doc);
		entities.submit();
		entities.basicFeilds();
//		entities.companyProfile();
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(doc);
//		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios.Saveuser();
//		documentsScenarios.DragAndDropFeildsInDocument("templateBasicFeilds", feilds);
//		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
//		documentsScenarios.SubDocScenarios(doc);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		recevierSide.firstOutlooklogin("jeevithapatnana200@outlook.com");
//		recevierSide.clickEmail(docname);
//		recevierSide.reviewandSign("Review & sign");
//		recevierSide.signaturefill();
//		recevierSide.receiverSideBasicFeildsFill(1, 4, 1, 2);
	}

//
	@Test(priority = 51)
	public void AdvancedFieldsCompanyProfile() throws Exception {
		String feild[] = { "Entity...", "Number", "Aggreg...", "Number...", "Auto I...", "Child ...", "", "Location",
				"FormulaField", "DataTable", "Currency" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		entities.FormTemplate();
//		entities.CreateFormtemplate(doc);
//		entities.templateAdvancedFeilds();
//		entities.submit();
//		entities.advancedFeilds();
//		entities.companyProfile();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DragAndDropFeildsInDocument("templateAdvancedFeilds", feild);
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
	}

	// check
	//
//	@Test()
//	public void primaryFeilds() throws Exception {
//		String feild[] = { "firstNameEle", "lastNameEle", "phoneEle", "emailEle" };
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(doc);
//		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios.Saveuser();
//		Thread.sleep(10000);
//		WebElement element = driver.findElement(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		documentsScenarios.DradAndDropSigAndFullName(3, -250, -120, 0, -120);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
//		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
//		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
////		documentsScenarios.SubDocScenarios(doc);
////		documentsScenarios.clickSubmit();
////		documentsScenarios.Verifysubmit();
//	}

//Entity mapping from documents: (Individual entity)(Update after document completion from settings)
	private String docname;

	@Test(priority = 52)
	public void EntityMappingIndividualEntityUpdateAfterDocumentCompletionFromSettings() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String docname = uuid.toString().replaceAll("-", "");
		String docname = "EntityUpdateAfterDocumentCompletionFromSettingsaaabbb";
		String arr[] = { "prudhvi b", "1", "06-01-2024 To 07-01-2024", "null", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "12:12:12", "1",
				"Computer science,maths", "9347618053", "Computer science", "PemmaMohan ReddyMeghana", "1,1" };
		login.SigninNSUIMeghana();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityFromScratch(docname, "Start from scratch", "INDIVIDUAL");
		entities.addtemplate(" templateBasicFeilds ");
//		documentsScenarios.Updateafterdocumentcompletionfromsettings("1");
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(docname);
//		documentsScenarios.addContactAtAddrecipient(1, docname, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
//		documentsScenarios.Saveuser();
//		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
//		documentsScenarios.DragBasicFeildsCompanyProfile();
//		documentsScenarios.SubDocScenarios(docname);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
//		recevierSide.clickEmail(docname);
//		recevierSide.reviewandSign("Review & sign");
//		recevierSide.signaturefill();
//		recevierSide.receiverSideBasicFeildsFill(1, 4, 1, 2);
//		driver.get("https://nsui.esigns.io/signin");
//		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
//		entities.entity();
//		entities.ClickEntityAction(docname);
//		entities.viewFeilds();
//		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
	}

//	, dependsOnMethods = {
//	"EntityMappingIndividualEntityUpdateAfterDocumentCompletionFromSettings" }
	@Test(priority = 53)
	public void EntityMappingIndividualEntityUpdateExistedData() throws Exception {
		String docname = "EntityUpdateAfterDocumentCompletionFromSettingsaaa";
		String arr[] = { "2", "06-02-2024 To 07-01-2024", "null", "06-06-2024 00:00:00", "NO", "Tuesday",
				"Automation testing", "06-02-2024", "TESTING.pdf", "02:00", "List", "01:01:01", "10", "Physics,maths",
				"7337060228", "Computer science", "Automation testing", "1,1" };
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(docname);
		documentsScenarios.Recipient(1, docname, "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.SubDocScenarios(docname);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(docname);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(docname);
		entities.viewFeilds();
		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
	}

	//
	@Test(priority = 54)
	public void EntityMappingIndividualEntityUpdateafteruserfinishesthedocumentfromsettings() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
		String doc = "afteruserfinishesthedocumentfromsettingsstart123";
		String arr[] = { "1", "06-01-2024 To 07-01-2024", "IMG", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "12:12:12", "1",
				"Computer science,maths", "9347618053", "Computer science", " PemmaMohan ReddyMeghana ", "1,2" };
//		entities.entity();
//		entities.ClickCreateEntity();
//		entities.CreateEntityFromScratch(doc, "Start from scratch", "INDIVIDUAL");
//		entities.addtemplate(" templateBasicFeilds ");
//		documentsScenarios.Updateafterdocumentcompletionfromsettings("2");
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(doc);
////		documentsScenarios.addContactAtAddrecipient(1, doc, "ramyasibbala200@outlook.com", "ramya", "sibbala",
////				"SIGNER");
////		documentsScenarios.addContactAtAddrecipient2(2, doc, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
//		documentsScenarios.Recipient(1, doc, "ramyasibbala200@outlook.com", "SIGNER");
//		documentsScenarios.Recipient(2, doc, "prudhvib200@outlook.com", "SIGNER");
//		documentsScenarios.Saveuser();
//		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
//		documentsScenarios.DragBasicFeildsCompanyProfile();
//		documentsScenarios.addPageAndClickOnPageTwoInDoc(); 
//		documentsScenarios.DradAndDropSigAndFullName(3, -250, -120, 0, -120);
//		documentsScenarios.DragBasicFeildsCompanyProfile();
//		documentsScenarios.SubDocScenarios(doc);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		recevierSide.firstOutlooklogin("ramyasibbala200@outlook.com");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & sign");
//		recevierSide.signaturefill();
//		recevierSide.receiverSideBasicFeildsFill(1,4,1,2);
//		driver.get("https://nsui.esigns.io/signin");
//		login.SigninNSUI("pmmeghana200@outlook.com","Meghana@123");
//		entities.entity();
//		entities.ClickEntityAction(doc);
//		entities.viewFeilds();
//		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr,1);
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		documentsScenarios.scrollToCertainPosition(2);
		recevierSide.signaturefill();
		recevierSide.receiverSideBasicFeildsFill(2, 8, 3, 2);
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(doc);
		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr, 2);
	}

	@Test(priority = 54)
	public void updateDataAndUpdateEntityafterUserFinishesTheDocumentfromsettings() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
		String doc = "afteruserfinishesthedocumentfromsettings";
		String arr[] = { "1", "06-01-2024 To 07-01-2024", " ", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "11:04:09", "1",
				"Computer science,maths", "9347618053", "Computer science", "PemmaMohan ReddyMeghana", "1,2" };
		login.SigninNSUIMeghana();
		documentsScenarios.Updateafterdocumentcompletionfromsettings("2");
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, doc, "ramyasibbala200@outlook.com", "SIGNER");
		documentsScenarios.Recipient(2, doc, "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.addPageAndClickOnPageTwoInDoc();
		documentsScenarios.DradAndDropSigAndFullName(3, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.firstOutlooklogin("ramyasibbala200@outlook.com");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(doc);
		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(doc);
		entities.viewFeilds();
		recevierSide.verifyBasicFieldDataFillInIndividualEntity(arr, 2);
	}

	@Test
	public void EntityMappingIndividualEntityneverUpdate() throws Exception {
		String docname = "EntityMappingIndividualEntityneverUpdate1";
		String arr[] = { "1", "06-01-2024 To 07-01-2024", "IMG", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "12:12:12", "1",
				"Computer science,maths", "9347618053", "Computer science", " PemmaMohan ReddyMeghana ", "1,2" };
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityFromScratch(docname, "Start from scratch", "INDIVIDUAL");
		entities.addtemplate(" templateBasicFeilds ");
		documentsScenarios.Updateafterdocumentcompletionfromsettings("3");
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(docname);
		documentsScenarios.addContactAtAddrecipient(1, docname, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
//		documentsScenarios.Recipient(1, docname, "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.SubDocScenarios(docname);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(docname);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.receiverSideBasicFeildsFill(1, 4, 1, 2);
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(docname);
		entities.viewFeilds();
		recevierSide.verifyNeverUpdate(arr, 1);
	}

	@Test
	public void UpdateDataEntityMappingIndividualEntityneverUpdate() throws Exception {
		String docname = "EntityMappingIndividualEntityneverUpdate1";
		String arr[] = { "1", "06-02-2024 To 07-01-2024", " ", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "11:04:09", "1",
				"Computer science,maths", "9347618053", "Computer science", "PemmaMohan ReddyMeghana", "1,2" };
		documentsScenarios.Updateafterdocumentcompletionfromsettings("3");
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(docname);
		documentsScenarios.Recipient(1, docname, "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.SubDocScenarios(docname);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(docname);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(docname);
		recevierSide.verifyNeverUpdate(arr, 1);
	}

	@Test
	public void BlankDocWithEnforcementAllContentFeilds() throws Exception {
		String feild[] = { "mySignatureEle", "headingEle", "paragraphEle", "tableEle", "myInitialEle",
				"horizontalLineEle" };
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
		String doc = "Content Feilds";
//		documentsScenarios.autofilloff();
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(doc);
//		documentsScenarios.Recipient(1,"Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios.Saveuser();
//		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
//		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
//		documentsScenarios.SubDocScenarios(doc);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		documentsScenarios.Viewdocument();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test
	public void BlankDocWithEnforcementAllFillabelFeilds() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUIMeghana();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.fillableFieldsDragAndDrop();
		documentsScenarios.FillRequestDocument();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.addPageAndClickOnPageTwoInDoc();
		documentsScenarios.fillableFieldsDragAndDrop();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
//		documentsScenarios.fillFillabelFeilds();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(2);
//		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 1
	@Test()
	public void BlankDocWithEnforcementAutoFillOnWithoutSenderFields() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(1);
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 2
	@Test()
	public void BlankDocWithEnforcementAutoFillOnWithSenderFielsNotFilled() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.addPageAndClickOnPageTwoInDoc();
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.SendDocumentInDocument();
		documentsScenarios.sendDocument();
		documentsScenarios.SubDoc(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		recevierSide.fillEssentialFeilds(1);
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(2);
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test()
	public void BlankDocWithEnforcementAutoFillOnWithSenderFielsAllFilled() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
//		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.fillEssentialFieldsInDocBeforeSendDoc(1);
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.addPageAndClickOnPageTwoInDoc();
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.SendDocumentInDocument();
		documentsScenarios.sendDocument();
		documentsScenarios.SubDoc(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(2);
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 4
	@Test()
	public void BlankDocWithEnforcementAutoFillOffWithoutSenderFields() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUIMeghana();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(1);
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 5
	@Test
	public void BlankDocWithEnforcementAutofillOffWithSenderFielsNotFilled() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.addPageAndClickOnPageTwoInDoc();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		recevierSide.fillEssentialFeilds(1);
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.fillEssentialFeilds(2);
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test
	public void entityMappingUpdateWithParentIndividualEntity() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String arr[] = { "1", "06-02-2024 To 07-01-2024", " ", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "11:04:09", "1",
				"Computer science,maths", "9347618053", "Computer science", "PemmaMohan ReddyMeghana", "1,2" };
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityFromScratch(doc, "Start from scratch", "INDIVIDUAL");
		entities.addtemplate(" templateBasicFeilds ");
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.addContactAtAddrecipient(1, doc, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		// driver.get("//nsui.esigns.io/emp-documents/custom/668d26fffad65b78b496f3db/pp");
		recevierSide.signaturefill();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		driver.get("https://nsui.esigns.io/signin");
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entities.entity();
		entities.ClickEntityAction(doc);
		entities.viewFeilds();
		recevierSide.verifyNeverUpdate(arr, 1);
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSingleline(1, -300, -150, "Entity", doc);
		documentsScenarios.updateWithParentBasicFieldsLoop("Entity-" + doc, "templateBasicFeilds");
		documentsScenarios.DradAndDropSigAndFullName(2, 150, -120, 300, -120);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");

	}

	@Test
	public void entityMappingUpdateWithParentGeneralEntity() throws Exception {
		String docname = "GeneralEntityWithBasicFieldsDuplicateTemplate4";
//		entities.entity();
//		entities.ClickCreateEntity();
//		entities.CreateEntityFromScratch(docname, "Start from scratch", "GENERAL");
//		entities.addtemplate(" templateBasicFeilds ");
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(docname);
		documentsScenarios.Recipient(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSingleline(1, -300, -150, "Entity", docname);
		documentsScenarios.basicFieldsLoopWithAndWithoutUpdateParent("Update Parent", "GeneralEntity",
				"templateBasicFeilds");
		documentsScenarios.DradAndDropSigAndFullName(2, 0, -180, 250, -180);
		documentsScenarios.SubDocScenarios(docname);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.addNewEntityDataInDocByClickOnPlus("Meghana");
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(docname);
		recevierSide.reviewandSign("Review & sign");
	}

	@Test
	public void entityMappingUpdateWithoutParentGeneralEntity() throws Exception {
		String docname = "GeneralEntityWithBasicFieldsDuplicateTemplate";
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(docname);
		documentsScenarios.Recipient(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSingleline(1, -300, -150, "Entity", docname);
		documentsScenarios.basicFieldsLoopWithAndWithoutUpdateParent("Without Update Parent", "GeneralEntity",
				"templateBasicFeilds-Dup");
		documentsScenarios.DradAndDropSigAndFullName(2, 0, -150, 300, -150);
		documentsScenarios.SubDocScenarios(docname);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.addNewEntityDataInDocByClickOnPlus("MeghanaPM");
		recevierSide.receiverSideUpdatedBasicFeildsFill();
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(docname);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
	}
	// Workflows

	@Test
	public void workflowIndividualEntityBasicFieldsUpdateAfterDocCompleted() throws Exception {
		String fields[] = { "Radio Group", "Date Range", "Sign", "Date Time", "Yes Or No", "Weekdays",
				"Single Line Text", "Date", "Document", "Fixed Time", "List", "Time", "Number", "Multi Select",
				"Phone no", "Select", "Multiline", "CheckBox" };
		String essentialFields[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle",
				"titleEle", "singleLineTextEle", "checkboxEle", "addressEle" };
		String doc = "WFIndividualEntityBasicFields24";
		documentsScenarios.Updateafterdocumentcompletionfromsettings("1");
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityFromScratch(doc, "Start from scratch", "INDIVIDUAL");
		entities.addtemplate(" templateBasicFeilds ");
		documentsScenarios.Templatesceanario();
		documentsScenarios.CreateBlankTemplate(doc + "Temp1");
		documentsScenarios.RecipientSignerToTemplate(doc, "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocument("templateBasicFeilds", fields);
		documentsScenarios.saveTemplate();
		documentsScenarios.back();
		documentsScenarios.Templatesceanario();
		documentsScenarios.CreateBlankTemplate(doc + "Temp2");
		documentsScenarios.RecipientSignerToTemplate(doc, "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(essentialFields);
		documentsScenarios.saveTemplate();
		documentsScenarios.back();
		workflow.clickWF();
		workflow.createWF(doc, doc + "Temp2", doc + "Temp1");
		workflow.AddRecipient(0, doc, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Start");
		recevierSide.fillEssentialFeilds(1);
//		recevierSide.clickOnStatusToClickOnSecondDocToFill();
		recevierSide.receiverSideBasicFeildsFill(1, 4, 1, 2);
	}

	@Test
	public void workflowIndividualEntityBasicFieldsNeverUpdate() throws Exception {
		String feild[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle", "titleEle",
				"singleLineTextEle", "checkboxEle", "addressEle" };
		String doc = "WFIndividualBasicFieldsneverupdate4";
		documentsScenarios.Updateafterdocumentcompletionfromsettings("3");
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityFromScratch(doc, "Start from scratch", "INDIVIDUAL");
		entities.addtemplate(" templateBasicFeilds ");
		documentsScenarios.Templatesceanario();
		documentsScenarios.CreateBlankTemplate(doc + "Temp1");
		documentsScenarios.RecipientSignerToTemplate(doc, "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragBasicFeildsCompanyProfile();
		documentsScenarios.saveTemplate();
		documentsScenarios.back();
		documentsScenarios.Templatesceanario();
		documentsScenarios.CreateBlankTemplate(doc + "Temp2");
		documentsScenarios.RecipientSignerToTemplate(doc, "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.selectRecipientForDragAndDrop(2);
		documentsScenarios.DragAndDropFeildsInDocumentUsingId(feild);
		documentsScenarios.saveTemplate();
		documentsScenarios.back();
		workflow.clickWF();
		workflow.createWF(doc, doc + "Temp2", doc + "Temp1");
		workflow.AddRecipient(0, doc, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
		recevierSide.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Start");
		recevierSide.fillEssentialFeilds(1);
		recevierSide.clickOnStatusToClickOnSecondDocToFill();
		recevierSide.receiverSideBasicFeildsFill(1, 4, 1, 2);

	}

	@Test

	public void FormRules() throws Exception {
		formrulesandactions.FormTemplate();
		formrulesandactions.formtemplateview("Loan");
		// formrules.hoverAndClick();
		// formrulesandactions.FormRuleApply("Status","Return Date","Less Than or
		// Equal(<=)" ,"TEMPLATE" ,"Due Date" ,"Loan Status" ,"Update" ,"From field"
		// ,"Returned" );
		formrulesandactions.FormRuleApply("Over status", "Return Date", "Greater Than (>)", "TEMPLATE", "Due Date",
				"Loan Status", "Update", "From field", "Overdue");
	}

	@Test
	public void formtemplatecreation() throws Exception {

	}

	@Test
	public void FormRulesVerification() throws Exception {
		formrulesandactions.Entity();
		formrulesandactions.ClickEntityViewAction("Loan");
		formrulesandactions.AddingDataToEntity();
		formrulesandactions.FormRulesVerification();
		formrulesandactions.FormRulesAssertion();
	}

	@Test
	public void FineDateEntityActions() throws Exception {
		login.SigninNSUI("jeevithapatnana06@gmail.com", "Nimble#2023");
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction("Fine");
		formrulesandactions.EntityWorkflowActionStep("FineDate", "Added", "Update", "Fine Date", "Variable Due Date");
	}

	@Test
	public void FineDueNotificationEntityActions() throws Exception {
		Random random = new Random();
		int id = random.nextInt(9000) + 1000;
		String rnmd = "Action" + id;
		login.SigninNSUI("jeevithapatnana06@gmail.com", "Nimble#2023");
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction("Fine");
		formrulesandactions.EntityWorkflowConditionStep();
//		formrulesandactions.UpdateNextClick();
//		formrulesandactions.UpdateNextClick();
//		formrulesandactions.UpdateNextClick();
		formrulesandactions.ActionCreation(rnmd);
		formrulesandactions.ActionOnAdd("Added");
		formrulesandactions.ConditionStepClick();
		formrulesandactions.EntityActionCondition("Notification due");
		formrulesandactions.EntityActionPlusButton();
		formrulesandactions.ActionTypeNotification("Notification");
		formrulesandactions.ConfigButton();
		formrulesandactions.NotificationConfiguration(rnmd);
		formrulesandactions.EnitityActionRelationalEntity("Field - member");
		formrulesandactions.EmailConfigurationFieldSelection("@");
		formrulesandactions.EmailConfigurationFieldSelection2("@");
		formrulesandactions.NotificationConfigurationSave();
		formrulesandactions.DoneClick();
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction2("Fine");
		formrulesandactions.DataAddEntity();
		formrulesandactions.EntityVariableDataAdd("030 - Overdue");
		formrulesandactions.EntityAddSave();
		formrulesandactions.Outlooklogin("jeevitha.patnana@kodefast.net", "Nimble#2023");
		formrulesandactions.clickEmail(rnmd);
		driver.get("https://nsui.esigns.io/payments/6530b91493314bb7b3348387/fa4d2ef2-66af-4ee2-8087-edb40e3b22a7/53616c7465645f5f5cff7158b90ecf2f27d93007c12b0f4b7f7152a78e588c0bdcafdda67ead4b0b4b935b069f411449b293c3ee8d196ab9637aaf227a9a2577a51487643a6cffe039071d33c1609bd408590549f909f378a99010b2f848933d29df705c116e64775b0a1737e8ab434d9c2e2c60235a7af7839193e278b29dbba94e3de7bcfb44576278a5b6259e6839043248204e2871f968c143b1e2c9f97fa58e723962bd9d3add8bae7552061eb0a507dd1ce760615d6116c18ce479034af27a97acc493a2d3425a42b514df6aaf2efe2285df684afbe3689a1655eeca543021f80f33b0a030a758639fcd600ce02f8f89c93cc28fb926d102d11261b532ff9310edee588c3366e579265f64e083a6216c67afb5d2df30da1893d8cd5b95714e962d7b90aa7a48b41913dedb028b436adaff234f5728434cfa719fd6415e74fd6de4e913e4869723adf6d6b384337185bc665a10745ea2b42142889cc502076dd4c951f39f7324c8cd5f972bf0a7ec9e695aaf2ac2f798318c5732035f4a849e8fc59b356a814b0c4b9d9db0be62234de9d69c1839804399b07c076054bd4f22b53a295e9e7fc5759205a1abfa4197d30a76b994a4f74584f3ac89dbb33f024ce4ec212c100c236d8225c60cc09e56a00960df9ba850f9a52a0ecaa030ce");	
		formrulesandactions.paymentclick("9010131526","9010131528@ybl");
	}

	@Test
	public void NotificationActionVerification() throws Exception {
		login.SigninNSUI("jeevithapatnana06@gmail.com", "Nimble#2023");
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction2("Fine");
		formrulesandactions.DataAddEntity();
		formrulesandactions.EntityVariableDataAdd("030 - Overdue");
		formrulesandactions.EntityAddSave();
		formrulesandactions.Outlooklogin("jeevitha.patnana@kodefast.net", "Nimble#2024");
		formrulesandactions.clickEmail("EmailAction1");
		formrulesandactions.paymentclick("9010131526","9010131528@ybl");
	}

	@Test
	public void NotificationActionVerification2() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		formrulesandactions.Outlooklogin("jeevitha.patnana@kodefast.net", "Nimble#2023");
		formrulesandactions.clickEmail("doc");

	}

	// Employee Notification
	public void FineDateEntityActionStep() throws Exception {
		login.SigninNSUI("akhil.pachipala@nimbleaccounting.com", "Nimble#2023");
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction("Tasks");
		formrulesandactions.EntityActionStepTasksNotification("Task Notification");
		formrulesandactions.EntityActionWhenPoint("File added");
		formrulesandactions.EntityWorkflowActionType("Notification");
		formrulesandactions.EntityWorkflowEmailConfigure("[[Tasks - Task ID]]", "pachipalaakhil15@gmail.com", "@");
	}

	@Test
	public void TaskEntityActionStep() throws Exception {
		login.SigninNSUI("akhil.pachipala@nimbleaccounting.com", "Nimble#2023");
		driver.get("https://nsui.esigns.io/entity");
		formrulesandactions.ClickEntityAction("Tasks");
		formrulesandactions.EntityActionStepTasksNotification("Task Allocation");
		formrulesandactions.EntityActionWhenPoint("Added");
		formrulesandactions.ActionStep();
		formrulesandactions.EntityWorkflowActionType("Add");
		formrulesandactions.EntityActionSelectEntity("Task allocation");
		formrulesandactions.ConfigureActionsTaskAllocation("Current Tasks", "Assigned Team Leader", "Deadline",
				"Deadline");
	}

	@Test
	public void BookAvailabilityAction() throws Exception {

		formrulesandactions.Entity();
		formrulesandactions.ClickEntityAction("Book");
		formrulesandactions.EntityWorkflowConditionStep2("Availability-Book", "Template-Book", "Availability of book",
				"Update", "Availability status", "Out of stock");

	}
	@SuppressWarnings("static-access")
	@Test
	public void BlankDocWithtSettigs() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
//		documentsScenarios.DocScenario();
		driver.get("https://nsui.esigns.io/documents/upload");
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.Loadingmask();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.Documentsettings();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
//		documentsScenarios.Viewdocument();
//		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.meghanaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.SignatureAuthentication();
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		// recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmailAuthentication(Email);
		recevierSide.OtpAuthentication();
		recevierSide.clickFinish();
//		driver.get("https://nsui.esigns.io/emp-documents/custom/669e079743eb7106d962b838/pp");

//		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test

	public void BlankTemplateWithtSettigs() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
		login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
		documentsScenarios.Templatesceanario();
		documentsScenarios.CreateBlankTemplate(doc);
		documentsScenarios.RecipientSignerToTemplate("Receiver", "SIGNER");
		documentsScenarios.SaveuserWF();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.Clickcreatedocument();
		documentsScenarios.TemplateDocumentsettings();
		documentsScenarios.Docsend(1, "pmmeghana200@outlook.com");
		documentsScenarios.clickSubmit();
		documentsScenarios.SubDocScenarios(doc);
		// documentsScenarios.clickSubmit();
		// documentsScenarios.Verifysubmit();
		recevierSide.meghanaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.SignatureAuthentication();
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		// recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmailAuthentication(Email);
		recevierSide.OtpAuthentication();
		recevierSide.clickFinish();
	}

	@Test
	public void BlankWorkflowWithtSettigs() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
		login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
		documentsScenarios.clickWF();
		documentsScenarios.VerifyclickWF();
		documentsScenarios.createWF(doc, "TEMPLATE test 23", "Test TEMPLATE23");
		documentsScenarios.WorkflowDocumentsettings();
		documentsScenarios.saveAndSend();
		documentsScenarios.AddRecipient(0, "jeevithapatnana200@outlook.com", "Jeevitha", "Nikki", "SIGNER");
		documentsScenarios.nextButtonAfterAddingTemplates();
		documentsScenarios.nextButtonAfterAddingRecipientInTemp();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignWF("Start");
		recevierSide.SignatureAuthentication();
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");

		recevierSide
				.clickEmailAuthentication("Action Required: Authenticate and Verify E-Signature for  TEMPLATE test 23");
		recevierSide.OtpAuthentication();
		receiverSide.NextDocWorkflow();
		recevierSide.NextFieldClickWF();
		recevierSide.ClickSignatureFeild();
		recevierSide.SignatureAuthentication();
		documentsScenarios.Switchtoparent();
		recevierSide
				.clickEmailAuthentication("Action Required: Authenticate and Verify E-Signature for Test TEMPLATE23");
		recevierSide.OtpAuthentication();
		recevierSide.clickFinish();

	}
	@SuppressWarnings("static-access")
	@Test
	public void DocGlobalSettingsFlow()throws Exception{
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
		login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
		driver.get("https://nsui.esigns.io/profilesettings");
		documentsScenarios.DocGlobalAppSettings();
		documentsScenarios.DocGenerationSettings();
		documentsScenarios.DocGlobalSettingsSave();
		driver.get("https://nsui.esigns.io/documents/upload");
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "pmmeghana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.Loadingmask();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.Documentsettings1();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.meghanaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
	}
	@Test
	public void DocGlobalSettingsFlow3()throws Exception{
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
		login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
		driver.get("https://nsui.esigns.io/profilesettings");
		documentsScenarios.DocGlobalAppSettings();
		documentsScenarios.ensureOnlySecureEsignCheckboxEnabled();
		documentsScenarios.DocGlobalSettingsSave();
		driver.get("https://nsui.esigns.io/documents/upload");
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.Recipient(1, "Receiver", "pmmeghana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.Loadingmask();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.Documentsettings1();
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.meghanaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSign("Review & sign");
		recevierSide.signaturefill();
		recevierSide.clickFinish();
	}

	
@Test
public void DocGlobalSettingsFlow1()throws Exception{
	UUID uuid = UUID.randomUUID();
	String doc = uuid.toString().replaceAll("-", "");
	String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
	login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
	driver.get("https://nsui.esigns.io/profilesettings");
	documentsScenarios.DocGlobalAppSettings();
	documentsScenarios.SecureEsignGlobal();
	documentsScenarios.DocGlobalSettingsSave();
	driver.get("https://nsui.esigns.io/documents/upload");
	documentsScenarios.Blankloginaccount(doc);
	documentsScenarios.Recipient(1, "Receiver", "pmmeghana200@outlook.com", " SIGNER ");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.Loadingmask();
	documentsScenarios.SignatureAndFullNameFeilds();
	documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
	documentsScenarios.Documentsettings1();
	documentsScenarios.SubDocScenarios(doc);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	recevierSide.meghanaOutlooklogin();
	recevierSide.clickEmail(doc);
	recevierSide.SignatureAuthentication();
	driver.get(
			"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
	// recevierSide.jeevithaOutlooklogin();
	recevierSide.clickEmailAuthentication(Email);
	recevierSide.OtpAuthentication();
	recevierSide.clickFinish();
}
@Test
public void DocGlobalSettingsFlow2()throws Exception{
	UUID uuid = UUID.randomUUID();
	String doc = uuid.toString().replaceAll("-", "");
	String Email = "Action Required: Authenticate and Verify E-Signature for " + " " + doc;
	login.SigninNSUI("jeevitha.patnana@nimbleaccounting.com", "Nikki@1338");
	driver.get("https://nsui.esigns.io/profilesettings");
	documentsScenarios.DocGlobalAppSettings();
	documentsScenarios.DocGenerationSettings1();
	documentsScenarios.DocGlobalSettingsSave();
	driver.get("https://nsui.esigns.io/documents/upload");
	documentsScenarios.Blankloginaccount(doc);
	documentsScenarios.Recipient(1, "Receiver", "pmmeghana200@outlook.com", " SIGNER ");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.Loadingmask();
	documentsScenarios.SignatureAndFullNameFeilds();
	documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
	documentsScenarios.Documentsettings1();
	documentsScenarios.SubDocScenarios(doc);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	recevierSide.meghanaOutlooklogin();
	recevierSide.clickEmail(doc);
	recevierSide.reviewandSign("Review & sign");
	recevierSide.signaturefill();
	recevierSide.clickFinish();
}
	
	
//	@AfterMethod;
//	public void quit() {
//		driver.quit();
//	}

}
