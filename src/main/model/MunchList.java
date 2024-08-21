package model;

import java.util.ArrayList;

//MunchList stores MunchItem in order MunchItem are added.
public class MunchList {
    private ArrayList<MunchItem> munchList;

    public MunchList() {
        munchList = new ArrayList<>();
    }

    public ArrayList<MunchItem> getMunchList() {
        return this.munchList;
    }

    // EFFECTS: add a MunchItem to MunchList
    public void addMunchItem(MunchItem munchItem) {
        this.munchList.add(munchItem);
    }

    // EFFECTS: remove a MunchItem to MunchList
    public void removeMunchItem(String name, int amount) {
        MunchItem toRemove = null;
        for (MunchItem mi : this.munchList) {
            if (name.equals(mi.getItemName()) && mi.getItemAmount() == amount) {
                toRemove = mi;
            }
        }
        if (toRemove == null) {
            System.out.print("MunchItem not found in MunchList.");
        } else {
            this.munchList.remove(toRemove);
            System.out.print("Successfully removed!");
        }
    }

    // EFFECTS: get a MunchItem to MunchList according to input index
    public MunchItem getMunchItem(int index) {
        return this.munchList.get(index);
    }

    // EFFECTS: allow users to view the MunchList
    public ArrayList<String> viewMunchList() {
        ArrayList<String> viewMunchList = new ArrayList<String>();
        for (MunchItem mi : this.munchList) {
            viewMunchList.add(mi.getItemName() + " " + mi.getItemAmount() + "(g) " + mi.getItemCategory());
        }
        return viewMunchList;
    }

    // REQUIRES: MunchList is not empty
    // EFFECTS: calculate the total amount of MunchItem in MunchList
    public int getTotalWeight() {
        int totalWeight = 0;
        for (MunchItem mi : this.munchList) {
            totalWeight += mi.getItemAmount();
        }
        return totalWeight;
    }

    // REQUIRES: this.sameCategoryTotalWeight(category)!=0 && this.getTotalWeight()!=0
    // EFFECTS: calculate the percentage of chosen category among entire MunchList
    public double overallAnalyzeList(String category) {
        return (1.0 * this.sameCategoryTotalWeight(category)) / (1.0 * this.getTotalWeight());
    }

    // REQUIRES: MunchList is not empty and have at least one MunchItem of chosen category
    // EFFECTS: calculate total amount of MunchItem of chosen category in MunchList
    public int sameCategoryTotalWeight(String category) {
        int sameCategoryTotalWeight = 0;
        for (MunchItem mi : this.munchList) {
            if (category.equals(mi.getItemCategory())) {
                sameCategoryTotalWeight += mi.getItemAmount();
            }
        }
        return sameCategoryTotalWeight;
    }
}
