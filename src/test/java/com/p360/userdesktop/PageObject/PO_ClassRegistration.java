package com.p360.userdesktop.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_ClassRegistration {
	
	public WebDriver ldriver;
	public  Logger logger = LogManager.getLogger(this.getClass());
	
	
	public PO_ClassRegistration(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}


	//=========================Start Sign In=====================//
	   // to find page elements
		@FindBy(xpath = "//span[@class='MuiButton-label']")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath = "//input[@id='signInName']")
		@CacheLookup
		WebElement textemail;
		
		@FindBy(xpath = "//input[@id='password']")
		@CacheLookup
		WebElement textpassword;
		
		@FindBy(xpath = "//button[@id='next']")
		@CacheLookup
		WebElement btnsubmit;
		
		
		// apply set method for each variable 
		// here get method not required beacues we are using config.properties files
		
		public void clickBtnLogin() {
			btnLogin.click();
		}

		public void setTextemail(String email) 
		{
			textemail.sendKeys(email);
		}
			
		public void setTextpassword(String password) {
			textpassword.sendKeys(password);
		}

		public void clickBtnsubmit() {
			btnsubmit.click();
		}

		//=========================End Sign In=====================//
		
		//=========================Start Class Registration=====================//
		@FindBy(xpath = "//span[normalize-space()='My Classes']")
		@CacheLookup
		WebElement btnMyClasses;
		
		@FindBy(xpath = "//span[@class='MuiButton-label']")
		@CacheLookup
		WebElement btnRegistorForClass;
		
		
	//=============================================================//
		@FindBy(xpath = "//div[@data-index=\"0\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate0;
		
		@FindBy(xpath = "//div[@data-index=\"1\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate1;
		
		@FindBy(xpath = "//div[@data-index=\"2\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate2;
		
		@FindBy(xpath = "//div[@data-index=\"3\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate3;
		
		@FindBy(xpath = "//div[@data-index=\"4\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate4;
		
		@FindBy(xpath = "//div[@data-index=\"5\"]") // it's list, user have select the date from the here
		@CacheLookup
		WebElement btnSelectDate5;
		
		//=============================================================//	
		
		@FindBy(xpath= "//div[text()=\"Register Class\"]")
		@CacheLookup
		WebElement btnRegisterClass;
		
		@FindBy(xpath = "//span[normalize-space()='CONFIRM CLASS REGISTRATION']")
		@CacheLookup
		WebElement btnConfirmClass;
		
		@FindBy(xpath = "//h1[@class='text-2xl font-bold']")
		@CacheLookup
		WebElement userDashbaord;
		
	

		public void clickBtnMyClasses() {
			btnMyClasses.click();
		}
		
		public void clickBtnRegisterForClass() {
			btnRegistorForClass.click();
		}
		
		//========================Start Date selection=================//
		public void clickClassDate0() {
			btnSelectDate0.click();
			
		}
		public void clickClassDate1() {
			btnSelectDate1.click();
			
		}
		public void clickClassDate2() {
			btnSelectDate2.click();
			
		}
		public void clickClassDate3() {
			btnSelectDate3.click();
			
		}
		public void clickClassDate4() {
			btnSelectDate4.click();
			
		}
		public void clickClassDate5() {
			btnSelectDate5.click();
			
		}

		//========================End Date selection=================//
		
		// method to check to register class button is enabled or not
		public boolean checkRegisterClassBtnPresence3() throws Exception
		{
			logger.info("Searching Register class button");
			boolean bol=false;
			try {
				if(btnRegisterClass.isDisplayed())
				{
					bol = true;
					logger.info("Class registration available");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("Catch block:- "+e.getMessage());
			}
			return bol;
		
		}
		
		public void clickBtnRegisterClass() {
			btnRegisterClass.click();
		}
		
		public void clickBtnConfirmRegisteredClass() {
			logger.info("clickBtnConfirmRegisteredClass");
			btnConfirmClass.click();
		}
		
		public boolean confirmUserDashBoard()
		{
			userDashbaord.isDisplayed();
			return true;
		}
		//=========================End Class Registration=====================//

		
	

}
