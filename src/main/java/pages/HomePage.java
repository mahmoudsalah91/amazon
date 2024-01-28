package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{

    // Constructor
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By signInLink = By.xpath("//a[@id=\"nav-link-accountList\"]");
    private By logo = By.id("nav-logo");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.xpath("//input[@value='Go']");

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }
    public boolean isHomePageDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
    }
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
    public String getSearchTerm() {
        return driver.findElement(searchBox).getAttribute("value");
    }

}



