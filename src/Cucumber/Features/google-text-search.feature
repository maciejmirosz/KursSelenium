Feature: Google search

  Scenario Outline: user can search any keyword
    Given an open browser with google.com
    When a keyword <keyword> is entered in input field
    Then the first one should contain <expectedWord>
   # And close browser

  Examples:
  |keyword|expectedWord|
  |karol  |karol       |
  |jacek  |jacek       |

#  Scenario: user can search any keyword (katalon)
#    Given an open browser with google.com
#    When a keyword katalon is entered in input field
#    Then the first one should contain katalon
#    And close browser