package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FetchPurchasedProductStatusTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 
		        
		        // Initialize WebDriver
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        
		        // Open ShoppersStack website
		        driver.get("https://www.shoppersstack.com/");
		        Thread.sleep(20000);

		        // Verify welcome page
		        if (driver.getTitle().contains("Shoppers")) {
		            System.out.println("Welcome page displayed Successfully");
		            Thread.sleep(5000);
		            
		            // Click on login button
		            driver.findElement(By.id("loginBtn")).click();
		            Thread.sleep(10000);

		            // Verify login page
		            if (driver.getTitle().contains("Login")) {
		                System.out.println("Login Page Displayed successfully...");
		                
		                // Enter credentials and login
		                driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
		                driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
		                driver.findElement(By.id("Login")).click();
		                Thread.sleep(5000);

		                // Verify login success
		                if (driver.getTitle().contains("Shoppers")) {
		                    System.out.println("User Logged in Successfully...");
		                    // Navigate to "Orders" section
		                    driver.findElement(By.xpath("//div[text()='K']")).click();
		        			driver.findElement(By.xpath("//li[contains(@class,'MuiButtonBase-root')][4]")).click();
		        			Thread.sleep(1000);

		                
		                    
		                 	TakesScreenshot ts= (TakesScreenshot) driver;
		        			File source = ts.getScreenshotAs(OutputType.FILE);
		        			File destination = new File("./src/test/resources/screenshots/FetchPurchasedProductStatusTest.png");
		        			FileHandler.copy(source, destination);
		                    
		                } else {
		                    System.out.println("Login failed.");
		                    driver.quit();
		                }
		            } else {
		                System.out.println("Login page not displayed.");
		                driver.quit();
		            }
		        } else {
		            System.out.println("Welcome page not displayed.");
		            driver.quit();
		        }

		        // Close the browser
		        driver.quit();
		    }
		}
