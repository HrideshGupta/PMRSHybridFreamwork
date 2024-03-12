package rts.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rts.testcases.base.Base;;

public class Login extends Base {
	
	
	
	public Login() throws IOException {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\configuration\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initrowserAndOpenApp(prop.getProperty("browserName"));
				
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority =1,dataProvider="validCredentialSupplier")
	public void verifyloginvalidcredential(String email ,String password ) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "RTS Checkout - Return To Station";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Verified");
	}
	
	@DataProvider(name="validCredentialSupplier")
	public Object[][] SupplyTestData() {

			Object[][] data = new Object[2][2];
			data[0][0] = "RTSNew12@yopmail.com";
			data[0][1] = "Test@12345";
			data[1][0] = "hrideshgupta06sds@gmail.com";
			data[1][1] = "Harry@001!";
return data;
		
	}
	
	@Test(priority =2)
	public void verifyloginInvalidcredential(){
		driver.findElement(By.id("email")).sendKeys("RTSNew12@mail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@type='submit']")).click();	
		System.out.println("negative Scenario");
	}
}
