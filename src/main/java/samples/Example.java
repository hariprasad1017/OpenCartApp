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

public class Example {

	public static WebDriver driver;
	static String year = "2026";

	static String month = "june";

	static String date = "24";

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {

			String Mo = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String Ye = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (month.equalsIgnoreCase(Mo) && year.equalsIgnoreCase(Ye)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}

		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement day : days) {
			
			  if(day.getText().equalsIgnoreCase(date)) {
				  day.click();
				  break;
			  }


			}
		}

	}

