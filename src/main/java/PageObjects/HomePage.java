package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(css = "[data-test='logo']")
    private WebElement headerLogoButton;
    @FindBy(css = "[data-test='preorder.account.auth.login-link']")
    private WebElement loginButton;

    @FindBy(css = "[data-test='preorder.profile.orders-history-link']")
    private WebElement profileButton;

    @FindBy(css = "[data-test='header-profile-sign-out']")
    private WebElement logoutButton;

    @FindBy(css = "[data-test='pickup-selector']")
    private WebElement pickupSelector;

    @FindBy(css = "[data-test='delivery-selector']")
    private WebElement deliverySelector;

    @FindBy(id = "searchText")
    private WebElement searchInput;

    @FindBy(xpath = "//*[invalid locators]")
    private WebElement invalidLocators;

    public boolean defaultHomePageIsDisplayed() {
        headerLogoButton.isDisplayed();
        searchInput.isDisplayed();
        pickupSelector.isDisplayed();
        deliverySelector.isDisplayed();
        return true;
    }

    public void clickLoginButton() {
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickProfileButton() {
        profileButton.isDisplayed();
        profileButton.isEnabled();
        profileButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.isDisplayed();
        logoutButton.isEnabled();
        logoutButton.click();
    }


    public void getInvalidLocators() {
        invalidLocators.isDisplayed();
    }
}
