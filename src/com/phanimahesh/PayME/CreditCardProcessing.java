package com.phanimahesh.PayME;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;


@Path("/charge")
public class CreditCardProcessing {

	final static Logger ProcessLogger = Logger.getLogger(CreditCardProcessing.class);
	@POST
	@Path("/creditcard")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CreditCardUtil creditCardProcessor(CreditCardUtil cardDetailsReceived)
	{
        
		CreditCardUtil cardDetails = null;
		boolean authorizationresult = false;
		CreditCardUtil isCardValid = null;
		
		
		try
		{
			
			cardDetails = new CreditCardUtil(cardDetailsReceived.getCardNumber(),cardDetailsReceived.getCvv(),
			cardDetailsReceived.getExpDate(),cardDetailsReceived.getCardHolderName(),cardDetailsReceived.getMerchid(),
			cardDetailsReceived.getAmount());
			
			
		     isCardValid = new CreditCardValidation().CardValidator(cardDetails);
		    
		    
		    if(isCardValid.getResult().equalsIgnoreCase("Card Valid"))
		    {
		    	ProcessLogger.error("Card Validation is done, now payment is being authorized..");
//		    	authorizationresult = new CreditCardAuthorization().CreditCardAuthorizer(cardDetails);
		    	
//		    	if(authorizationresult)
		    	cardDetails.setResult("Transaction Successful");
		    	System.out.println("This is authorization result");
				System.out.println(cardDetails.getResult());
				return cardDetails;
		    	
		    	
		    }
		    
		    else
		    {
		    	ProcessLogger.error("Sorry, your card didn't go through..");
		    	
		    	
		    	
		    	
		    	return isCardValid;
		    }
		    
		    
		}
		
		catch(Exception exception)
		
		{
			exception.printStackTrace();
			ProcessLogger.error("An exception occured during initial processing : " + exception);
			cardDetails.setResult("Server Failure");
	    	
	    	
	    	return cardDetails;
		}
		
		
		

	}
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping()
	{
		ProcessLogger.error("A ping request was sent to the server.");
		return "PayMe Service is active";
	}

}
