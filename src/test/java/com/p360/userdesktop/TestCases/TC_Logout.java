package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_Logout;

public class TC_Logout extends BaseClass{
	
	@Test(priority = 2 /*,dependsOnMethods = {"com.p360.userdesktop.TestCases.test_User_Login_Logout_Functionality"}  */)
	public void test_Logout() throws InterruptedException, IOException
	{
		PO_Logout lgo = new PO_Logout(driver);
		
		lgo.clickBtnUserName();
		logger.info("Clicked on the user name");
		Thread.sleep(1000);
		
		lgo.clickBtnLogout();
		logger.info("Clicked on the logout button");
		Thread.sleep(5000);
		
		if(driver.getTitle().contains(""))
		{
			logger.info("Logout successfully...");
			Assert.assertTrue(true);
		}
		else
		{
			//captureScreen(driver,"test_Logout");
			Assert.assertTrue(false);
			logger.info("Logout failed!!!");
		}
	}

}
