package api.bing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class BingApiTest {

    private static final String API_KEY = "AsH7f6Vwgt9FlHe3p1kl2kt0shYcss9_-pf73hxzK4rT1W4bEW6YBFYmjSJvvBRm";
    private String placeFoundURL = "http://dev.virtualearth.net/REST/v1/Locations?CountryRegion=US&adminDistrict=WA&locality=Somewhere&postalCode=98001&addressLine=100 Main St.&key=AsH7f6Vwgt9FlHe3p1kl2kt0shYcss9_-pf73hxzK4rT1W4bEW6YBFYmjSJvvBRm";
    private String unauthorizedURL = "http://dev.virtualearth.net/REST/v1/Locations?CountryRegion=US&adminDistrict=WA&locality=Somewhere&postalCode=98001&addressLine=100 Main St.&key=fakeKey";
    private String badRequestURL = "http://dev.virtualearth.net/REST/v1/Locations/US/WA/98052/Redmond/1%20Microsoft%20Way?o=xml&key=AsH7f6Vwgt9FlHe3p1kl2kt0shYcss9_-pf73hxzK4rT1W4bEW6YBFYmjSJvvBRm";
    private String forbiddenURL = "http://dev.virtualearth.net/REST/v1/";
    private String notFoundURL = "http://dev.virtualearth.net/notfoundpage";

    @Test
    public void testIfNameOfThePlaceCorrect() {
        Response res = given()
                .accept(ContentType.JSON)
                .when()
                .get(placeFoundURL)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String locationName = res.jsonPath().getString("resourceSets.resources.name");
        assertThat(res.getStatusCode()).as("verify if response is OK").isEqualTo(200);
        assertThat(locationName).as("verify if place is correct").isEqualTo("[[100 Main St, Algona, WA 98001]]");
    }

    @Test
    public void testIfUnauthorizedWithoutKey() {
        Response res = given()
                .accept(ContentType.JSON)
                .when()
                .get(unauthorizedURL)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String authorizationInfo = res.jsonPath().getString("authenticationResultCode");
        assertThat(res.getStatusCode()).as("verify if Unauthorized").isEqualTo(401);
        assertThat(authorizationInfo).as("verify if invalidCredentials").isEqualTo("InvalidCredentials");
    }

    @Test
    public void testIfBadRequest() {
        Response res = given()
                .when()
                .get(badRequestURL)
                .then()
                .extract()
                .response();
        String response = res.getBody().prettyPrint();
        assertThat(res.getStatusCode()).as("verify if bad request").isEqualTo(400);
        assertThat(response).as("verify if bad request").contains("An application error occurred on the server. The current custom error settings for this application prevent the details of the application error from being viewed remotely (for security reasons). It could, however, be viewed by browsers running on the local server machine.");
    }

    @Test
    public void testIfForbidden() {
        Response res = given()
                .when()
                .get(forbiddenURL)
                .then()
                .extract()
                .response();
        String response = res.getBody().prettyPrint();
        assertThat(res.getStatusCode()).as("verify if forbidden").isEqualTo(403);
        assertThat(response).as("verify if forbidden").contains("403 - Forbidden: Access is denied.");
    }

    @Test
    public void testIfNotFound(){
        Response res = given()
                .when()
                .get(notFoundURL)
                .then()
                .extract()
                .response();
        String response = res.getBody().prettyPrint();
        assertThat(res.getStatusCode()).as("verify if not found").isEqualTo(404);
        assertThat(response).as("verify if not found").contains("404 - File or directory not found");
    }
}
