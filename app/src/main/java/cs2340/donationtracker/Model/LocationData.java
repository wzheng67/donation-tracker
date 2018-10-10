package cs2340.donationtracker.Model;

public class LocationData {
    private String Key;
    private String Location_name;
    private String Location_type;
    private String Longitude;
    private String Latitude;
    private String Address;
    private String Phone_number;

    public LocationData(String key, String location_name, String location_type, String longitude, String latitude, String address, String phone_number) {
        Key = key;
        Location_name = location_name;
        Location_type = location_type;
        Longitude = longitude;
        Latitude = latitude;
        Address = address;
        Phone_number = phone_number;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getLocation_name() {
        return Location_name;
    }

    public void setLocation_name(String location_name) {
        Location_name = location_name;
    }

    public String getLocation_type() {
        return Location_type;
    }

    public void setLocation_type(String location_type) {
        Location_type = location_type;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }
}
