package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.Homepage;
import com.qa.opencart.pages.Loginpage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	
	protected Properties prop;
	protected Homepage homepage;
	protected Loginpage loginpage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName)
	{
		pf=new PlaywrightFactory();
		prop = pf.init_prop();
		if(browserName!=null)
		{
			prop.setProperty("browser", browserName);
			
		}
		page = pf.initBrowser(prop);
		homepage=new Homepage(page);
	}
	
	@AfterTest
	public void teardown()
	{
		page.context().browser().close();
	}
}
