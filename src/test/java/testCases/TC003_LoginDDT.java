package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void Verify_Loginddt(String username, String pass) {
		
		logger.info("I AM STARTING MY TEST CASE TC_003");
		 
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.cusLoginBtn();
		
		AccountLoginPage alp=new AccountLoginPage(driver);
		
		alp.cusTxtEmail(username);
		alp.cusTxtPass(pass);
		alp.cusLoginSubmitBtn();
		
		MyAccountPage map=new MyAccountPage(driver);
		map.cusLogoutBtn();
		
		logger.info("FINISHED MY TEST CASE TC_003");
		
		
	}
	
	
	@DataProvider(name="LoginData")
	public Object[][] LoginData(){
		
		return new Object[][] {
			
			{"abdjhon123@gmail.com","1234rty"},
			{"abdjhon123@gmail.com","1234rty"},
			{"abdjhon1234@gmail.com","12345rty"},
			{"abdjhon123@gmail.com","1234rty"},
			{"abdjhon1234@gmail.com","12345rty"}
		                      };
		
		
		
	}
	
	
	

}
