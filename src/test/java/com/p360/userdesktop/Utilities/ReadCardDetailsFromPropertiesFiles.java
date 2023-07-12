package com.p360.userdesktop.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadCardDetailsFromPropertiesFiles {
	
	Properties pro_cardDetails;
	
	public ReadCardDetailsFromPropertiesFiles()
	{
		File src = new File("./Configurations/changeCardNumber.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro_cardDetails = new Properties();
			pro_cardDetails.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	

	

	public String getCardName() {
		String cardName = pro_cardDetails.getProperty("cardName");
		return cardName;
	}
	public String getCardNumber() {
		String cardNumber = pro_cardDetails.getProperty("cardNumber");
		return cardNumber;
	}
	public String getCardExpiryDate() {
		String cardExpiryDate = pro_cardDetails.getProperty("cardExpiryDate");
		return cardExpiryDate;
	}
	public String getCardCCVCode() {
		String cardCCVCode = pro_cardDetails.getProperty("cardCCVCode");
		return cardCCVCode;
	}
	public String getZipCode() {
		String zipCode = pro_cardDetails.getProperty("zipCode");
		return zipCode;
	}

}
