package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class ProductPage extends BaseClass{

	/*
	 * @FindBy(id="search_product") WebElement searchBox;
	 * 
	 * @FindBy(id="submit_search") WebElement searchBtn;
	 */
	
	By searchBox=By.xpath("//*[@id='search_product']");
	By searchBtn=By.xpath("//*[@id='submit_search']");

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public SearchResultPage validateSearchBox(String src) {
		
		driver.findElement(searchBox).sendKeys(src);
		driver.findElement(searchBtn).click();
		return new SearchResultPage();
	}
}
