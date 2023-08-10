package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	By logo=By.xpath("//img[@src='/static/images/home/logo.png']");
	By sign=By.xpath("//a[@href='/login']");
	By productLink=By.xpath("//a[contains(text(),'Products')]");

	//@FindBy(xpath ="//a[@href='/login']")	WebElement sign;
	//	@FindBy(xpath="//header[@id='header']//a[1]/img")	WebElement logo;
	//@FindBy(linkText = " Products") 	WebElement productLink;
	
	
	
	
public IndexPage() {
	PageFactory.initElements(driver, this);
}

public LoginPage clickOnSignUp() {
	driver.findElement(sign).click();
	return new LoginPage();
}

public boolean validateLogo() {
	return driver.findElement(logo).isDisplayed();
	
}

public String getAppTitle() {
	String myStoreTitle=driver.getTitle();
	return myStoreTitle;
}

public ProductPage clickOnProducts() {
	
	driver.findElement(productLink).click();
	return new ProductPage();
}
}
