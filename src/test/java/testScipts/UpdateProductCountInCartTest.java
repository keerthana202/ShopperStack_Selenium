package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class UpdateProductCountInCartTest {

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
		                    
		                    // Search for a product
		                    driver.findElement(By.id("search")).sendKeys("apple", Keys.ENTER);
		                    Thread.sleep(3000);
		                    driver.findElement(By.id("searchBtn")).click();
		                    Thread.sleep(5000);

		                    // Click on the first product
		                    driver.findElement(By.xpath("(//div[@class='featuredProducts_footerLeft__PmkNa'])[1]")).click();
		                    Thread.sleep(2000);

		                    // Add product to cart
		                    driver.findElement(By.id("Add To Cart")).click();
		                    Thread.sleep(2000);

		                    // Navigate to cart
		                    driver.findElement(By.id("cartIcon")).click();
		                    Thread.sleep(2000);

		                    // Increase the quantity of the product in the cart
		                    String quantityText = driver.findElement(By.className("cart_quantity__Eg+qv")).getText().replaceAll("[^0-9]", "");
		                    int quantity = Integer.parseInt(quantityText); // Convert string to integer

		                    // Condition to increase quantity if less than 5, otherwise decrease
		                    if (quantity < 5) {
		                        System.out.println("Increasing quantity...");
		                        driver.findElement(By.id("increase")).click();
		                    } else {
		                        System.out.println("Decreasing quantity...");
		                        driver.findElement(By.id("decrease")).click();
		                    }
		                  
		                    Thread.sleep(1000);

		                   
		                    
		                    System.out.println("Product quantity updated successfully.");

		                    // Take screenshot after updating quantity
		                    TakesScreenshot ts = (TakesScreenshot) driver;
		                    File source = ts.getScreenshotAs(OutputType.FILE);
		                    File destination = new File("./src/test/resources/screenshots/UpdateProductCountInCartTest.png");
		                    FileHandler.copy(source, destination);
		                    
		                    System.out.println("Screenshot saved successfully.");
		                    
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
