/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class SearchResultPage extends BaseClass{

	/*
	 * @FindBy(xpath="//div[@class='productinfo text-center']/img") WebElement
	 * searchresultproduct;
	 * 
	 * @FindBy(xpath="//div[@class='choose']/ul//li/a") WebElement viewProduct;
	 */
	
	By searchresultproduct=By.xpath("//div[@class='productinfo text-center']/img");
	By viewProduct=By.xpath("//div[@class='choose']/ul//li/a");
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
	//return	Action.isDisplayed(driver, searchresultproduct);
	return driver.findElement(searchresultproduct).isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() {
		//Action.click(driver, viewProduct);
		driver.findElement(viewProduct).click();
		return new AddToCartPage();
	}
}
