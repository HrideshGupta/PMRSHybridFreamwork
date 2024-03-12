package vendor.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class requestVehicle extends Base{

	public requestVehicle() throws IOException {
	
	prop = new Properties();
	File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\configuration\\config.properties");
	FileInputStream fis = new FileInputStream(propFile);
	prop.load(fis);
	
	loc = new Properties();
	File propFile2 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\configuration\\locators.properties");
	FileInputStream fis2 = new FileInputStream(propFile2);
	loc.load(fis2);

}
WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initrowserAndOpenApp("chrome");
				
	}
	
	
//	 @AfterMethod
//	 public void tearDown() {
//	  
//	 driver.quit(); }
	
	 
	@Test
	public void verifyloginvalidcredential3() throws InterruptedException {
		driver.get(prop.getProperty("vendorurl"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")).sendKeys("newvendor12@yopmail.com");
		driver.findElement(By.xpath("//label[contains(text(),'P')]/following-sibling::div/input")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	    Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class=\"bg-[#E7FFDF] rounded-full w-[3rem] h-[3rem] flex justify-center items-center cursor-pointer\"]")).click();
		//driver.findElement(By.xpath("//p[contains(text(),'ACCEPT')]")).click();
		
		
	}

}	