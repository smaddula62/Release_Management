package com.phanimahesh.PayME;

import org.apache.log4j.Logger;

public class CreditCardAuthorization 
{
	final static Logger logger = Logger.getLogger(CreditCardAuthorization.class);
 
	boolean CreditCardAuthorizer(CreditCardUtil cardDetails)
{    
	  
	 
	 if(cardDetails.getMerchid().equalsIgnoreCase("mss"))
	 {
	 logger.error("Transaction Successful");
	 cardDetails.setResult("Transaction Successful");
	 
	 }
	 
	 else
	 {
	 logger.error("Sorry Transaction failed");
	 cardDetails.setResult("Sorry Transaction failed");
	 return false;
	 }
	 
	 
	 return true;
	
}

}
