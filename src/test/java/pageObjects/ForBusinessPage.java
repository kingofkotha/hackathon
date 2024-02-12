package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForBusinessPage extends BasePage{

	public ForBusinessPage(WebDriver driver) {
		super(driver);
	}
	
	//elements
	//@FindBy(xpath = "//a[@href='https://www.coursera.org/campus']") WebElement ForUniversitiesEle;
	@FindBy(xpath = "//a[@class='cds-119 cds-113 cds-115 css-v9xlsv cds-142' and text()='Solutions']")WebElement solutionsElement;
	@FindBy(xpath = "//p[text()='Coursera for Campus']")WebElement ForCampusEle;
	@FindBy(xpath = "(//span[@class='cds-button-label'][normalize-space()='Contact us'])[1]") WebElement contactusEle;
	
	
	
	//action methods
	
	
	public void navigatetoform() 
	{
		solutionsElement.click();
		ForCampusEle.click();
//		contactusEle.click();
	}
}
