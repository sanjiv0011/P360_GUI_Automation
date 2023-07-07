package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_SignUP {
	
	public WebDriver ldriver;
	
	public PO_SignUP(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath= "//a[@id='createAccount']")
	@CacheLookup
	WebElement btnSignup;
	

	@FindBy(xpath= "//input[@id='givenName']")
	@CacheLookup
	WebElement textFirstName;
	
	@FindBy(xpath= "//input[@id='surname']")
	@CacheLookup
	WebElement textLastName;
	
	
	@FindBy(xpath= "//input[@id='email']")
	@CacheLookup
	WebElement textEmail;
	
	
	@FindBy(xpath= "//input[@id='newPassword']")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath= "//input[@id='reenterPassword']")
	@CacheLookup
	WebElement textConfirmPassword;
	
	@FindBy(xpath = "//button[@id='continue']")
	@CacheLookup
	WebElement btnCreate;

	
	public void clickBtnLogin() {
		btnLogin.click();
	}

	
	public void clickBtnSignup() {
		btnSignup.click();
	}

	public void setTextFirstName(String fname) {
		textFirstName.sendKeys(fname);
	}

	public void setTextLastName(String lname) {
		textLastName.sendKeys(lname);
	}

	

	public void setTextEmail(String email) {
		textEmail.sendKeys(email);
	}

	
	public void setTextPassword(String pwd) {
		textPassword.sendKeys(pwd);;
	}


	public void setTextConfirmPassword(String conpwd) {
		textConfirmPassword.sendKeys(conpwd);
	}

	public void clickBtnCreate() {
		btnCreate.click();
	}

}
