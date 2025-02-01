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
import org.openqa.selenium.support.ui.Select;

public class AddAddressTest {

	public static void main(String[] args)  throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(1000);
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
				Thread.sleep(1000);
				if (driver.getTitle().contains("Shoppers")) {
					System.out.println("User Logged in Successfully...");
					driver.findElement(By.xpath("//span[@class='BaseBadge-root MuiBadge-root css-1rzb3uu']")).click();
					driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz'])[1]")).click();
					driver.findElement(By.xpath("//div[text()='My Addresses']")).click();
					driver.findElement(By.xpath("//button[text()='Add Address']")).click();
					
					driver.findElement(By.id("Name")).sendKeys("Keerthana");
					Thread.sleep(500);
					driver.findElement(By.id("House/Office Info")).sendKeys("No:21");
					Thread.sleep(500);
					driver.findElement(By.id("Street Info")).sendKeys("Sundaramoorthy Nagar");
					Thread.sleep(500);
					driver.findElement(By.id("Landmark")).sendKeys("New Saram");
					Thread.sleep(500);
					
					WebElement country = driver.findElement(By.id("Country"));
					Select sel1=new Select(country);
					sel1.selectByVisibleText("India");
					Thread.sleep(500);
					
					WebElement state = driver.findElement(By.id("State"));
					Select sel2=new Select(state);
					sel2.selectByVisibleText("Puducherry (union territory)");
					Thread.sleep(500);
					
					WebElement city = driver.findElement(By.id("City"));
					Select sel3=new Select(city);
					sel3.selectByVisibleText("Puducherry");
					Thread.sleep(1000);
					
					driver.findElement(By.id("Pincode")).sendKeys("605013");
					Thread.sleep(1000);
					
					driver.findElement(By.id("Phone Number")).sendKeys("7339573131");
					Thread.sleep(1000);
					
					driver.findElement(By.id("addAddress")).click();
					Thread.sleep(500);
					TakesScreenshot ts= (TakesScreenshot) driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File destination = new File("./src/test/resources/screenshots/AddAdress.png");
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
