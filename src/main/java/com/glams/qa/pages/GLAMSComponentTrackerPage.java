package com.glams.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.glams.qa.base.TestBase;

public class GLAMSComponentTrackerPage extends TestBase {

	@FindBy(xpath = "(//input[@name='grid_search_input'])[1]")
	WebElement SearchField;
	
	@FindBy(xpath = "(//button[@title='Search'])[1]")
	WebElement binculosserach;
	
	@FindBy(xpath = "//table[@class='k-selectable']//tr[1]//td[3]//a")
	WebElement PartNumber;
	
	@FindBy(xpath = "//a[@title='Job Control']")
	WebElement JobControlTab;
	
	@FindBy(xpath = "//textarea[@name='Comments']")
	WebElement Comments;
	
	@FindBy(name = "GLAMS Comments")
	WebElement GLAMSComments;
	
	@FindBy(xpath = "//button[@name='BtnHold']sd")
	WebElement Holdbutton;
	
	public GLAMSComponentTrackerPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void SearchandJobControl() throws InterruptedException {
		SearchField.sendKeys("BLI-12663-01");
		binculosserach.click();
		Thread.sleep(5000);
		String PartNumberText = PartNumber.getText();
		Assert.assertEquals(PartNumberText, "BLI-12663-01jkjkhuf", "PartNumber not matched");
		
		PartNumber.click();
		JobControlTab.click();
	}
	
	public void AddbothComments() {
		Comments.sendKeys("Only Comments");
		
		GLAMSComments.sendKeys("GLAMS Comments");
	}
	
	public void HoldJob() {
		Holdbutton.click();
	}

}
