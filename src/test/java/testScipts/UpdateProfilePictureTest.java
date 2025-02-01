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

public class UpdateProfilePictureTest {

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
			driver.findElement(By.xpath("(//button[contains(@class,MuiButtonBase)])[2]")).click();
			Thread.sleep(2000);
			System.out.println("Updating..");
			WebElement dobField = driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']"));
			Thread.sleep(1000);
			dobField.clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).click();
			dobField.clear();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("arguments[0].value='02/12/2003';", dobField);
             
             // Trigger a change event if necessary
             js.executeScript("arguments[0].dispatchEvent(new Event('change'));", dobField);
             
             Thread.sleep(1000);
            WebElement state = driver.findElement(By.id("State"));
     		Select sel=new Select(state);
     		sel.selectByValue("Puducherry (union territory)");	
     		
     		 Thread.sleep(1000);
             WebElement city = driver.findElement(By.id("City"));
      		Select sel1=new Select(city);
      		sel1.selectByValue("Puducherry");	
      		
      		driver.findElement(By.xpath("//button[@name='submit']")).click();
    
        	System.out.println("Update displayed Successfully");
			
        	TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./src/test/resources/screenshots/UpdateProfile.png");
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
