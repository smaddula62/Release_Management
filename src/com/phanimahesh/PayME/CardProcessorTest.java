package com.phanimahesh.PayME;

//import static org.junit.Assert.*;

import org.junit.Test;

public class CardProcessorTest {

	@Test
	public void Test() {
		CreditCardUtil cardDetailsSent = new CreditCardUtil("4317575016571144",883, "0220", "Phani","MiracleStore001",
				200);
		
		CreditCardUtil detailsReceived;
	    CreditCardProcessing test = new CreditCardProcessing();
	    
		System.out.println(test.creditCardProcessor(cardDetailsSent));
	 
	    detailsReceived=test.creditCardProcessor(cardDetailsSent);
	    
	    System.out.println(detailsReceived.getAmount());
	    System.out.println(detailsReceived.getResult());

	
		
	}

}
