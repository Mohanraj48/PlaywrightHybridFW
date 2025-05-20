package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class Homepage {
	
	private Page page;
	
	private String searchBox = "div#search input";
	private String searchBtn = "div#search button";
	private String searchTitle = "div#content h1";
	private String myAccountBtn = "span:text('My Account')";
	private String loginLink = "a:text('Login')";
	
	public Homepage(Page page)
	{
		this.page=page;
	}
	
	public String getHomepageTitle()
	{
		String title = page.title();
		System.out.println("The title is : " + title);
		return title;
	}
	
	public String getHomepageUrl()
	{
		String url = page.url();
		System.out.println("The homepage URL is : " + url);
		return url;
	}
	
	public String doSearch(String productName)
	{
		page.fill(searchBox, productName);
		page.click(searchBtn);
		String searchHeader = page.textContent(searchTitle);
		System.out.println("The search header is : " + searchHeader);
		return searchHeader;
	}

	public Loginpage navigateToLoginPage()
	{
		page.click(myAccountBtn);
		page.click(loginLink);
		return new Loginpage(page);
	}
}
