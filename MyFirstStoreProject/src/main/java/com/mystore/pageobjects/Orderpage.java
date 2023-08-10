/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class Orderpage extends BaseClass{
	/*
	 * @FindBy(xpath="//td[@class='cart_price']") WebElement price;
	 * 
	 * @FindBy(xpath="//p[@class='cart_total_price']") WebElement total;
	 * 
	 * @FindBy(linkText = "Proceed To Checkout") WebElement checkout;
	 */

	By price=By.xpath("//td[@class='cart_price']");
	By total=By.xpath("//p[@class='cart_total_price']");
	By checkout=By.xpath("//a[@class='btn btn-default check_out']");
	By loginReg=By.xpath("//p[@class='text-center']/a");
	
public Orderpage() {
	PageFactory.initElements(driver, this);
}

public double getPrice() {
String pr=driver.findElement(price).getText();
String unitPrice=pr.replaceAll("Rs.","");
double prc=Double.parseDouble(unitPrice);
return prc;
}

public double getTotalPrice() {
String tpr=driver.findElement(total).getText();
String totalPrice=tpr.replaceAll("Rs.","");
double totPrc=Double.parseDouble(totalPrice);
return totPrc;
}

public LoginPage clickOnCheckout() {
	//Action.click(driver, checkout);
	driver.findElement(checkout).click();
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginReg));
	
	FluentWait<WebDriver> wait = new FluentWait(driver);
	//Specify the timout of the wait
	wait.withTimeout(Duration.ofSeconds(15));
	//Sepcify polling time
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(loginReg));
	
	WebElement lgn=driver.findElement(loginReg);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", lgn);
	
	return new LoginPage();
}

public AddressPage clickOnCheckout1() {
	//Action.click(driver, checkout);
	driver.findElement(checkout).click();
	
	
	return new AddressPage();
}
}
