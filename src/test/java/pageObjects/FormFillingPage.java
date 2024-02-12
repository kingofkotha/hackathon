package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormFillingPage extends BasePage {

	public FormFillingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='FirstName']") WebElement FirstNameEle;
	@FindBy(xpath = "//input[@id='LastName']") WebElement LasttNameEle;
	@FindBy(xpath = "//input[@id='Email']") WebElement workemailEle;
	@FindBy(xpath = "//input[@placeholder='Country Code + Phone Number']") WebElement phoneEle;
	@FindBy(xpath="//select[@id='Institution_Type__c']") WebElement institutiontypeEle;
	@FindBy(xpath = "//input[@placeholder='Institution Name']") WebElement institutenamEle;
	@FindBy(xpath="//select[@id='Title']")WebElement jobroleEle;
	@FindBy(xpath="//select[@id='Department']")WebElement DepartmentEle;
	@FindBy(xpath="//select[@id='What_the_lead_asked_for_on_the_website__c']")WebElement needsEle;
	@FindBy(xpath="//select[@name='Country']") WebElement countryEle;
	@FindBy(xpath="//select[@name='State']") WebElement stateEle;
	@FindBy(xpath="//button[text()='Submit']") WebElement submitElement;
	@FindBy(xpath ="//div[@id='ValidMsgEmail']")WebElement errElement;

	
	public void Namefilling()
	{
		
		Scrollby(FirstNameEle);
		
		FirstNameEle.sendKeys("abc");
		LasttNameEle.sendKeys("abc");
		workemailEle.sendKeys("abc@gmail.com");
		phoneEle.sendKeys("9373672369");
		institutenamEle.sendKeys("abcd college");
		
		Select ss = new Select(institutiontypeEle);
		ss.selectByValue("2 Year College");
		
		Select ss2 = new Select(jobroleEle);
		ss2.selectByValue("Student");
		
		Select ss3 = new Select(DepartmentEle);
		ss3.selectByValue("Student Affairs");
		
		Select ss4 =  new Select(needsEle);
		ss4.selectByValue("Learner Support");
		
		Select ss5 =  new Select(needsEle);
		ss5.selectByValue("Learner Support");
		
		Select ss6 =  new Select(countryEle);
		ss6.selectByValue("India");
		
		Select ss7 =  new Select(stateEle);
		ss7.selectByValue("Karnataka");
		
		submitElement.click();
		
		
	}
	
	public void errormsgdisp()
	{
		String errormsg = errElement.getText();
		System.out.println(errormsg);
		
	}
	public boolean errormsg1()
	
	{
		boolean err = errElement.isDisplayed();
		System.out.println(err);
		return err;
	}
	
	public void scrolling_up() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
}
