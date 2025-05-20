package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test (priority = 1)
	public void navigateToLoginPageTest()
	{
		loginpage = homepage.navigateToLoginPage();
		String acutalTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(acutalTitle, AppConstants.LOGINPAGE_PAGE_TITlE);
	}
	
	@Test (priority = 2)
	public void forgotPasswordLinkExistTest()
	{
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
	}
	
	@Test (priority = 3)
	public void loginPageTest()
	{
		Assert.assertTrue(loginpage.loginTest(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		
	}

}
