package com.p360.userdesktop.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.p360.userdesktop.PageObject.PO_ClassRegistration;



public class TC_ClassRegistration extends BaseClass{
	
	
	String date;
	@Test(priority = 1)
	public void test_ClassRegistration() throws Exception
	{
		
		// for the scroll function 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//=====================Start login==========================//
		      //driver.get(baseUrl); // it set in base class 
				driver.manage().window().maximize();
				Thread.sleep(2000);
				
				PO_ClassRegistration cr = new PO_ClassRegistration(driver);
				cr.clickBtnLogin();
				logger.info("Driver click on login button");
				Thread.sleep(2000);
				
				driver.getCurrentUrl();
				Thread.sleep(2000);
				
				cr.setTextemail(email);
				logger.info("Email entered");
				Thread.sleep(1000);
				
				cr.setTextpassword(password);
				logger.info("Passwrod entered");
				Thread.sleep(1000);
				
				
				cr.clickBtnsubmit();
				logger.info("Driver clicked on login submit button");
				Thread.sleep(15000);
				//driver.wait();
				
		//=====================Login Done==========================//
		
		//=====================Start Class Registration=============//
				
				cr.clickBtnMyClasses();
				logger.info("Clicked my Classes");
				Thread.sleep(2000);
				
				cr.clickBtnRegisterForClass();
				logger.info("Clicked register for Class");
				Thread.sleep(5000);
				
				cr.clickClassDate0();
				Thread.sleep(2000);
				logger.info("Date selected");
				
				// to scroll down the page
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(2000);
				
				boolean bol=false;
				// to confirm the register class presence on the specific date
				if(cr.checkRegisterClassBtnPresence3())
				{
					// before calling this method first confirm the class registration presence on the selected date
					cr.clickBtnRegisterClass();
					Thread.sleep(2000);
					logger.info("clicked on Register for clas button");
				}
				else
				{	int x =1;
					while(bol== false)
					{
						
						// select new date in which class registration is available
						logger.info("Class registration not available");
						logger.info("chenge the date");
						switch(x) 
						{
							case 1:
								
								cr.clickClassDate1();
								Thread.sleep(4000);
								logger.info("New date selected"+x);
								bol = cr.checkRegisterClassBtnPresence3();
								Thread.sleep(4000);
								break;
							case 2:
							
								cr.clickClassDate2();
								Thread.sleep(4000);
								logger.info("New date selected"+x);
								bol = cr.checkRegisterClassBtnPresence3();
								Thread.sleep(4000);
								break;
							case 3:
								
								cr.clickClassDate3();
								Thread.sleep(4000);
								logger.info("New date selected"+x);
								bol = cr.checkRegisterClassBtnPresence3();
								Thread.sleep(4000);
								break;
							case 4:
								
								cr.clickClassDate4();
								Thread.sleep(4000);
								logger.info("New date selected"+x);
								bol = cr.checkRegisterClassBtnPresence3();
								Thread.sleep(4000);
								break;
							case 5:
							
								cr.clickClassDate5();
								logger.info("New date selected"+x);
								Thread.sleep(4000);
								bol = cr.checkRegisterClassBtnPresence3();
								Thread.sleep(4000);
								break;
						}
						x++;
						
					}
					
				}
				if(bol)
				{
					Thread.sleep(5000);
					cr.clickBtnRegisterClass();
					Thread.sleep(5000);
					logger.info("clicked on Register for clas button");
				}
				
				
				
				
				driver.getCurrentUrl();
				Thread.sleep(2000);
			
				cr.clickBtnConfirmRegisteredClass();
				logger.info("confirm class registration");
				Thread.sleep(5000);
				
				if(cr.confirmUserDashBoard()==true)
				{
					logger.info("Class registration Done...");
					Assert.assertTrue(true);
				}
				else
				{
					
					Thread.sleep(3000);
					captureScreen(driver,"test_ClassRegistration3");
					logger.info("Screenshots taken");
					logger.info("class the registration Failed!!!");
					Assert.assertTrue(false);
				}
				
				
				//=====================End Class Registration=============//	
				
	}
}
