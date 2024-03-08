@regression
Feature: validate film values
  Background: for all steps
    Given the film service is up and running

  Scenario: Get a list of all films
    When I request a list of all films
    Then I should receive a list containing all films in the database

  Scenario: Get an film by their ID
    When I request the film with ID 62
    Then I should receive the details of the film with ID 62

  Scenario: Get film's title and description by their ID
    When I request the title and description of the film with ID 89
    Then I should receive the title and description of the film with ID 89