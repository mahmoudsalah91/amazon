package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage  {

    private WebDriver driver;
    public SearchResultPage(WebDriver driver){
        this.driver=driver;
    }
 //locators
    private By searchResults = By.cssSelector("div.s-search-results");
    private By resultTitles = By.cssSelector(".s-title-instructions");
    private By searchResultItem =By.xpath("//div[@class='s-result-item']");
    private By noSearchResultItem =By.xpath("//span[@class='a-size-medium a-color-base'][contains(.,'No results for')]");




    public WebElement getSearchResultElement() {
        return driver.findElement(searchResults);
    }

    public boolean areSearchResultsDisplayed() {
        return driver.findElement(searchResults).isDisplayed();
    }
    public boolean noSearchResultsDisplayed() {
        return driver.findElement(noSearchResultItem).isDisplayed();
    }
    public String getFirstResultTitle() {
        List<WebElement> titles = driver.findElements(resultTitles);
        if (!titles.isEmpty()) {
            return titles.get(0).getText();
        } else {
            throw new IllegalStateException("No search results found.");
        }
    }

    // Method to get the number of search results
    public int getNumberOfResults() {
        List<WebElement> searchResultItems = driver.findElements(searchResultItem);
        return searchResultItems.size();
    }
    // Method to get the search term used for the search
    public String getSearchTerm() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        return searchBox.getAttribute("value");
    }
    // Method to get the expected search term (you may set this value based on your scenario)
    public String expectedSearchTerm() {
        // Return the expected search term
        return "laptop"; // Example value, update as per your requirement
    }

}
