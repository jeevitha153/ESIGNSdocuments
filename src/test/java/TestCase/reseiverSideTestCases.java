package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Recieverfieldsfill;
import TestBase.ReceiverBase;

public class reseiverSideTestCases extends ReceiverBase {
	Recieverfieldsfill recieverfieldsfill;

	@BeforeMethod
	public void intilize() {
		setup();
		recieverfieldsfill = new Recieverfieldsfill(driver);
		
	}

@Test
public void Fieldsfillingfromreciever() throws Exception {
	recieverfieldsfill.loginmail();
}
	
}
