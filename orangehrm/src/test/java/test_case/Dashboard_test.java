package test_case;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common_functions.common_code;
import page_object.Dashboard;

public class Dashboard_test extends common_code
{
	public static Logger log = Logger.getLogger(Dashboard_test.class);

	@Test
	public void dash()
	{
		test = reports.createTest("navigating to dashboard");
		PageFactory.initElements(driver,Dashboard.class);
		test.log(Status.PASS,"Successfully Enter int dahboard page");
		String actual_test =  Dashboard.get_text.getText();
		test.info("Getting The Text And Verifing");
		System.out.println(actual_test);
		log.info("before varification of text in dashboard");
		Assert.assertEquals(actual_test , "No Records are Available");
		test.info("Test Verification Done And It passes");
//		Assert.fail();
		log.info("after varification of text in dashboard");
	}
}
