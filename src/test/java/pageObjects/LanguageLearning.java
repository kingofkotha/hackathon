package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguageLearning extends BasePage {
	
	public LanguageLearning(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder=\"What do you want to learn?\"]")
	WebElement inputBox;
	
	@FindBy(xpath="//button[@aria-label=\"Show more Language options\"]")
	WebElement langShowmore;
		
	@FindBy(xpath="(//div[@class='cds-227 cds-formGroup-groupWrapper'])[3]//div[contains(@class, 'css-zf4w52')]/label/span/span/input")
    List<WebElement> total_levels;
	
	@FindBy(xpath="//h2[@role='heading']/div/span")
	WebElement heading;
	
	@FindBy(xpath="//div[contains(@data-testid,'search-filter-group-Level')]//div[contains(@class,'css-wns57a')]//div[contains(@class,'cds-formGroup-groupWrapper')]//div[contains(@class,'css-zf4w52')]//label/div/span")
	List<WebElement> Alllevels;


	//search for Language Learning
	public void search_Language() throws InterruptedException {
		Thread.sleep(5000);
		Courses cobj = new Courses(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		inputBox.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		inputBox.sendKeys("Language Learning");
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", cobj.searchBtn);
		
	}
	
	
	
	//click on show more from language for level Beginner
	public void clickShow_Languages() throws InterruptedException
	{
		//clicking on show more
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement lang = waits.until(ExpectedConditions.visibilityOf(langShowmore));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", langShowmore);
		
	}
	
	//Printing total levels available
	public void select_levels() {
		List<WebElement> totalLevels =  total_levels;
		for(int i=0;i<1;i++)
		{
			//checking if selected 
			if(!totalLevels.get(i).isSelected()) {
				totalLevels.get(i).click();
				System.out.println("Level Selected:"+totalLevels.get(i).getText());
			}
			
		}
	}
	//scrolling up
	public void scrolling_up() {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		}
		
	
	public void LanguageOne() throws InterruptedException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		for(WebElement ls: levels) {
			Thread.sleep(3000);
			
			String frstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			WebElement clickLang = driver.findElement(By.xpath("//div[@aria-label='Select Language options']/div[1]/label/div/span"));
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang.getText());
			js.executeScript("arguments[0].click();",clickLang);
			getLang=true;
						
			waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement applybtn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='scroll-container']/div[3]/button[1]")));
			applybtn.click();
			
			}		
			Thread.sleep(8000);	
			
			scrolling_up();
			
			System.out.println(getLang==true?"For: "+frstLevel:"");
			
			Pattern pattrn = Pattern.compile(" ");
			String[] matche;
			Thread.sleep(5000);
			matche = pattrn.split(heading.getText());
			System.out.println("Total Count: "+matche[0].trim());			
			js.executeScript("arguments[0].click();",ls);
			
		}
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(8));
		WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Clear all filters\"]")));
		js.executeScript("arguments[0].click();",btn);
	}
	

	public void LanguageTwo() throws InterruptedException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		Pattern pattern;
		String[] matches;
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		for(WebElement ls: levels) {
			Thread.sleep(2000);
			
			String frstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			WebElement clickLang = driver.findElement(By.xpath("//div[@aria-label='Select Language options']/div[2]/label/div/span"));
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang.getText());
			js.executeScript("arguments[0].click();",clickLang);
			getLang=true;
						
			waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement applybtn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='scroll-container']/div[3]/button[1]")));
			applybtn.click();
			
			}		
			Thread.sleep(8000);	
			
			
			scrolling_up();
			
			System.out.println(getLang==true?"For: "+frstLevel:"");	 
			pattern = Pattern.compile(" ");
			Thread.sleep(5000);
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());			
			js.executeScript("arguments[0].click();",ls);
			
		}
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Clear all filters\"]")));
		js.executeScript("arguments[0].click();",btn);
	}

	public void LanguageThird() throws InterruptedException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		Pattern pattern;
		String[] matches;
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		for(WebElement ls: levels) {
			Thread.sleep(2000);
			scrolling_up();
			String frstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			WebElement clickLang = driver.findElement(By.xpath("//div[@aria-label='Select Language options']/div[6]/label/div/span"));
			System.out.println(clickLang.getText());
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang.getText());
			js.executeScript("arguments[0].click();",clickLang);
			getLang=true;
						
			waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement applybtn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='scroll-container']/div[3]/button[1]")));
			applybtn.click();
			
			}		
			Thread.sleep(8000);	
		
			scrolling_up();
			
			System.out.println(getLang==true?"For: "+frstLevel:"");	 
			pattern = Pattern.compile(" ");
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());			
			js.executeScript("arguments[0].click();",ls);
			
		}
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Clear all filters\"]")));
		js.executeScript("arguments[0].click();",btn);
	}
	public void LanguageFourth() throws InterruptedException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		Pattern pattern;
		String[] matches;
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		for(WebElement ls: levels) {
			Thread.sleep(2000);
			scrolling_up();
			String frstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			WebElement clickLang = driver.findElement(By.xpath("//div[@aria-label='Select Language options']/div[4]/label/div/span"));
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang.getText());
			js.executeScript("arguments[0].click();",clickLang);
			getLang=true;
						
			waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement applybtn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='scroll-container']/div[3]/button[1]")));
			applybtn.click();
			
			}		
			Thread.sleep(8000);	
		
			scrolling_up();
			
			System.out.println(getLang==true?"For: "+frstLevel:"");	 
			pattern = Pattern.compile(" ");
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());			
			js.executeScript("arguments[0].click();",ls);
			
		}
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Clear all filters\"]")));
		js.executeScript("arguments[0].click();",btn);
	}
	
	public void LanguageFifth() throws InterruptedException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		Pattern pattern;
		String[] matches;
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		for(WebElement ls: levels) {
			Thread.sleep(2000);
			scrolling_up();
			String frstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			WebElement clickLang = driver.findElement(By.xpath("//div[@aria-label='Select Language options']/div[5]/label/div/span"));
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang.getText());
			js.executeScript("arguments[0].click();",clickLang);
			getLang=true;
						
			waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement applybtn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='scroll-container']/div[3]/button[1]")));
			applybtn.click();
			
			}		
			Thread.sleep(8000);	
		
			scrolling_up();
			
			System.out.println(getLang==true?"For: "+frstLevel:"");	 
			pattern = Pattern.compile(" ");
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());			
			js.executeScript("arguments[0].click();",ls);
			
		}
		
		waits = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement btn = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Clear all filters\"]")));
		js.executeScript("arguments[0].click();",btn);
	}

}
