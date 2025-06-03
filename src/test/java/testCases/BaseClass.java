package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	
	
	@Parameters({"os","browser"})
	@BeforeClass
	public void stepup(String os, String br) throws IOException 
	{
		
		//Loading config.properties file
		FileReader fis=new FileReader("./src/test/resources/config.properties");
		prop=new Properties();  
		prop.load(fis);
		
		logger =LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
		
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome": capabilities.setBrowserName("chrome"); break;
		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox": capabilities.setBrowserName("firefox"); break;
		default: System.out.println("No matching browser"); return;
		}
		
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
		
		
	

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {
//		driver.close();
		driver.quit();
	}
	
	public static String RandomString(int num) {

		String random = RandomStringUtils.randomAlphabetic(num);

		return random;
	}
	
	public static String RandomNumber(int num) {

		String random = RandomStringUtils.randomNumeric(num);

		return random;
	}
	
	public static String RandomAlphaNumeric(int num, int num1) {

		String ranApl = RandomStringUtils.randomAlphabetic(num);
		String ranNum = RandomStringUtils.randomNumeric(num1);
		return (ranApl+"@"+ranNum);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
