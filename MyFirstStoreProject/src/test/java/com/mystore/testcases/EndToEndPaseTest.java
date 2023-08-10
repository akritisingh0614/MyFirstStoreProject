package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.ProductPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.ExtentManager;

public class EndToEndPaseTest  extends BaseClass{
	IndexPage indexPage=new IndexPage();;
	ProductPage productPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	Orderpage orderpage;
	LoginPage loginPage;
	AddressPage addressPage;
	Homepage homePage;
	PaymentPage paymentPage;
	OrderConfirmationPage orderConfirmationPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String brNm) {
		launchApp(brNm);
	}

		
		 @AfterMethod (groups = {"Smoke","Sanity","Regression"})
		 public void tearDown() { 
		  driver.quit();
		  ExtentManager.extent.flush();
		  }
		 @Test(groups="Regression")
		 public void endToEndTest() {
			 productPage=indexPage.clickOnProducts();
				searchResultPage=productPage.validateSearchBox("T-Shirt");
				addToCartPage=searchResultPage.clickOnProduct();
				addToCartPage.enterQuantity("1");
				addToCartPage.clickOnAddToCart();
			orderpage=addToCartPage.clickOnShoppingCart();
			loginPage=orderpage.clickOnCheckout();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			orderpage=homePage.clickOnCarts();
			addressPage=orderpage.clickOnCheckout1();
			paymentPage=addressPage.clickOnPlaceorder();
			orderConfirmationPage=paymentPage.enterCardDetails("abc", "123455678", "123", "09", "2027");
String orderMsg=orderConfirmationPage.validateOrderConfirmed();
Assert.assertEquals("Congratulations! Your order has been confirmed!", orderMsg);
		 }
}
