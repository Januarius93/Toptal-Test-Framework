package api.google;

public enum Locations {


    NEW_YORK("New York", "40.730610", "-73.935242", "ChIJOwg_06VPwokRYv534QaPC8g"),
    WASHINGTON("Washington", "47.751076", "-120.740135", "ChIJW-T2Wt7Gt4kRKl2I1CJFUsI"),
    BERLIN("Berlin", "52.520008", "13.404954", "ChIJAVkDPzdOqEcRcDteW0YgIQQ"),
    WARSAW_MALFUNCTIONED("arsawawda","","",""),
    WARSAW_PROPER("Warsaw","","","");

    String cityName;
    String latitude;
    String longitude;
    String locationID;


    public String getCityName() {
        return cityName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLocationID() {
        return locationID;
    }
    public String getCoordinatesAsOneString(){
        return latitude +","+longitude;
    }

    Locations(String cityName, String latitude, String longitude, String locationID) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationID = locationID;
    }
}
