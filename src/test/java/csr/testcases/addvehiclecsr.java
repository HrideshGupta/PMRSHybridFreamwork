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

public class addvehiclecsr extends Base {

	public addvehiclecsr() throws IOException {

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

	 @Test(priority = 2)
	public void verifyloginvalidcredential1() throws InterruptedException {
		driver.get(prop.getProperty("csrurl"));
		driver.findElement(By.xpath(
				"//*[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng\"]"))
				.sendKeys("newcsr12@yopmail.com");
		driver.findElement(By.xpath(
				"//*[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-b52kj1\"]"))
				.sendKeys("Test@12345");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/button[1]/div[1]/i[1]")));
	        element2.click();

		driver.findElement(By.xpath(
				"//*[@class=\"p-1 px-2 rounded-md  focus:outline-none mt-2 mb-1  border-2  focus:border-primary hover:border-black\"]"))
				.sendKeys("HRDESHGUPTA417411");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@class=\"text-primary flex justify-center items-center	 my-auto text-xs font-bold gap-1\"]"))
				.click();
		driver.findElement(By.xpath(
				"//*[contains(text(),'Proceed')]"))
				.click();

		driver.findElement(By.xpath(
				"(//*[@class= \"p-1 px-2 rounded-md  focus:outline-none mt-2 mb-1 border-2   w-full focus:border-primary hover:border-black\"])[1]"))
				.sendKeys("4500");
		driver.findElement(By.xpath(
				"(//*[@class= \"p-1 px-2 rounded-md  focus:outline-none mt-2 mb-1 border-2   w-full focus:border-primary hover:border-black\"])[2]"))
				.sendKeys("8500");
		driver.findElement(By.xpath(
				"(//*[contains(text(),'Add Vehicle')])[2]"))
				.click();
		
		 WebElement radioButton =driver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/p[2]/p[2]/input[1]"));
		
		 if (!radioButton.isSelected()) {
	            // If not selected, click on it to select it
	            radioButton.click();
	        }
		
		driver.findElement(By.xpath(
			"((//*[contains(text(),'Schedule')]))[2]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(text(),'Vendor Name')]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'newvendor 12')]")).click();
		driver.findElement(By.xpath(
				"//*[@class = \"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium px-8 css-lgbobu\"]"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'MM/DD/YYYY')]")).click();
		Thread.sleep(2000);

		driver.findElement(By
				.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/button[4]"))
				.click();

		driver.findElement(By.xpath("//p[contains(text(),'00:00 AM')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//p[contains(text(),'02') and @id =\"hr\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//p[contains(text(),'PM') and @id ='period']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//*[@class=\"MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-esi9ax\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("(//*[contains(text(),'Add Services')])")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath(
				"(//*[@class=\"px-2 pt-1 border border-solid border-slate-200 flex items-center rounded-lg cursor-pointer gap-2\"])[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//*[contains(text(),'Schedule')])[4]")).click();
					
        
	}

}
