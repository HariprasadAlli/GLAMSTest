package com.glams.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.glams.qa.util.TestUtil;
import com.google.j2objc.annotations.Property;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hariprasad.alli\\OneDrive - Perigord Premedia Ltd\\"
					+ "Documents\\Eclipse\\Practise\\N_Automation\\src\\main\\java\\com\\glams\\qa\\util\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\hariprasad.alli\\OneDrive - Perigord Premedia Ltd\\Documents\\Eclipse\\Practise\\testing.glams\\target\\Server\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));

		
	}
	
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
