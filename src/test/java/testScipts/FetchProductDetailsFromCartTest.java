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

public class FetchProductDetailsFromCartTest {

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
	                    driver.findElement(By.id("cartIcon")).click();
	                   WebElement element = driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiCard-root cart_cartProduct__6vbyW MuiPaper-elevation1 MuiPaper-rounded']"));
	                   System.out.println(element.getText());
	                    // Take a screenshot after deletion
	                    TakesScreenshot ts = (TakesScreenshot) driver;
	                    File source = ts.getScreenshotAs(OutputType.FILE);
	                    File destination = new File("./src/test/resources/screenshots/FetchProductDetailsFromCard.png");
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
