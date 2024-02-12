package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDevelopmentCourses extends BasePage {
	
	public WebDevelopmentCourses(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='cds-ProductCard-content']//h3)[1]")
	WebElement CourseName;


	@FindBy(xpath = "(//*[@class=\"cds-119 css-11uuo4b cds-121\"])[1]")
	WebElement rating;

	@FindBy(xpath = "(//div[@class=\"cds-CommonCard-metadata\"]/p)[1]")
	WebElement duration;

	@FindBy(xpath = "(//div[@class='cds-ProductCard-content']//h3)[2]")
	WebElement CourseNames2;

	@FindBy(xpath = "(//*[@class=\"cds-119 css-11uuo4b cds-121\"])[2]")
	WebElement rating2;

	@FindBy(xpath = "(//div[@class=\"cds-CommonCard-metadata\"]/p)[2]")
	WebElement duration2;

	@FindBy(xpath = "(//div[@class='cds-227 cds-formGroup-groupWrapper'])[3]//div[contains(@class, 'css-zf4w52')]")
	List<WebElement> TotalLevels;

	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(2));
	Pattern pattern;
	String[] matches;

	public void getFirstCourseDetails() {
		
		try {
			WebElement courseN = waits.until(ExpectedConditions.visibilityOf(CourseName));
			WebElement ratings = waits.until(ExpectedConditions.visibilityOf(rating));

			System.out.println("Name of the Course:" + courseN.getText());
			System.out.println("Rating: " + ratings.getText());

			pattern = Pattern.compile(".·.");
			matches = pattern.split(duration.getText());

			System.out.println("Duration: " + matches[2].trim());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getSecondCourseDetails() {
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(0));
		try {
			WebElement courseN = waits.until(ExpectedConditions.visibilityOf(CourseNames2));
			WebElement ratings = waits.until(ExpectedConditions.visibilityOf(rating2));

			System.out.println("Name of the Course:" + courseN.getText());
			System.out.println("Rating: " + ratings.getText());

			pattern = Pattern.compile(".·.");
			matches = pattern.split(duration2.getText());

			System.out.println("Duration: " + matches[2].trim());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	


}
