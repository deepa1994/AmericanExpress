@Regression
Feature: Validate American Express Credit Card Application

  Scenario: Verify navigation to credit card application form
    Given User navigates to the American Express France homepage
    Given User accepts cookies
    When User clicks on "Cartes American Express" credit card
    Given User accepts cookies
    When User clicks on "En savoir plus" for "Carte Gold American Express" credit card
    When User clicks on "Demandez votre Carte" to request card
    Then User should be redirected to the "Application Form" page
    When User fills the application form with test data
      |Title| First Name | Last Name | Email                | Phone       | Date of Birth |
      | Mr  | John       | Doe       | john.doe@test.com    | 0712345678  | 07/02/2000    |
    #Then User should see the application confirmation or next step
    
    #Then User should be redirected to the "All Cards" page
    #Then User should be redirected to the "Gold Card Description" pagea
