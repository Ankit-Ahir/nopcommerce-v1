Feature: Login

  @sanity
  Scenario: Login with valid credentials
    Given Launch browser
    When Open url "https://admin-demo.nopcommerce.com/login"
    And Enter email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When Click on logout
    Then Page title should be "Your store. Login"
    And Close browser

  @regression
  Scenario Outline: Login data driver
    Given Launch browser
    When Open url "https://admin-demo.nopcommerce.com/login"
    And Enter email as "<email>" and password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When Click on logout
    Then Page title should be "Your store. Login"
    And Close browser

    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin    |