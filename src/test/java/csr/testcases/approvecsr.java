package csr.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class approvecsr extends Base {

	public approvecsr() throws IOException {

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
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element2 = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"mr-1 flex items-center gap-1\"])[3]")));
		element2.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@class=\"bg-tableHead rounded-tl-2xl rounded-tr-2xl\"]/tr[1]/td[1]/div/div[2]")).click();

		driver.findElement(By.xpath("//*[@class=\"text-blue-500 flex items-center border-none hover:bg-blue-50 py-2 px-4 rounded-lg\"]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement element = driver.findElement(By.xpath("//*[@class=\"pi pi-plus text-lg\"]"));
		element.click();
		js.executeScript("arguments[0].scrollIntoView();", element);
		String filePath = "D:\\Selenium\\RTS_LMD\\MyFile\\my-passport-photo.jpg";
		Robot robot = new Robot();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(15000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath("//*[@class=\"bg-tableHead rounded-tl-2xl rounded-tr-2xl\"]/tr[1]/td[1]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@class=\"w-full flex justify-between bg-[#F3F3F3] p-2 rounded-2xl\"]/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class=\"ml-1 flex gap-1 items-center\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='text1']")).sendKeys("52525884545");
		driver.findElement(By.xpath(
				"(//*[@class=\"border-solid border-2 border-gray p-1.5 pt-2 rounded-md w-full focus:outline-none focus:border-stone-400 invalid:border-rose-300 transition ease-in duration-300\"])[2]"))
				.sendKeys("25000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)");
		WebElement element21 = driver.findElement(By.xpath("//p[contains(text(),'Add Email Attachment')]"));
		element21.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js2.executeScript("arguments[0].scrollIntoView();", element21);
		String filePath2 = "D:\\Selenium\\RTS_LMD\\MyFile\\my-passport-photo.jpg";
		Robot robot2 = new Robot();
		Thread.sleep(2000);
		StringSelection stringSelection2 = new StringSelection(filePath2);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.delay(1000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath(" //button[contains(text(),'Submit')]")).click(); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class=\"pi pi-check-circle text-sm p-1\"]")).click();
	 

	}

}
