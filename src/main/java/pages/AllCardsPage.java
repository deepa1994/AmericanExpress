package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllCardsPage extends BasePage {

    public AllCardsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickCardDetails(String action, String cardTitle) {
        // XPath to find the card section based on the title
    	String cardActionXpath = "//div[contains(@class, 'button parbase')]/..//div[contains(@title, '"+ cardTitle + "')]/../../../..//a[contains(@alt, '"+ action + "')]";
		By cardActionByObject = By.xpath(cardActionXpath);
        wait.until(ExpectedConditions.presenceOfElementLocated(cardActionByObject));
        // Locate the card container
        WebElement cardButton = driver.findElement(cardActionByObject); 
        // Click the button
        wait.until(ExpectedConditions.elementToBeClickable(cardButton)).click();
        System.out.println("Clicked on 'En Savoir Plus' for: " + cardTitle);
    }
}
