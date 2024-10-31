package com.glams.qa.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestcase {

	public static void main(String args[]) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hariprasad.alli\\OneDrive - Perigord Premedia Ltd\\Documents\\Eclipse\\Practise\\testing.glams\\target\\Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.navigate()
				.to("https://glams6qa.glams.ie/Login?returnUrl=%2FRequest%3FType%3DDefault%26taskName%3DDashboard");
		
		System.out.println("who are youl;");
		
		driver.findElement(By.xpath("//button[@id='open-menu']")).click();
		driver.findElement(By.xpath("//ul[@id='language-menu']//li//a[text()='English ']")).click();
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("Hariprasad");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Perigord2!");
		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
		driver.findElement(By.id("vpin1")).sendKeys("7");
        driver.findElement(By.id("vpin2")).sendKeys("7");
        driver.findElement(By.id("vpin3")).sendKeys("7");
        driver.findElement(By.xpath("//*[@value = 'Submit']")).click();
        driver.quit();
	}
}
