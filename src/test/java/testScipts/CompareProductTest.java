package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CompareProductTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open ShoppersStack website
        driver.get("https://www.shoppersstack.com/");
        Thread.sleep(5000);

        // Verify welcome page
        if (driver.getTitle().contains("Shoppers")) {
            System.out.println("Welcome page displayed Successfully");
            Thread.sleep(20000);
            driver.findElement(By.id("loginBtn")).click();
            Thread.sleep(5000);

            // Verify login page
            if (driver.getTitle().contains("Login")) {
                System.out.println("Login Page Displayed successfully...");
                driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
                driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
                driver.findElement(By.id("Login")).click();
                Thread.sleep(5000);

                // Verify login success
                if (driver.getTitle().contains("Shoppers")) {
                    System.out.println("User Logged in Successfully...");
                    
                    // Search for the first product
                    driver.findElement(By.id("search")).sendKeys("apple");
                    driver.findElement(By.id("searchBtn")).click();
                    Thread.sleep(5000);

                    // Select the first product
                    WebElement product1 = driver.findElement(By.xpath("//span[text()='APPLE iPhone 13 Pro max']"));
                    String product1Name = product1.getText();
                    WebElement price1 = driver.findElement(By.xpath("(//span[text()='174600'])[1]"));
                    String product1Price = price1.getText();
                    product1.click();
                    Thread.sleep(3000);

                    // Search for the second product
                    driver.findElement(By.id("search")).sendKeys("apple");
                    driver.findElement(By.id("searchBtn")).click();
                    Thread.sleep(5000);

                    // Select the second product
                    WebElement product2 = driver.findElement(By.xpath("//span[text()='iphone 14 pro 128gb']"));
                    String product2Name = product2.getText();
                    WebElement price2 = driver.findElement(By.xpath("(//span[text()='112491'])"));
                    String product2Price = price2.getText();
                    product2.click();
                    Thread.sleep(3000);

                    // Compare products
                    System.out.println("Comparing Products:");
                    System.out.println("Product 1: " + product1Name + " - Price: " + product1Price);
                    System.out.println("Product 2: " + product2Name + " - Price: " + product2Price);

                    if (product1Price.equals(product2Price)) {
                        System.out.println("Both products have the same price.");
                    } else {
                        System.out.println("Products have different prices.");
                    }
                    
                    
                 	TakesScreenshot ts= (TakesScreenshot) driver;
        			File source = ts.getScreenshotAs(OutputType.FILE);
        			File destination = new File("./src/test/resources/screenshots/CompareProductTest.png");
        			FileHandler.copy(source, destination);

                } else {
                    System.out.println("Login failed.");
                }
            } else {
                System.out.println("Login page not displayed.");
            }
        } else {
            System.out.println("Welcome page not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}