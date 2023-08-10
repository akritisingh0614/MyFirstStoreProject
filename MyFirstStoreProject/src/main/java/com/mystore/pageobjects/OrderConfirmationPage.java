package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	/*
	 * @FindBy(xpath="//div[@class=\"col-sm-9 col-sm-offset-1\"]//b") WebElement
	 * orderPlaced;
	 * 
	 * @FindBy(xpath="//div[@class=\"col-sm-9 col-sm-offset-1\"]//p") WebElement
	 * orderConfirmed;
	 */
	

By orderPlaced=By.xpath("//div[@class=\"col-sm-9 col-sm-offset-1\"]//b");
By orderConfirmed=By.xpath("//div[@class=\"col-sm-9 col-sm-offset-1\"]//p");

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateOrderPlaced() {
	//return	Action.isDisplayed(driver, orderPlaced);
	return driver.findElement(orderPlaced).isDisplayed();
	}
	

	public String validateOrderConfirmed() {
	String	confirmationmsg=driver.findElement(orderConfirmed).getText();
	return confirmationmsg;
	}
}
