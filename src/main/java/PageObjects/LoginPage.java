package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[data-test='auth-tab-login']")
    private WebElement loginTab;

    @FindBy(css = "[data-test='auth-tab-register']")
    private WebElement createAccountTab;

    @FindBy(css = "#auth > h2")
    private WebElement loginHeaderTitle;

    @FindBy(css = "#auth > h2")
    private WebElement createAccountHeaderTitle;

    @FindBy(id = "firstName")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id="checkbox-undefined")
    private WebElement checkBox;

    @FindBy(css = "[data-test='auth-button']")
    private WebElement createAccountButton;

    @FindBy(css = "[data-test='auth-button']")
    private WebElement loginButton;

    @FindBy(css = "#auth > ul > li > button.css-sq6epl.e2l7ybf4")
    private WebElement forgotPasswordButton;

    public boolean emailLoginPageIsDisplayed() {
        loginTab.isDisplayed();
        createAccountTab.isDisplayed();
        loginHeaderTitle.isDisplayed();
        emailField.isDisplayed();
        passwordField.isDisplayed();
        forgotPasswordButton.isDisplayed();
        loginButton.isDisplayed();
        return true;
    }

    public boolean createAccountPageIsDisplayed() {
        createAccountTab.isDisplayed();
        createAccountHeaderTitle.isDisplayed();
        nameField.isDisplayed();
        emailField.isDisplayed();
        passwordField.isDisplayed();
        checkBox.isDisplayed();
        createAccountButton.isDisplayed();
        return true;
    }

    public String getLoginHeaderTitle() {
        loginHeaderTitle.isDisplayed();
        return loginHeaderTitle.getText();
    }

    public String getCreateAccountHeaderTitle() {
        createAccountHeaderTitle.isDisplayed();
        return createAccountHeaderTitle.getText();
    }

    public void fillNameData(String name) {
        nameField.isEnabled();
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillEmailData(String email) {
        emailField.isEnabled();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordData(String email) {
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(email);
    }


    //    public void forgotPasswordButton(){
    //    forgotPasswordButton.isDisplayed();
    //    forgotPasswordButton.click();
    //    }


    public void clickLoginButton() {
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.isEnabled();
        createAccountButton.click();
    }

    public void clickCreateAccountTab(){
        createAccountTab.isDisplayed();
        createAccountTab.click();
    }
}
