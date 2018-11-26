package cs2340.donationtracker.Model;

/**
 * implementation of location of items
 */
@SuppressWarnings({"ALL", "unused"})
public class LocationData {
    private String Key;
    private String Location_name;
    private String Location_type;
    private String Longitude;
    private String Latitude;
    private String Address;
    private String Phone_number;

    /**
     * no arg constructor for LocationData
     */
    public LocationData() {
    }

    /**
     * constructor of LocationData
     * @param key key
     * @param location_name location name
     * @param location_type location type
     * @param longitude longitude
     * @param latitude latitude
     * @param address address
     * @param phone_number phone_number
     */
    public LocationData(String key, String location_name, String location_type, String longitude, String latitude, String address, String phone_number) {
        Key = key;
        Location_name = location_name;
        Location_type = location_type;
        Longitude = longitude;
        Latitude = latitude;
        Address = address;
        Phone_number = phone_number;
    }

    /**
     * getter for Key
     * @return Key
     */
    public String getKey() {
        return Key;
    }

    /**
     * setter for Key
     * @param key key
     */
    @SuppressWarnings("unused")
    public void setKey(String key) {
        Key = key;
    }

    /**
     * getter for Location_name
     * @return Location_name
     */
    public String getLocation_name() {
        return Location_name;
    }

    /**
     * setter for Location_name
     * @param location_name location name
     */
    public void setLocation_name(String location_name) {
        Location_name = location_name;
    }

    /**
     * getter for Location_type
     * @return Location_type
     */
    public String getLocation_type() {
        return Location_type;
    }

    /**
     * setter for location_type
     * @param location_type location_type
     */
    public void setLocation_type(String location_type) {
        Location_type = location_type;
    }

    /**
     * getter for Longitude
     * @return Longitude
     */
    public String getLongitude() {
        return Longitude;
    }

    /**
     * setter for Longitude
     * @param longitude Longitude
     */
    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    /**
     * getter for Latitude
     * @return Latitude
     */
    public String getLatitude() {
        return Latitude;
    }

    /**
     * setter for Latitude
     * @param latitude latitude
     */
    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    /**
     * getter for Address
     * @return Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * setter for Address
     * @param address Address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * getter for Phone_number
     * @return Phone_number
     */
    public String getPhone_number() {
        return Phone_number;
    }

    /**
     * setter for Phone_number
     * @param phone_number phone number
     */
    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    /**
     * toString method
     * @return location name
     */
    public String toString() {
        return Location_name;
    }
}
