package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.ProductPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	IndexPage indexPage=new IndexPage();;
	ProductPage productPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	Orderpage orderpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String brNm) {
		launchApp(brNm);
	}

		
		 @AfterMethod (groups = {"Smoke","Sanity","Regression"})
		 public void tearDown() { 
		  driver.quit();
		  }
		 @Test(groups="Regression")
		 public void verifyTotalPrice() {
			 productPage=indexPage.clickOnProducts();
				searchResultPage=productPage.validateSearchBox("T-Shirt");
				addToCartPage=searchResultPage.clickOnProduct();
				addToCartPage.enterQuantity("1");
				addToCartPage.clickOnAddToCart();
			orderpage=addToCartPage.clickOnShoppingCart();
			Double prc=orderpage.getPrice();
			Double ttlPrc= orderpage.getTotalPrice();
			By qnty= By.xpath("//*[@class='disabled']");
			String qnt=driver.findElement(qnty).getText();
			int qntty=Integer.valueOf(qnt);
			Double ttlexpectedPrc= prc*qntty;
			Assert.assertEquals(ttlPrc, ttlexpectedPrc);
		 }

}
