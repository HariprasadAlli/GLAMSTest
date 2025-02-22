package com.glams.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glams.qa.base.TestBase;

public class GLAMSComponentRequestPage extends TestBase {

	@FindBy(xpath = "//input[@name='GLAMS Component Name']")
	WebElement GLAMSComponentNameInputField;

	@FindBy(xpath = "(//*[@class='k-widget k-dropdown k-header ng-scope'])[1]")
	WebElement ComponentTypeDropDown;

	@FindBy(xpath = "//li[text()='Blister']")
	WebElement ComponentTypeBlister;

	@FindBy(xpath = "(//div[@class='k-widget k-multiselect k-header ng-scope'])[1]")
	WebElement CountryDropDown;

	@FindBy(xpath = "//div[@class='container-fluid main-holder']")
	WebElement ClickASide;

	@FindBy(xpath = "//li[text()='Hyderabad']")
	WebElement CountryHyderabad;

	@FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement ProductNameDropDown;

	@FindBy(xpath = "//li[text()='Acular']")
	WebElement ProductNameAcular;

	@FindBy(xpath = "(//div[@class='k-widget k-multiselect k-header ng-scope'])[3]")
	WebElement PackagingSiteDropDown;

	@FindBy(xpath = "(//*[text()='CMO3'])[2]")
	WebElement PackagingSiteCMO1;

	@FindBy(name = "GLAMS Comments")
	WebElement GLAMSComm;

	@FindBy(xpath = "//input[@id='ctrle67897b93ddf479cb472717579ff7616']")
	WebElement CurrentPackagingCodeInputField;

	@FindBy(xpath = "//button[@name='btn Save & Submit to Routing']")
	WebElement SaveSubmitbutton;

	@FindBy(xpath = "//input[@name='OK']")
	WebElement Ok;

	public GLAMSComponentRequestPage() {
		PageFactory.initElements(driver, this);
	}

	public void GLAMSComponentNameInputFieldSendKeys(String componentName) {
		// Send the provided component name to the input field
		GLAMSComponentNameInputField.sendKeys(componentName);
	}

	public void GLAMSClickASide() {
		ClickASide.click();
	}

	public void GLAMSComponentTypeDropDown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ComponentTypeDropDown));
			ComponentTypeDropDown.click();

			wait.until(ExpectedConditions.elementToBeClickable(ComponentTypeBlister));
			ComponentTypeBlister.click();
		} catch (TimeoutException e) {
			System.out.println("Element not clickable: " + e.getMessage());
		}
		GLAMSClickASide();
//		ComponentTypeDropDown.click();
//		ComponentTypeBlister.click();
//		GLAMSClickASide();

	}

	public void GLAMSCountryDropDown() {
		CountryDropDown.click();
		CountryHyderabad.click();
		GLAMSClickASide();

	}
	
	public void printsomething() {
		System.out.println("222");
	}

	public void GLAMSComments() {

		GLAMSComm.sendKeys("Comments");
		
	}

	public void GLAMSProductNameDropDown() {
		ProductNameDropDown.click();
		ProductNameAcular.click();
		GLAMSClickASide();

	}

	public void GLAMSPackagingSiteDropDown() {
		PackagingSiteDropDown.click();
		PackagingSiteCMO1.click();

	}

	public void GLAMSCurrentPackagingCodeInputField(String PackagingText) {
		// Send the provided component name to the input field
		CurrentPackagingCodeInputField.sendKeys(PackagingText);
	}

	public DashboardPage GLAMSSaveSubmitbutton() {
		SaveSubmitbutton.click();

		Ok.click();
		return new DashboardPage();

	}

}
