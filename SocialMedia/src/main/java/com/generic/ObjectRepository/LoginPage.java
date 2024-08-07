package com.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	 WebDriver driver=null;
		public LoginPage(WebDriver driver)
		{
		   this.driver=driver;	
		   PageFactory.initElements(driver,this);
		}
		
		
		@FindBy(xpath="//input[@name='username']")
		private WebElement  username;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement  password;
		
		@FindBy(xpath="//div[text()='Log in']")
		private WebElement LoginButton;
		
		
		public void login(String user,String pass) {
			 username.sendKeys(user);
			 password.sendKeys(pass);
			 LoginButton.click();
			
		}

}
