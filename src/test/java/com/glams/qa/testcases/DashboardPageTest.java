package com.glams.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glams.qa.base.TestBase;
import com.glams.qa.pages.DashboardPage;
import com.glams.qa.pages.GLAMSComponentRequestPage;
import com.glams.qa.pages.GLAMSComponentTrackerPage;
import com.glams.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	GLAMSComponentRequestPage glamsComponentRequestPage;
	GLAMSComponentTrackerPage glamsComponentTrackerPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		
		initialization();
		loginPage = new LoginPage();
		loginPage.clickOpenMenu();
		loginPage.clickFrenchtoEnglish();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), 7, 7, 7);
		glamsComponentTrackerPage = dashboardPage.clickOnGLAMSComponentTrackerPage();
	}

	@Test(priority = 1)
	public void verifyUserNameTest() {
		Assert.assertTrue(dashboardPage.VerifyUserNameLabel());
	}

	@Test(priority = 2)
	public void verifyDasboardTitlePageTest() {
		String dashboardPageTitle = dashboardPage.VerifyDashboardTitle();
		Assert.assertEquals(dashboardPageTitle, "GLAMS - Global Artwork Management System",
				"Dashboard Page Title not matched");
	}

	@Test(priority = 3)
	public void verifyclickOnGLAMSComponentRequestPageTest() {
		implicitwait();
		glamsComponentRequestPage = dashboardPage.clickOnGLAMSComponentRequestPage();

	}

	@Test(priority = 4)
	public void verifyclickOnGLAMSComponentTrackerPageTest() {
		glamsComponentTrackerPage = dashboardPage.clickOnGLAMSComponentTrackerPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
