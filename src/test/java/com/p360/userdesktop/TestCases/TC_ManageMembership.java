package com.p360.userdesktop.TestCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_Login;
import com.p360.userdesktop.PageObject.PO_ManageMemberShip;
import com.p360.DataProvideres.From_ReadExcelData_Packages.DataProviders;
public class TC_ManageMembership extends BaseClass {
	
	public TC_ManageMembership()
	{
		super();
	}
	
	
	public PO_Login lgn;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Test(priority =1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void test_changeMembership(String categoryName, String packageName) throws InterruptedException, IOException
	{
		System.out.println(categoryName);
		System.out.println(packageName);
		
		// First do the login
		lgn = new PO_Login(driver);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		lgn.login(email, password);
		logger.info("Login done");
		
		PO_ManageMemberShip mms = new PO_ManageMemberShip(driver);
		Thread.sleep(5000);
		logger.info("Startd PO_ManageMemberShip");
		
		mms.clickMenuMembership();
		logger.info("Clicked membership menu butotn");
		Thread.sleep(5000);
		
		mms.clickManageMembershipBtn();
		logger.info("Clicked on maange membership button");
		Thread.sleep(4000);
		
		mms.clickOnDropdownBtn();
		logger.info("Clicked on the dropdown button of category");
		Thread.sleep(5000);
		
	
		mms.selectCategoryFromDropdownlist(categoryName);
		logger.info("Selected the category");
		Thread.sleep(5000);
	
		
		mms.selectPackageFromGrid(packageName);
		logger.info("Selected package from the packages grid");
		Thread.sleep(2000);
		
		mms.clickOnCheckBox();
		logger.info("Clicked on the check box");
		Thread.sleep(2000);
		
		mms.clickChangeMembershipBtn();
		logger.info("Clicked on the change membership button");
		
		//mms.clickOnAgreedTerm();
		//Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		mms.clickOnCloseAgreedTermPage();
		Thread.sleep(1000);
		/*
		boolean bol = mms.confirmChangeMembership();
		if(bol)
		{
			Assert.assertTrue(true);
			logger.info("Membership change Successfully...");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Membership change Failed!!!");
			captureScreen(driver,"test_changeMembership");
		}
		*/
	}
}
