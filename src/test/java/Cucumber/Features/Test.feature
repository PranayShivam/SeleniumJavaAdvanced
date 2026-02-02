

@default
Feature: Demo Print Functionality

  Background:
    Given User prepares the system

  Scenario: Print a single Message
    When User prints "Hello World"
    Then Message should be displayed successfully

  Scenario Outline: Print multiple messages
    When User prints "<Message>"
    Then Message should be displayed successfully

    Examples:
      | Message        |
      | Cucumber Demo  |
      | BDD Testing    |
      | Selenium Java  |

  Scenario: Print multiple messages using Data Table
    When User prints the following values:
      | Apple  |
      | Mango  |
      | Banana |
    Then Message should be displayed successfully
