package com.p360.userdesktop.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_ChangeCardNumber{
	
	public WebDriver driver=null;
	public  Logger logger = LogManager.getLogger(this.getClass());
	

	public PO_ChangeCardNumber(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	//=====================start for login========================//
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
	
	public void login(String email, String password) throws InterruptedException
	{
		Thread.sleep(5000);
		btnLogin.click();
		logger.info("clicke on login button");
		Thread.sleep(5000);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(1000);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(1000);
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(10000);
	}
	
	//=====================end for login========================//

	
	//=====================Start card details change========================//
	@FindBy(xpath = "//span[normalize-space()='Change']")
	@CacheLookup
	WebElement btnChange;
	
	@FindBy(xpath = "//input[@name='holderName']")
	@CacheLookup
	WebElement textCardHolderName;
	
	@FindBy(xpath = "//input[@placeholder=\"Card number\"]")
	@CacheLookup
	WebElement textCardNumberDetails;
	
	@FindBy(xpath = "//input[@class=\"InputElement is-empty Input Input--empty\" and contains(@placeholder, \"MM / YY\")]\r\n"
			+ "")
	@CacheLookup
	WebElement textCardExpiryDate;
	
	@FindBy(xpath = "//input[@class=\"InputElement is-empty Input Input--empty\" and contains(@placeholder,\"CVC\")]")
	@CacheLookup
	WebElement textCardCCVCode;
	
	@FindBy(xpath = "//input[@class=\"InputElement is-empty Input Input--empty\" and contains(@placeholder,\"ZIP\")]")
	@CacheLookup
	WebElement textCardZipcode;
	
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	@CacheLookup
	WebElement btnSave;
	
	public void clickOnChangeCardNumbeButton()
	{
		btnChange.click();
	}
	
	public void setCardHoldName(String cardName)
	{
		textCardHolderName.sendKeys(cardName);
	}
	
	public void setCardNumber(String cardNumber)
	{
		
		textCardNumberDetails.sendKeys(cardNumber);
	}
	
	public void setCardExpiry(String cardExpiry)
	{
		textCardExpiryDate.sendKeys(cardExpiry);
	}
	
	public void setCardCCVCode(String ccvcode)
	{
		textCardCCVCode.sendKeys(ccvcode);
	}
	
	public void setCardZipcode(String cardzipcode)
	{
		textCardZipcode.sendKeys(cardzipcode);
	}
	
	public PO_Login clickOnSaveButton()
	{
		btnSave.click();
		return new PO_Login(driver);
	}
	
	
	public PO_Login changeCardDetails(String cardName, String cardNumber, String cardExpiryDate, String cardCCVCode, String zipCode ) throws InterruptedException
	{
		
		btnChange.click();
		logger.info("Clicked on Change button");
		Thread.sleep(3000);
		
		textCardHolderName.sendKeys(cardName);
		logger.info("Entered card name");
		Thread.sleep(2000);
	
		textCardNumberDetails.sendKeys(cardNumber);
		logger.info("Entered card number");
		Thread.sleep(1000);
		
		textCardExpiryDate.sendKeys(cardExpiryDate);
		logger.info("Entered card expiray date");
		Thread.sleep(1000);
		
		textCardCCVCode.sendKeys(cardCCVCode);
		logger.info("Entered card ccv code");
		Thread.sleep(1000);
		
		textCardZipcode.sendKeys(zipCode);
		logger.info("Entetered zip code");
		Thread.sleep(1000);
		
		btnSave.click();
		logger.info("Clicked on save button");
		Thread.sleep(3000);
		
		return new PO_Login(driver);
		
	}
	
	public PO_Login changeCardDetails2(String cardName) throws InterruptedException
	{
		btnChange.click();
		logger.info("Clicked on Change button");
		Thread.sleep(3000);
		
		textCardHolderName.sendKeys(cardName);
		logger.info("Entered card name");
		Thread.sleep(2000);
		
		logger.info("Waiting to enter card number details, it will wait 40 seconds");
		Thread.sleep(40000);
		
		btnSave.click();
		logger.info("Clicked on save button");
		Thread.sleep(3000);
		
		return new PO_Login(driver);
	}
	//=====================end card details change========================//
}
