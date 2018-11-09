package cs2340.donationtracker.Model;

public class ItemInfo {
    private String timeStamp;

    private int value;

    private LocationData locationData;
    private String shortDescription;
    private String fullDescription;
    private Category category;
    private String otherCategory;
    private String comments;
    private String imageName;

    public ItemInfo() {

    }
    public ItemInfo(String timeStamp, int value, LocationData locationData, String shortDescription, String fullDescription, Category category, String otherCategory, String comments, String imageName) {
        this.timeStamp = timeStamp;
        this.value = value;
        this.locationData = locationData;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.category = category;
        this.otherCategory = otherCategory;
        this.comments = comments;
        this.imageName = imageName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOtherCategory() {
        return otherCategory;
    }

    public void setOtherCategory(String otherCategory) {
        this.otherCategory = otherCategory;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
