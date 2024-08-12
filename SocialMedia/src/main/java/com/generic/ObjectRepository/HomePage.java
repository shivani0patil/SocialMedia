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

	@FindBy(xpath="//section[@class='x78zum5 xdt5ytf x1iyjqo2 xg6iff7']/descendant::div[@class='x78zum5 xdt5ytf x1e56ztr']")
	private WebElement saveLogin;
	@FindBy(xpath="//button[text()='Not Now']")
	private WebElement TurnOffNotification;
	@FindBy(xpath="//*[@aria-label=\"Messenger\"]")
	private WebElement messageButton;
	public void goToHomePage() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		saveLogin.click();
		TurnOffNotification.click();
	}

	public WebElement getSaveLogin() {
		return saveLogin;
	}

	public WebElement getTurnOffNotification() {
		return TurnOffNotification;
	}

	public WebElement getmessageButton() {
		return messageButton;
	}
	

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
