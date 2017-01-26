package com.mss;

import org.junit.Assert;
import org.junit.Test;

public class SpringTest {
	
	@Test
	public void springTest(){
		
		WelcomeController welcomeController = new WelcomeController();

        System.out.println("saikumar test case running /????????");
		Assert.assertEquals("Welcome to MSS", welcomeController.messageGenerator("MSS"));
		
	}
	
	

}
