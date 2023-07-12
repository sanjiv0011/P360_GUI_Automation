package com.p360.userdesktop.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_DashBoard {
	
	public WebDriver driver;
	public PO_DashBoard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	// =====================Page object========================//

	
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	@CacheLookup
	WebElement menuDashBoard;
	
	@FindBy(xpath = "//span[normalize-space()='Membership']")
	@CacheLookup
	WebElement menuMembership;
	
	@FindBy(xpath = "//span[normalize-space()='My Classes']")
	@CacheLookup
	WebElement menuMyClasses;
	
	
	@FindBy(xpath = "//p[normalize-space()='Dashboard']")
	@CacheLookup
	WebElement textDashboard;
	
	@FindBy(xpath = "//span[normalize-space()='Manage My Membership']")
	@CacheLookup
	WebElement linkManageMyMembership;
	
	@FindBy(xpath = "//div[@class='gap-3 flex flex-col items-center cursor-pointer']")
	@CacheLookup
	WebElement linkNextClass;
	
	@FindBy(xpath = "//div[normalize-space()='App Store']")
	@CacheLookup
	WebElement linkAppStore;
	
	@FindBy(xpath = "//div[normalize-space()='Google Play']")
	@CacheLookup
	WebElement linkGooglePlayStore;
	
	
	@FindBy(xpath = "//p[@class='MuiTypography-root text-base font-semibold MuiTypography-body1']")
	@CacheLookup
	WebElement btnUserName;
	
	@FindBy(xpath = "//div[@class='ml-2']")
	@CacheLookup
	WebElement btnLogout;
	
	
	// =====================Actions========================//
	
	
	public void clickMenuDashBoard()
	{
		menuDashBoard.click();
	}
	
	public void clickMenuMembership()
	{
		menuMembership.click();
	}
	
	public void clickMenuMyClasses()
	{
		menuMyClasses.click();
	}
	
	public boolean verifyDashboard()
	{
		boolean bol = textDashboard.isDisplayed();
		return bol;
		
	}
	
	public void clickManageMyMembership()
	{
		linkManageMyMembership.click();
	}
	
	public void clickNextClass()
	{
		linkNextClass.click();
	}
	
	public void clickAppStore()
	{
		linkAppStore.click();
	}
	
	public void clickGooglePlayStore()
	{
		linkGooglePlayStore.click();
	}
	
	public void clickOnUserNameButton()
	{
		btnUserName.click();
	}
	
	public void clickOnLogoutButton()
	{
		btnLogout.click();
	}
	
	
	
}
