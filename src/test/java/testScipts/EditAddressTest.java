package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class EditAddressTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(20000);
		if (driver.getTitle().contains("Shoppers")) {
			System.out.println("Welcome page displayed Successfully");
			Thread.sleep(20000);
			driver.findElement(By.id("loginBtn")).click();
			Thread.sleep(10000);
			if (driver.getTitle().contains("Login")) {
				System.out.println("Login Page Displayed successfully...");
				driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
				driver.findElement(By.id("Login")).click();
				Thread.sleep(1000);
				if (driver.getTitle().contains("Shoppers")) {
					System.out.println("User Logged in Successfully...");
					driver.findElement(By.xpath("//span[@class='BaseBadge-root MuiBadge-root css-1rzb3uu']")).click();
					driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
					driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@type='button' and @class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textSuccess MuiButton-sizeSmall MuiButton-textSizeSmall  css-n3v15g' ]")).click();
					Thread.sleep(200);
					// Locate Street Info field
                    WebElement streetInfo = driver.findElement(By.id("Street Info"));

                    // Solution 1: JavaScript Executor to force clear the field
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].value = '';", streetInfo); // Clears input field
                    Thread.sleep(500);
                    
                    // Solution 2: Use sendKeys to delete (extra safety)
                    streetInfo.sendKeys(Keys.CONTROL + "a", Keys.DELETE); 
                    Thread.sleep(500);

                    // Enter new address
                    streetInfo.sendKeys("Sundaramurthy Nagar");
                    Thread.sleep(500);

                    // Take a screenshot
					
					TakesScreenshot ts= (TakesScreenshot) driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File destination = new File("./src/test/resources/screenshots/EditAdress.png");
					FileHandler.copy(source, destination);
				
					
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
