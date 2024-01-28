package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class ShoppingCartPage {
    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }

    private By cartButton = By.id("nav-cart");

    private By quantityDD = By.xpath("//span[@class='a-dropdown-prompt']");
    private By quantity2 = By.xpath("//a[@id='quantity_2']");



    private By productContainer = By.cssSelector(".s-result-item");

    public void open() {
        // Click on the cart button to open the shopping cart page
        driver.findElement(cartButton).click();
    }
    public void updateQuantityOfFirstItem(String quantity) {
        // Enter the new quantity in the quantity input field
        WebElement quantityInputElement = driver.findElement(quantityDD);
        quantityInputElement.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(quantity2).click();
    }

    public void selectFirstProductOfType(String productType) {
        List<WebElement> products = driver.findElements(productContainer);

        // Iterate through the product list and find the first product of the specified type
        for (WebElement product : products) {
            if (product.getText().contains(productType)) {
                // Click on the first product of the specified type
                product.click();
                break; // Stop iterating once the first product is found
            }
        }
    }
    public String getCurrentQuantity() {
        // Find the quantity input field
        WebElement element = driver.findElement(By.id("quantity_2"));
        String dataValue = element.getAttribute("data-value");

// Parse the JSON string to extract the value
        JsonReader jsonReader = Json.createReader(new StringReader(dataValue));
        JsonObject jsonObject = jsonReader.readObject();
        String stringValue = jsonObject.getString("stringVal");

        System.out.println("Value extracted from JSON: " + stringValue);


        return stringValue;
    }


}
