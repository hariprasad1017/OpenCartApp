package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement cusEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement cusPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement loginsubmit;
	
	
	
	public void cusTxtEmail(String cEmail) {
		cusEmail.sendKeys(cEmail);
	}
	
	public void cusTxtPass(String cPass) {
		cusPassword.sendKeys(cPass);
	}
	
	public void cusLoginSubmitBtn() {
		loginsubmit.click();
	}
	

	
	
	
	
	
	
	
	
	

}
