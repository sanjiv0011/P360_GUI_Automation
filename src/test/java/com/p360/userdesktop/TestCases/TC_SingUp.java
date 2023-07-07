package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_SignUP;

public class TC_SingUp extends BaseClass{
	
	 
	@Test(priority =1)
	public void test_SignUp() throws InterruptedException, IOException
	{
		//driver.get(baseUrl); // it set in base class 
		driver.manage().window().maximize();
		Thread.sleep(2000);
				
		
		PO_SignUP sgn = new PO_SignUP(driver);
		
		sgn.clickBtnLogin();
		Thread.sleep(5000);
		logger.info("Clicked on the Login button");
		
		driver.getCurrentUrl();
		
		sgn.clickBtnSignup();
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		sgn.setTextFirstName(faker.name().firstName());
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		sgn.setTextLastName(faker.name().lastName());
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		
		sgn.setTextEmail(faker.internet().emailAddress());
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		final String  pwd = "Qwer4321!";
		sgn.setTextPassword(pwd);
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		sgn.setTextConfirmPassword(pwd);
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		sgn.clickBtnCreate();
		Thread.sleep(1000);
		logger.info("Clicked on sign up button");
		
		Thread.sleep(10000); // take longer time
		
		if(driver.getPageSource().contains("Welcome") || driver.getTitle().contains("Performance360 Home"))
		{
			Assert.assertTrue(true);
			logger.info("User sign up successfully...");
			
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("User sign up failed!!!");
			Thread.sleep(5000);
			logger.info("Start capturing screenshot");
			captureScreen(driver,"test_SignUp");
			logger.info("Screenshot taken");
		}
	}
}
