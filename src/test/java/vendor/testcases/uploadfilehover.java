package vendor.testcases;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rts.testcases.base.Base;

public class uploadfilehover extends Base {

	public uploadfilehover() throws IOException {
		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\qa\\configuration\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);

		loc = new Properties();
		File propFile2 = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\qa\\configuration\\locators.properties");
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
	public void verifyloginvalidcredential3() throws InterruptedException, AWTException {
		driver.get(prop.getProperty("vendorurl"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")));
		element.sendKeys("newvendor12@yopmail.com");
		// driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::div/input")).sendKeys("newvendor12@yopmail.com");
		driver.findElement(By.xpath("//label[contains(text(),'P')]/following-sibling::div/input"))
				.sendKeys("Test@12345");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//*[@class = \"mr-1 flex items-center gap-1\"])[3]")).click();
		WebElement elementToHover = driver.findElement(By.xpath("//p[contains(text(),'Request Status')]"));
		// Create Actions class object
		Actions actions = new Actions(driver);
		// Perform hover action on the element
		actions.moveToElement(elementToHover).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(text(),'Job Completed/ Upload Proof')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap w-full overflow-hidden\"])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Add Proof')]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement element1 = driver.findElement(By.xpath("(//*[@class=\"pi pi-plus text-lg\"])[1]"));
		element1.click();
		js.executeScript("arguments[0].scrollIntoView();", element1);
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        
		
	}

}
