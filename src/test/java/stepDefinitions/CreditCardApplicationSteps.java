package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.*;
import utils.DriverFactory;

public class CreditCardApplicationSteps {
    
    private WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private AllCardsPage allCardsPage = new AllCardsPage(driver);
    private CreditCardPage creditCardPage = new CreditCardPage(driver);
    private GoldCardPage goldCardPage = new GoldCardPage(driver);
    private ApplicationPage applicationPage = new ApplicationPage(driver);

    @Given("User navigates to the American Express France homepage")
    public void user_navigates_to_homepage() {
        driver.get("https://www.americanexpress.com/fr-fr/?inav=NavLogo");
    }
    
    @Given("User accepts cookies")
    public void userAcceptsCookies() {
        BasePage basePage = new BasePage(driver);
        basePage.handleCookiePopup(BasePage.CookieOption.ACCEPT);
    }
    
    @Given("User clicks on {string} to request card")
    public void requestYourCard(String actionName) {
    	goldCardPage.waitForPageToLoad();
    	goldCardPage.performCardRequest(actionName);
    }

    @Given("User rejects cookies")
    public void userRejectsCookies() {
        BasePage basePage = new BasePage(driver);
        basePage.handleCookiePopup(BasePage.CookieOption.REJECT);
    }

    @Given("User manages cookie settings")
    public void userManagesCookies() {
        BasePage basePage = new BasePage(driver);
        basePage.handleCookiePopup(BasePage.CookieOption.MANAGE);
    }
    
    @Given("User clicks on {string} credit card")
    public void userClicksOnCreditCard(String cardName) {
        creditCardPage.clickOnSpecificCard(cardName);
    }


    @When("User clicks on {string} for {string} credit card")
    public void user_clicks_on(String action, String cardName) {
    	allCardsPage.clickCardDetails(action, cardName);
    }

    @Then("User should be redirected to the {string} page")
    public void user_should_be_redirected(String expectedPage) {
        String currentUrl = driver.getCurrentUrl();
        allCardsPage.waitForPageToLoad();
        Assert.assertTrue(currentUrl.contains("personal/gold"), "Failed to reach All Cards page.");
    }

    @When("User fills the application form with test data")
    public void user_fills_application_form(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.List<String>> data = dataTable.asLists(String.class);
        String firstName = data.get(1).get(1);
        String lastName = data.get(1).get(2);
        String email = data.get(1).get(3);
        String phone = data.get(1).get(4);
        String dob = data.get(1).get(5);
        String civility = data.get(1).get(0);
        applicationPage.fillApplicationForm(civility, firstName, lastName, email, phone, dob);
    }

    @Then("User should see the application confirmation or next step")
    public void user_should_see_application_confirmation() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("apply"), "Application did not proceed.");
    }
}
