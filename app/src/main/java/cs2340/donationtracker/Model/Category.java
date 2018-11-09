package cs2340.donationtracker.Model;

public enum Category {
    CLOTHING("Clothing"), HAT("Hat"), KITCHEN("Kitchen"), ELECTRONICS("Electronics"),
    HOUSEHOLD("Household"), OTHER("Other");

    private String category;

    Category(String s) {this.category = s;}

    @Override
    public String toString() {return category;}
}
