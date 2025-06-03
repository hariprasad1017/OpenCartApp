package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registrartion() {
        
		logger.info("I AM STARTING MY TEST CASE TC_001");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(RandomString(5));
		regpage.setLastName(RandomString(4));
		regpage.setEmail(RandomString(8) + "@gmail.com");
		regpage.setTelephone(RandomNumber(10));
		
		String pasto=RandomAlphaNumeric(3, 4);
		regpage.setPassword(pasto);
		regpage.setConfimPassword(pasto);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();

		String conf = regpage.getConfirmationMsg();
		Assert.assertEquals(conf, "Your Account Has Been Created!");
		
		logger.info("FINISHED MY TEST CASE TC_001");

	}

	

}
