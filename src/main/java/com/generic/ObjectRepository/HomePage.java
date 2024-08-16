package com.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver=null;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='More']")
	private WebElement morelink;
	
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logoutlink;

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	public void logout()
	{
		morelink.click();
		logoutlink.click();
	}
}
