/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddToCartPage extends BaseClass{

	/*
	 * @FindBy(id="quantity") WebElement quantity;
	 * 
	 * @FindBy(xpath="//button[@class='btn btn-default cart']") WebElement
	 * addToCartBtn;
	 * 
	 * @FindBy(xpath="//div[@class='modal-body']/p") WebElement addToCartMsg;
	 * 
	 * @FindBy(linkText = "View Cart") WebElement shoppingCart;
	 */
	
	
	By addToCartBtn=By.xpath("//button[@class='btn btn-default cart']");
	By shoppingCart=By.xpath("//*[contains(text(),'View Cart')]");
	By addToCartMsg=By.xpath("//div[@class='modal-body']/p");
	By quantity=By.xpath("//*[@id='quantity']");
			
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String num) {
	//	Action.type(quantity, num);
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(num);
	}
	
	
	public void clickOnAddToCart() {
		//Action.click(driver, addToCartBtn);
		driver.findElement(addToCartBtn).click();
	}
	
	public String validateAddToCart() {
		//return Action.isDisplayed(driver, addToCartMsg);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartMsg));
		String addToCartMsg1=driver.findElement(addToCartMsg).getText();
		return addToCartMsg1;
	}
	
	public Orderpage clickOnShoppingCart() {
		//Action.JSClick(driver, shoppingCart);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoppingCart));
		WebElement cart=driver.findElement(shoppingCart);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", cart);
		
		return new Orderpage();
	}
}
