package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage  {

    // Constructor
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    // Locators
    private By firstProductLink = By.xpath("(//img[@data-image-latency='s-product-image'])[1]");
    private By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");

    public void selectFirstProduct(String productType) {
        // Click on the link of the first product listed
        driver.findElement(firstProductLink).click();
    }

    public void addToCart(String productType) {
        // Click on the "Add to Cart" button
        driver.findElement(addToCartButton).click();
    }
}