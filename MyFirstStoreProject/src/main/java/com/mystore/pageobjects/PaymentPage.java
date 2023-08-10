/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
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
public class PaymentPage extends BaseClass{
	/*
	 * @FindBy(name="name_on_card") WebElement nameOnCard;
	 * 
	 * @FindBy(name="card_number") WebElement cardNo;
	 * 
	 * @FindBy(name="cvc") WebElement cvv;
	 * 
	 * @FindBy(name="expiry_month") WebElement month;
	 * 
	 * @FindBy(name="expiry_year") WebElement year;
	 * 
	 * @FindBy(id="submit") WebElement payConfirm;
	 */
	
	By payConfirm=By.xpath("//*[@id='submit']");
	By nameOnCard=By.xpath("//*[@name='name_on_card']");
	By cardNo=By.xpath("//*[@name='card_number']");
	By cvv=By.xpath("//*[@name='cvc']");
	By month=By.xpath("//*[@name='expiry_month']");
	By year=By.xpath("//*[@name='expiry_year']");
			
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage enterCardDetails(String name,String number,String cvc,String mm,String yyyy) {
		FluentWait<WebDriver> wait = new FluentWait(driver);
		//Specify the timout of the wait
		wait.withTimeout(Duration.ofSeconds(15));
		//Sepcify polling time
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard));
		
		driver.findElement(nameOnCard).sendKeys(name);
		driver.findElement(cardNo).sendKeys(number);
		driver.findElement(cvv).sendKeys(cvc);
		driver.findElement(month).sendKeys(mm);
		driver.findElement(year).sendKeys(yyyy);
		driver.findElement(payConfirm).click();
		return new OrderConfirmationPage();
	}
}
