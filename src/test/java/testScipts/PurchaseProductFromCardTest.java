package testScipts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class PurchaseProductFromCardTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.shoppersstack.com/");
	        Thread.sleep(20000);

	        // Verify welcome page
	        if (driver.getTitle().contains("Shoppers")) {
	            System.out.println("Welcome page displayed Successfully");
	            Thread.sleep(20000);
	            driver.findElement(By.id("loginBtn")).click();
	            Thread.sleep(10000);

	            // Verify login page
	            if (driver.getTitle().contains("Login")) {
	                System.out.println("Login Page Displayed successfully...");
	                driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
	                driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
	                driver.findElement(By.id("Login")).click();
	                Thread.sleep(1000);

	                // Verify login success
	                if (driver.getTitle().contains("Shoppers")) {
	                    System.out.println("User Logged in Successfully...");
	                    Thread.sleep(2000);
	                    driver.findElement(By.id("search")).sendKeys("apple",Keys.ENTER);
	                    Thread.sleep(3000);
	                    driver.findElement(By.id("searchBtn")).click();
	                    Thread.sleep(10000);
	                    
	                    driver.findElement(By.xpath("(//div[@class='featuredProducts_footerLeft__PmkNa'])[1]")).click();
	                    Thread.sleep(1000);
	                    driver.findElement(By.id("Add To Cart")).click();
	                    Thread.sleep(500);
	                    driver.findElement(By.id("cartIcon")).click();
	                    Thread.sleep(500);
	                    driver.findElement(By.id("buynow_fl")).click();
	                    Thread.sleep(500);
	                    driver.findElement(By.xpath("//button[@class='selectaddress_adneadd__cICdt']")).click();
	                    Thread.sleep(500);
	                 // Check if any saved address is available
	                    List<WebElement> existingAddresses = driver.findElements(By.xpath("//input[@name='address']"));

	                    if (!existingAddresses.isEmpty()) { 
	                        // If address exists, select it
	                        existingAddresses.get(0).click(); 
	                        System.out.println("Existing address selected.");
	                    } else { 
	                        // If no address exists, add a new address
	                        System.out.println("No existing address found. Adding a new address...");
	                    	                        
	                        driver.findElement(By.id("Name")).sendKeys("Keerthana");
	                        Thread.sleep(500);
	                        driver.findElement(By.id("House/Office Info")).sendKeys("No:21");
	                        Thread.sleep(500);
	                        driver.findElement(By.id("Street Info")).sendKeys("Sundaramoorthy Nagar");
	                        Thread.sleep(500);
	                        driver.findElement(By.id("Landmark")).sendKeys("New Saram");
	                        Thread.sleep(500);
	                        
	                        WebElement country = driver.findElement(By.id("Country"));
	                        new Select(country).selectByVisibleText("India");
	                        Thread.sleep(500);
	                        
	                        WebElement state = driver.findElement(By.id("State"));
	                        new Select(state).selectByVisibleText("Puducherry (union territory)");
	                        Thread.sleep(500);
	                        
	                        WebElement city = driver.findElement(By.id("City"));
	                        new Select(city).selectByVisibleText("Puducherry");
	                        Thread.sleep(1000);
	                        
	                        driver.findElement(By.id("Pincode")).sendKeys("560029");
	                        Thread.sleep(1000);
	                        
	                        driver.findElement(By.id("Phone Number")).sendKeys("7339573131");
	                        Thread.sleep(1000);
	                        
	                        driver.findElement(By.id("addAddress")).click();
	                        Thread.sleep(1000);
	                        
	                        // Select the newly added address
	                        driver.findElement(By.xpath("//input[@name='address']")).click();
	                    }

	                    // Proceed with checkout
	                    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	                    Thread.sleep(800);

	                    // Take a screenshot
	                    TakesScreenshot ts = (TakesScreenshot) driver;
	                    File source = ts.getScreenshotAs(OutputType.FILE);
	                    File destination = new File("./src/test/resources/screenshots/PurchaseProductFromCardTest.png");
	                    FileHandler.copy(source, destination);

					
	                }
           else {
              System.out.println("Invalid page displayed");
              driver.quit();
          }
      } else {
          System.out.println("Invalid page displayed");
          driver.quit();
      }
	      } else {
      System.out.println("Invalid page displayed");
      driver.quit();
  }
	        
	}

}
