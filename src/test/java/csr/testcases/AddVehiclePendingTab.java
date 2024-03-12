package csr.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class AddVehiclePendingTab extends Base {

	public AddVehiclePendingTab() throws IOException {
		super();
	}

	public void addvehiclecsr() throws IOException {

		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\qa\\configuration\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initrowserAndOpenApp(prop.getProperty("browserName"));

	}

//	@AfterMethod
//	public void tearDown() {
//
//		driver.quit();
//	}

	@Test
	public void verifyloginvalidcredential2() throws InterruptedException {
		driver.get(prop.getProperty("csrurl"));
		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("newcsr12@yopmail.com");
		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("Test@12345");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[@id='2181requestRow']/td[1]/div[1]/button[1]")));
	        element2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/p[2]/p[2]/input[1]")).click();
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();

		
		driver.findElement(By.xpath("//p[contains(text(),'Vendor Name')]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'newvendor 12')]")).click();
		driver.findElement(By.xpath(
				"//*[@class = \"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium px-8 css-lgbobu\"]"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'MM/DD/YYYY')]")).click();
		Thread.sleep(5000);

		driver.findElement(By
				.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/button[4]"))
				.click();

		driver.findElement(By.xpath("//p[contains(text(),'00:00 AM')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//p[contains(text(),'02') and @id =\"hr\"]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//p[contains(text(),'PM') and @id ='period']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//body/div[@id='simple-popover']/div[1]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[1]/button[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"))
				.click();

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]/button[1]"))
				.click();
		
		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/p[1]"))
				.click();
		
		
	}

}
