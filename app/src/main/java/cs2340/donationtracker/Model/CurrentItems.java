package cs2340.donationtracker.Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of list of current items.
 */
public class CurrentItems {
    private static final CurrentItems ourInstance = new CurrentItems();

    /**
     * getter for current items
     * @return current items
     */
    public static CurrentItems getInstance() {
        return ourInstance;
    }

    private List<ItemInfo> itemList = new LinkedList<>();


    private CurrentItems() {
    }

    /**
     * getter for item list
     * @return item list
     */
    public List<ItemInfo> getItemList() {
        return itemList;
    }

    /**
     * erases all items in an item list
     */
    public void clear() {
        itemList = new LinkedList<>();
    }
}
