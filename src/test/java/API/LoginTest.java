package API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {
    String tokenGenerated = "";
    String payload = "{\"email\": \"nileshgupta.nitc@gmail.com\", \"password\": \"Nilu@demo26\"}";

    RequestSpecification request;

    // @Test
    @BeforeClass
    public void setup(){
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " +tokenGenerated);
    }

    // @Test
    @BeforeTest
    public void generate_token(){
        RestAssured.baseURI = "https://vmos2.vmos-demo.com/";
        Response tokenResponse = given()
                .header("Content-Type", "application/json")
                .body(payload).post("/user/v1/auth");
        Assert.assertEquals(tokenResponse.statusCode(), 201);

        String jsonToken = tokenResponse.getBody().asString();
        tokenGenerated = JsonPath.from(jsonToken).get("payload.token.value");
    }

    @Test
    public void test_get_user_profile_successful() {
        Response profileResponse = request.get("/user/v1/user/profile");
        Assert.assertEquals(profileResponse.statusCode(), 200);

        String getProfile = profileResponse.getBody().asString();

        String firstName = JsonPath.from(getProfile).get("payload.firstName");
        String memberNumber = JsonPath.from(getProfile).get("payload.memberNumber");

        System.out.println("First Name: " +firstName);
        System.out.println("Member Number: " +memberNumber);

        Assert.assertEquals(firstName, "Nilesh");
        Assert.assertEquals(memberNumber, "366567762231");
    }

    @Test
    public void test_loyalty_points_balance(){
        Response balanceResponse = request.get("/loyalty/points/balance");
        String getBalance = balanceResponse.getBody().asString();
        int points = JsonPath.from(getBalance).get("payload.points");
        Assert.assertEquals(points, 0);
    }

    @Test
    public void test_catalog_menu_stores(){
        Response storesResponse = request.get("/catalog/menu/stores");
        String getStores = storesResponse.getBody().asString();
        String stores = JsonPath.from(getStores).get("payload");
        Assert.assertNull(stores);
    }

    @Test
    void get_auth_option_status_successful(){
        RestAssured.baseURI = "https://vmos2.vmos-demo.com/";
        given().
                options("/user/v1/auth").
                then().
                log().
                all().
                assertThat().
                statusCode(200);
    }

    @Test
    void get_auth_status_successful(){
        RestAssured.baseURI = "https://vmos2.vmos-demo.com/";
        String payload = "{\"email\": \"nileshgupta.nitc@gmail.com\", \"password\": \"Nilu@demo26\"}";
        given().
                header("Content-Type", "application/json").
                body(payload).
                post("/user/v1/auth").
                then().
                log().
                all().
                assertThat().
                statusCode(201);
    }

    @Test
    void test_login_user_not_authenticate_due_to_bad_request(){
        payload = "{email: \"abc@gmail.com\", password: \"abc\"}";
        given().
                header("Content-type", "application/json").
                body(payload).
                when().
                post("/user/v1/auth").
                then().
                log().
                all().
                assertThat().
                statusCode(400);
    }

    @Test
    void test_user_profile_not_authorize(){
        given().
                get("https://vmos2.vmos-demo.com/user/v1/user/profile").
                then().
                log().
                all().
                assertThat().
                statusCode(401);
    }
}
