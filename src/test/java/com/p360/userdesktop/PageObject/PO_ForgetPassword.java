package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_ForgetPassword {
	
	public WebDriver ldriver;
	
	public PO_ForgetPassword(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	// login button
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	@CacheLookup
	WebElement btnLogin;
	
	
	// Button forget password
	@FindBy(xpath  = "//a[@id='forgotPassword']")
	@CacheLookup
	WebElement btnForgetPwd;
	
	
	// Enter email
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement btnEmail;
	
	// button send verification
	@FindBy(xpath= "//button[@id='email_ver_but_send']")
	@CacheLookup
	WebElement btnSendVerification;
	
	
	// button to verify the code
	@FindBy(xpath= "//button[@id='email_ver_but_verify']")
	@CacheLookup
	WebElement btnVerifyCode;
	
	// button continue
	@FindBy(xpath= "//button[@id='continue']")
	@CacheLookup
	WebElement btnContinue;
	
	// Enter new password
	@FindBy(xpath= "//input[@id='newPassword']")
	@CacheLookup
	WebElement textNewPwd;
	
	// Enter confirm password
	@FindBy(xpath= "//input[@id='reenterPassword']")
	@CacheLookup
	WebElement textConfirmPwd;
	
	// Button continue
	@FindBy(xpath= "//button[@id='continue']")
	@CacheLookup
	WebElement btnContinueFinal;
	
	

	
	public void clickBtnLogin() {
		btnLogin.click();
	}

	
	public void clickBtnForgetPassword() {
		btnForgetPwd.click();
	}

	public void setEmail(String email) {
		btnEmail.sendKeys(email);
	}

	public void clickSendVerification() {
		btnSendVerification.click();
	}

	
	public void clickVerifyCode()
	{
		btnVerifyCode.click();
	}
	

	public void clickContinueInBetween() {
		btnContinue.click();
	}

	
	public void setTextNewPwd(String pwd) {
		textNewPwd.sendKeys(pwd);;
	}


	public void setTextConfirmNewPwd(String conpwd) {
		textConfirmPwd.sendKeys(conpwd);
	}

	public void clickContinueFinal() {
		btnContinueFinal.click();
	}

}
