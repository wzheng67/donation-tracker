package cs2340.donationtracker.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** holds the list of all courses */
    private List<User> users;

    private Model() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() { return users; }

    public boolean addUser(User user) {
        for (User s : users) {
            if (s.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public User findUserByEmail(String email) {
        for (User s : users) {
            if (email.equals(s.getEmail())) {
                return s;
            }
        }
        return null;
    }

    public boolean findUserByUserPass(String username, String password) {
        for (User s : users) {
            if (username.equals(s.getUsername()) && password.equals(s.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
