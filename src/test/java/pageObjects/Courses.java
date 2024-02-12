package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Courses extends BasePage {
	
	public Courses(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@role=\"textbox\"]")
	WebElement takeInput;
	
	@FindBy(xpath="//button[@class=\"nostyle search-button\" and @aria-label=\"Submit Search\"]")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[starts-with(@placeholder,'What do you')]")
	WebElement searchOption;
	
	@FindBy(xpath="//*[(text()='Beginner')]")
	WebElement levelBeginner;
	
	@FindBy(xpath="(//span[text()=\"English\"])[1]")
	WebElement langEng;
	
	
	
	//verify searchOption is displayed
	public boolean verify_searchoption() throws InterruptedException {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(0));
		try {
			WebElement icon = waits.until(ExpectedConditions.visibilityOf(searchOption));
			if(icon.isDisplayed()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	
	//Search for courses
	public void search_courses() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", takeInput);
		takeInput.sendKeys("web development courses");
	    Thread.sleep(5000);
	    js.executeScript("arguments[0].click();", searchBtn);
	}
	
	//Selecting Level as Beginner if not selected
	public void selecting_Levels() {
		try {
			if(!levelBeginner.isSelected()) {
				System.out.println("Beginner Level is clicked");
				levelBeginner.click();
			}else {
				System.out.println("Beginner Level is not clicked");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Selecting English Language
	public void selecting_Langs() {
		
		try {
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(8));
			WebElement lang = waits.until(ExpectedConditions.visibilityOf(langEng));
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			
			if(!lang.isSelected()) {
			js.executeScript("arguments[0].click();", lang);
			System.out.println("English Language is clicked");
			}
			else {
				System.out.println("English Language is not clicked");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//scrolling up
		public void scrolling_up() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	

}
