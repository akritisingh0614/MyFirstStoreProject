package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.ProductPage;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage=new IndexPage();;
	LoginPage loginPage=new LoginPage();
	Homepage homePage=new Homepage();
	ProductPage productPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String brNm) {
		launchApp(brNm);
	}

		
		 @AfterMethod (groups = {"Smoke","Sanity","Regression"})
		 public void tearDown() { 
		  driver.quit();
			  }
		 @Test(groups="Smoke")
		 public void verifyLoggedInAs() {
			 loginPage=indexPage.clickOnSignUp();
			 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			Boolean loggedInAsResult= homePage.validateLoggedInAs();
			Assert.assertTrue(loggedInAsResult);
		 }

		 @Test(groups="Smoke")
		 public void clickOnProductsTest() {
			 loginPage=indexPage.clickOnSignUp();
			 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			productPage=homePage.clickOnProducts();
		 }
}
