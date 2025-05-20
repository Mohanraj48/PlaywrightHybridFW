package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class Loginpage {
	Page page;

	public Loginpage(Page page) {
		this.page = page;
	}

	private String emailID = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPasswordVisible = "div.form-group a";
	private String logoutLinkVisible = "div.list-group a:text('Logout')";
	
	
	public String getLoginPageTitle()
	{
		return page.title();
	}
	
	public boolean isForgotPasswordLinkExist()
	{
		return page.isVisible(forgotPasswordVisible);
	}
	
	public boolean loginTest(String appUserName, String appPassword)
	{
		System.out.println("App cred is : " + appUserName + " : " + appPassword);
		page.fill(emailID, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		
		if (page.isVisible(logoutLinkVisible))
		{
			System.out.println("Logged in successfully..");
			return true;
		}
		return false;
	}

}
