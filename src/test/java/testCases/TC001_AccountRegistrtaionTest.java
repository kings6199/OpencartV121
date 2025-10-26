package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrtaionTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("*****Starting registration test ********");
		
		try {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*****clicked myaccount link ********");
		hp.clickRegister();
		logger.info("*****clicked register link ********");
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		logger.info("*****providing customer details ********");
		
		repage.setFirstName(randomNumber() + "John");
		repage.setLirstName(randomNumber()  +"David");
		repage.setEmail(randomNumber() + "abcdmah3e@gmail.com");
		repage.setTelephone(randomNumber() +"76738");
		repage.setpassword("xyz12345");
		repage.txtConfimrPassword("xyz12345");
		repage.setPrivacyPolicy();
		repage.clickContinue();
		logger.info("*****validating  expected message ********"); 
		
		String confmsg = repage.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!jj");
		if(confmsg.equals("Your Account Has Been Created!")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			logger.error("test failed");
			logger.debug("debug logs");
			AssertJUnit.assertTrue(false);
		}
		
		}
		catch(Exception e) {
			
			
			AssertJUnit.fail();
		}
		logger.info("finished registation test");
		
	}
	
	

}



















