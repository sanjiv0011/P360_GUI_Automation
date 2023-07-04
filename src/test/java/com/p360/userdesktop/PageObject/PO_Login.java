package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Login {
	
	
	// initiate page factory constructor
	public WebDriver ldriver= null;
	
	public PO_Login(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
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

	
}
