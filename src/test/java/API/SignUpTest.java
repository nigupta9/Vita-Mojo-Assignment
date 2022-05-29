package API;

import DataProviders.UserDataFactory;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SignUpTest {



    @Test
    void test_create_user_profile_(){
        RestAssured.baseURI = "https://vmos2.vmos-demo.com/";

        UserDataFactory userDataFactory = new UserDataFactory();
        User userInfo = userDataFactory.getUserInfo();

        Response userResponse  = given().
                header("Content-Type", "application/json").
                header("tenant", "695a1486-80e7-4ee6-bc55-f4911944ef2a").
                body(userInfo).
                post("/user/v1/user");

        Assert.assertEquals(userResponse.statusCode(), 201);
        String getUser = userResponse.getBody().asString();

        String firstName = JsonPath.from(getUser).get("payload.user.profile.firstName");
        Assert.assertEquals(firstName, userInfo.getProfile().getFirstName());

        String email = JsonPath.from(getUser).get("payload.user.email");
        Assert.assertEquals(email, userInfo.getEmail());

        String storeUUID = JsonPath.from(getUser).get("payload.user.storeUUID");
        Assert.assertEquals(storeUUID, userInfo.getStoreUUID().toString());

        String memberNumber = JsonPath.from(getUser).get("payload.user.profile.memberNumber");

        String token = JsonPath.from(getUser).get("payload.token.value");

        Response profileResponse = given().
                header("Content-Type", "application/json").
                header("Authorization", "Bearer " +token).
                get("/user/v1/user/profile");
        Assert.assertEquals(profileResponse.statusCode(), 200);

        String getProfile = profileResponse.getBody().asString();

        String getFirstName = JsonPath.from(getProfile).get("payload.firstName");
        String getMemberNumber = JsonPath.from(getProfile).get("payload.memberNumber");

        System.out.println("First Name: " +firstName);
        System.out.println("Member Number: " +memberNumber);

        Assert.assertEquals(getFirstName, firstName);
        Assert.assertEquals(getMemberNumber, memberNumber);
    }
}
