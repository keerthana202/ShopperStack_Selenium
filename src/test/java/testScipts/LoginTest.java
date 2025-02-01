package testScipts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LoginTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(10000);
		if (driver.getTitle().contains("Shoppers")) {
			System.out.println("Welcome page displayed Successfully");
			Thread.sleep(10000);
			driver.findElement(By.id("loginBtn")).click();
			Thread.sleep(10000);
			if (driver.getTitle().contains("Login")) {
				System.out.println("Login Page Displayed successfully...");
				driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
				driver.findElement(By.id("Login")).click();
				if (driver.getTitle().contains("Shoppers")) {
					System.out.println("User Logged in Successfully...");
					TakesScreenshot ts= (TakesScreenshot) driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File destination = new File("./src/test/resources/screenshots/login.png");
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
