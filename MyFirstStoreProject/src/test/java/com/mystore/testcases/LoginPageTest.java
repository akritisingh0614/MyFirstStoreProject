package com.mystore.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{

IndexPage indexPage=new IndexPage();;
LoginPage loginPage=new LoginPage();
Homepage homePage=new Homepage();

@Parameters("browser")
@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
public void setUp(String brNm) {
	launchApp(brNm);
}

	
	 @AfterMethod (groups = {"Smoke","Sanity","Regression"})
	 public void tearDown() { 
	  driver.quit();
	  ExtentManager.extent.flush();
		  }
	  
	@Test  (groups = {"Sanity","Smoke"})
	public void loginTest()  {
		
		Log.startTestCase("loginTest");
		loginPage=indexPage.clickOnSignUp();
		Log.info("Enter username and password");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Verify if you are on HomePage");
		Boolean logoutResult=homePage.validateLogout();
		Assert.assertTrue(logoutResult);
		TakesScreenshot ss=(TakesScreenshot) driver;
		File loginSs=ss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(loginSs, new File("C:\\Users\\ASUS\\eclipse-workspace\\MyFirstStoreProject\\ScreenShot\\loginSS.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		Log.endTestCase("loginTest");
	}
	@Test(groups="Sanity")
	public void verifyDeleteAcc() {
		loginPage=indexPage.clickOnSignUp();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Boolean delAccResult=homePage.validateDeleteAccount();
		Assert.assertTrue(false);
		TakesScreenshot ssDelAcc=(TakesScreenshot) driver;
		File delAccSS=ssDelAcc.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(delAccSS, new File("C:\\Users\\ASUS\\eclipse-workspace\\MyFirstStoreProject\\ScreenShot\\delAccSS.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
