package com.p360.userdesktop.TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_DashBoard;
import com.p360.userdesktop.PageObject.PO_Login;

public class TC_ClickActionOnDashBoardElement extends BaseClass {

	
	public TC_ClickActionOnDashBoardElement()
	{
		super();
	}
	
	public PO_Login lgn;
	

	@Test(priority = 2)
	public void test_ClickActionOnDashBoardElement() throws InterruptedException, IOException
	{
		// First do the login
		lgn = new PO_Login(driver);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		lgn.login(email, password);
		captureScreen(driver, "test_ClickActionOnDashBoardElement");
		
		// initiate dash board page object constructor
		PO_DashBoard dashboard = new PO_DashBoard(driver);
		logger.info("PO_DashBoard Started");
		
		
		// to check dash board is open or not
		if(dashboard.verifyDashboard())
		{
			Assert.assertTrue(true);
			logger.info("Dashboard is Open");
			Thread.sleep(10000);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Dashboard is not open");
			Thread.sleep(5000);
		}
		
		// to click on the Dash board menu button
		dashboard.clickMenuDashBoard();
		logger.info("Clicked on Dashboard menu");
		Thread.sleep(10000);
		
		// to click on the membership menu button
		dashboard.clickMenuMembership();
		logger.info("Clicked on Membership menu");
		Thread.sleep(10000);
		
		
		// to click on the my classes menu button
		dashboard.clickMenuMyClasses();
		logger.info("Clicked on My classes menu");
		Thread.sleep(10000);
	
				
			
		dashboard.clickMenuDashBoard();
		logger.info("Clicked on Dashboard menu");
		Thread.sleep(5000);
		
		// to click on the manage membership menu button
		dashboard.clickManageMyMembership();
		logger.info("Clicked on Manage membership button");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
				
		
		// to click on the Next Class box
		dashboard.clickNextClass();
		logger.info("Clicked on Next class box link");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		
		
		// here driver transfer to new tab so navigate the correct tab
		Set<String> handles = driver.getWindowHandles();
		
		// it takes care of tab iterations
		Iterator itr  = handles.iterator();	
		String parenttab = (String) itr.next(); // it is on parent tab
		
		// click to download P360 from the App Store
		dashboard.clickAppStore();
		logger.info("Clicked on App Store link");
		Thread.sleep(10000);
		captureScreen(driver, "App Store link");
		logger.info("App store tab is opened");
		
		driver.switchTo().window(parenttab);
		Thread.sleep(5000);
		logger.info("Driver is on P360 page");
		// once we switch new tab then we can't come back
	
		
		
		// click to download P360 from the Google Store
		dashboard.clickGooglePlayStore();
		logger.info("Clicked on Google Store link");
		Thread.sleep(10000);
		captureScreen(driver, "Google Store link");
		
		driver.switchTo().window(parenttab);
		Thread.sleep(5000);
		logger.info("Driver is on P360 page");
		
		
		// click on the user name button for the logout
		dashboard.clickOnUserNameButton();
		logger.info("Clicked on User name button for logout");
		Thread.sleep(2000);
		
		
		// click to download P360 from the App Store
		dashboard.clickOnLogoutButton();
		captureScreen(driver, "Logout button");
		logger.info("Clicked on Logout button");
		Thread.sleep(5000);
			
	}
	
}
