package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class BasePage {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public WebElement waitElement(WebDriver driver, By element, long timeout){
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitElement(WebDriver driver, WebElement element, long timeout){
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitElementText(WebDriver driver, By element, String pattern, long timeout){
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.textMatches(element,Pattern.compile(pattern)));
	}

	public void typeText(WebElement ele, String text) throws InterruptedException {
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			String character = String.valueOf(c);
			ele.sendKeys(character);
			Thread.sleep(100);
		}
	}


}
