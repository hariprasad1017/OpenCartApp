package samples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://testautomationpractice.blogspot.com/");
		driver.get("https://ui.vision/demo/webtest/frames/");
		System.out.println(driver.getTitle());
//		Thread.sleep(3000);
    	driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("hari");
		driver.switchTo().defaultContent();
		
		
		
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("prasad");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("prasad12345");
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame(3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("poorna Chandra");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(4);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("jyothi prakash");
		driver.switchTo().defaultContent();
		
		
		
		

	


		
		 
		 
	}

}
