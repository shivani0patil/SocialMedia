package com.generic.ListenerUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
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
import com.generic.WebUtility.JavaUtility;
import com.generic.WebUtility.ObjectUtility;
import com.generic.WebUtility.WebDriverUtility;
import com.generic.ObjectRepository.*;


public class BaseClass {
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility excel=new ExcelUtility();
	public JavaUtility java=new JavaUtility();
	public PropertyFile p=new PropertyFile();
	public WebDriver driver=null;
	static  WebDriver  sdriver;
	public HomePage h;
	public SerachPage se;
	
	@BeforeClass()
	public void confiBC() throws Throwable
	{
		System.out.println("lancu browser");
		String Browser=p.getDataProperty("browser");
		//String Browser=browser;
		
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
	
	@BeforeMethod()
	public void configBm() throws Throwable
	{
		System.out.println("login ===");
		
		 String Url=p.getDataProperty("url");
			String Username=p.getDataProperty("username");
			String Password=p.getDataProperty("password");
			LoginPage l=new LoginPage(driver);
			driver.get(Url);
			driver.manage().window().maximize();
		    l.login(Username, Password);
		    h=new HomePage(sdriver);
		    se=new SerachPage(sdriver);
	}
	

	@AfterMethod
	public void configAm()
	{
		
		
	h.logout();
	
	}
	
	//@Parameters("BROWSER")
	
	@AfterClass()
	public void configAC()
	{
		System.out.println("close browser");
		driver.close();
	}

   @BeforeSuite()
   public void config()
   {
   	System.out.println(" open database connection");
   	
   }
   @AfterSuite()
   public void configAS()
   {
   	System.out.println(" close database connection");
   
   }
}
