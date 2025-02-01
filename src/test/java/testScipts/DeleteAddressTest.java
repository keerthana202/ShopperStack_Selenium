package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DeleteAddressTest {

	public static void main(String[] args) throws InterruptedException, IOException {
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
	                    driver.findElement(By.xpath("//span[@class='BaseBadge-root MuiBadge-root css-1rzb3uu']")).click();
	                    driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
	                    driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
	                    Thread.sleep(2000);

	                    // Click on the delete button for the first address (Adjust XPath if needed)
	                    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeSmall MuiButton-textSizeSmall  css-1bhvu8']")).click();
	                    Thread.sleep(1000);
	                    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium  css-1ap6el4']")).click();
	                    // Check if an alert is present before accepting it
	                    try {
	                        driver.switchTo().alert().accept();
	                        System.out.println("Alert accepted.");
	                    } catch (NoAlertPresentException e) {
	                        System.out.println("No alert present, proceeding without accepting alert.");
	                    }

	                 // Take a screenshot after deletion
	                    TakesScreenshot ts = (TakesScreenshot) driver;
	                    File source = ts.getScreenshotAs(OutputType.FILE);
	                    File destination = new File("./src/test/resources/screenshots/DeleteAddress.png");
	                    FileHandler.copy(source, destination);

	                    System.out.println("Address deleted successfully!");

	                } else {
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