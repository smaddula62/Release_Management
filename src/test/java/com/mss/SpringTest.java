package com.mss;

import org.junit.Assert;
import org.junit.Test;

public class SpringTest {
	
	@Test
	public void springTest(){
		
		WelcomeController welcomeController = new WelcomeController();

		Assert.assertEquals("Welcome to MSS", welcomeController.messageGenerator("MSS"));
		
	}
	
	

}
