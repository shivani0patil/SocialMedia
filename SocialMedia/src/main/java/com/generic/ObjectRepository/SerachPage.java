package com.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerachPage {
	
	WebDriver driver=null;
	
	public SerachPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSerachInput() {
		return serachInput;
	}


	public WebElement getSelectOne() {
		return selectOne;
	}


	public WebElement getFollowbutton() {
		return followbutton;
	}


	public WebElement getFollowingStatus() {
		return FollowingStatus;
	}

	@FindBy(xpath="//input[@type='text']")
	private WebElement serachInput;
	
	@FindBy(xpath="//span[text()='shivani__kumari323' and @dir='auto']")
	private WebElement selectOne;
	
	@FindBy(xpath="//div[text()='Follow']")
	private WebElement followbutton;
	
	
	@FindBy(xpath="//div[text()='Following']")
	private WebElement FollowingStatus;
	
	@FindBy(xpath="//*[name()='svg'][@aria-label=\"Search\"]")
	private WebElement serahc;

	public WebElement getSerahc() {
		return serahc;
	}

	public void setSerahc(WebElement serahc) {
		this.serahc = serahc;
	}
	
	
	
}
