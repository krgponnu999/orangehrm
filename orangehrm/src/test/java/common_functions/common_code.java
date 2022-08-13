package common_functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class common_code
{

	public static WebDriver driver = null;
	public static Properties pros = null;
	public static Logger log = Logger.getLogger("common_code.class");
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;

	public Properties property_file() throws IOException 
	{
		File f = new File("config.properties");
		FileInputStream fis = new FileInputStream(f);
		pros = new Properties();
		pros.load(fis);
		return pros;
	}
	
	
	public void launch_url() throws IOException 
	{
		property_file();
		String url = pros.getProperty("url");
		String location = pros.getProperty("driverlocation");
		String browser = pros.getProperty("browser");
       
		test = reports.createTest("chromedriver has been launched");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",location);
			driver = new ChromeDriver();
			test.log(Status.PASS,"chrome driver launched successfully");
			log.info("chrome launched");
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.chrome.driver",location);
			driver = new ChromeDriver();
			test.log(Status.PASS,"Edge driver launched successfully");
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		log.info("url launched");

	}
	
}
