package cs2340.donationtracker.Model;


import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable{
    private String email;
    private String username;
    private String password;
    private String type;

    public User(String email, String username, String password, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return email + " " + username + " " + password + " " + type;
    }

    @Override
    public boolean equals(Object o) {
        User c = (User) o;
        return (c.getEmail().equals(email) && c.getUsername().equals(username));
    }

    private User(Parcel in) {
        email = in.readString();
        username = in.readString();
        password = in.readString();
        type = in.readString();
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
        dest.writeString(type);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}