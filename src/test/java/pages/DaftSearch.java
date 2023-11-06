package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.TestBase;

import java.util.List;

public class DaftSearch extends BasePage {

    @FindBy(xpath=".//h1[@data-testid='search-h1']")
    private WebElement searchedProperties;

    @FindBy(xpath="//button[@aria-label='Filters']")
    private WebElement filterButton;

    @FindBy(xpath="//input[@id='keywordtermsModal']")
    private WebElement txtKeywordFilter;

    @FindBy(xpath=".//button[@data-testid='filters-modal-show-results-button']")
    private WebElement btnFilterResult;

    @FindBy(xpath=".//ul[@data-testid='results']/li")
    private List<WebElement> results;

    @FindBy(xpath="//div[@class='styles__StandardParagraph-sc-15fxapi-8 eMCuSm']")
    private WebElement propertyDesc;


    private WebDriver driver = null;

    public DaftSearch(WebDriver driver) throws Exception{
        super(driver);
        this.driver =  driver;
        if(!isSearchResultPageDisplayed()) throw new Exception("Search Page not displayed");
    }

    public boolean isSearchResultPageDisplayed() {
        return searchedProperties.isDisplayed();
    }

    public int getSearchPropertyResults(){
        String txtPropertySearch = searchedProperties.getText();
        String[] split = txtPropertySearch.split(" ");
        String numberofProperties = split[0];
        numberofProperties= numberofProperties.replaceAll("[^0-9]", "");
        int countofProperties = Integer.parseInt(numberofProperties);
        return countofProperties;
    }

    public int getFilterResultCount(){
        String filterResultText = btnFilterResult.getText();
        String[] garageFilterResult = filterResultText.split(" ");
        String garageProperties = garageFilterResult[1];
        garageProperties= garageProperties.replaceAll("[^0-9]", "");
        int countofGarageProperties = Integer.parseInt(garageProperties);
        return countofGarageProperties;
    }

    public void setFilterKeyword(String keyWord) throws Exception{
        filterButton.click();
        typeText(txtKeywordFilter, keyWord);
        txtKeywordFilter.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public String performSearchByFilterAndViewPropertyDesc() throws Exception{
        Thread.sleep(2000);
        btnFilterResult.click();
        results.get(0).click();
        return propertyDesc.getText();
    }



}
