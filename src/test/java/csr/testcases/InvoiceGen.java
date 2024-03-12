package csr.testcases;

import java.awt.AWTException;
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

public class InvoiceGen extends Base{
	
	public InvoiceGen() throws IOException {
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
	public void verifyloginvalidcredential1() throws InterruptedException, AWTException {
		driver.get(prop.getProperty("csrurl"));
		driver.findElement(By.xpath(
				"//*[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng\"]"))
				.sendKeys("newcsr12@yopmail.com");
		driver.findElement(By.xpath(
				"//*[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-b52kj1\"]"))
				.sendKeys("Test@12345");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement element2 = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"flex gap-3 w-[45%]\"]/button[3]")));
		element2.click();
		Thread.sleep(5000);
		driver.findElement(
	         By.xpath("//*[@class=\"bg-tableHead rounded-tl-2xl rounded-tr-2xl\"]/tr[1]/td[1]/div/div[2]")).click();

		
		  driver.findElement(By.xpath("//*[@class=\"pi pi-angle-down rotate-180 ease-in-out duration-200 text-grey text-primary mt-[1rem]\"]")).click();
		  driver.findElement(By.xpath("//*[contains(text(),'DSP Invoice')]")).click();
		  Thread.sleep(5000); 
		  WebElement textBox3 = driver.findElement(By.xpath(
		  "//*[@class=\"border border-[#DDDDDD] px-2 py-2 rounded-md focus:border-primary  focus:outline-none  w-[18rem] \"]"
		 ));
		  textBox3.clear();
		     textBox3.sendKeys("7446523454555");
          Thread.sleep(5000);
          WebElement textBox4 =driver.findElement(By.xpath(
		 "(//*[@class=\"w-[9rem] h-[2.1rem] text-right rounded-r-[0.40rem] pr-2 focus:border-primary  focus:outline-none text-bold\"])[1]"
		 ));
          textBox4.clear();
		     textBox4.sendKeys("5000");
		 driver.findElement(By.xpath("//button[contains(text(),'Create Invoice')]")).click();
		 Thread.sleep(20000);
		 driver.findElement(By.xpath("//button[contains(text(),'Send Invoice')]")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@class=\"w-full py-8 content-center border-2 mb-4 rounded-[1rem] hover:bg-primary-light \"]")).click();
		 Thread.sleep(5000);
		 WebElement textBox = driver.findElement(By.xpath("//*[@class=\"border border-[#DDDDDD] px-2 py-2 rounded-md focus:border-primary  focus:outline-none  w-[18rem] \"]"));
		 textBox.clear();
	     textBox.sendKeys("745723232323");
		 WebElement textBox2 = driver.findElement(By.xpath("//div[@class='flex justify-between rounded-[0.5rem] border-2 border-[#DDDDDD]']/input"));
		 textBox2.clear();
	     textBox2.sendKeys("8787569086");
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Create Invoice')]")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[contains(text(),'Send Invoice')]")).click();

	}

}
