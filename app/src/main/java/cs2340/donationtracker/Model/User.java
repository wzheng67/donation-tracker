package cs2340.donationtracker.Model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * implementation of user class
 */
@SuppressWarnings("ALL")
public class User implements Parcelable{
    private String email;
    private String username;
    private String password;
    private User_type type;

    public User(String email, String password, String username, User_type type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * an arg constructor of User
     */
    public User() {

    }

    /**
     * constructor of User
     * @param email user's email
     * @param type user's type
     */
    public User(String email, User_type type) {
        this (email, "", "", type);
    }

    /**
     * getter for email
     * @return email
     */
    public String getEmail() { return email; }

    /**
     * setter for email
     * @param email user's email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * getter for username
     * @return username
     */
    private String getUsername() { return username; }

    /**
     * setter for username
     * @param username name of a user
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * getter for password
     * @return password
     */
    @SuppressWarnings("unused")
    public String getPassword() { return password; }

    /**
     * setter for password
     * @param password password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * getter for User_type
     * @return
     */
    public User_type getType() {
        return type;
    }

    /**
     * setter for type
     * @param type type of a user
     */
    public void setType(User_type type) {
        this.type = type;
    }

    /**
     * @return returns user's email, username, password, and type
     */
    @Override
    public String toString() {
        return email + " " + username + " " + password + " " + type;
    }

    /**
     * This method checks whether the parameter is same object with
     * @param o
     * @return
     */
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        User c = (User) o;
        return (c.getEmail().equals(email) && c.getUsername().equals(username));
    }

    private User(Parcel in) {
        email = in.readString();
        username = in.readString();
        password = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(password);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}