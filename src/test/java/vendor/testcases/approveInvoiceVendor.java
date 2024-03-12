package vendor.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class approveInvoiceVendor extends Base {
	
	public approveInvoiceVendor() throws IOException {
		
		
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
		
		
//		 @AfterMethod
//		 public void tearDown() {
//		  
//		 driver.quit(); }
		
		 
		@Test
		public void verifyloginvalidcredential3() throws InterruptedException {
			driver.get(prop.getProperty("vendorurl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")).sendKeys("newvendor12@yopmail.com");
			driver.findElement(By.xpath("//label[contains(text(),'P')]/following-sibling::div/input")).sendKeys("Test@12345");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("(//*[@class=\"flex gap-3 w-[45%]\"])/button[4]")).click();
			driver.findElement(By.xpath("(//*[@class=\"text-blue-500 font-semibold text-sm cursor-pointer border-none py-1.5 px-3 hover:bg-slate-100 rounded-full whitespace-nowrap \"])[1]")).click();	
			driver.findElement(By.xpath("//*[@class=\"py-2 px-6 bg-blue-600 text-white rounded-lg border-none\"]")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Approve Invoice')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//body/div[@id='simple-popover']/div[3]/div[1]/div[1]/button[2]")).click();
			
	}


}
