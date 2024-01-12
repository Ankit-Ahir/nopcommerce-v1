package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        logger = Logger.getLogger("nopcommerce-v1");
        PropertyConfigurator.configure("log4j.properties");

        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("firefoxpath"));
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", properties.getProperty("edgepath"));
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @Given("Launch browser")
    public void launch_browser() {
        loginPage = new LoginPage(driver);
        logger.info("Launch browser");
    }

    @When("Open url {string}")
    public void open_url(String url) throws InterruptedException {
        driver.get(url);
        logger.info("Open url");
        Thread.sleep(2000);
    }

    @When("Enter email as {string} and password as {string}")
    public void enter_email_as_and_password_as(String email, String password) {
        loginPage.setUsername(email);
        logger.info("Entered email");
        loginPage.setPassword(password);
        logger.info("Entered password");
    }

    @When("Click on login")
    public void click_on_login() {
        loginPage.clickOnLogin();
        logger.info("Click on login");
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String pageTitle) throws InterruptedException {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            logger.info("login failed");
            driver.close();
            Assert.fail();
        } else {
            logger.info("login passed");
            Assert.assertEquals(pageTitle, driver.getTitle());
        }
        Thread.sleep(3000);
    }

    @When("Click on logout")
    public void click_on_logout() throws InterruptedException {
        loginPage.clickOnLogout();
        logger.info("Click on logout");
        Thread.sleep(2000);
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
        logger.info("Close browser");
    }

    @Then("User can view the dashboard")
    public void can_view_dashboard() {
        addCustomerPage = new AddCustomerPage(driver);
        logger.info("verifying dashboard page title after login successfully");
        Assert.assertEquals("Dashboard / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("Click on customers main menu option")
    public void click_on_customers_main_menu_option() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on customers main menu option");
        addCustomerPage.clickOnCustomersMainMenu();
    }

    @When("Click on customers sub menu option")
    public void click_on_customers_sub_menu_option() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Click on customers sub menu option");
        addCustomerPage.clickOnCustomersSubMenu();
    }

    @When("Click on add new button")
    public void click_on_add_new_button() throws InterruptedException {
        logger.info("Click on add new button");
        addCustomerPage.clickOnAddNew();
        Thread.sleep(2000);
    }

    @Then("User can view add new customer page")
    public void can_view_add_new_customer_page() {
        logger.info("verifying add new customer page title after clicked on add new button");
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("Enter customer details")
    public void enter_customer_details() throws InterruptedException {

        String email = getRandomString() + "@gmail.com";
        addCustomerPage.setEmail(email);
        addCustomerPage.setPassword("test@123");
        addCustomerPage.setFirstName("John");
        addCustomerPage.setLastName("Wick");
        addCustomerPage.setGender("Male");
        addCustomerPage.setDob("1/1/2024");
        addCustomerPage.setCompanyName("testCompany");
        Thread.sleep(3000);
        addCustomerPage.setNewsletter();
        Thread.sleep(3000);
        addCustomerPage.setCustomerRoles("Guest");
        Thread.sleep(3000);
        addCustomerPage.setManagerOfVendor("Vendor 1");
        addCustomerPage.setAdminComment("this is for testing purpose");
        logger.info("Entered customer details");
    }

    @When("Click on save button")
    public void click_on_save_button() throws InterruptedException {
        addCustomerPage.clickOnSave();
        logger.info("Clicked on save button");
        Thread.sleep(2000);
    }

    @Then("System should displays confirmation message as {string}")
    public void system_should_displays_confirmation_message_as(String confirmationMessage) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }

    @When("Enter customer email")
    public void enter_customer_email() {
        logger.info("Search customer by email id");
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
        logger.info("Entered customer email");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCustomerPage.clickSearch();
        logger.info("Clicked on search button");
        Thread.sleep(3000);
    }

    @Then("Email id should be available in search results")
    public void email_id_should_be_available_in_search_results() {
        boolean status = searchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertTrue(status);
        logger.info("Email id should be available in search results = Pass");
    }

    @When("Enter customer firstname")
    public void enter_customer_firstname() {
        logger.info("Search customer by name");
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setFirstName("Victoria");
        logger.info("Entered customer firstname");
    }

    @When("Enter customer lastname")
    public void enter_customer_lastname() {
        searchCustomerPage.setLastName("Terces");
        logger.info("Entered customer lastname");
    }

    @Then("Name should be available in search results")
    public void name_should_be_available_in_search_results() {
        boolean status = searchCustomerPage.searchCustomerByName("Victoria Terces");
        Assert.assertTrue(status);
        logger.info("Name should be available in search results = Pass");
    }

}
