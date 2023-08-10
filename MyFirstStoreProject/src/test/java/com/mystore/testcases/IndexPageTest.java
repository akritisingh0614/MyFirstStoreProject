package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String brNm) {
		launchApp(brNm);
	}
	
	  @AfterMethod(groups = {"Smoke","Sanity","Regression"})
	  public void tearDown() { 
		  driver.quit();
		  }
	 
	IndexPage indexPage= new IndexPage();
	
	
	  @Test(groups="Smoke")
	  public void verifyLogo() { 
		  boolean logoResult=indexPage.validateLogo();
	  Assert.assertTrue(logoResult); 
	  }
	 
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		String actTitle=indexPage.getAppTitle();
	Assert.assertEquals(actTitle, "Automation Exercise");
	}
	
	
}
