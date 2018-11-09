package cs2340.donationtracker.Model;

/**
 * implementation of list of current users
 */
public class CurrentUser {
    private static final CurrentUser ourInstance = new CurrentUser();

    /**
     * getter for user instances
     * @return CurrentUser
     */
    public static CurrentUser getInstance() {
        return ourInstance;
    }

    User currUser;
    User_type userType;
    LocationData locationData;
    private CurrentUser() {
        currUser = new User();
        userType = User_type.USER;
    }

    /**
     * getter for currUser
     * @return currUser
     */
    public User getCurrUser() {
        return currUser;
    }

    /**
     * setter for currUser
     * @param currUser current user
     */
    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }

    /**
     * getter for userType
     * @return userType
     */
    public User_type getUserType() {
        return userType;
    }

    /**
     * setter for UserType
     * @param userType user type
     */
    public void setUserType(User_type userType) {
        this.userType = userType;
    }

    /**
     * getter for locationData
     * @return locationData
     */
    public LocationData getLocationData() {
        return locationData;
    }

    /**
     * setter for locationData
     * @param locationData location data
     */
    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }
}
