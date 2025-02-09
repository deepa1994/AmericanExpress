package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static void initializeDriver() {
        // Manually set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa\\OneDrive\\Desktop\\Framework\\AmericanExpress\\src\\test\\resources\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        WebDriver webDriver = new ChromeDriver(options);
        driver.set(webDriver);
        System.out.println("WebDriver Initialized Successfully!");
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            System.out.println("WebDriver Closed Successfully!");
        }
    }
}
