package cs2340.donationtracker.Model;

import cs2340.donationtracker.Controllers.Location;

/**
 * implementation of information of items
 */
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

    /**
     * no arg constructor for ItemInfo
     */
    public ItemInfo() {
    }

    /**
     * constructor of ItemInfo
     * @param timeStamp donated time
     * @param value value
     * @param locationData location data
     * @param shortDescription short description of data
     * @param fullDescription full description of data
     * @param category category of an item
     * @param otherCategory other category
     * @param comments comments of an item
     * @param imageName name of an image
     */
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

    /**
     * getter for timeStamp
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * setter for timeStamp
     * @param timeStamp donated time
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * getter for value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * getter for setValue
     * @param value value of an item
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * getter for locationData
     * @return locationData
     */
    public LocationData getLocationData() {
        return locationData;
    }

    /**
     * setter for locationData
     * @param locationData location of an item
     */
    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    /**
     * getter for shortDescription
     * @return shortDescription short description of an item
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * setter for shortDescription
     * @param shortDescription short description of an item
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * getter for fullDescription
     * @return fullDescription
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * setter for fullDescription
     * @param fullDescription full description of an item
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * getter for category
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setter for category
     * @param category category of an item
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * getter for otherCategory
     * @return otherCategory
     */
    public String getOtherCategory() {
        return otherCategory;
    }

    /**
     * setter for otherCategory
     * @param otherCategory other category
     */
    public void setOtherCategory(String otherCategory) {
        this.otherCategory = otherCategory;
    }

    /**
     * getter for comments
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * setter for comments
     * @param comments comments of an item
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * getter for imageName
     * @return imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * setter for ImageName
     * @param imageName name of an image
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
