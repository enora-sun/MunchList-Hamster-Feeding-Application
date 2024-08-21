package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MunchListTest {
    private MunchItem munchItem1;
    private MunchItem munchItem2;
    private MunchItem munchItem3;
    private MunchItem munchItem4;
    private MunchItem munchItem5;
    private MunchList munchList1;

    public MunchListTest() {
        munchItem1 = new MunchItem();
        munchItem2 = new MunchItem();
        munchItem3 = new MunchItem();
        munchItem4 = new MunchItem();
        munchItem5 = new MunchItem();
        munchList1 = new MunchList();
    }

    @BeforeEach
    void runBefore() {
        munchItem1.setMunchItem("apple", 5, "fruit");
        munchItem2.setMunchItem("peanut", 5, "nut");
        munchItem3.setMunchItem("lettuce", 5, "vegetable");
        munchItem4.setMunchItem("cashew", 5, "nut");
        munchItem5.setMunchItem("cashew", 10, "nut");
    }

    @Test
    void testViewMunchItem() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        ArrayList ArrayList = new ArrayList<>();
        ArrayList.add("apple" + " " + "5(g) " + "fruit");
        ArrayList.add("peanut" + " " + "5(g) " + "nut");
        ArrayList.add("lettuce" + " " + "5(g) " + "vegetable");
        assertEquals(ArrayList, munchList1.viewMunchList());
    }

    @Test
    void testAddMunchItem() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        assertEquals(munchItem1, munchList1.getMunchItem(0));
        assertEquals(munchItem2, munchList1.getMunchItem(1));
    }

    @Test
    void testRemoveMunchItem() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        munchList1.removeMunchItem("peanut", 5);
        assertEquals(munchItem3, munchList1.getMunchItem(1));
        ArrayList ArrayList = new ArrayList<>();
        ArrayList.add(munchItem1);
        ArrayList.add(munchItem3);
        assertEquals(ArrayList, munchList1.getMunchList());
    }

    @Test
    void testRemoveMunchItem1() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        ArrayList ArrayList = new ArrayList<>();
        ArrayList.add(munchItem1);
        ArrayList.add(munchItem2);
        ArrayList.add(munchItem3);
        munchList1.removeMunchItem("peanut", 6);
        assertEquals(ArrayList, munchList1.getMunchList());
        munchList1.removeMunchItem("cheese", 5);
        assertEquals(ArrayList, munchList1.getMunchList());
        munchList1.removeMunchItem("cheese", 6);
        assertEquals(ArrayList, munchList1.getMunchList());
        munchList1.removeMunchItem("apple", 5);
        ArrayList.remove(0);
        assertEquals(ArrayList, munchList1.getMunchList());
    }

    @Test
    void testGetMunchList() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        ArrayList ArrayList = new ArrayList<>();
        ArrayList.add(munchItem1);
        ArrayList.add(munchItem2);
        ArrayList.add(munchItem3);
        assertEquals(ArrayList, munchList1.getMunchList());
    }

    @Test
    void testGetTotalWeight() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        assertEquals(15, munchList1.getTotalWeight());
    }

    @Test
    void testOverallAnalyzeList() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem4);
        munchList1.addMunchItem(munchItem5);
        assertEquals(0.8, munchList1.overallAnalyzeList("nut"));
        assertEquals(0.2, munchList1.overallAnalyzeList("fruit"));
        assertEquals(0, munchList1.overallAnalyzeList("meat"));
    }

    @Test
    void testGetMunchItem() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        munchList1.addMunchItem(munchItem4);
        assertEquals(munchItem1, munchList1.getMunchItem(0));
        assertEquals(munchItem4, munchList1.getMunchItem(3));
    }

    @Test
    void testSameCategoryTotalWeight() {
        munchList1.addMunchItem(munchItem1);
        munchList1.addMunchItem(munchItem2);
        munchList1.addMunchItem(munchItem3);
        munchList1.addMunchItem(munchItem4);
        munchList1.addMunchItem(munchItem5);
        assertEquals(20, munchList1.sameCategoryTotalWeight("nut"));
        assertEquals(5, munchList1.sameCategoryTotalWeight("fruit"));
        assertEquals(0, munchList1.sameCategoryTotalWeight("meat"));
    }
}
