package report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Testcapture {
	public static String capturescreenshot(WebDriver driver, String screenshotname) {

		String imagelocation = System.getProperty("user.dir") + "\\MIR Screenshots\\";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Calendar calendare = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String actualimage = imagelocation + screenshotname + "_" + formater.format(calendare.getTime()) + ".png";

		try {
			FileUtils.copyFile(src, new File(actualimage));

		} catch (IOException e) {

			e.printStackTrace();
		}
		return actualimage;
	}
}
