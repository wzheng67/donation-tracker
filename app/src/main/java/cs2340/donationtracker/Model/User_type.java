package cs2340.donationtracker.Model;

/**
 * enum class for categorizing types of users
 */
public enum User_type {
    USER("User"), LOCATION_EMPLOYEE("Employee"), MANAGER("Manager"), ADMIN("Admin");

    String user_type;

    User_type(String type) {
        user_type = type;
    }

    @Override
    public String toString() {
        return user_type;
    }
}
