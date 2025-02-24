package com.glams.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.glams.qa.pages.DashboardPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotITListener {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReportNAutomation.html", true);
		extent.addSystemInfo("User Name", "Hariprasad");
		extent.addSystemInfo("OS", "Window11");
		extent.addSystemInfo("Host Name", "Hariprasad");
	}

	@AfterTest
	public void endRport() {
		extent.flush();
		extent.close();
	}

	public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		// After execution., you could see a folder "FailedTestsScreensgots" -> under
		// src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots" + ScreenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(Source, finalDestination);

		return destination;
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());// to add name in extent Report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());// to add error/exception in
																							// extent Report

			String ScreenshotPath = ScreenshotITListener.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ScreenshotPath));// to add screen in extent
																						// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(ScreenshotPath));//
			// to add cast/video in extent report

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getName());// to add name in extent Report
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());// to add name in extent Report
		}
		extent.endTest(extentTest);// ending test and ends the current test and prepare to create html report
		driver.quit();
	}

}
