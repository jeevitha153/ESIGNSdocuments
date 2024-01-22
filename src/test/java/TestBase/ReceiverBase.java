package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReceiverBase {
	protected WebDriver driver;

	public void setup() {

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.esigns.io/emp-documents/preview/659c15d09a7cf5f5136dac87/pp/vp/651bfdd60399937d1d5c74d4?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBfZG9jdW1lbnRfaWQiOiI2NTljMTVkMDlhN2NmNWY1MTM2ZGFjODciLCJwYXNzY29kZSI6Im1lcGxhYyIsIndvcmtmbG93X2lkIjpudWxsLCJpYXQiOjE3MDQ3MjgwMTcsImV4cCI6MTcwNDkwMDgxN30.qBVYzWQdkjeIPhQ63oZCXHh-Qa-v1Qf-TQMVF67ugrk");

	}
}

