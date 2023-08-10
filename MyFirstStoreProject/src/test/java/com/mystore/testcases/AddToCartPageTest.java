package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.ProductPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	IndexPage indexPage=new IndexPage();;
	ProductPage productPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setUp(String brNm) {
			launchApp(brNm);
		}

		
		 @AfterMethod (groups = {"Smoke","Sanity","Regression"})
		 public void tearDown() { 
		  driver.quit();
		  }
		 @Test(groups = {"Regression","Sanity"})
		 public void verifyClickOnAddToCart() {
			 productPage=indexPage.clickOnProducts();
				searchResultPage=productPage.validateSearchBox("T-Shirt");
				addToCartPage=searchResultPage.clickOnProduct();
				addToCartPage.enterQuantity("1");
				addToCartPage.clickOnAddToCart();
				String addToCartMsgResult=addToCartPage.validateAddToCart();
				Assert.assertEquals("Your product has been added to cart.", addToCartMsgResult);
				
		 }

}
