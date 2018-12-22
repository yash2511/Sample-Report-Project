package report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {

	ExtentReports report;
	ExtentTest logger;
	Exception exe;

	public void startReport() {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.  HH.mm.ss").format(new Date());
		report = new ExtentReports ("C:\\Users\\Yashodip\\workspace\\report\\reportAutomation" + timeStamp + ".html", true);
		
		//report = new ExtentReports("C:\\Users\\Yashodip\\workspace\\report\\reportAutomation.html", true);

		report.loadConfig(
				new File("C:\\Users\\Yashodip\\workspace\\report\\ExtentReport-config.xml"));

	}

	public void startTest(String testName) {

		logger = report.startTest(testName);
	}

	public void stepPass(String stepName) {

		logger.log(LogStatus.PASS, stepName);
	}

	public void stepFail(String stepName) {

		logger.log(LogStatus.FAIL, stepName);

	}

	public void exceptionMessage(String exceptionMessage) {

		logger.log(LogStatus.FAIL, exceptionMessage);

	}

	public void attachScreenshot(String stepName, String screeShotPath) {

		logger.log(LogStatus.PASS, stepName, logger.addScreenCapture(screeShotPath));

	}

	public void stepSkip(String stepName) {

		logger.log(LogStatus.SKIP, stepName);

	}

	public void endTest(String stepName) {

		report.endTest(logger);
		report.flush();
		report.close();

	}

}