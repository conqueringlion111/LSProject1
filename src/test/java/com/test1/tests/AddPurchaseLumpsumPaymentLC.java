package com.test1.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.test1.pages.DefaultLandingPage;

import org.testng.annotations.BeforeMethod;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AddPurchaseLumpsumPaymentLC extends TestBase

{
	

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulPurchaseLumpsumPayAdd(String casenumber, String day, String month, String year,
		  String amount) throws InterruptedException, IOException 
  {

	
	//The entry point DefaultLandingPage object below can now be removed because its added to TestBase can now inherit this
    //DefaultLandingPage defaultlandingpage = new DefaultLandingPage(driver);
	  
	boolean testResult = defaultlandingpage.ClickResearchCasesLink()
										   .clickCaseNumbertLink(casenumber)
			 						       .ClickContinueLinkwithOutFillingOut()
			 						       .ClickContinueLinkwithOutFillingOut()
			 						       .ClickContinueLinkwithOutFillingOut()
			 						       .CreateLumpsumPaymentLifeCon(amount, month, year, day)
			 						       .ClickContinueLinkwithOutFillingOut()
			 						       .CreateLumpsumPaymentLifeCon(amount, month, year, day)
			 						       .isAddPurchaseLumpsumPaymentSuccessful(amount, year, day, month); 
  
	 System.out.println(testResult);
	 
	 Thread.sleep(2000);
	 
	 Assert.assertTrue(testResult, "Purchase payment has not been successfully created for : " + casenumber);
	 
  }
  
 

  //AfterMethod is not inherited from TestBase class
//  @AfterMethod
//  public void afterMethod() 
//  {
//	  driver.close();
//  }

}
