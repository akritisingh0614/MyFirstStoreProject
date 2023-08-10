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
public class LoginPage extends BaseClass{
	/*
	 * @FindBy(xpath="//*[@data-qa='login-email']") WebElement username;
	 * 
	 * @FindBy(name="password") WebElement password;
	 * 
	 * @FindBy(linkText="Login") WebElement submit; //@FindBy(linkText = "Continue")
	 * WebElement newuserLink;
	 * 
	 * @FindBy(name="name") WebElement name;
	 * 
	 * @FindBy(xpath="//*[@data-qa='signup-email']") WebElement signUpMail;
	 * 
	 * @FindBy(linkText = "Signup") WebElement signUpBtn;
	 */

	By username=By.xpath("//*[@data-qa='login-email']");
	By password=By.name("password");
	By submit=By.xpath("//*[@data-qa='login-button']");
	By name=By.name("name");
	By signUpMail=By.xpath("//*[@data-qa='signup-email']");
	By signUpBtn=By.xpath("//*[@data-qa='signup-button']");
	
public LoginPage() {
	PageFactory.initElements(driver, this);
}

public Homepage login(String usrnm,String pass) {
		
	driver.findElement(username).sendKeys(usrnm);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(submit).click();
	return new Homepage();
}

public AccountCreationPage createNewAccount(String nm, String email) {
	
	driver.findElement(name).sendKeys(nm);
	driver.findElement(signUpMail).sendKeys(email);
	driver.findElement(signUpBtn).click();
	return new AccountCreationPage();
}


}
