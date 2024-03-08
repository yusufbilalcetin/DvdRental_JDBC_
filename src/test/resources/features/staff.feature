@regression
Feature: validate staff values
  Background: for all steps
    Given the staff service is up and running

  Scenario: Get a list of all staff details
    When I request a list of all staff details
    Then I should receive a list containing all staff details in the database

  Scenario: Get a staff by their staff_id
    When I request the staff with staff_id 2
    Then I should receive the details of the staff with staff_id 2

  Scenario: Get staff's first_name and last_name by their staff_id
    When I request the first_name and last_name of the staff with staff_id 1
    Then I should receive the first_name and last_name of the staff with staff_id 1