package com.phanimahesh.PayME;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class CreditCardValidation
{
	final static Logger logger = Logger.getLogger(CreditCardValidation.class);
	
	public CreditCardUtil CardValidator(CreditCardUtil cardDetailsValidation)
	{
		
     boolean validity = false;
     boolean cardFormat = false;
     Pattern pattern;
     Matcher matcher;
     
     String cNumber= cardDetailsValidation.getCardNumber();
    
     try
     {
     
     
     if(cNumber.length()>=15 && cNumber.length()<=16 )
     {
     
     String creditCardPattern = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
    	        "(?<mastercard>5[1-5][0-9]{14})|" +
    	        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
    	        "(?<amex>3[47][0-9]{13})|" +
    	        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
    	        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
	 
     pattern = Pattern.compile(creditCardPattern);
     matcher = pattern.matcher(cNumber);
     
    
     
     if(matcher.matches())
            {      
    	       cardFormat =  CreditCardValidation.Check(cNumber);
    	       
               
    	       //ExpDate Logic
               SimpleDateFormat currentYear = new SimpleDateFormat("yy");
               String currentYearString = currentYear.format(new Date()); 
                                    
               SimpleDateFormat currentMonth = new SimpleDateFormat("MM");
               String currentMonthString = currentMonth.format(new Date()); 
              
                             
               validity = (Integer.parseInt(cardDetailsValidation.getExpDate().substring(0,2)) >= Integer.parseInt(currentMonthString) && Integer.parseInt(cardDetailsValidation.getExpDate().substring(2,4))>=Integer.parseInt(currentYearString));             
               
              
            }
     }
     
     
     else
     {
    	 logger.error("Invalid Credit Card Number");
    	 cardDetailsValidation.setResult("Unknown Card");
       	 return cardDetailsValidation;
    	
     
     }
     
     
     
     
       
     if(validity == true && cardFormat == true)
     {
    	 cardDetailsValidation.setResult("Card Valid");
         return cardDetailsValidation;
     }
     else if(!cardFormat)
     {
    	 
    	 cardDetailsValidation.setResult("Invalid Card Number");
    	 return cardDetailsValidation;
     }
     else if(!validity)
     {
    	 
    	 cardDetailsValidation.setResult("Card Expired");
    	 return cardDetailsValidation;
     }
     
     else
     {
    	 cardDetailsValidation.setResult("Please check your card details");
    	 return cardDetailsValidation;
     }
     
     
	}  
     
     
     
     catch(Exception e)
     {
    	 logger.error("An exception was caught " + e);
    	 cardDetailsValidation.setResult(e.toString());
    	 return  cardDetailsValidation;
     }
     
     
     
	}
     
     
      static boolean Check(String cNumber)
	    {
	        int sum = 0;
	        boolean alternate = false;
	        for (int i = cNumber.length() - 1; i >= 0; i--)
	        {
	            int n = Integer.parseInt(cNumber.substring(i, i + 1));
	            if (alternate)
	            {
	                n *= 2;
	                if (n > 9)
	                {
	                    n = (n % 10) + 1;
	                }
	            }
	            sum += n;
	            alternate = !alternate;
	        }
	        return (sum % 10 == 0);

	    
	    }
}
