/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddressPage extends BaseClass{

	/*
	 * @FindBy(xpath="//*[@id=\"address_delivery\"]//h3") WebElement
	 * addressDelivery;
	 * 
	 * @FindBy(xpath="//*[@id=\"address_invoice\"]//h3") WebElement billingAddress;
	 * 
	 * @FindBy(linkText = "Place Order") WebElement placeorder;
	 */
	

By addressDelivery=By.xpath("//*[@id=\"address_delivery\"]//h3");
By placeorder=By.xpath("//a[@class='btn btn-default check_out']");
By billingAddress=By.xpath("//*[@id=\"address_invoice\"]//h3");

	public AddressPage() {
		PageFactory.initElements(driver, this);
	}	
	
	public boolean validateShippingAddress() {
		//return Action.isDisplayed(driver, addressDelivery);
		return driver.findElement(addressDelivery).isDisplayed();
	}
	
	public boolean validateBillingAddress() {
		//return Action.isDisplayed(driver, billingAddress);
		return driver.findElement(billingAddress).isDisplayed();
	}
	
	public PaymentPage clickOnPlaceorder() {
		//Action.click(driver, placeorder);
		new Actions(driver).moveToElement(driver.findElement(placeorder)).click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(placeorder));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(driver.findElement(placeorder))).click();;
		//driver.findElement(placeorder).click();
		return new PaymentPage();
	}
}
