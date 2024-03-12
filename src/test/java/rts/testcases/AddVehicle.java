package rts.testcases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class AddVehicle extends Base{	
public AddVehicle() throws IOException {
	
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
	 
	@SuppressWarnings("deprecation")
	 @Test(priority = 1)
	public void verifyloginvalidcredential() throws InterruptedException, AWTException {
		driver.get(prop.getProperty("rtsurl"));
		Thread.sleep(4000);
		driver.findElement(By.id("email")).sendKeys("RTSNew12@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(15000);
		//LOcator File Initialize
		driver.findElement(By.xpath(loc.getProperty("clickvehicle"))).click();
		
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    

		driver.findElement(By.xpath("(//*[contains(text(),'Add Vehicle')])[1]")).click();
	
		driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[1]")).sendKeys("HRIDESHGUPTA85287411");
	
		driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[2]")).sendKeys("HRDESHGUPTA417411");
		
		WebElement divClick = driver.findElement(By.id("vehicle-type-select"));
		divClick.click();
	    driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[4]")).click(); 
	    driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[3]")).sendKeys("45SSSS7411");
	    driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[4]")).sendKeys("KKK757411");    
	    driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[5]")).sendKeys("BBBB57411");
	    driver.findElement(By.xpath("(//*[@class=\"MuiInputBase-input MuiOutlinedInput-input css-c9d76q\"])[6]")).sendKeys("LJHHG7411");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[12]/div[1]/div[1]/input[1]")).sendKeys("12/12/2024");
        JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
        // Alternatively, you can scroll to a specific element
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Browse File')]"));
        element.click();
        js.executeScript("arguments[0].scrollIntoView();", element);
	    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Browse File')]")));
        String filePath = "D:\\Selenium\\RTS_LMD\\MyFile\\my-passport-photo.jpg";  
        Robot robot = new Robot();
        Thread.sleep(2000);
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
     // Press CTRL+V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000); // Delay to allow time for the file path to be pasted
        // Press ENTER to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
       //fileInput.sendKeys(uploadFile.getAbsolutePath());
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
       driver.findElement(By.xpath("(//*[contains(text(),'Add Vehicle')])[4]")).click();   
      
	    
	}

}