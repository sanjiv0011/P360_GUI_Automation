package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_ChangeCardNumber;
import com.p360.userdesktop.Utilities.ReadCardDetailsFromPropertiesFiles;



public class TC_ChangeCardDetails extends BaseClass {
		
	@Test(priority =1)
	public void test_ChangeCardDetails() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// to instantiate the PO_ChangeCardNumber constructor
		PO_ChangeCardNumber ccn  = new PO_ChangeCardNumber(driver);
		
		// Login application
		ccn.login(email, password);
		
		
		// Checking login confirmation
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Welcome"))
		{
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Login success...");
		}
		else
		{
			Thread.sleep(2000);
			captureScreen(driver,"test_Login");  // from base class
			Assert.assertTrue(false);
			logger.info("Login failed!!!");
		}
		
	
		
		// to read card details from the properties files
		ReadCardDetailsFromPropertiesFiles rcdfpf = new ReadCardDetailsFromPropertiesFiles();

			ccn.changeCardDetails2(rcdfpf.getCardName());
	
			if(driver.getPageSource().contains("Welcome"))
			{
				Thread.sleep(2000);
				Assert.assertTrue(true);
				logger.info("Card details changed...");
			}
			else
			{
				Thread.sleep(2000);
				captureScreen(driver,"test_ChangeCardDetails");  // from base class
				Assert.assertTrue(false);
				logger.info("Failed to changed card details!!!");
				
			}
		
		
	}
	

}
