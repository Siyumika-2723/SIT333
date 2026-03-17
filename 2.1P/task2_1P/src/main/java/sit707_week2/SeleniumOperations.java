package sit707_week2;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kavi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
	
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Siyumika");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastname = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element);
		lastname.sendKeys("Herathge");
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + element);
		email.sendKeys("siyumika225520039@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element);
		password.sendKeys("Siyumika123#");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		
		WebElement createAccountBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		createAccountBtn.click();

		sleep(3);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("officeworks_registration.png"));
			System.out.println("Screenshot saved successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void alternative_registration_page(String url) {

		System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Kavi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		try {
			sleep(2);
			driver.get(url);
			sleep(8);

			// First Name
			WebElement firstName = driver.findElement(By.xpath("//input[contains(@name,'first')]"));
			firstName.sendKeys("Siyumika");

			// Last Name
			WebElement lastName = driver.findElement(By.xpath("//input[contains(@name,'last')]"));
			lastName.sendKeys("Herathge");

			// Email
			WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
			email.sendKeys("siyumika225520039@example.com");

			// Password
			WebElement password = driver.findElement(By.xpath("//input[contains(@name,'pass')]"));
			password.sendKeys("Sandanee12345#");

			// Confirm Password
			WebElement confirmPassword = driver.findElement(By.xpath("//input[contains(@name,'confirm') or contains(@name,'confirmation')]"));
			confirmPassword.sendKeys("Sandanee12345#");

			sleep(2);

			// Click submit button
			WebElement createButton = driver.findElement(By.xpath("//button[@type='submit']"));
			createButton.click();

			sleep(3);

		} catch (Exception e) {
			System.out.println("JBL field filling failed.");
			e.printStackTrace();
		}

		// Take screenshot no matter what
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("jbl_registration.png");
			screenshot.renameTo(destination);
			System.out.println("JBL screenshot saved successfully.");
		} catch (Exception e) {
			System.out.println("Screenshot failed.");
			e.printStackTrace();
		}

		sleep(2);
		driver.close();
	}
	
}
