package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard 
{
	@FindBy(xpath="//tr[@class=\"odd\"]//td[1] ")
	public static WebElement get_text;
}
