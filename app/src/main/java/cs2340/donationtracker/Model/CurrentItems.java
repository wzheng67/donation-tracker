package cs2340.donationtracker.Model;

import java.util.LinkedList;
import java.util.List;

public class CurrentItems {
    private static final CurrentItems ourInstance = new CurrentItems();

    public static CurrentItems getInstance() {
        return ourInstance;
    }

    private List<ItemInfo> itemList = new LinkedList<>();


    private CurrentItems() {
    }

    public List<ItemInfo> getItemList() {
        return itemList;
    }

    public void clear() {
        itemList = new LinkedList<>();
    }
}
