package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_ForgetPassword;

public class TC_ForgetPassword extends BaseClass {
	
	String oldEmail = "johnsmith141@yopmail.com"; // to change the password provide the email here 
	String newpassword = "Qwert4321!"; //  write the new password here
	
	@Test(priority =1)
	public void test_ForgetPassword() throws InterruptedException, IOException
	{
		PO_ForgetPassword fgp = new PO_ForgetPassword(driver);
		
		//driver.get(baseUrl); // it set in base class 
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		fgp.clickBtnLogin();
		Thread.sleep(5000);
		logger.info("Clicked on the login button");
		
		fgp.clickBtnForgetPassword();
		Thread.sleep(1000);
		logger.info("Clicked on forget password button");
		
		
		fgp.setEmail(oldEmail);
		Thread.sleep(2000);
		logger.info("Entered email");
		
		
		fgp.clickSendVerification();
		Thread.sleep(1000);
		logger.info("Clicked on send verification button");
		
		// thread the sleep for long time so that user can enter the code;
		Thread.sleep(45000);
		logger.info("Waiting for code verification");
		fgp.clickVerifyCode();
		Thread.sleep(10000);
		logger.info("Code verified ");
		
		
		fgp.clickContinueInBetween();
		Thread.sleep(5000);
		logger.info("Clicked on continue in-between button");
		
		fgp.setTextNewPwd(newpassword);
		Thread.sleep(2000);
		logger.info("Entered new password");
		
		fgp.setTextConfirmNewPwd(newpassword);
		Thread.sleep(2000);
		logger.info("Confirm new password");
		
		fgp.clickContinueFinal();
		Thread.sleep(5000);
		logger.info("Clicked on final continue button");
		
		
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
			captureScreen(driver,"test_ForgetPassword");
			logger.info("Screenshot taken");
		}
		
		
				
	}

}
