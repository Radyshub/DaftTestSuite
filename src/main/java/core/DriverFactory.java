package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
private WebDriver driver = null;
	
	public WebDriver getDriver(String browser) {	
		switch(browser.toLowerCase()) {
			case "chrome"  : 
				driver = new ChromeDriver();
				break;
			case "firefox" :
				driver = new FirefoxDriver();
			default : 
				System.out.println("Incorrect browser name provided "+ browser);
				System.out.println("Hence running in Chrome ");
				driver = new ChromeDriver();
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);

		return driver;
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
