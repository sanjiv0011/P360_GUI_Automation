package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_Login;
import com.p360.userdesktop.PageObject.PO_Logout;

public class TC_Logout extends BaseClass{
	
	@Test(priority = 2 /*,dependsOnMethods = {"com.p360.userdesktop.TestCases.test_User_Login_Logout_Functionality"}  */)
	public void test_Logout() throws InterruptedException, IOException
	{
		//driver.get(baseUrl); // it set in base class 
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		// first perform login functionality
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
		
		
		// To perform the logout functionality
		PO_Logout lgo = new PO_Logout(driver);
		
		lgo.clickBtnUserName();
		logger.info("Clicked on the user name");
		Thread.sleep(1000);
		
		lgo.clickBtnLogout();
		logger.info("Clicked on the logout button");
		Thread.sleep(5000);
		
		if(driver.getTitle().equals(""))
		{
			logger.info("Logout successfully...");
			Assert.assertTrue(true);
		}
		else
		{	Thread.sleep(2000);
			logger.info("Start capturing screenshots");
			captureScreen(driver,"test_Logout");
			Thread.sleep(2000);
			Assert.assertTrue(false);
			logger.info("Logout failed!!!");
		}
	}
	

}
