package com.glams.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.glams.qa.base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath = "//span[@title='Hariprasad']")
	WebElement UserNameLabel;
	
	@FindBy(xpath = "//a[@title='GLAMS Add New']")
	WebElement GLAMSAddNew;
	
	@FindBy(xpath = "//a[text()='GLAMS Component ']")
	WebElement GLAMSComponentRequest;
	
	@FindBy(xpath = "//a[@title='GLAMS Tracker']")
	WebElement GLAMSTracker;
	
	@FindBy(xpath= "//a[@title='GLAMS Component Tracker']")
	WebElement GLAMSComponentTracker;
	
	@FindBy(xpath = "//a[@title='GLAMS Repository']")
	WebElement GLAMSRepository;
	
	@FindBy(xpath= "//a[@title='GLAMS Component Repository']")
	WebElement GLAMSComponentRepository;
	
	//deleted
	//why deleted
	public boolean VerifyUserNameLabel() {
	    return UserNameLabel.isDisplayed();
	}
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyDashboardTitle() {
		return driver.getTitle();
	}
	
	public GLAMSComponentRequestPage clickOnGLAMSComponentRequestPage() {
		GLAMSAddNew.click();
		GLAMSComponentRequest.click();
		
		return new GLAMSComponentRequestPage();
		
	}
	
	public GLAMSComponentTrackerPage clickOnGLAMSComponentTrackerPage() {
//		Actions action = new Actions(driver);
//		action.moveToElement(GLAMSComponentTracker).build().perform();
		GLAMSTracker.click();
		GLAMSComponentTracker.click();
		return new GLAMSComponentTrackerPage();
		
		
	}
	
	public GLAMSComponentRepositoryPage clickOnGLAMSComponentRepositorypage() {
		GLAMSRepository.click();
		GLAMSComponentRepository.click();
		return new GLAMSComponentRepositoryPage();
		
	}

}
