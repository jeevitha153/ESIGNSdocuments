package TestCase;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.DragAndDrop;
import Pages.Login;
import Pages.ReviewSend;
import Pages.Uploaddocuments;
import Pages.addRecipient;
import Pages.clickWorkflow;
import Pages.createDocument;
//import Pages.Login;
import Pages.multipleFilesUpload;
import Pages.uploadFileFromPc;
import Pages.uploadGdive;

public class TestCases_Meghana extends TestBase.testCaseBase {
	Login Loginpage;
	createDocument UploadDocumentFromPC;
	uploadFileFromPc UploadFile;
	uploadGdive upload;
	Uploaddocuments uploadDropBox;
	addRecipient Add;
	DragAndDrop Drag;
	ReviewSend send;
	multipleFilesUpload mulupload;
	Dashboard dashboard;
	clickWorkflow WF;

	@BeforeMethod
	public void initalize() {
		setUp();
		Loginpage = new Login(driver);
		UploadDocumentFromPC = new createDocument(driver);
		UploadFile = new uploadFileFromPc(driver);
		Add = new addRecipient(driver);
		Drag = new DragAndDrop(driver);
		send = new ReviewSend(driver);
		mulupload = new multipleFilesUpload(driver);
		upload = new uploadGdive(driver);
		dashboard = new Dashboard(driver);
		WF = new clickWorkflow(driver);
		uploadDropBox = new Uploaddocuments(driver);
	}

	// Login
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
	}

	// click on create Document
	@Test
	public void verifyCreateDocument() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
	}

	// Upload File Gdrive
	@Test
	public void verifyUploadFilePC() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		UploadFile.uploadFile();
	}

	// Upload file from DropBox
	@Test
	public void uploadOnedrive() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		uploadDropBox.Dropbox();
	}

	// Test Overall Creation of Document
	@Test
	public void verify() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		upload.upload();
		UploadFile.VerifyFileUploadSucess();
		Add.recipient();
		Add.VerifyAddRecipientSucess();
		Drag.draging();
		Drag.VerifyDragSucess();
		send.submit();
	}

	// Add recipient
	@Test
	public void verifyAddRecipient() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		UploadFile.uploadFile();
		Add.recipient();
		Add.VerifyAddRecipientSucess();
		// Add.receiver();
		// Add.Details();

	}

	// fields Drag And Drop
	@Test
	public void drags() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		UploadFile.uploadFile();
		UploadFile.VerifyFileUploadSucess();
		Add.recipient();
		Add.VerifyAddRecipientSucess();
		Drag.draging();
		Drag.VerifyDragSucess();
		send.submit();
	}
	//Entity Feilds Drag and Drop
	@Test
	public void dragEntityFeilds() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		UploadFile.uploadFile();
		UploadFile.VerifyFileUploadSucess();
		Add.recipient();
		Add.VerifyAddRecipientSucess();
		Drag.entityFeilds();
		Drag.VerifyDragSucess();
		send.submit();
	}

	// recipients multiple add
	@Test
	public void mulRecipients() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		UploadFile.uploadFile();
		Add.mulRecipient();
		Drag.VerifyDragSucess();
		send.submit();
	
	}

	// Add multiple files
	@Test
	public void multifiles() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		UploadDocumentFromPC.CreateDoc();
		UploadDocumentFromPC.VerifyCreateDocSucess();
		mulupload.uploadFile();
		Add.mulRecipient();

	}

	// Dashboard
	@Test
	public void Db() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Alldoc();
//		dashboard.VerifyAlldocClick();
//		dashboard.waitingForMe();
//		dashboard.VerifywaitingForMeClick();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.completed();
//		dashboard.VerifyCompleteClick();

	}

	// Drafts
	// Actions
	// Drafts-send Document
	@Test
	public void DSendDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.DSendDoc();
		send.submit();
		send.Verifysubmit();
	}

	// Drafts-Save As Template
	@Test
	public void SaveAsTemp() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.draftSaveAsTemplate();
		dashboard.VerifyClickSaveAsTemplate();
	}

	// Drafts-Rename Document
	@Test
	public void Rename() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.DraftsRename();
		dashboard.VerifyRenameDoc();
	}

	// Drafts-Document Settings
	@Test
	public void docSetting() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.DraftDocSettings();
		dashboard.VerifyDocSettings();
	}

	// Drafts-Delete Document
	@Test
	public void delete() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.DraftdeleteDoc();
		dashboard.VerifyDeleteDoc();
	}

	// Drafts-Download original
	@Test
	public void Downloadorg() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.Draft();
		dashboard.VerifyDraftsClick();
		dashboard.DraftdownloadOriginal();
	}

	// completed
	// Actions
	// Download original
	@Test
	public void comDownloadOriginal() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.comDownloadOriginal();
	}

	@Test
	public void comDownloadDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.comDownloadDoc();
	}
	//Actions
	// completed- SAVE AS TEMPLATE
	@Test
	public void com() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.comsaveAsTemplate();
		dashboard.VerifyClickSaveAsTemplate();
	}
	//completed-Rename
	@Test
	public void comRename() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.completedDocRename();
		dashboard.VerifyRenameDoc();
	}
	//completed-Clone
	@Test
	public void comClone() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.CompletedClonedoc();
		dashboard.VarifyCompletedClonedoc();
		send.submit();
		send.Verifysubmit();
	}
	//completed-Download Document
	@Test
	public void completedDownloadDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.compDocDownloadDoc();
	}


	//completed-Delete Document
	@Test
	public void completedDeleteDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.CompleteddeleteDoc();
		dashboard.VerifyDeleteDoc();
	}
	//completed-Download Original
	@Test
	public void completedDownloadOrginalDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.completeddownloadOriginal();
	}
	//completed--Send to Mail
	@Test
	public void completedSentToMail() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.completed();
		dashboard.VerifyCompleteClick();
		dashboard.CompletedSendToMail();
	}
	//completed-



	// Waiting For ME
	// The case in which there are fields in a document which was sent by the sender and to be filled by the sender
	// Actions

	//Waiting For ME-correct Document
	@Test
	public void WFMcorrectDocument() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.correctDoc();
		send.submit();
		send.Verifysubmit();
	}

// Waiting For ME-Resend
	@Test
	public void WFMResend() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMresend();
		dashboard.VerifyResendDoc();

	}
	// Waiting For ME-Save As Template
	@Test
	public void WFM() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMSaveAsTemplate();
		dashboard.VerifyClickSaveAsTemplate();
	}
	// Waiting For ME-void Document
	@Test
	public void WFMvoidDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMVoidDoc();
		dashboard.VerifyVoidDoc();
	}
	// Waiting For ME-Rename
	@Test
	public void WFMrename() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMRenameDoc();
		dashboard.VerifyRenameDoc();
	}
	// Waiting For ME-document Settings
	@Test
	public void WFMdocSettings() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMDocSettings();
		dashboard.VerifyDocSettings();
	}
	// Waiting For ME-Delete Document
	@Test
	public void WFMdeleteDoc() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMDelDoc();
		dashboard.VerifyDeleteDoc();
	}

	// Waiting For ME-Download Original
	@Test
	public void WFmdownloadOriginal() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.WFMdownloadDoc();
	}
	//the case in which the file sent by the receiver
	// Waiting For ME-Download Original
	@Test
	public void dwnldOriginal() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		dashboard.waitingForMe();
		dashboard.VerifywaitingForMeClick();
		dashboard.wFMdownloadOriginal();
	}


	//waiting for others
		// Actions
		// waiting for others-correct document
		@Test
		public void waitforOthers() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.correctDoc();
			send.submit();
			send.Verifysubmit();
		}

		// waiting for others-resend
		@Test
		public void dbSentResend() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.resend();
			dashboard.VerifyResendDoc();
		}

		// waiting for others-saveAsTemplate
		@Test
		public void dbsaveAsTemp() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.saveAsTemplate();
			dashboard.VerifyClickSaveAsTemplate();
		}

		// waiting for others-void Document
		@Test
		public void voidDoc() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.voidDoc();
			dashboard.VerifyVoidDoc();
		}

		// waiting for others-Rename
		@Test
		public void rename() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.rename();
			dashboard.VerifyRenameDoc();
		}

		// waiting for others-document Settings
		@Test
		public void docSettings() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.docSettings();
			dashboard.VerifyDocSettings();
		}

		// waiting for others-Delete Document
		@Test
		public void deleteDoc() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.deleteDoc();
			dashboard.VerifyDeleteDoc();
		}

		// waiting for others-Download Original
		@Test
		public void downloadOriginal() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.waitOthers();
			dashboard.VerifyWaitingForOthersClick();
			dashboard.downloadOriginal();
		}
		//expiring soon -correct Document
		@Test
		public void expSooncorrectDocument() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSooncorrectDocument();
			send.submit();
			send.Verifysubmit();
		}
		// expiring soon- Resend
		@Test
		public void expSoonResend() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.resendDocument();
			dashboard.VerifyResendDoc();
		}

		// expiring soon-Save As Template
		@Test
		public void expSoonSaveAsTemplate() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoonSaveAsTemplate();
			dashboard.VerifyClickSaveAsTemplate();
		}
		// expiring soon-Void Document
		@Test
		public void expSoonVoidDoc() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoonvoidDocument();
			dashboard.VerifyVoidDoc();
		}
		// expiring soon-Rename
		@Test
		public void expSoonRename() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoonRename();
		}
		// expiring soon-DOcument Settings
		@Test
		public void expSoonDocSettings() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoonDocSettings();
			dashboard.VerifyDocSettings();
		}
		// expiring soon-Delete Document
		@Test
		public void expSoonDeleteDoc() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoondeleteDoc();
			dashboard.VerifyDeleteDoc();
		}
		// expiring soon-Download Original
		@Test
		public void expSoondownloadOriginal() throws Exception {
			Loginpage.Signin();
			Loginpage.VerifyLoginSucess();
			dashboard.expSoon();
			dashboard.VerifyExpSoonClick();
			dashboard.expSoondownloadOriginal();
		}
	// Workflows
	// Create Workflow
	@Test
	public void Createworkflow() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.createWF();
		WF.VerifyClickCreateWF();
		WF.WFDetails();
		WF.VerifyWFDetails();
		WF.AddFiles();
		WF.VerifyAddFiles();
		WF.AddRecipient();
		WF.VerifyAddRecipients();
		WF.sendWF();
		WF.VerifySendWF();
	}

	// Edit
	@Test
	public void workflowActionEdit() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.actionEdit();
		WF.VerifyEditSuccess();
		WF.AddFiles();
		WF.VerifyAddFiles();
		WF.AddRecipient();
		WF.previewWF();
		WF.VerifySendWF();
	}

//	ViewData
	@Test
	public void workflowactionViewData() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.actionViewData();
		WF.VerifyViewWFDataSuccess();
	}

//	actionRename
	@Test
	public void workflowActionRename() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.actionRename();
		WF.VerifyRenameSuccess();
	}

//	actionInactive
	@Test
	public void workflowaction() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.actionInactive();
		WF.VerifyInactiveSuccess();
	}

//status
	@Test
	public void workflow() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.status();

	}

	// preview
	@Test
	public void workflowpreview() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.createWF();
		WF.WFDetails();
		WF.AddFiles();
		WF.VerifyAddFiles();
		WF.AddRecipient();
		WF.previewWF();
		WF.VerifySendWF();
	}

	// enforce
	@Test
	public void enforce() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.createWF();
		WF.VerifyClickCreateWF();
		WF.WFDetails();
		WF.AddFiles();
		WF.VerifyAddFiles();
		WF.AddRecipient();
		WF.enforce();
		WF.sendWF();
		WF.VerifySendWF();

	}

	// PrimaryUser
	@Test
	public void primaryUser() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.createWF();
		WF.VerifyClickCreateWF();
		WF.WFDetails();
		WF.primaryUser();
		WF.sendWF();
		WF.VerifySendWF();
	}

	// AddGroup
	@Test
	public void AddGroup() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.createWF();
		WF.VerifyClickCreateWF();
		WF.addGroup();
		WF.AddFiles();
		WF.VerifyAddFiles();
		WF.AddRecipient();
		WF.sendWF();
		WF.VerifySendWF();

	}

	// SelectGroup
	@Test
	public void selectGroup() throws Exception {
		Loginpage.Signin();
		Loginpage.VerifyLoginSucess();
		WF.clickWF();
		WF.VerifyClickWF();
		WF.selectGroup();
		WF.VerifySendWF();
	}
//	@AfterMethod
//	public void cleanUp() {
//		driver.quit();
//	}
}
