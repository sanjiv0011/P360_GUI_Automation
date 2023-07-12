package com.p360.userdesktop.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p360.userdesktop.TestCases.TC_Login;

public class PO_Login {
	
	public Logger logger = LogManager.getLogger(getClass());
	
	// initiate page factory constructor
	public WebDriver driver= null;
	
	public  PO_Login(WebDriver driver)
	{ 
		this.driver = driver;
		//this.driver = driver;
		PageFactory.initElements(driver,this);
	}

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
	
	public PO_Login login(String email, String password) throws InterruptedException
	{
		Thread.sleep(5000);
		btnLogin.click();
		logger.info("clicke on login button");
		Thread.sleep(10000);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(1000);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(1000);
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(10000);
		
		return new PO_Login(driver);

	}
	
}
