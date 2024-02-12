package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	WebDriver driver;
	public Screenshots(WebDriver driver) {
		this.driver=driver;
	}
	
	public String screenShot(String ss) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\screenshots\\" + ss + ".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();
	}

}
