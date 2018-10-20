package cs2340.donationtracker.Model;

import cs2340.donationtracker.Controllers.Location;

public class ItemInfo {
    private int hour;
    private int min;
    private int year;
    private int month;
    private int day;

    private int value;

    private LocationData locationData;
    private String shortDescription;
    private String fullDescription;
    private Category category;
    private String otherCategory;
    private String comments;

    public ItemInfo(int hour, int min, int year, int month, int day, int value, LocationData locationData, String shortDescription, String fullDescription, Category category, String otherCategory, String comments) {
        this.hour = hour;
        this.min = min;
        this.year = year;
        this.month = month;
        this.day = day;
        this.value = value;
        this.locationData = locationData;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.category = category;
        this.otherCategory = otherCategory;
        this.comments = comments;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
}
