package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static stepDefinitions.Hooks.BASE_URL;
import static stepDefinitions.Hooks.driver;

public class LoginStepDefinitions {

    SoftAssert softAssert= new SoftAssert();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        loginPage.enterEmail("mahmoudsalah036@gmail.com");
        loginPage.clickContinueButton();
        loginPage.enterPassword("Aa123456");
        loginPage.clickSignInButton();
    }
    @Then("login should be successful")
    public void login_should_be_successful() {
        softAssert.assertTrue(homePage.isHomePageDisplayed(),"Home page not displayed");
        softAssert.assertAll();
    }
    @When("user logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        homePage.clickSignInLink();
        loginPage.enterEmail("mahmoudsalah036@gmail.com");
        loginPage.clickContinueButton();
        loginPage.enterPassword("Aa123455");
        loginPage.clickSignInButton();
    }
    @Then("login should fail with an error message")
    public void login_should_fail_with_an_error_message() throws InterruptedException {
        String expectedErrorMessage = "There was a problem\n" +
                "Your password is incorrect";

        Thread.sleep(3000);
        driver.get(BASE_URL);

    }
}

