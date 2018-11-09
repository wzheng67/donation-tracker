package cs2340.donationtracker.Model;

public final class CurrentUser {
    private static final CurrentUser ourInstance = new CurrentUser();

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

    public User getCurrUser() {
        return currUser;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }

    public User_type getUserType() {
        return userType;
    }

    public void setUserType(User_type userType) {
        this.userType = userType;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }
}
