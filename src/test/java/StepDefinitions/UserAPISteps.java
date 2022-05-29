package StepDefinitions;

import DataProviders.UserDataFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class UserAPISteps {

    User userInfo = new User();
    Response userResponse;
    Response profileResponse;
    String getUser = "";
    String memberNumber = "";
    String token = "";

    @Given("Create user request")
    public void createUserRequest() {
        UserDataFactory userDataFactory = new UserDataFactory();
        userInfo = userDataFactory.getUserInfo();
        Assert.assertNotNull(userInfo);
    }

    @Given("Create user with {string} endpoint")
    public void createUserWithEndpoint(String endpoint) {
        userResponse  = given().
                header("Content-Type", "application/json").
                header("tenant", "695a1486-80e7-4ee6-bc55-f4911944ef2a").
                body(userInfo).
                post(endpoint);
    }

    @And("Validate create user response status code with {int}")
    public void validateCreateUserResponseStatusCodeWith(int statusCode) {
        Assert.assertEquals(userResponse.statusCode(), 201);
    }

    @And("Validate all user request field with user profile response")
    public void validateAllUserRequestField() {
        getUser = userResponse.getBody().asString();
        Assert.assertNotNull(getUser);
        String firstName = JsonPath.from(getUser).get("payload.user.profile.firstName");
        Assert.assertEquals(firstName, userInfo.getProfile().getFirstName());

        String email = JsonPath.from(getUser).get("payload.user.email");
        Assert.assertEquals(email, userInfo.getEmail());

        String storeUUID = JsonPath.from(getUser).get("payload.user.storeUUID");
        Assert.assertEquals(storeUUID, userInfo.getStoreUUID().toString());

        String locale = JsonPath.from(getUser).get("payload.user.locale");
        Assert.assertEquals(locale, userInfo.getLocale());
    }

    @And("Validate new user profile member number and token generation")
    public void validateNewUserProfileMemberNumber() {
        memberNumber = JsonPath.from(getUser).get("payload.user.profile.memberNumber");
        Assert.assertNotNull(memberNumber);

        token = JsonPath.from(getUser).get("payload.token.value");
        Assert.assertNotNull(token);
    }
}
