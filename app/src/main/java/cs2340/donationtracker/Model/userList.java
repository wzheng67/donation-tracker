package cs2340.donationtracker.Model;

import java.util.ArrayList;
import java.util.List;

public class userList {
    private  List<User> users;

    public userList() {
        users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        for (User s : users) {
            if (s.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public User findStudentByEmail(String email) {
        for (User s : users) {
            if (email == s.getEmail()) {
                return s;
            }
        }
        return null;
    }
}