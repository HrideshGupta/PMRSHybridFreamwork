package rts.testcases.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public WebDriver driver;
	
	public Properties prop;
	public Properties loc;
	
	public Base() throws IOException {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\configuration\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		
		loc = new Properties();
		File propFile2 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\configuration\\locators.properties");
		FileInputStream fis2 = new FileInputStream(propFile2);
		loc.load(fis2);
	}

	public WebDriver initrowserAndOpenApp(String browserName) throws InterruptedException {
		
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
		return driver;
						
	}
	
	}
