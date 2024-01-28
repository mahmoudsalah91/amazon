package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;


import static stepDefinitions.Hooks.driver;


public class SearchStepDefinitions {
    SoftAssert softAssert= new SoftAssert();

    private HomePage homePage = new HomePage(driver);
    private SearchResultPage searchResultPage = new SearchResultPage(driver);


    @When("User searches for {string}")
    public void userSearchesFor(String searchTerm) {

        homePage.enterSearchTerm(searchTerm);
        homePage.clickSearchButton();
    }

    @Then("Search results are displayed")
    public void searchResultsAreDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getSearchResultElement()));
        softAssert.assertTrue(searchResultPage.areSearchResultsDisplayed(), "Search results are not displayed");
        softAssert.assertAll();
    }
    @Then("the search results should match the search criteria")
    public void verifySearchResultsMatchCriteria() {
        // Get the actual search term from the search results page
        String actualSearchTerm = searchResultPage.getSearchTerm();
        String expectedSearchTerm = searchResultPage.expectedSearchTerm();
        // Compare the actual search term with the expected search term
        softAssert.assertEquals(expectedSearchTerm, actualSearchTerm,"Search results do not match search criteria");

    }

    @Then("No search results are displayed")
    public void noSearchResultsAreDisplayed() {

        softAssert.assertTrue(searchResultPage.noSearchResultsDisplayed(), "Search results are displayed");
        softAssert.assertAll();
    }

    @Then("Search results are displayed with response time and relevance")
    public void searchResultsAreDisplayedWithResponseTimeAndRelevance() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getSearchResultElement()));
        softAssert.assertTrue(searchResultPage.areSearchResultsDisplayed(), "Search results are not displayed");
        softAssert.assertAll();


    }

    // Method to check response time
    private long checkResponseTime() {
        long startTime = System.currentTimeMillis();
        // Perform any action that takes time here
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // Method to check relevance
    private boolean checkRelevance() {
        // Implement logic to check relevance
        // For example, you can check if the first search result matches the search term
        // You can access search results using methods from SearchResultsPage class
        String searchTerm = homePage.getSearchTerm();
        String firstResultTitle = searchResultPage.getFirstResultTitle();
        return firstResultTitle.toLowerCase().contains(searchTerm.toLowerCase());
    }
}
