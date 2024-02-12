package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.WebDevelopmentCourses;
import testBase.BaseClass;

public class TC_003_WebDevelopmentCourses extends BaseClass {
	
	WebDevelopmentCourses wobj;
	@Test(priority=8)
	public void course_name() {
		logger.info("course_name started");

		try {
			wobj = new WebDevelopmentCourses(driver);
			wobj.getFirstCourseDetails();
			wobj.getSecondCourseDetails();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
			
		}
		
		logger.info("course_name ended");

	}


}
