package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LanguageLearning;
import testBase.BaseClass;

public class TC_004_LanguageLearning extends BaseClass {

	@Test(priority=9)
	public void search_Language()
	{
		logger.info("search_Language started");
		try {
		LanguageLearning lobj=new LanguageLearning(driver);
		lobj.search_Language();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("search_Language ended");
	}
	
	@Test(priority=10)
	public void show_FirstCourses()
	{
		logger.info("show_FirstCourses started");
		try {
			LanguageLearning lobj=new LanguageLearning(driver);
			lobj.LanguageOne();
			
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		logger.info("show_FirstCourses ended");

	}
	
	@Test(priority=11)
	public void show_SecondCourses()
	{
		logger.info("show_SecondCourses started");
		try {
			LanguageLearning lobj=new LanguageLearning(driver);
			
			lobj.LanguageTwo();
			
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail();
					
			}
		logger.info("show_SecondCourses ended");

	}
	
	@Test(priority=12)
	public void show_ThirdCourses()
	{
		logger.info("show_ThirdCourses started");
		try {
			LanguageLearning lobj=new LanguageLearning(driver);
			
			lobj.LanguageThird();
			
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail();
			
			}
		logger.info("show_ThirdCourses ended");

	}
	
	@Test(priority=13)
	public void show_FourthCourses()
	{
		logger.info("show_FourthCourses started");
		try {
			LanguageLearning lobj=new LanguageLearning(driver);
			
			lobj.LanguageFourth();
			
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail();	
			}
		logger.info("show_FourthCourses ended");

	}
	
	@Test(priority=14)
	public void show_FifthCourses()
	{
		logger.info("show_FifthCourses started");
		try {
			LanguageLearning lobj=new LanguageLearning(driver);
			
			lobj.LanguageFifth();
			
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail();
		
			}
		logger.info("show_FifthCourses ended");

	}

	
}
