package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
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

	@BeforeMethod
	public void Start() {
		setUp();
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

	}

	@Test
	public void Signupverify() throws Exception {
		signup.Newsignind();

	}

	@Test

	public void verifyloginwithValidCredentials() throws InterruptedException {
		login.Signin();
		login.VerifyLoginSucess();

	}

	@Test
	public void Document() throws InterruptedException {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
	}

	@Test
	public void Upload() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.oneDriveupload();
		// uploaddocuments.uploadGdrive();
		// uploaddocuments.Dropbox();
		// uploaddocuments.Fileupload();
		// uploaddocuments.VerifyUpload();
	}

	@Test
	public void AddingRecipients() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		addrecipients.Recipients1();
		addrecipients.MoreFields();
		addrecipients.Verifrecipient();

	}

	@Test
	public void Drag() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		dragdrop.EssentialFields();
		dragdrop.Contentfields();
		dragdrop.Draw();
		dragdrop.image();
		dragdrop.send();

	}

	@Test
	public void Review() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		addrecipients.Recipients1();
		addrecipients.Verifrecipient();
		dragdrop.EssentialFields();
		dragdrop.Contentfields();
		dragdrop.Draw();
		dragdrop.image();
		dragdrop.send();
		reviewaNdSend.submit();
	}

	@Test
	public void ValidRecevierSide() throws Exception {
		recevierSide.CheckRecevierSide();

	}

	@Test
	public void ValidTemplates() throws Exception {
		login.Signin();
		templatespage.Temp();
		// templatespage.EditTemp();
		// templatespage.SendTocontacts();
		// templatespage.Addnew();
		// templatespage.Send();
		// templatespage.ConfirmationAlert();
		// templatespage.BulkSend();
		// templatespage.ValidBulk();
		// templatespage.Getlink();
		// templatespage.Share();
		// templatespage.Settings();
		templatespage.ChangeOwner();
		// templatespage.Viewdata();
		// templatespage.DuplicateTemplate();
		// templatespage.RenameTemplate();
		// templatespage.inactive();
		// templatespage.Delete();
		// templatespage.Creategroup();

	}

	@Test
	public void ValidDocScenarios() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields();
		documentsScenarios.Senddoc();
		reviewaNdSend.submit();

	}

	@Test
	public void ValidBlankdocView() throws Exception {
		recevierSide.CheckRecevierSide();
	}

	@Test
	public void ValidBlankwithoutsenderautofill() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidWithoutEnforceSignatureThroughLoginAccount() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test
	public void ValidDocscenarioOnedrive() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidDocscenariosGdrive() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenariosGdrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidWithEnforceSignatureOrderWithSenderAutofill() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFieldscc();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidBlankDocMultipleSigners() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidRearrangingOrderFirstOtherSignersndThenSender() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidBlankdocSignerndApprover() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test
	public void ValidBlankdocSignerndApproverOnedrive() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();


	}
	@Test
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Rearrange();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();


	}
	@Test
	public void ValidUploadBlankDocSignerApproverAndCC() {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Approver();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}
}
