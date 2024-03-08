@regression
Feature: validate rental values

  Background: for all steps
    Given the rental service is up and running

  Scenario: Get a list of all rentals
    When I request a list of all rentals
    Then I should receive a list containing all rental details in the database

  Scenario Outline: Get a rental by their rental_id
    When I request the rental with rental_id <rentalId>
    Then I should receive the details of the rental with rental_id <rentalId>
    Examples:
      | rentalId |
      | 7        |
      | 12       |
      | 5        |
      | 8        |
      | 9        |

  Scenario Outline: Get rental's inventory_id and customer_id by their rental_id
    When I request the inventory_id and customer_id of the rental with rental_id <rentalId>
    Then I should receive the inventory_id and customer_id of the rental with rental_id <rentalId>
    Examples:
      | rentalId |
      | 17       |
      | 55       |
      | 12       |
      | 65       |
      | 2        |
      | 162      |