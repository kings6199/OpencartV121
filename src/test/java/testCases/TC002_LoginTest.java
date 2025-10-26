package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void Login() {
		
		logger.info("******** Starting TC002_Login_Test *************");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		logger.info("entered email");
		lp.setPassword(p.getProperty("password"));
		
		logger.info("entered password");
		lp.clickLogin();
		logger.info("******** Clicked on Login Button *************");
		
		
		MyAccountPage myacc = new MyAccountPage(driver);
		
		boolean targetPage = myacc.isMyAccountPagesExists();
		
		Assert.assertEquals(targetPage, true , "login failed");
		
		}catch(Exception e) {
			
			Assert.fail();
			
		}
		
		logger.info("******** Finished TC002_Login_Test *************");
		
	}

}
