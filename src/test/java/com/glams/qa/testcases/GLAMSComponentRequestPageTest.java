package com.glams.qa.testcases;

import java.time.Duration;
import com.glams.qa.util.randomVariables;

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
        
		glamsComponentRequestPage.GLAMSComponentNameInputFieldSendKeys(componentNameRan);
		Assert.assertTrue(true);
		glamsComponentRequestPage.GLAMSComponentTypeDropDown();
		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSCountryDropDown();
		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSProductNameDropDown();
		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSPackagingSiteDropDown();
		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSCurrentPackagingCodeInputField("123456");
		Thread.sleep(2000);
		glamsComponentRequestPage.GLAMSSaveSubmitbutton();
		
		
		
		
	}


	
	
	

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
}
