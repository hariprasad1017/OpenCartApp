package samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeLaunch {
	
	
	public static WebDriver driver;
	
	@Test
	public void chromestart() {
		
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		driver.close();	
	}
	
	@Test
	public void terminarymtd() {
		int a=10,b=20,c=30;
		
		int max=( a>b) ? (a>c ? a : c)  : (b>c ? b: c); 
		
		System.out.println(max);
		
	}
	
	

}
