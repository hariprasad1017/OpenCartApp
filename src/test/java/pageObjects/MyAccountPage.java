package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement textMyAcc;
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement cuslogout;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement uplogout;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement cusContinue;
	
	
	public void myAccountreadtext() {
		System.out.println(textMyAcc.getText());
	}
	
	public void cusLogoutBtn() {
		cuslogout.click();
	}
	
	
	public void upperLogoutBtn() {
		uplogout.click();
	}
	
	public void cusAgainContinueBtn() {
		cusContinue.click();
	}
	
	

}
