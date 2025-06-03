package samples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		futureDatePicker(driver,"April","2026","10");


	}

	static void futureDatePicker(WebDriver driver,String month,String year, String date) {

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

			if (day.getText().equalsIgnoreCase(date)) {
				day.click();
				break;
			
			}
		}
			
	}	
			
	static void pastDatePicker(WebDriver driver,String month,String year, String date) {

				while (true) {

					String Mo = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					String Ye = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

					if (month.equalsIgnoreCase(Mo) && year.equalsIgnoreCase(Ye)) {
						break;
					} else {
						driver.findElement(By.xpath("//span[text()='Prev']")).click();
					}
				}

				List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

				for (WebElement day : days) {

					if (day.getText().equalsIgnoreCase(date)) {
						day.click();
						break;
					}

				}

		



}
	
		}
