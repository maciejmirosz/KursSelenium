Feature: my store registration

  Scenario: user can register with proper data
    Given user is on registration page
    When user inputs Karol, Kowalski, email, password
    When user clicks Save button
    Then user is registered