package com.mystore.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.mystore.base.BaseClass;


public class ListenerClass extends ExtentManager implements ITestListener {

	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//	String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());

  TakesScreenshot ss=(TakesScreenshot) BaseClass.driver; File
  loginSs=ss.getScreenshotAs(OutputType.FILE); 
  try {
	FileUtils.copyFile(loginSs, new  File(  "C:\\Users\\ASUS\\eclipse-workspace\\MyFirstStoreProject\\ScreenShot\\loginSS.png" ));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
  String imgPath=  "http://localhost:8082/job/MyFirstStoreProject/ws/MyFirstStoreProject/ScreenShots/"  +result.getName()+".png";
  try {
	test.fail("ScreenShot is Attached",  MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}