package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.p360.userdesktop.PageObject.PO_Login;
import com.p360.userdesktop.PageObject.PO_Logout;


public class TC_Login extends BaseClass {
	
	//public String screenshotpath; // from base class
	
	@Test(priority = 1)
	public void test_Login() throws InterruptedException, IOException
	{
		//driver.get(baseUrl); // it set in base class 
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		PO_Login lgn = new PO_Login(driver);
		lgn.clickBtnLogin();
		logger.info("Driver click on login button");
		Thread.sleep(4000);
		
		driver.getCurrentUrl();
		Thread.sleep(4000);
		
		lgn.setTextemail(email);
		logger.info("Email entered");
		Thread.sleep(1000);
		
		lgn.setTextpassword(password);
		logger.info("Passwrod entered");
		Thread.sleep(1000);
		
		
		lgn.clickBtnsubmit();
		logger.info("Driver clicked on login submit button");
		Thread.sleep(15000);
		//driver.wait();
	
		
		if(driver.getPageSource().contains("Welcome"))
		{
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Login success...");
		}
		else
		{
			Thread.sleep(2000);
			logger.info("Start capturing screenshots");
			captureScreen(driver,"test_Login");  // from base class
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
			logger.info("Login failed!!!");
		}
	}
	
}
