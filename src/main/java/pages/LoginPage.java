package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    // Locators
    private By emailInput = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordInput = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
    private By errorMessage = By.xpath("//div[@id='auth-error-message-box']");


    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);

    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
