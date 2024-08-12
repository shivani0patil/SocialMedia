package sendrequest;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.FileUtiity.ExcelUtility;
import com.generic.FileUtiity.PropertyFile;
import com.generic.ListenerUtility.BaseClass;
import com.generic.ObjectRepository.HomePage;
import com.generic.ObjectRepository.LoginPage;
import com.generic.ObjectRepository.SerachPage;
import com.generic.WebUtility.JavaUtility;

@Listeners(com.generic.ListenerUtility.ListenerUtility.class)
public class SendRequestTest extends BaseClass {
	
	//WebDriver driver =new ChromeDriver();
	 HomePage home=new HomePage(driver);

	 ExcelUtility excel=new ExcelUtility();
	 JavaUtility java=new JavaUtility();
	 PropertyFile p=new PropertyFile();
	LoginPage l=new LoginPage(driver);
		
	
	@Test
	public void sendFriendRequest() throws IOException, Throwable
	{
		driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   

		String expectedresult=excel.getDataExcel("Sheet2",2, 1);
		
		int num=java.random();
		String name=excel.getDataExcel("Sheet2",3,0)+num;
		
		// nevigate the search and send follow request
		se.getSerahc().click();
		se.getSerachInput().sendKeys(name);
		driver.findElement(By.xpath("//span[text()='"+name+"' and @dir='auto']")).click();
		se.getFollowbutton().click();
		
		
		String actualresult=driver.findElement(By.xpath("//div[@class='_ap3a _aaco _aacw _aad6 _aade']")).getText();
		
		//Assert.assertEquals(actualresult, expectedresult);
		
		
		
	}
	

}
