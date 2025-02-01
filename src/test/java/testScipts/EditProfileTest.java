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

public class EditProfileTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(10000);
		if (driver.getTitle().contains("Shoppers")) {
			System.out.println("Welcome page displayed Successfully");
			Thread.sleep(40000);
			driver.findElement(By.id("loginBtn")).click();
			Thread.sleep(10000);
			if (driver.getTitle().contains("Login")) {
				System.out.println("Login Page Displayed successfully...");
				driver.findElement(By.id("Email")).sendKeys("keerthikarls2020@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("Keerthana@12");
				Thread.sleep(10000);
				driver.findElement(By.id("Login")).click();
		
		
		if (driver.getTitle().contains("Shoppers")) {
			System.out.println("Home page displayed Successfully");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[text()='K']")).click();
			driver.findElement(By.xpath("//li[contains(@class,'MuiButtonBase-root')][1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium  css-t2wvjf']")).click();
			Thread.sleep(1000);
			WebElement state = driver.findElement(By.id("State"));
     		Select sel=new Select(state);
     		sel.selectByValue("Tamil Nadu");	
     		
     		 Thread.sleep(1000);
             WebElement city = driver.findElement(By.id("City"));
      		Select sel1=new Select(city);
      		sel1.selectByValue("Chennai");	
      		
      		driver.findElement(By.xpath("//button[@name='submit']")).click();
      		Thread.sleep(500);
      		driver.switchTo().alert().accept();
      		System.out.println("Profile Edited Successfully");
			
        	TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./src/test/resources/screenshots/ProfileEdited.png");
			FileHandler.copy(source, destination);
		 }
		else {
			System.out.println("Invalid page displayed");
			driver.quit();
		}
		}
		else {
			System.out.println("Invalid page displayed");
			driver.quit();
		}
		}
		else {
			System.out.println("Invalid page displayed");
			driver.quit();
		}
	
	}

}
