package com.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
	WebDriver driver=null;
	
	public MessagePage(WebDriver driver)
	{
	   this.driver=driver;	
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[text()='Send message']")
	private WebElement  sendMsgButton;
	
	@FindBy(xpath="//input[@name=\"queryBox\"]")
	private WebElement toTextbox;
	
	@FindBy(xpath="//div[text()='Chat']")
	private WebElement chatButton;
	
	@FindBy(xpath="//p[@class=\"xat24cr xdj266r\"]")
	private WebElement messageEdtBox;
	
	@FindBy(xpath="//div[text()=\"Send\"]")
	private WebElement sendButton;
	
	@FindBy(xpath="//div[@class=\"x1n2onr6\"]/descendant::div[@class=\"x78zum5 xdt5ytf\"][last()]/descendant::div[@class=\"html-div xexx8yu x4uap5 x18d9i69 xkhd6sd x1gslohp x11i5rnm x12nagc x1mh8g0r x1yc453h x126k92a xyk4ms5\"]")
	private WebElement message;
	
	
	public WebElement getMessage() {
		return message;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public WebElement getToTextbox() {
		return toTextbox;
	}

	public WebElement getsendMsgButton() {
		return sendMsgButton;
	}
 
	
	public WebElement getMessageEdtBox() {
		return messageEdtBox;
	}

	public WebElement getChatButton() {
		return chatButton;
	}
	
}
