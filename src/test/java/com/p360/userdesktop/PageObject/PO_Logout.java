package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Logout {
	
	// initiate page factory constructor
		public WebDriver ldriver= null;
		
		public PO_Logout(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
		}
		
		// to find page elements
		@FindBy(xpath = "//p[@class='MuiTypography-root text-base font-semibold MuiTypography-body1']")
		@CacheLookup
		WebElement btnUsrName;
		
		@FindBy(xpath = "//div[@class='ml-2']")
		@CacheLookup
		WebElement btnLogout;
		
				
		// apply set method for each variable 
		// here get method not required beacues we are using config.properties files
		public void clickBtnUserName() {
			btnUsrName.click();
		}

		public void clickBtnLogout() {
			btnLogout.click();
		}

}
