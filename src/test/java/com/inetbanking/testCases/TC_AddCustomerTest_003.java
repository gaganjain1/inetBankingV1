package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass

{
   @Test
   public void addNewCustomer() throws InterruptedException, IOException
   {
	   LoginPage lp = new LoginPage(driver);
	   lp.setUserName(username);
	   logger.info("Username is entered");
	   lp.setPassword(password);
	   logger.info("Password is entered");
	   lp.clickSubmit();
	   
	   Thread.sleep(3000);
	   
	   AddCustomerPage addcust = new AddCustomerPage(driver);
	   
	   addcust.clickAddNewCustomer();
	   
	   logger.info("Providing Customer Details");
	   
	   addcust.custName("Gagan");
	   addcust.custgender("male");
	   addcust.custdob("06", "10", "1992");
	   addcust.custaddress("INDIA");
	   addcust.custcity("Delhi");
	   addcust.custstate("NCR");
	   addcust.custpinno("121003");
	   addcust.custtelephoneno("9999948565");
	    
	   String email = randomestring()+"@gmail.com";
	   addcust.custemailid(email);
	   addcust.custpassword("9999948565");
	   addcust.custsubmit();
	   
	   Thread.sleep(3000);
	   
	   logger.info("Validtion Started");
	   
	  boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	  
	  if(res==true)
	  {
		  Assert.assertTrue(true);
		  logger.info("Test Case is Passed");
	  }
	  
	  else
	  {
		  logger.info("Test Case is Failed");
		  captureScreen(driver, "addNewCustomer");
		  Assert.assertTrue(false);
		  
		  
	  }
	   
	   
   }
   
   

}
