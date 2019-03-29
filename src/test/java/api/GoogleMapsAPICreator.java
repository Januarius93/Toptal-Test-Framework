package api;

public class GoogleMapsAPICreator {
    private static final String API_KEY = "&key=AIzaSyDLhVAanBXJx3NF5ithQxhrVNCZ14nimGw";
    private String baseGoogleMap = "https://www.google.com/maps/search/?api=1";
    private String baseGoogleMap_Malfunctioned = "https://www.google.com/maps/searches/?api=1";
    private String staticMap = "https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap\n" +
            "&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318\n" +
            "&markers=color:red%7Clabel:C%7C40.718217,-73.998284\n";
    private String paramSign = "&";
    private String place = "query=%s";
    private String apiRequest = "";

    public String getPlace() {
        return place;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    String getApiRequest() {
        return apiRequest;
    }

    private void setApiRequest(String finalApiForm) {
        this.apiRequest = finalApiForm;
    }


    GoogleMapsAPICreator setLocation(Locations location, String discriminator) {
        switch (discriminator) {
            case "city":
                setPlace(String.format(place, location.getCityName()));
                break;
            case "coordinates":
                setPlace(String.format(place, location.getCoordinatesAsOneString()));
                break;
            case "locationID":
                setPlace(String.format(place, location.getLocationID()));
                break;
        }
        return this;
    }

    GoogleMapsAPICreator createMap() {
        setApiRequest(apiRequest.concat(baseGoogleMap));
        return this;
    }

    GoogleMapsAPICreator createFaultMap() {
        setApiRequest(apiRequest.concat(baseGoogleMap_Malfunctioned));
        return this;
    }

    GoogleMapsAPICreator addParams() {
        setApiRequest(apiRequest.concat("&"));
        return this;
    }

    GoogleMapsAPICreator buildStaticMap() {
        setApiRequest(staticMap);
        return this;
    }

    GoogleMapsAPICreator buildRequest() {
        setApiRequest(apiRequest.concat(place));
        return this;
    }

    GoogleMapsAPICreator changeLocation(Locations oldLocation, Locations newLocation) {
        setApiRequest(apiRequest.replace(oldLocation.getCityName(),newLocation.getCityName()));
        return this;
    }

    public GoogleMapsAPICreator addAPIKey() {
        setApiRequest(apiRequest.concat(API_KEY));
        return this;
    }

}
