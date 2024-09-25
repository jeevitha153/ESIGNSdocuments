package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.DocumentsScenarios;
import Pages.Entities;
import Pages.Login;
import TestBase.testCaseBase;

public class TestCasesEntity_meghana extends testCaseBase {
	Login login;
	Entities entities;
	DocumentsScenarios documentsScenarios;
	@BeforeMethod
	public void Start() {
		setUp();
		login = new Login(driver);
		entities = new Entities(driver);
		documentsScenarios = new DocumentsScenarios(driver);
	}



//	@Test
//	public void Bug4798() throws Exception {
//		login.login();
//		login.VerifyLoginSucess();
//		entities.entity();
//		entities.ClickCreateEntity();
//		entities.CreateEntityScratch();
//		entities.confirmButton();
//		entities.addtemplatesScratch();
//		entities.primaryFeild();
//		entities.clickAction();
//		entities.Done();
//		entities.ClickCreateEntity();
//		entities.CreateEntityScratch();
//		entities.entityTwo();
//		entities.confirmButton();
//		entities.addSecondtemplatesScratch();
//		entities.primaryFeild();
//		entities.Relationship();
//		entities.Customization();
//		entities.Done();
//		entities.actionView();
//		entities.addNewData();
//		entities.contactDetails2();
//		entities.back();
//		entities.EyeIcon();
//		entities.Bug4798();
//		entities.validSuccessBug4798();
//		
//	}
//	@Test
//	public void Bug4796() throws Exception{
//		login.login();
//		login.VerifyLoginSucess();
//		entities.formBuilder();
//		entities.clickAddFormBuilder();
//		entities.createFormBuilder();
//		entities.addTemplate();
//		entities.viewAction4796();
//		entities.sendFormBuilder();
//		entities.detailedView();
//		entities.validSuccessBug4796();
//	}
//	@Test
//	public void Bug4790() throws Exception{
//		login.login();
//		login.VerifyLoginSucess();
//		entities.entity();
//		entities.viewAction4790();
//		entities.filter4790();		
//	}
	@Test
	public void Bug4776() throws Exception{
		login.Signin();
		login.VerifyLoginSucess();
//		entities.FormTemplate();
//		entities.CreateFormtemplate();
//		entities.submit();
//		entities.Addbasicfields();
//		entities.save();
//		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.entity4776();
		entities.confirmButton();
		entities.VerifyconfirmSucess();
		entities.uploadFile();
		entities.nextButton();
		entities.VerifyNext();
		entities.plusIcon();
		entities.templateTwo4776();
		entities.primaryFeillsSelectCheckBox();
		entities.configureFeilds();
		entities.reviewImport();
		entities.x();
		entities.FormTemplate();
		entities.templateActionEdit();
		entities.SaveButton();
		entities.verify4776();
	}
	@Test
	public void Bug4775() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4775();
		entities.submit();
		entities.captchaFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4775();
		entities.confirmButton();
		entities.addtemplate4775();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.viewAction4775();
		entities.addNewData();
		entities.captchaFill();
	}
	@Test
	public void Bug3959() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template3959();
		entities.submit();
		entities.passwordFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity3959();
		entities.confirmButton();
		entities.addtemplates3959();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction3959();
		entities.addNewData();
		entities.fillPasswordFeild();
		entities.validBug3959();
	}
	
	@Test(priority =1)
	public void Bug4758() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4758();
		entities.submit();
		entities.dateTimerangeDateRange();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4758();
		entities.confirmButton();
		entities.addtemplates4758();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction4758();
		entities.addNewData();
		entities.fillDateRange();
		entities.save();
		entities.back();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4758_1();
		entities.submit();
		entities.entityVariable();
		entities.repeatableTempPrimaryFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4758_1();
		entities.confirmButton();
		entities.addtemplates4758_1();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction4758_1();
		entities.addNewData();
		entities.contactDetails();
		entities.addData();
		entities.fillDateRange4758();
		entities.validSuccessBug4758();
	}
	@Test(priority =2)
	public void Bug4760() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.entity();
		entities.veiwAction4758_1();
		entities.addNewData();
		entities.contactDetails3();
		entities.addData();
		entities.fillDateRange4758();
		entities.EyeIcon();
		entities.layout();
		entities.validSuccessBug4760();
	}
	//hold
//	@Test
//	public void Bug4186() throws Exception {
//		login.Signin();
//		login.VerifyLoginSucess();
//		entities.entity();
//		entities.inspect1();
//	}
	
	
	@Test
	public void Bug4660() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4660();
		entities.submit();
		entities.Addbasicfields();
		entities.weekdayFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4660();
		entities.confirmButton();
		entities.addtemplates4660();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction4660();
		entities.filterWeekday();
	}
	@Test
	public void Bug4746() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4746();
		entities.submit();
		entities.Feild4746();
		entities.repeatableTempPrimaryFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4746();
		entities.confirmButton();
		entities.addtemplates4746();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction4746();
		entities.addNewData();
		entities.uploadFile4746();
		entities.validSuccessBug4746();
	}
	@Test
	public void Bug3994() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template3994();
		entities.submit();
		entities.documentFeild();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity3994();
		entities.confirmButton();
		entities.addtemplates3994();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template3994_1();
		entities.submit();
		entities.entityVariable();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity3994_1();
		entities.confirmButton();
		entities.addtemplates3994_1();
		entities.primaryFeild();
		entities.clickAction();
		entities.Done();
		entities.veiwAction3994_1();
		entities.addNewData();
		entities.contactDetails();
		entities.valid3994();
	}
	@Test
	public void Bug4042() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4042();
		entities.submit();
		entities.radioGroupFeild();
		entities.companyProfile();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4042();
		entities.confirmButton();
		entities.addtemplates4042();
		entities.primaryFeild();
		entities.x();
		entities.clickAction();
		entities.Done();
		entities.veiwAction4042();
		entities.addNewData();
		entities.contactDetails();
		entities.back();
		entities.clickTemplate();
		entities.createTemplate();
		entities.addRecipient();
		entities.radioFeildDragInTemplate();
		entities.CreateDocFromTemp();
		entities.receiver();
		entities.Senddoc();
	}
	@Test
	public void Bug4022() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.template4022();
		entities.submit();
		entities.hyperLinkfields();
		entities.x();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4022();
		entities.confirmButton();
		entities.addtemplates4022();
		entities.primaryFeild();
		entities.x();
		entities.clickAction();	
		entities.Done();
		entities.veiwAction4022();
		entities.addNewData();
		entities.validSuccessBug4022();
	}
	@Test
	public void Bug4004() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.entity();
		entities.ClickCreateEntity();
		entities.CreateEntityScratch();
		entities.entity4004();
		entities.confirmButton();
		entities.validSuccessBug4004();
	}
}



