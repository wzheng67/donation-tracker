package cs2340.donationtracker.Model;


import android.os.Parcel;
import android.os.Parcelable;


@SuppressWarnings("ChainedMethodCall")
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
    public User() {

    }
    public User(String email, User_type type) {
        this (email, "", "", type);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public User_type getType() {
        return type;
    }

    public void setType(User_type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return email + " " + username + " " + password + " " + type;
    }

    @Override
    public boolean equals(Object o) {
        User c = (User) o;
        //noinspection ChainedMethodCall
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