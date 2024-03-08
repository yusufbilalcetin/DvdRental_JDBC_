@regression
Feature: validate film details values
  Background: for all steps
    Given the film details service is up and running

  Scenario: Get a list of film details which also inherits some informations from other lists
    When I request a list of film details
    Then I should receive a list containing film details in the database

  Scenario Outline: Get a film detail by title
    When I request the film details with title "<title>"
    Then I should receive the details of the "<title>"
    Examples:
      | title          |
      | Ace Goldfinger |
      | African Egg    |
      | Agent Truman   |
      | Alabama Devil  |


  Scenario: Get film's category and release year by their title
    When I request the category and release year of the film with "African Egg"
    Then I should receive the category and release year of the film with "African Egg"