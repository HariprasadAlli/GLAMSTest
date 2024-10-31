package com.glams.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glams.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository
	
	
	@FindBy(xpath = "//button[@id='open-menu']")
	WebElement OpenMenu;
	
	@FindBy(xpath = "//ul[@id='language-menu']//li//a[text()='English ']")
	WebElement FrenchtoEnglish;
	
	
	@FindBy(name = "UserName")
	WebElement UserName;

	@FindBy(name = "Password")
	WebElement Password;

	@FindBy(xpath = "//button[@id='login_submit']")
	WebElement LoginBtn;

	@FindBy(xpath = "//input[@id='vpin1']")
	WebElement vpin1;

	@FindBy(xpath = "//input[@id='vpin2']")
	WebElement vpin2;

	@FindBy(xpath = "//input[@id='vpin3']")
	WebElement vpin3;

	@FindBy(xpath = "//input[@name='Submit']") //button[text()='Submit']
	WebElement Submit;

	@FindBy(xpath = "//img[@src='/Content/themes/Hydrogen/Images/GLAMS-Landing-logo.png']")
	WebElement GLAMSLogo;
	
	//Method to click
	public void clickOpenMenu() {
		OpenMenu.click();
	}
	
	public void clickFrenchtoEnglish() {
		FrenchtoEnglish.click();
	}

	// Initialization of the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean ValidateGLAMSLogo() {
		return GLAMSLogo.isDisplayed();
	}
	
	

	public DashboardPage login(String un, String pwd, int v, int vp, int vpin) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
		vpin1.sendKeys(String.valueOf(v));
		vpin2.sendKeys(String.valueOf(vp));
		vpin3.sendKeys(String.valueOf(vpin));
		Submit.click();

		return new DashboardPage();
	}

}
