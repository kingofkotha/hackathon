package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForEnterprisePage extends BasePage {

	public ForEnterprisePage(WebDriver driver) {
		super(driver);
	}
	
	//elements 
	
	@FindBy(xpath="//img[@alt='Coursera']")  WebElement courseraEle;
	@FindBy(xpath="//a[text()='For Enterprise']") WebElement ForEnterpriseEle;

	//action methods
	public void navigatetohome()
	{
		courseraEle.click();
	}
	
	public void clickEnterprise() 
	{	
		
		ForEnterpriseEle.click();
	}
}
