@Regression
Feature: Validate American Express Credit Card Application

  Scenario: Verify navigation to credit card application form
    Given User navigates to the American Express France homepage
    Given User accepts cookies
    When User clicks on "Cartes American Express" credit card
    Given User accepts cookies
    When User clicks on "En Savoir Plus" for "Cartes Gold American Express" credit card
    When User clicks on "Demandez Votre Carte" to request card
    #Then User should be redirected to the "Application Form" page
    #When User fills the application form with test data
      #| First Name | Last Name | Email                | Phone       |
      #| John       | Doe       | john.doe@test.com    | 9876543210  |
    
    #Then User should be redirected to the "All Cards" page
    #Then User should be redirected to the "Gold Card Description" pagea
    #Then User should see the application confirmation or next step
