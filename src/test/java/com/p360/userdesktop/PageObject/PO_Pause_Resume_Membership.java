package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Pause_Resume_Membership {
	
	WebDriver driver;
	public PO_Pause_Resume_Membership(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Object
	@FindBy(xpath = "//span[normalize-space()='Membership']")
	@CacheLookup
	WebElement menuMembership;
	
	@FindBy(xpath = "//span[normalize-space()='Pause Membership']")
	@CacheLookup
	WebElement btnPause_ResumeMember;
	
	

	@FindBy(xpath = "")
	@CacheLookup
	WebElement icnStartDate;
	
	@FindBy(xpath = "//div[@class=\"MuiPickersCalendar-week\"]//div[@role=\"presentation\"]")
	@CacheLookup
	WebElement btnStartDate;
	
	@FindBy(xpath = "")
	@CacheLookup
	WebElement icnEndDate;
	
	@FindBy(xpath = "//div[@class=\"MuiPickersCalendar-week\"]//div[@role=\"presentation\"]")
	@CacheLookup
	WebElement btnEndDate;
	
	
	
	
	@FindBy(xpath = "")
	@CacheLookup
	WebElement selectorDropdown;
	
	
	@FindBy(xpath = "")
	@CacheLookup
	WebElement btnPauseMyMembership;
	
	@FindBy(xpath = "")
	@CacheLookup
	WebElement btnConfirmation;
	

	
	

}
