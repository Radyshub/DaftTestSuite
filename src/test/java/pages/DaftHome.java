package pages;

import core.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DaftHome extends BasePage {

    @FindBy(xpath="//button[@id='didomi-notice-agree-button']")
    private WebElement cookies;

    @FindBy(xpath="//input[@id='search-box-input']")
    private WebElement searchInput;

    private By topSearchResult = By.xpath(".//ul[@data-testid='menu']//li[1]");

    private By exploreByCity = By.xpath(".//p[text()='Explore By City']");

    private WebDriver driver = null;

    public DaftHome(WebDriver driver) throws Exception{
        super(driver);
        this.driver =  driver;
        driver.get(TestConfig.getProperty("appBaseURL"));
        if(!isHomePageDisplayed()) throw new Exception("Home Page not displayed");
    }

    public boolean isHomePageDisplayed() {
        return searchInput.isDisplayed();
    }

    public void searchCity(String city) throws InterruptedException {
        try{cookies.click();}catch (Exception e){}
        searchInput.click();
        waitElement(driver, exploreByCity,5 );
        typeText(searchInput, city);
        driver.findElement(topSearchResult).click();
    }
}
