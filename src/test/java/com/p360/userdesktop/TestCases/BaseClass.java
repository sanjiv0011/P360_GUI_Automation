package com.p360.userdesktop.TestCases;

import java.io.File;
import java.io.IOException;
/*import java.text.SimpleDateFormat;
import java.util.Date;
*/
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;
import com.p360.userdesktop.Utilities.ReadConfigFiles;

public class BaseClass {
	
	public static WebDriver driver;
	
	// logger to log the messages
	public  Logger logger = LogManager.getLogger(this.getClass());
	
	
	// to read the file from utilities.ReadConfigFiles
	ReadConfigFiles rcf = new ReadConfigFiles();
	public String baseUrl = rcf.getApplicationUrl();
	public String email = rcf.getEmail();
	public String password = rcf.getPassword();	
	
	// screenshots path 
	public String screenshot_path;
	
	
	// to generate random data
	public Faker faker = new Faker();
	
	// to select the driver
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger.info("Base class started...");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chromedriver",rcf.getChromePath());
			
			// for headless browsing
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless=chrome");
			driver = new ChromeDriver();
			
			logger.info("Chrome driver selected");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver",rcf.getFireFoxPath());
			driver = new FirefoxDriver();
			logger.info("Fire fox driver selected");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.msedgedriver",rcf.getMsEdgePath());
			driver = new EdgeDriver();
			logger.info("Edge driver selected");
		}
		driver.get(baseUrl);
		Thread.sleep(5000);
		
	}
	
	
	
	// to stop the driver
	@AfterClass
	public void teardown()
	{
		driver.quit();
		logger.info("Driver shutdown");
	}
	
	


	// to capture the screenshots
	public String captureScreen(WebDriver driver, String targetName) throws IOException
	{
		String repName;
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "_Screenshots" /*+ timeStamp*/ + ".png";
        screenshot_path = System.getProperty("user.dir")+"//Screenshots//"+targetName+repName;
        
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(screenshot_path);
		
		FileUtils.copyFile(source, target);
		//System.out.println("Screenshots taken and return path is "+screenshot_path);
		return screenshot_path;
		
	}

	
	
	// to generate random string 
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}
	
	
	// to generate random String number with specfic digit length
	public String randomStringNumber(int max, int min)
	{
		String rdmStringNumber = RandomStringUtils.randomNumeric(min, max);
		return rdmStringNumber;
	}
	
	
	
	
	
	
}
