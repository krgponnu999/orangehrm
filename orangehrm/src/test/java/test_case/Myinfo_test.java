package test_case;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common_functions.common_code;
import page_object.Myinfo_page;

public class Myinfo_test extends common_code
{
	public static Logger log = Logger.getLogger(Myinfo_test.class);

	public void add_photo() throws IOException, InterruptedException 
	{
		PageFactory.initElements(driver,Myinfo_page.class);
		test.log(Status.PASS,"Myinfo Page Loaded");
		test.info("Enter into myinfo page");
		log.info("Enter into myinfo page");
		Myinfo_page.myscr.click();
		test.info("And Click Profile To Add photo");
		log.info("And Click Profile To Add photo");
		Myinfo_page.click_profile.click();
		Actions action = new Actions(driver);
		action.click(Myinfo_page.click_photo).build().perform();
		Runtime.getRuntime().exec("C:\\Users\\krgpo\\OneDrive\\Documents\\imagefile.exe");
		Thread.sleep(5000);
		Myinfo_page.upload.click();
		test.info("Successfully Profile is Uploaded");
		log.info("Profile uploaded");


	}




	@Test
	public void screen() throws IOException, InterruptedException 
	{   
		test = reports.createTest("Navigating to Myinfo Page");
		add_photo();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scr = screenshot.getScreenshotAs(OutputType.FILE);
		File f = new File("D:\\screesnshot\\image.png");
		FileUtils.copyFile(scr, f);
	}

}
