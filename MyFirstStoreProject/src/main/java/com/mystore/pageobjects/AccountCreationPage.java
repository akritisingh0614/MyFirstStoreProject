package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;


public class AccountCreationPage extends BaseClass{

	
//	@FindBy(xpath="//div[@class='login-form']//b")WebElement formTitle;
	
	By formTitle=By.xpath("//div[@class='login-form']//b");
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatepage() {
		//return Action.isDisplayed(driver, formTitle);
		return driver.findElement(formTitle).isDisplayed();
	}
}
