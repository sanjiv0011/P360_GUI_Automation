package com.p360.userdesktop.PageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



// to use this first perform the login
public class PO_ManageMemberShip {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	
	// Fage Factory constructor
	public PO_ManageMemberShip(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// Object
	@FindBy(xpath = "//span[normalize-space()='Membership']")
	@CacheLookup
	WebElement menuMembership;
	
	@FindBy(xpath = "//span[contains(text(),\"Manage Membership\")]")
	@CacheLookup
	WebElement btnManageMembership;
	
	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-marginDense MuiOutlinedInput-marginDense\"]")
	@CacheLookup
	WebElement btnDropdown;
	
	
	// it is give the list of category present under this dropdown
	@FindBy(xpath = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li[text()]")
	@CacheLookup
	List <WebElement>  listCategory;
	
	
	// it is give the list of category present under this dropdown
	@FindBy(xpath = "//div[@class=\"grid md:grid-cols-3 gap-6\"]//div[@class=\"text-red text-base capitalize\"]")
	@CacheLookup
	 List <WebElement> gridPackageName;
	

	@FindBy(xpath = "//input[@id='agreeToPricing']")
	@CacheLookup
	WebElement checkBox;
	
	
	@FindBy(xpath = "//span[contains(text(), 'Change Membership')]")
	@CacheLookup
	WebElement btnChangeMembership;
	
	@FindBy(xpath = "//div[@id='notistack-snackbar']")
	@CacheLookup
	WebElement slidebarConfirmation;
	
	@FindBy(xpath = "//span[normalize-space()='Agreed Terms']")
	@CacheLookup
	WebElement btnAgreeTerm;
	
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	@CacheLookup
	WebElement btnCancleAgreedTermPage;
	
	// Actions
	public void clickMenuMembership()
	{
		menuMembership.click();
	}
	
	public void clickManageMembershipBtn()
	{
		btnManageMembership.click();
	}
	
	public void clickOnDropdownBtn()
	{
		btnDropdown.click();
	}
	
	// select category from the list
	public void selectCategoryFromDropdownlist(String categoryName) throws InterruptedException
	{
		boolean flag=false;

		//System.out.println(listCategory.size());
		for(WebElement listname : listCategory)
		{ 	
			Thread.sleep(10);
			if(listname.getText().equals(categoryName))
			{
				listname.click();
				flag = true;
				break;
			}
			//System.out.println(listname.getText());
		}
		
		if(flag == true)
		{
			logger.info("Category name selected");
		}
		else
		{
			logger.info("Category name NOT selected");
		}
		
	}
	

	//Select package from the grid list
	public void selectPackageFromGrid(String packageName) throws InterruptedException
	{
		boolean flag=false;
		
		for(WebElement gridname : gridPackageName)
		{
			Thread.sleep(10);
			logger.info("Thread wating");
			if(gridname.getText().equals(packageName))
			{
				//logger.info("Entered inside if blcok");
				gridname.click();
				flag = true;
				break;
			}
			//System.out.println("SOP: "+gridname.getText().equals(packageName)+" "+gridname.getText());
		}
		if(flag == true)
		{
			logger.info("packageName name selected ");
		}
		else
		{
			logger.info("packageName name NOT selected");
		}
		
	}
	
	public void clickOnCheckBox()
	{
		checkBox.click();
	}
	
	public void clickChangeMembershipBtn()
	{
		btnChangeMembership.click();
	}
	
	public boolean confirmChangeMembership()
	{
		logger.info("Inside confirm change membership method");
		String done = "Membership Package Changed.";
		String notdone = "There was an error changing the Stripe Subscription Schedule.";
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Alert "+alert.getText());
		System.out.println("From Path "+slidebarConfirmation.getText());
		
		if(slidebarConfirmation.getText().equals(done))
		{
			logger.info("If condition");
			return true;
		}
		else if(slidebarConfirmation.getText().contains(notdone))
		{
			logger.info("else condition");
			return false;
		}
		
		return false;
		
	}
	
	public void clickOnAgreedTerm()
	{
		btnAgreeTerm.click();
		logger.info("Clicked on Agreed Term button");
	
	}
	
	public void clickOnCloseAgreedTermPage()
	{
		btnCancleAgreedTermPage.click();
		logger.info("Clicked on Agreed page cancle button");
		
	}
	
	
	
/*	
	// All in one
	public boolean manageMembership(String categoryName, String packageName)
	{
		menuMembership.click();
		logger.info("clicked on Membership menu button");
		
		btnManageMembership.click();
		logger.info("Clicked on manage membersihp");
		
		btnDropdown.click();
		logger.info("Clicked on category list dropdown option");
		
		listCategory.click();
		logger.info("Selected category from the list");
		
		
		checkBox.click();
		logger.info("Clicked on the checkbox");
		
		gridPackageName.click();
		logger.info("Selected package from the grid list");
		
		btnChangeMembership.click();
		logger.info("Clicked on the change member ship button");
		
		boolean bol = slidebarChangeMembershipConfirmation.isDisplayed();
		return bol;
		
	}
	
*/
	
}
