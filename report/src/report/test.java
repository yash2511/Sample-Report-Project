package report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	 WebDriver driver;
	 Report objReport = new Report();
	
	
	@Test
	public void setup()
	{
		objReport.startReport();
		objReport.startTest("test");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String office365 = Testcapture.capturescreenshot(driver, "Office365");
		
		objReport.attachScreenshot("Google", office365);
		
		
	}
	@AfterTest
	public void endTest() {
		driver.close();
		driver.quit();
		objReport.endTest("End");

	}
}
