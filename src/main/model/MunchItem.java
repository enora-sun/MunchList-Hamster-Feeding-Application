package model;

import java.util.ArrayList;

// Represents items in MunchList, each item has three private fields,
// name,amount(in grams)
// and category(one out the five categories: Vegetable, Fruit, Nut, Meat,Carb).

public class MunchItem {
    private String itemName;        // name of MunchItem
    private Integer itemAmount;       // amount of MunchItem
    private String itemCategory;    // category of MunchItem
    ArrayList<String> itemCategories = new ArrayList<String>();


    //REQUIRES: name!="", amount>0, category exists inside itemCategories
    //EFFECTS; create an MunchItem
    public void setMunchItem(String name, int amount, String category) {
        itemCategories.add("vegetable");
        itemCategories.add("fruit");
        itemCategories.add("meat");
        itemCategories.add("carb");
        itemCategories.add("nut");

        itemName = name;
        itemAmount = amount;
        itemCategory = category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public String getItemCategory() {
        return itemCategory;
    }

}

