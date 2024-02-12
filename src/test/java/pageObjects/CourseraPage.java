package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseraPage extends BasePage {
	
	public CourseraPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"surveyModal~title\"]")
	WebElement surveyyVisible;
	
	@FindBy(xpath="//img[@class=\"rc-CourseraLogo\"]")
	WebElement courseraLogo;
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/div[1]/div/div[2]/div[2]/div/button[1]")
	WebElement surveyThanks;
	
	//verify survey is displayed
	public void SurveyDisplay()
	{
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {
		WebElement surveyVisible = waits.until(ExpectedConditions.visibilityOf(surveyyVisible));
		if(surveyVisible.isDisplayed()) {
			System.out.println("Survey is displaying");
			WebElement surveyButton = waits.until(ExpectedConditions.visibilityOf(surveyThanks));	
		
			surveyButton.click();
			
		}else {
			System.out.println("Survey did not appear");
		}
		}catch(Exception e) {
			{
			System.out.println("Survey did not appear");
			}
		}
	}
	
	//verify CourseraPage is displayed
	public String Verify_CourseraPage() {
		String get_title = courseraLogo.getAttribute("alt");
		return get_title;
	}
	

}
