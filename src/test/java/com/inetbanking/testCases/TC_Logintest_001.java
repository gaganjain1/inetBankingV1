package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_Logintest_001 extends BaseClass

{
  
	@Test
	public void loginTest() throws IOException
	
	{
		
		
		
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		   Assert.assertTrue(true);
		   logger.info("Login test passed");
			
		}
		
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			
		}
		
	
	}
	
	
}
