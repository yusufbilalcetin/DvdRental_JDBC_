@regression
Feature: validate payment values
  Background: for all steps
    Given the payment service is up and running

  Scenario: Get a list of all payments
    When I request a list of all payments
    Then I should receive a list containing all payments in the database

  Scenario: Get a payment by their payment_id
    When I request the payment with payment_id 17503
    Then I should receive the details of the payment with payment_id 17503

  Scenario: Get payment's customer_id and staff_id by their payment_id
    When I request the customer_id and staff_id of the payment with payment_id 17504
    Then I should receive the customer_id and staff_id of the payment with payment_id 17504