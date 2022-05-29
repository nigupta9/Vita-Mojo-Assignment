package StepDefinitions;

import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeSteps {

    HomePage homePage;
    TestContext testContext;

    public HomeSteps(TestContext context) {
        testContext = context;
    }

    @Given("Goto the Home Page")
    public void gotoTheHomePage() {
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @When("Login form in login page")
    public void goToLoginPage() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
        homePage.clickLoginButton();
    }

    @And("Click profile button")
    public void clickProfileButton() {
        homePage.clickProfileButton();
    }

    @And("Click logout button")
    public void clickLogoutButton() {
       homePage.clickLogoutButton();
    }

    @Then("This is for invalid locators")
    public void thisIsForInvalidLocators() {
        homePage.getInvalidLocators();
    }


}
