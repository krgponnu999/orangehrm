package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import common_functions.common_code;

public class Admin_page extends common_code
{
	@FindBy(xpath="//a[@id=\"menu_admin_viewAdminModule\"]")
	public static WebElement admin_icon;
	@FindBy(xpath="//a[@id=\"menu_admin_UserManagement\"]")
	public static WebElement usermanagement_icon;
	@FindBy(xpath="//a[@id=\"menu_admin_viewSystemUsers\"]")
	public static WebElement user_icon;
	@FindBy(xpath="//select[@id=\"searchSystemUser_userType\"]")
	public static WebElement user_role_icon;
	@FindBy(xpath="//select[@id=\"searchSystemUser_status\"]")
	public static WebElement status;
	@FindBy(xpath="//input[@id=\"searchBtn\"]")
	public static WebElement search_button;
	@FindBy(xpath="//tr[@class='odd']//td[3]")
	public static WebElement user_role_text;
	@FindBy(xpath="//tr[@class='odd']//td[5]")
	public static WebElement status_text;

	
	Actions actions = new Actions(driver);
	
	
	public void admin_choose()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(Admin_page.admin_icon);
		actions.moveToElement(Admin_page.usermanagement_icon);
		actions.moveToElement(Admin_page.user_icon);
		actions.click().build().perform();
			
		
	}
}
