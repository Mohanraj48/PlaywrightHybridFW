package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext bcx;
	Page page;
	
	Properties prop;
	
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	
	public static Playwright getPlaywright() 
	{
		return tlPlaywright.get();
	}
	
	public static Browser getBrowser() 
	{
		return tlBrowser.get();
	}
	
	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}
	
	public static Page getPage() 
	{
		return tlPage.get();
	}
	
	
	
	
	
	
	public Page initBrowser(Properties prop)
	{
		String browserName= prop.getProperty("Browser").trim();
		
		//playwright = Playwright.create();
		
		tlPlaywright.set(Playwright.create());
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
			//browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			
		case "safari":
			//browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			
		case "chrome":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;

		default:
			System.out.println("Please provide the proper browser name");
			break;
		}
		
//		bcx = browser.newContext();
//		page = bcx.newPage();
		
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(getBrowserContext().newPage());
		
		getPage().navigate(prop.getProperty("url").trim());
		//return page;
		
		return getPage();
	}

public Properties init_prop()
{
	try {
		FileInputStream ip=new FileInputStream("./src/test/resource/config/config.properties");
		prop=new Properties();
		prop.load(ip);
		
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	return prop;
}

}
