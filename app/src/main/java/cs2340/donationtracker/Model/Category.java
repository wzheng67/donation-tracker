package cs2340.donationtracker.Model;

/**
 * enum class for categorizing types of items
 */
public enum Category {
    CLOTHING("Clothing"), HAT("Hat"), KITCHEN("Kitchen"),
    @SuppressWarnings("SpellCheckingInspection") EKECTRONICS("Electronics"),
    HOUSEHOLD("Household"), OTHER("Other");

    private final String category;

    Category(String s) {this.category = s;}

    @Override
    public String toString() {return category;}
}
