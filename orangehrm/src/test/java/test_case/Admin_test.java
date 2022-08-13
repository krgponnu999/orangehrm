package test_case;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common_functions.common_code;
import page_object.Admin_page;

public class Admin_test extends common_code
{

	public static Logger log = Logger.getLogger(Admin_test.class);
	public void admin_setup ()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(Admin_page.admin_icon);
		actions.moveToElement(Admin_page.usermanagement_icon);
		actions.moveToElement(Admin_page.user_icon);
		actions.click().build().perform();
		test.log(Status.PASS,"Admin Page Loaded");
		test.info("Enters into Admin Page");
		log.info("user icon is clicked");
	}
	public void select_tag() 
	{
		Select select = new Select(Admin_page.user_role_icon);
		select.selectByIndex(1);
		test.info("admin is selected in user role dropdown");
		log.info("admin is selected in user role dropdown");
	}
	public void select_tag_two() 
	{
		Select sel = new Select(Admin_page.status);
		sel.selectByIndex(1);
		test.info("enabled is selected in status dropdown");
		log.info("enabled is selected in status dropdown");
	}
	public void click_search_button() 
	{
		Admin_page.search_button.click();
		test.info("search button is clicked");
		log.info("search button is clicked");
	}
	public void get_text() 
	{
		String text1 =  Admin_page.user_role_text.getText();
		System.out.println(text1);
		assertEquals(text1,"Admin");
		log.info("verification of user role text");
		String text2 = Admin_page.status_text.getText();
		System.out.println(text2);
		assertEquals(text2,"Enabled");
		log.info("verification of status text");
	}
	@Test
	public void to_write_user_role() throws InterruptedException
	{
		test = reports.createTest("Navigating to Admin Page");
		PageFactory.initElements(driver, Admin_page.class);
		admin_setup();
		select_tag();
		select_tag_two();
		click_search_button();
		get_text();
		
		
	}
}
