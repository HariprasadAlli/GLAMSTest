package com.glams.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glams.qa.base.TestBase;
import com.glams.qa.pages.DashboardPage;
import com.glams.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage; 
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "GLAMS - Global Artwork Management System");
		System.out.println(title + "=title" );
	}
	
	@Test(priority = 2)
	public void GLAMSLogoTest() {
		boolean flag = loginPage.ValidateGLAMSLogo();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		loginPage.clickOpenMenu();
		loginPage.clickFrenchtoEnglish();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), 7, 7, 7);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
