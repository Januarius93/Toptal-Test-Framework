package api.google;

import io.restassured.response.Response;
import org.testng.annotations.*;
import webautomation.listener.GeneralListener;

import static api.google.Locations.*;
import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(GeneralListener.class)
public class MapTest extends GoogleMapsAPICreator {

    GoogleMapsAPICreator googleMapsAPICreator;

    private static String launchGoogleMap = "https://www.google.com/maps/search/?api=1";

    @BeforeMethod
    public void setUpBeforeTest() {
        googleMapsAPICreator = new GoogleMapsAPICreator();
    }

    @Test
    public void testIfWashingtonWillBeFoundByCityName() {
        //given
        googleMapsAPICreator.
                createMap()
                .addParams()
                .setLocation(WASHINGTON, "city")
                .buildRequest();

        //when
        Response res = get(googleMapsAPICreator.getApiRequest());
        //then
        assertThat(res.statusCode()).as("verify if response OK").isEqualTo(200);
        assertThat(res.getBody().toString().contains("Washington"))
                .as("verify is: " + WASHINGTON.getCityName());
    }

    @Test
    public void testIfBerlinWillBeFoundByCoordinates() {
        //given
        googleMapsAPICreator.
                createMap()
                .addParams()
                .setLocation(BERLIN, "coordinates")
                .buildRequest();
        //when
        Response res = get(googleMapsAPICreator.getApiRequest());
        //then
        assertThat(res.statusCode()).as("verify if response OK").isEqualTo(200);
        assertThat(res.getBody().toString().contains(BERLIN.getCoordinatesAsOneString()))
                .as("verify is: " + BERLIN.getCoordinatesAsOneString());
    }


    @Test
    public void testIfWarsawWillNotBeFound() {
        //given
        googleMapsAPICreator.
                createMap()
                .addParams()
                .setLocation(WARSAW_MALFUNCTIONED, "city")
                .buildRequest();
        //when
        Response res = get(googleMapsAPICreator.getApiRequest());
        assertThat(res.statusCode()).as("verify if response OK").isEqualTo(200);
        //then
        assertThat(!res.getBody().toString().contains(WARSAW_PROPER.getCityName()))
                .as("verify is not: " + WARSAW_PROPER.getCityName());
    }

    @Test
    public void testMalfunctionedURL() {
        googleMapsAPICreator.
                createFaultMap()
                .setLocation(WARSAW_MALFUNCTIONED, "city")
                .buildRequest();
        Response res = get(googleMapsAPICreator.getApiRequest());
        //then
        assertThat(res.statusCode()).as("verify if not found").isEqualTo(404);

    }

    @Test
    public void testIfUnauthorizedToCreateStaticMapWithoutAPIKey() {
        //given
        googleMapsAPICreator
                .buildStaticMap();
        //when
        Response res = get(googleMapsAPICreator.getApiRequest());

        //then
        assertThat(res.statusCode()).as("verify if unauthorized").isEqualTo(403);
    }

    @Test
    public void testIfPlacedAndLocationChangeWorksAsExpected() {
        //given
        googleMapsAPICreator.
                createMap()
                .addParams()
                .setLocation(BERLIN, "city")
                .buildRequest();
        //when
        Response resBeforeLocationChange = get(googleMapsAPICreator.getApiRequest());

        //then
        assertThat(resBeforeLocationChange.statusCode()).as("verify if response OK").isEqualTo(200);
        assertThat(resBeforeLocationChange.getBody().toString().contains(BERLIN.getCoordinatesAsOneString()))
                .as("verify is: " + BERLIN.getCoordinatesAsOneString());

        //when
        googleMapsAPICreator.changeLocation(BERLIN, NEW_YORK);
        Response resAfterLocationChange = get(googleMapsAPICreator.getApiRequest());

        //then
        assertThat(resAfterLocationChange.statusCode()).as("verify if response OK").isEqualTo(200);
        assertThat(!resAfterLocationChange.getBody().toString().contains(BERLIN.getCoordinatesAsOneString()))
                .as("verify is not: " + BERLIN.getCoordinatesAsOneString());
        assertThat(resBeforeLocationChange.getBody().toString().contains(NEW_YORK.getCoordinatesAsOneString()))
                .as("verify is: " + NEW_YORK.getCoordinatesAsOneString());
    }


}
