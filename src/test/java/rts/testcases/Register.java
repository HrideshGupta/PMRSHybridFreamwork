package rts.testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {

WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		String browserName = "chrome";
		
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);	
		}else if(browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://staging.fleet.lmdmax.com/Signup");	
		
	}
	
	
	 @AfterMethod
	 public void tearDown() {
	  
	  driver.quit(); }
	 
	
	@Test(priority =1)
	public void verifyloginvalidcredential() throws InterruptedException {
		driver.findElement(By.name("name")).sendKeys("maxwellteam061191");
		driver.findElement(By.id("somerandom")).sendKeys("maxwellteam061191@softsensor.ai");
		driver.findElement(By.id("newphoneNumber")).sendKeys("7578061191");
		driver.findElement(By.id("somepassword")).sendKeys("Harry@001!");
		driver.findElement(By.id("cpassword")).sendKeys("Harry@001!");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("maxwellteam061191@softsensor.ai");
		driver.findElement(By.id("password")).sendKeys("Harry@001!");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Softsensor");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[3]/div[1]/div[1]/input[1]")).sendKeys("SoftsensorHKG");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("190 SoftsensorHKG");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[5]/div[1]/div[1]/input[1]")).sendKeys("302033");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[6]/div[1]/div[1]/input[1]")).sendKeys("HK77");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/main[1]/div[3]/div[1]/div[7]/div[1]/div[1]/input[1]")).sendKeys("SS06");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	
	}	
}
