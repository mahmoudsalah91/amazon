package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.WebDriverFactory;

import static stepDefinitions.Hooks.driver;


public class ShoppingCartStepDefinitions {
    SoftAssert softAssert= new SoftAssert();
    private HomePage homePage = new HomePage(driver);
    private final ProductPage productPage = new ProductPage(driver);
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);



    @When("User searches for product{string}")
    public void user_searches_for(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
        homePage.clickSearchButton();
    }

    @And("User selects the first available {string}")
    public void user_selects_the_first_available(String productType) {
        productPage.selectFirstProduct(productType);
    }

    @And("User adds the {string} to the shopping cart")
    public void user_adds_the_to_the_shopping_cart(String productType) {
        productPage.addToCart(productType);
    }

    @Then("{string} should be added to the shopping cart")
    public void product_should_be_added_to_the_shopping_cart(String productType) {
        // Implement assertion to verify product is added to the shopping cart
    }

    @Given("User is on the Amazon shopping cart page")
    public void user_is_on_the_amazon_shopping_cart_page() {
        shoppingCartPage.open();
    }

    @When("User updates the quantity of the first item to {string}")
    public void user_updates_the_quantity_of_the_first_item_to(String quantity) {
        shoppingCartPage.updateQuantityOfFirstItem(quantity);
    }

    @Then("Quantity in the shopping cart should be updated to {string}")
    public void quantity_in_the_shopping_cart_should_be_updated_to(String quantity) {
        // Retrieve the current quantity from the shopping cart
        String currentQuantity = shoppingCartPage.getCurrentQuantity();
        System.out.println(currentQuantity);

        // Assert that the current quantity matches the expected quantity
        softAssert.assertEquals(currentQuantity,(quantity) , "Quantity in the shopping cart is not updated to the expected value");
        softAssert.assertAll();
    }
}
