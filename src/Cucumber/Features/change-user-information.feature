Feature: Change user information after login

  Scenario: Change user birthday date, gender and sign up for a newsletter
    Given User is logged in to CodersLab shop
    When User goes to UserInformationPage
    And User changes his birthday to "10/10/2005"
    #And User changes gender
    And User signs up for our newsletter
    And User saves information
    Then User sees "Information successfully updated."