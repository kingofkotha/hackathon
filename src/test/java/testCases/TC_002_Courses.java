package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Courses;
import testBase.BaseClass;
public class TC_002_Courses extends BaseClass {
	
	Courses cobj;
	@Test(priority=3)
	public void verify_SearchIcon()
	{
		logger.info("verify_SearchIcon started");

		try {
		cobj = new Courses(driver);
		if(cobj.verify_searchoption()) {
			System.out.println("Search icon is displayed");
			Assert.assertEquals(cobj.verify_searchoption(), true,"Search icon is displayed");
		}else {
			System.out.println("Search icon is not displayed");
			Assert.fail("Search icon is not displayed");
		}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Search icon is not displayed");
		}
		logger.info("verify_SearchIcon ended");

	}
	
	@Test(priority=4)
	public void search_courses() throws InterruptedException {
		logger.info("search_courses started");

		try {
		cobj.search_courses();
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("search_courses ended");

	}
	
	@Test(priority=5)
	public void select_levels() {
		logger.info("select_levels started");

		try {
		cobj.selecting_Levels();
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("select_levels ended");

	}
	
	@Test(priority=6)
	public void select_langs() {
		logger.info("select_langs started");

		try {
		cobj.selecting_Langs();
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("select_langs ended");

	}
	@Test(priority=7)
	public void scrollUp(){
		try {
			cobj.scrolling_up();
			}catch(Exception e) {
				Assert.fail();
			}
	}

}
