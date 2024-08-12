package com.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver=null;
	//jhgjgkgkjgkg
	
	public ProfilePage(WebDriver driver)
	{
	   this.driver=driver;	
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class=\"x1q0g3np x2lah0s\"]")
	private WebElement  optionsButton;
	
	@FindBy(xpath="//button[text()=\"Log Out\"]")
	private WebElement getLogoutButton;
	
	@FindBy(xpath="")
	private WebElement profileButton;
	
	public WebElement getOptionsButton() {
		return optionsButton;
	}

	public WebElement getGetLogoutButton() {
		return getLogoutButton;
	}

	public WebElement getProfileButton() {
		return profileButton;
	}
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
     	getOptionsButton().click();
     	getGetLogoutButton().click();
	}

}
