package com.generic.ListenerUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.generic.FileUtiity.ExcelUtility;
import com.generic.FileUtiity.PropertyFile;
import com.generic.WebUtility.ObjectUtility;
import com.generic.WebUtility.WebDriverUtility;
import com.generic.ObjectRepository.*;


public class BaseClass {
	
	
	public PropertyFile p=new PropertyFile();
	 public WebDriver driver=null;
	static  WebDriver  sdriver;
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	@BeforeMethod
	public void configBm() throws Throwable
	{
		System.out.println("login ===");
		String Url=p.getDataProperty("url");
		String Username=p.getDataProperty("username");
		String Password=p.getDataProperty("password");
		driver.get(Url);
		LoginPage l=new LoginPage(driver);
		l.login(Username, Password);
	}

	
	@AfterMethod
	public void configAm() throws InterruptedException
	{
		ProfilePage pp=new ProfilePage(driver);
	    pp.logout();	
	}
	
	
	@BeforeClass(groups="smokeTest")
	public void confiBC() throws Throwable
	{
		System.out.println("lancu browser");
		String Browser=p.getDataProperty("browser");
		
		
	     if(Browser.equals("chrome"))
	     {
	    	 driver=new ChromeDriver();
	     }
	     else if(Browser.equals("firefox"))
	     {
	    	 driver=new FirefoxDriver();
	    	 
	     }
	     else if(Browser.equals("Edges"))
	     {
	    	 driver=new EdgeDriver();
	    	 
	     }
	     else
	     {
	    	 driver=new ChromeDriver(); 
	     }
	     sdriver=driver;
	     ObjectUtility.setDriver(driver);
	     
	}
	@AfterClass(groups="smokeTest")
	public void configAC()
	{
		System.out.println("close browser");
		driver.close();
	}

  @BeforeSuite(groups="smokeTest")
  public void config()
  {
  	System.out.println(" open database connection");
  	
  }
  @AfterSuite(groups="smokeTest")
  public void configAS()
  {
  	System.out.println(" close database connection");
  
  }


}
