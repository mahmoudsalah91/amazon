package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public WebDriverFactory(){
        // Private constructor to prevent instantiation
    }

    public static void initializeDriver(){


        // Create a new instance of the ChromeDriver
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

    }

    public static WebDriver getDriver(){
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
}
