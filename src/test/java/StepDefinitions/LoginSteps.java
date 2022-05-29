package StepDefinitions;

import DataProviders.UserDataFactory;
import PageObjects.LoginPage;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("Login page is displayed")
    public void logPageIsDisplayed() {
        Assert.assertTrue(loginPage.emailLoginPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getLoginHeaderTitle();
        Assert.assertEquals("Login", actualLoginHeaderTitle);
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }



    @When("Click Create Account button")
    public void clickCreateAccountButton(){
        loginPage.clickCreateAccountButton();
    }

    @When("Input credentials to login with headers table")
    public void inputCredentialsToLoginWithHeadersTable(DataTable dataTable) {
        List<Map<String,String>> dataRow = dataTable.asMaps(String.class,String.class);

        //Use for...loop if you have multiple data table
        for (Map<String, String> dataMap : dataRow) {
            String email = dataMap.get("Email");
            String password = dataMap.get("Password");
            loginPage.fillEmailData(email);
            loginPage.fillPasswordData(password);
            System.out.println("row header email " + email);
            System.out.println("row index 1 --- " + dataMap.get("Password"));
        }
    }

    @When("Input credentials to create account")
    public void inputCredentialsToCreateAccount(){
        UserDataFactory userDataFactory = new UserDataFactory();
        User userInfo = userDataFactory.getUserInfo();
        loginPage.fillNameData(userInfo.getProfile().getFirstName());
        loginPage.fillEmailData(userInfo.getEmail());
        loginPage.fillPasswordData(userInfo.getPassword());
    }

    @And("Click on create account page")
    public void clickOnCreateAccountTabPage(){
        loginPage.clickCreateAccountTab();
    }

    @And("Create account page is displayed")
    public void createAccountPageIsDisplayed() {
        Assert.assertTrue(loginPage.createAccountPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getCreateAccountHeaderTitle();
        Assert.assertEquals("Create your account", actualLoginHeaderTitle);
    }
}
