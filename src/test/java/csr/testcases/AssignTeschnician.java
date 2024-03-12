package csr.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class AssignTeschnician extends Base {

	public AssignTeschnician() throws IOException {
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")));
	        element.sendKeys("newvendor12@yopmail.com");
			//driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")).sendKeys("newvendor12@yopmail.com");
			driver.findElement(By.xpath("//label[contains(text(),'P')]/following-sibling::div/input")).sendKeys("Test@12345");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"mr-1 flex items-center gap-1\"])[2]")));
	        element2.click();
		    driver.findElement(By.xpath("//tbody/tr[5]/td[8]/div[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//div[contains(text(),'HR')]")).click();
		    driver.findElement(By.xpath("//button[contains(text(),'Assign Technician')]")).click();		  
		    driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		    
		}

	}