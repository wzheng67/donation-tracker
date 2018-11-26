package cs2340.donationtracker.Model;

import java.util.Collection;
import java.util.regex.Pattern;

/**
 * implementation of verification class
 */
public class Verification {

    /**
     * This method checks whether password is valid.
     * @param password password
     * @return returns true when pass is valid
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public boolean verifyPassword(String password) {
        return (password != null) && (password.length() >= 6);
    }

    /**
     * This method checks whether an email is valid.
     * @param email email address of a user
     * @return returns true if email address is valid or false if email address if invalid
     */
    @SuppressWarnings({"TypeMayBeWeakened", "ChainedMethodCall"})
    public boolean verifyEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return (email != null) && pat.matcher(email).matches();
    }

    /**
     * This method checks whether an email matches with a certain user.
     * @param email email address
     * @param users User
     * @return returns true if the email matches with correct user or false if it does not match
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public boolean isValidEmail(String email, Collection<User> users) {
        for (User s : users) {
            if (email.equals(s.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
