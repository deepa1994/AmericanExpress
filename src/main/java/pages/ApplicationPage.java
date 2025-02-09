package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage extends BasePage {

    @FindBy(name = "firstName") 
    private WebElement firstNameField;

    @FindBy(name = "lastName") 
    private WebElement lastNameField;

    @FindBy(name = "email") 
    private WebElement emailField;

    @FindBy(name = "mobilePhoneNumber") 
    private WebElement phoneField;
    
    @FindBy(name="fieldControl-input-dateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//button[contains(text(),'Sauvegarder et Continuer')]") 
    private WebElement sauvegarderEtContinuerButton;

    public ApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void selectCivility(String civility) {
        String xpath = "//input[@id='" + civility.toUpperCase() + "']/following-sibling::label";
        WebElement civilityLabel = driver.findElement(By.xpath(xpath));
        
        if (!civilityLabel.isSelected()) {
            civilityLabel.click();
        }
    }


    public void fillApplicationForm(String civility, String firstName, String lastName, String email, String phone, String dob) {
        selectCivility(civility);
    	enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(emailField, email);
        enterText(phoneField, phone);
        enterText(dateOfBirth, dob);
        clickSauvegarderEtContinuer();
    }
    
    public void dismissPopups() {
        try {
            WebElement popup = driver.findElement(By.xpath("//button[contains(text(),'Close')]")); // Adjust the locator if needed
            if (popup.isDisplayed()) {
                popup.click();
                System.out.println("Closed interfering popup.");
            }
        } catch (Exception ignored) {
            System.out.println("No popup found.");
        }
    }


    public void clickSauvegarderEtContinuer() {
        try {
        	dismissPopups();
            clickElement(sauvegarderEtContinuerButton);
        } catch (Exception e) {
            System.out.println("Click failed, retrying with JS click...");
            jsClickElement(sauvegarderEtContinuerButton);
        }
    }
}
