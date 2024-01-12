Feature: Customers

  Background: Below are the common steps for every scenario
    Given Launch browser
    When Open url "https://admin-demo.nopcommerce.com/login"
    And Enter email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view the dashboard
    When Click on customers main menu option
    And Click on customers sub menu option

  @sanity
  Scenario: Add new customer
    And Click on add new button
    Then User can view add new customer page
    When Enter customer details
    And Click on save button
    Then System should displays confirmation message as "The new customer has been added successfully."
    And Close browser

  @regression
  Scenario: Search customer by email id
    And Enter customer email
    When Click on search button
    Then Email id should be available in search results
    And Close browser

  @regression
  Scenario: Search customer by name
    And Enter customer firstname
    And Enter customer lastname
    When Click on search button
    Then Name should be available in search results
    And Close browser