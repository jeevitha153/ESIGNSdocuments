package TestCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.Contacts;
import Pages.Login;
import Pages.Recieverfieldsfill;
import Pages.Uploaddocuments;
import Pages.addrecipients;
import TestBase.testCaseBase;

public class LoginPageTest extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	addrecipients Addrecipients;
	Recieverfieldsfill recieverfieldsfill;
	Contacts contacts;
	@BeforeMethod
	public void intilize() {
		setup();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments =new Uploaddocuments(driver);
		Addrecipients =new addrecipients(driver);
		recieverfieldsfill=new Recieverfieldsfill(driver);
		contacts=new Contacts(driver);
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
	//contacts.contactssearch();
	//contacts.addcontacts();
	//contacts.contacttypespage();
	//contacts.entercontacttype();
	//contacts.selectcontacts();
	//contacts.createcontacts();
	//contacts.delcontacts();
	//contacts.editcontacts();
	//contacts.viewdocument();
	//contacts.Voiddoc();
	contacts.importcontacts();
	contacts.importcontactsdraganddrop();

	
}

	
	


}



