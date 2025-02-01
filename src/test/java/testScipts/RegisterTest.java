package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class RegisterTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		        WebDriver driver = new ChromeDriver();

		        // Maximize window and navigate to the website
		        driver.manage().window().maximize();
		        driver.get("https://www.shoppersstack.com/");
		        Thread.sleep(20000);
		        // Wait for the page to load
		        if (driver.getTitle().contains("Shoppers")) {
		            System.out.println("Welcome page displayed successfully");
		            
		            // Click on Login button
		            driver.findElement(By.id("loginBtn")).click();
		            Thread.sleep(10000);

		                // Click Register button
		                driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[2]")).click();
		                Thread.sleep(1000);

		                // Fill Registration Form
		                driver.findElement(By.id("First Name")).sendKeys("Keerthana");
		                Thread.sleep(1000);
		                driver.findElement(By.id("Last Name")).sendKeys("Sankar");
		                Thread.sleep(1000);
		                driver.findElement(By.xpath("//span[text()='Female']")).click();
		                Thread.sleep(1000);
		                driver.findElement(By.id("Phone Number")).sendKeys("7339573131");
		                Thread.sleep(1000);
		                driver.findElement(By.id("Email Address")).sendKeys("keerthikarls2020@gmail.com");
		                Thread.sleep(1000);
		                driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
		                Thread.sleep(1000);
		                driver.findElement(By.id("Confirm Password")).sendKeys("Keerthana@12");
		                Thread.sleep(1000);

		                // Accept Terms and Conditions
		                driver.findElement(By.id("Terms and Conditions")).click();
		                Thread.sleep(10000);

		                // Submit Registration Form
		                driver.findElement(By.id("btnDisabled")).click();
	
		                if (driver.getTitle().contains("Signup")) {
		                	System.out.println("Registration process completed successfully");
							TakesScreenshot ts= (TakesScreenshot) driver;
							File source = ts.getScreenshotAs(OutputType.FILE);
							File destination = new File("./src/test/resources/screenshots/register.png");
							FileHandler.copy(source, destination);
						} else {
							System.out.println("Invalid page displayed");
							
						}
		           
		        } else {
		            System.out.println("Invalid Welcome page displayed");
		           
		        }

		       
		    }
		}