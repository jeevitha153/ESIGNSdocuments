package TestCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.Contacts;
import Pages.EmailTemplates;
import Pages.Login;
import Pages.Recieverfieldsfill;
import Pages.Uploaddocuments;
import Pages.addrecipients;
import Pages.documentsw4;
import TestBase.testCaseBase;

public class LoginPageTest extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	addrecipients Addrecipients;
	Recieverfieldsfill recieverfieldsfill;
	Contacts contacts;
	documentsw4 Documentsw4;
	EmailTemplates emailtemplates;
	@BeforeMethod
	public void intilize() {
		setup();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments =new Uploaddocuments(driver);
		Addrecipients =new addrecipients(driver);
		recieverfieldsfill=new Recieverfieldsfill(driver);
		contacts=new Contacts(driver);
		Documentsw4=new documentsw4(driver);
		emailtemplates=new EmailTemplates(driver);
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
	uploaddocuments.Fileupload();
	uploaddocuments.VerifyUpload();
}
@Test
public void AddingRecipients() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	alldocuments.Createdocument();
	alldocuments.Validdocument();
	uploaddocuments.Fileupload();
	uploaddocuments.VerifyUpload();
	Addrecipients.Recipients();
	Addrecipients.Verifrecipient();
}
	
	
@Test
public void Fieldsfillingfromreciever() throws Exception {
	recieverfieldsfill.loginmail();
	
}
@Test
public void ContactsModule() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	
}
@Test
public void ContactsSearch() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.contactssearch();
}

@Test
public void AddContacttype() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.addcontacts();
	contacts.contacttypespage(); 
	contacts.entercontacttype();
	contacts.VerifyContacttypeCreation();
}


@Test
public void Deletecontacttype() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.addcontacts();
	contacts.Contacttypedelete();
	contacts.Contacttypedeleteconfirm();
	contacts.VerifyContacttypedeletion();
}


@Test

public void Editcontacttype() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.addcontacts();
	contacts.Contacttypeedit();
	contacts.updatecontacttype();
	contacts.Contacttypeupdateconfirm();
	contacts.VerifyContacttypeupdating();
	
}
@Test

public void ContactBack () throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.addcontacts();
	contacts.contacttypespage(); 
	contacts.entercontacttype();
	contacts.VerifyContacttypeCreation();
	contacts.backtocontactspage();
	contacts.VerifyContactBack();
}
@Test

public void Selectcontact() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
    contacts.selectcontacts();
}
	
//	  contacts.createcontacts(); 

//	  contacts.delcontacts(); 
//	  contacts.editcontacts();
@Test

public void Viewdocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.viewdoc();
	contacts.documentstatus();
	contacts.viewdocumentselectsent();
	contacts.viewdocumentrename();
}
@Test
public void Viewdocumentcompleted() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.viewdoc();
	contacts.documentstatus();
	contacts.completeddoc();
	contacts.completeddocact();
	contacts.completeddocact1();
}
@Test
public void Viewdocumentvoided() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.viewdoc();
	contacts.documentstatus();
	contacts.viewdocumentselectvoided();
	contacts.VerifyVoidedDocument();
	contacts.delvoidaction();
	contacts.VerifyDelVoidDocument();
}

	//contacts.Voiddoc();

	  //contacts.delaction();
@Test

public void importingcontacts() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.importcontacts();
}
//	  contacts.importcontactsdraganddrop();
//	 contacts.completeddoc();
	
//	 contacts.completeddocact1();
//	 contacts.archiveddoc();
//	 contacts.archiveddocact1();
@Test
public void validationcontacts() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	contacts.contactsclick();
	contacts.VerifyContactsclickSuccess();
	contacts.createcontacts();
	contacts.fieldvalidations();
	contacts.fieldvalidation();
	

}

@Test
public void Documentsw4() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	alldocuments.Createdocument();
	alldocuments.Validdocument();
	uploaddocuments.Fileupload();
	uploaddocuments.VerifyUpload();
	Documentsw4.Recipients();
	Documentsw4.addfields();
	Documentsw4.DradAndDropAtTwo();
	Documentsw4.docfinal();
	Documentsw4.docsettings();
	Documentsw4.viewdoc();
	Documentsw4.textclear();
	
	
	}
@Test

public void emailtemplates() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	emailtemplates.emailtemplatesclick();
	emailtemplates.selectemailtemplate();
	emailtemplates.selectentities();
	emailtemplates.emailsearch();
	emailtemplates.selectemailtemplate1();
	emailtemplates.selectemailtemplate2();
	emailtemplates.createentityemailtemplate();
}

	
}

	
	






