package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myinfo_page 
{
	@FindBy(id="menu_pim_viewMyDetails")
	public static WebElement myscr;
	@FindBy(id="empPic")
	public static WebElement click_profile;
	@FindBy(id="photofile")
	public static WebElement click_photo;
	@FindBy(id="btnSave")
	public static WebElement upload;
	
}



