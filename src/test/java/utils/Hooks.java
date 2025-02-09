package utils;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Launching the browser...");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing the browser...");
            driver.quit();
        }
    }
}
