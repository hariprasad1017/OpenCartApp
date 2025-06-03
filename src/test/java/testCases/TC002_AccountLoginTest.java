package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class TC002_AccountLoginTest extends BaseClass {
	
	@Test()
	public void verify_Account_Login() {
		
		logger.info("I AM STARTING MY TEST CASE TC_002");
		 
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.cusLoginBtn();
		
		AccountLoginPage alp=new AccountLoginPage(driver);
		
		alp.cusTxtEmail(prop.getProperty("cusEmail"));
		alp.cusTxtPass(prop.getProperty("cusPassword"));
		alp.cusLoginSubmitBtn();

		MyAccountPage map=new MyAccountPage(driver);
	    map.myAccountreadtext();
	  

		
		logger.info("FINISHED MY TEST CASE TC_002");
		
	}
	


}
