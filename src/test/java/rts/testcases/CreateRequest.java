package rts.testcases;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class CreateRequest extends Base{	
public CreateRequest() throws IOException {
		super();
	}
WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initrowserAndOpenApp("chrome");
				
	}
	
	
	 @AfterMethod
	 public void tearDown() {
	  
	 driver.quit(); }
	 
	@Test
	public void verifyloginvalidcredential() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("RTSNew12@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(10000);
		//LOcator File Initialize
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/a[12]/div[1]/span[1]/*[1]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();

	}

}