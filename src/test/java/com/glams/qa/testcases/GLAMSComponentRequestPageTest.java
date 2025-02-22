package com.glams.qa.testcases;

import java.time.Duration;
import java.util.regex.Pattern;

import java.util.regex.*;
import com.glams.qa.util.randomVariables;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glams.qa.base.TestBase;
import com.glams.qa.pages.DashboardPage;
import com.glams.qa.pages.GLAMSComponentRequestPage;
import com.glams.qa.pages.LoginPage;

public class GLAMSComponentRequestPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	GLAMSComponentRequestPage glamsComponentRequestPage;

	public GLAMSComponentRequestPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.clickOpenMenu();
		loginPage.clickFrenchtoEnglish();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), 7, 7, 7);
		glamsComponentRequestPage = dashboardPage.clickOnGLAMSComponentRequestPage();

	}

	@Test
	public void allMandatoryfieldsInRequestPage() throws InterruptedException {
		implicitwait();

		// Generate the random variable
		randomVariables.getRandomVariable();

		// Combine "ABC" with the generated random value
		String componentNameRan = "ABC" + randomVariables.GlobalVar;

//		glamsComponentRequestPage.GLAMSComponentNameInputFieldSendKeys(componentNameRan);
//		Assert.assertTrue(true);

		glamsComponentRequestPage.GLAMSComponentTypeDropDown();

//		glamsComponentRequestPage.GLAMSCountryDropDown();
//		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSProductNameDropDown();
//		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSPackagingSiteDropDown();

		glamsComponentRequestPage.GLAMSCurrentPackagingCodeInputField("123456");

		glamsComponentRequestPage.GLAMSComments();
		glamsComponentRequestPage.printsomething();
		System.out.println("111");
		glamsComponentRequestPage.GLAMSSaveSubmitbutton();

		Alert alert = driver.switchTo().alert();
		String popupText = alert.getText(); // Get the popup text
		System.out.println(popupText);
		alert.accept(); // Close the alert
		// Get full popup text
		Pattern pattern = Pattern.compile("BLI-\\d{5}-\\d{2}"); // Regex for job ID
		Matcher matcher = pattern.matcher(popupText);

		if (matcher.find()) {
			String jobID = matcher.group(); // Extract matched job ID
			System.out.println("Extracted Job ID: " + jobID);
		} else {
			System.out.println("Job ID not found in popup.");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
