$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/Customers.feature");
formatter.feature({
  "name": "Customers",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Below are the common steps for every scenario",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.launch_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open url \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.open_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter email as \"admin@yourstore.com\" and password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.enter_email_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on login",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.can_view_dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on customers main menu option",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.click_on_customers_main_menu_option()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on customers sub menu option",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_customers_sub_menu_option()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add new customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "Click on add new button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_add_new_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view add new customer page",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.can_view_add_new_customer_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter customer details",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.enter_customer_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "System should displays confirmation message as \"The new customer has been added successfully.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.system_should_displays_confirmation_message_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.launch_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open url \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.open_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter email as \"admin@yourstore.com\" and password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.enter_email_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on login",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page title should be \"Dashboard / nopCommerce administration\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.page_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on logout",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.click_on_logout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page title should be \"Your store. Login\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.page_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});