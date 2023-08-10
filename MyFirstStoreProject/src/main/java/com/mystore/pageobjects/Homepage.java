/**
 * 
 */
package com.mystore.pageobjects;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class Homepage extends BaseClass {

	/*
	 * @FindBy(xpath="//*[text()=' Logged in as ']") WebElement loggedInAs;
	 * 
	 * @FindBy(linkText = " Logout") WebElement logOut;
	 * 
	 * @FindBy(linkText=" Delete Account") WebElement deleteAcc;
	 * 
	 * @FindBy(linkText = " Products") WebElement products;
	 */
	
	By loggedInAs=By.xpath("//*[text()=' Logged in as ']");
	By logOut=By.xpath("//a[contains(text(),'Logout')]");
	By deleteAcc=By.xpath("//a[contains(text(),'Delete Account')]");
	By products=By.xpath("//a[contains(text(),'Products')]");
	By carts =By.xpath("//a[contains(text(),'Cart')]");
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoggedInAs() {
	//return 	Action.isDisplayed(driver, loggedInAs);
		return driver.findElement(loggedInAs).isDisplayed();
	}
	
	public boolean validateLogout() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//WebElement currentElement = driver.switchTo().activeElement();
		//currentElement.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logOut));
		
	return driver.findElement(logOut).isDisplayed();
		//return 	Action.isDisplayed(driver, logOut);
		}
	
	public boolean validateDeleteAccount() {
		//return 	Action.isDisplayed(driver, deleteAcc);
		return driver.findElement(deleteAcc).isDisplayed();
		}
	
	public ProductPage clickOnProducts() {
		//Action.click(driver, products);
		driver.findElement(products).click();
		return new ProductPage();
	}
	
	public Orderpage clickOnCarts() {
		//Action.click(driver, products);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(carts));
		driver.findElement(carts).click();
		return new Orderpage();
	}
	public String getCurrUrl() {
		String currUrl=driver.getCurrentUrl();
		return currUrl;
	}
}
