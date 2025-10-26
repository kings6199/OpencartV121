package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDt extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // getting data provider from different class
	
	public void verify_loginDTT(String email,String pwd,String exp) {
		
		logger.info("******** Starting lognindtt *************");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(email);
		logger.info("entered email");
		lp.setPassword(pwd);
		
		logger.info("entered password");
		lp.clickLogin();
		logger.info("******** Clicked on Login Button *************");
		
		
		MyAccountPage myacc = new MyAccountPage(driver);
		
		boolean targetPage = myacc.isMyAccountPagesExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(targetPage == true) {
				
				myacc.clickLogout();
				Assert.assertTrue(true);
			}else {
				
				Assert.assertTrue(false);
			}
			
		}
          if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage == true) {
				
				myacc.clickLogout();
				Assert.assertTrue(false);
			}else {
				
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e) {
			
			Assert.fail();
		}
          logger.info("******** finished lognindtt *************");
	}

}
