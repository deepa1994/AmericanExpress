package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreditCardPage extends BasePage {

	public CreditCardPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// Using a generic locator for all card elements inside the container
	private By cardContainer = By.className("contentlibrary-container");
	private By cardLinks = By.tagName("a"); // Selecting all <a> elements inside

	public void clickOnSpecificCard(String partialCardText) {
		wait.until(ExpectedConditions.presenceOfElementLocated(cardContainer));

		WebElement container = driver.findElement(cardContainer);
		List<WebElement> links = container.findElements(cardLinks);

		for (WebElement link : links) {
			String linkText = link.getText().trim();
			System.out.println("Found link text: " + linkText);

			if (linkText.toLowerCase().contains(partialCardText.toLowerCase())) { // Case-insensitive partial match
				wait.until(ExpectedConditions.elementToBeClickable(link)).click();
				System.out.println("Clicked on: " + linkText);
				return;
			}
		}

		throw new RuntimeException("Card containing text '" + partialCardText + "' not found!");
	}

}
