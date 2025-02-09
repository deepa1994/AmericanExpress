package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	// Defining By locators instead of @FindBy
	private By btnToutRefuser = By.id("user-consent-management-granular-banner-decline-all-button");
	private By btnToutAccepter = By.id("user-consent-management-granular-banner-accept-all-button");
	private By btnGererParametres = By.id("user-consent-management-granular-banner-prefs-button");

	public enum CookieOption {
		ACCEPT, REJECT, MANAGE
	}
	
	public void waitForPageToLoad() {
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete"));
	}


	public void waitForCookiePopup() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(btnToutAccepter));
			System.out.println("Cookie popup appeared.");
		} catch (Exception e) {
			System.out.println("No cookie popup found, proceeding...");
		}
	}

	public void handleCookiePopup(CookieOption option) {
        try {
            waitForCookiePopup();  // Ensure the popup is present before interacting
            
            WebElement button = null;

            switch (option) {
                case ACCEPT:
                    button = driver.findElement(btnToutAccepter);
                    break;
                case REJECT:
                    button = driver.findElement(btnToutRefuser);
                    break;
                case MANAGE:
                    button = driver.findElement(btnGererParametres);
                    break;
            }

            if (button != null && button.isDisplayed()) {
                button.click();
                System.out.println("Clicked on: " + option);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(btnToutAccepter));
            } else {
                System.out.println("Cookie popup not found, continuing...");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Cookie popup not displayed, skipping...");
        }
    }

	protected void clickElement(WebElement element) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element)); // Wait until visible
	        wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until clickable
	        
	        // Scroll only if needed
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	        Thread.sleep(500); // Small wait for stability
	        
	        element.click(); // Click normally
	    } catch (Exception e) {
	        System.out.println("Normal click failed: " + e.getMessage());
	        jsClickElement(element); // Use JavaScript Click as fallback
	    }
	}

	// JavaScript click as a fallback
	protected void jsClickElement(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}

	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
}
