package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondrivers.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		try {
			prop=new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("Driver:"+driver);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void launchApp(String browsername) {
		WebDriverManager.chromedriver().setup();
		//String browsername=prop.getProperty("browser");
		if(browsername.contains("chrome")) {
			driver=new ChromeDriver();
		}else if (browsername.contains("FireFox")){
			driver= new FirefoxDriver();
		}else if (browsername.contains("IE")) {
			driver=new InternetExplorerDriver();
		}
		
driver.get(prop.getProperty("url"));
driver.manage().window().maximize();
Action.implicitWait(driver,10);
Action.pageLoadTimeOut(driver, 20);


	}
	public void afterSuite() {
		ExtentManager.endReport();
	}
		
	
	}
		
		
	

