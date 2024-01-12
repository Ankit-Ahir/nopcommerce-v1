package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitHelper;

public class AddCustomerPage {
    WebDriver driver;
    WaitHelper waitHelper;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
    }

    By customersMainMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
    By customersSubMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
    By addNewButton = By.xpath("//div/a[@class='btn btn-primary']");
    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");
    By txtFirstName = By.id("FirstName");
    By txtLastName = By.id("LastName");
    By genderMaleRadioButton = By.id("Gender_Male");
    By genderFemaleRadioButton = By.id("Gender_Female");
    By txtDateOfBirth = By.id("DateOfBirth");
    By txtCompany = By.id("Company");
    By administratorCustomerRole = By.xpath("//li[contains(text(),'Administrators')]");
    By guestCustomerRole = By.xpath("//li[contains(text(),'Guests')]");
    By vendorCustomerRole = By.xpath("//li[contains(text(),'Vendors')]");
    By registeredCustomerRole = By.xpath("//li[contains(text(),'Registered')]");
    By newsletter = By.cssSelector("div[role='listbox']");
    By newsletterListItem = By.xpath("//li[text()='Your store name']");

    By txtCustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");

    By managerOfVendor = By.id("VendorId");
    By txtAdminComment = By.id("AdminComment");

    By saveButton = By.name("save");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnCustomersMainMenu() {
        driver.findElement(customersMainMenu).click();
    }

    public void clickOnCustomersSubMenu() {
        driver.findElement(customersSubMenu).click();
    }

    public void clickOnAddNew() {
        driver.findElement(addNewButton).click();
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void setNewsletter() throws InterruptedException {
        driver.findElement(newsletter).click();
//        Thread.sleep(2000);
        waitHelper.waitForElement(driver.findElement(newsletterListItem), 10);
        driver.findElement(newsletterListItem).click();
    }

    public void setCustomerRoles(String role) throws InterruptedException {
        if (!role.equals("Vendor")) //If role is vendors should not delete Register as per req.
        {
            driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
        }

        driver.findElement(txtCustomerRoles).click();

        WebElement listItem;

        Thread.sleep(3000);

        if (role.equals("Administrator")) {
            listItem = driver.findElement(administratorCustomerRole);
        } else if (role.equals("Guest")) {
            listItem = driver.findElement(guestCustomerRole);
        } else if (role.equals("Registered")) {
            listItem = driver.findElement(registeredCustomerRole);
        } else if (role.equals("Vendor")) {
            listItem = driver.findElement(vendorCustomerRole);
        } else {
            listItem = driver.findElement(guestCustomerRole);
        }

        //listItem.click();
        //Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", listItem);

    }

    public void setManagerOfVendor(String value) {
        Select select = new Select(driver.findElement(managerOfVendor));
        select.selectByVisibleText(value);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            driver.findElement(genderMaleRadioButton).click();
        } else if (gender.equals("Female")) {
            driver.findElement(genderFemaleRadioButton).click();
        } else {
            driver.findElement(genderMaleRadioButton).click();//Default
        }

    }

    public void setFirstName(String firstName) {
        driver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(txtLastName).sendKeys(lastName);
    }

    public void setDob(String dob) {
        driver.findElement(txtDateOfBirth).sendKeys(dob);
    }

    public void setCompanyName(String company) {
        driver.findElement(txtCompany).sendKeys(company);
    }

    public void setAdminComment(String content) {
        driver.findElement(txtAdminComment).sendKeys(content);
    }

    public void clickOnSave() {
        driver.findElement(saveButton).click();
    }

}
