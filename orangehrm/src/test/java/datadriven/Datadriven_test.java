package datadriven;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import common_functions.common_code;

public class Datadriven_test extends common_code
{

	@Test(dataProvider = "dp")
	public void f(String n, String s)
	{
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys(n);
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys(s);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginbutton.click();
	}

	@DataProvider
	public Object[][] dp() throws IOException
	{
		Datadriven_class dc = new Datadriven_class("C:\\Users\\krgpo\\OneDrive\\Documents\\data2.xlsx");
		int totalrow = dc.rowcount(0);
		Object[][]data = new Object[totalrow][2];
		for(int i=0;i<totalrow;i++)
		{
			data[i][0] = dc.getdata(0, i, 0);
			data[i][1] = dc.getdata(0, i, 1);
		}
		return data;

	}

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void browser_launch() throws IOException 
	{
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("Extentreport.html");
		reports.attachReporter(htmlReporter);
		test = reports.createTest("launching orangehrm url");
		launch_url();
		test.log(Status.PASS,"url as been launched");
        log.info("orangehrm page is loaded");	
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().window().maximize();


	}
	@AfterSuite
	public void close_browser() 
	{
		reports.flush();
		//driver.quit();
	}
}
