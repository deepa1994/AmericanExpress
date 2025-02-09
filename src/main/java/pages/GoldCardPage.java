package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoldCardPage extends BasePage {

    @FindBy(xpath = "//a")  // Finding all 'a' tags, since text is inside it
    private List<WebElement> allButtons;

    public GoldCardPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void performCardRequest(String actionName) {
    	String requestCard = "//div[contains(@class, 'stickySideRail')]//a[contains(@class, 'sc_horizontallyFluid')][contains(text(),'"+ actionName + "')]";
    
    	By requestCardByObject = By.xpath(requestCard);
    	wait.until(ExpectedConditions.presenceOfElementLocated(requestCardByObject));
    	WebElement requestCardElement = driver.findElement(requestCardByObject);
    	requestCardElement.click();
    	System.out.println("Clicked on button: " + actionName);
    }
}
