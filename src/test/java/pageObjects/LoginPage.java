package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(css = ".login-button")
    @CacheLookup
    WebElement loginButton;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement logoutLink;

    public void setUsername(String username) {
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnLogout() {
        logoutLink.click();
    }
}
