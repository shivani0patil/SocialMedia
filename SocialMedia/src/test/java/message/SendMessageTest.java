package message;
/*
 * @author Priyanka Naik
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.ListenerUtility.BaseClass;
import com.generic.ObjectRepository.HomePage;
import com.generic.ObjectRepository.MessagePage;
import com.generic.ObjectRepository.ProfilePage;

public class SendMessageTest extends BaseClass {
	@Test
	public void sendMessage() throws Throwable {
		wlib.waitForPageImplicity(driver);
		HomePage hp=new HomePage(driver);
		wlib.waitImplicite(driver, hp.getSaveLogin());
		hp.getSaveLogin().click();
		hp.getTurnOffNotification().click();
		hp.getmessageButton().click();

		MessagePage s=new MessagePage(driver);

		String user2= p.getDataProperty("username2");
		String user1=p.getDataProperty("username");
		wlib.waitImplicite(driver, s.getsendMsgButton());
		s.getsendMsgButton().click();
		Thread.sleep(3000);
		wlib.waitImplicite(driver, s.getToTextbox());
		s.getToTextbox().sendKeys(user2);
		Thread.sleep(5000);
		WebElement u = driver.findElement(By.xpath("//div[@class='xt7dq6l x1a2a7pz x6ikm8r x10wlt62 x1n2onr6 x14atkfc']/descendant::div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 x2lah0s x1qughib x6s0dn4 xozqiw3 x1q0g3np']/child::div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 x1iyjqo2 xs83m0k xeuugli x1qughib x6s0dn4 x1a02dak x1q0g3np xdl72j9']/descendant::span[text()='"+user2+"']/parent::span/parent::span[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i0vuye xvs91rp xo1l8bm x5n08af x10wh9bi x1wdrske x8viiok x18hxmgj']\r\n"
				+ ""));
		wlib.waitImplicite(driver, u);
		u.click();
		s.getChatButton().click();
	    Thread.sleep(3000);
	    String message=elib.getDataExcel("Sheet2", 1, 2);
	    s.getMessageEdtBox().sendKeys(message);
	    s.getSendButton().click();
	    String actualmsg=s.getMessage().getText();
	    System.out.println(actualmsg);
	    Assert.assertEquals(message, actualmsg);
	    driver.findElement(By.xpath("//img[@alt=\""+user1+"'s profile picture\"]")).click();
	    Thread.sleep(3000);
	}
}
