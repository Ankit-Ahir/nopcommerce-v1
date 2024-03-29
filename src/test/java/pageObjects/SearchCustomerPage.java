package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver driver;
    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    public void setEmail(String email) {
        waitHelper.waitForElement(txtEmail, 10);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstName) {
        waitHelper.waitForElement(txtFirstName, 10);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitHelper.waitForElement(txtLastName, 10);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void clickSearch() {
        btnSearch.click();

    }

    public int getNoOfRows() {
        return (tableRows.size());
    }

    public int getNoOfColumns() {
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;

        for (int i = 1; i <= getNoOfRows(); i++) {
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
                    .getText();

            System.out.println(emailId);

            if (emailId.equals(email)) {
                flag = true;
                break;
            }
        }

        return flag;

    }

    public boolean searchCustomerByName(String customerName) {
        boolean flag = false;

        for (int i = 1; i <= getNoOfRows(); i++) {
            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
                    .getText();
            String names[] = name.split(" ");

            if (names[0].equals("Victoria") && names[1].equals("Terces")) {
                flag = true;
                break;
            }
        }

        return flag;

    }
}
