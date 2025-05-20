package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstants;

public class HomepageTest extends BaseTest
{
	@Test
	public void homepageTitleTest()
	{
		String actualTitle = homepage.getHomepageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOMEPAGE_PAGE_TITlE);
	}
	
	@Test
	public void homepageUrlTest()
	{
		String actualUrl = homepage.getHomepageUrl();
		Assert.assertEquals(actualUrl, "https://naveenautomationlabs.com/opencart/");
	}
	
	@DataProvider
	public Object[][] getSearchData()
	{
		return new Object[][] 
		{
			{"Apple"},
			{"Phone"},
			{"sony"},
			{"canon"}
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void searchTest(String srchData)
	{
		String actualHeader = homepage.doSearch(srchData);
		Assert.assertEquals(actualHeader, "Search - "+srchData);
	}
	
	
	

}
