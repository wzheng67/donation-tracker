package cs2340.donationtracker.Model;

import java.util.Collection;
import java.util.regex.Pattern;

public class Verification {
    public boolean verifyPassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 6) {
            return false;
        }
        return true;
    }
    public boolean verifyEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public boolean isVaildEmail(String email, Collection<User> users) {
        for (User s : users) {
            if (email.equals(s.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
