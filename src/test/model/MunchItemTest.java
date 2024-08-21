package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MunchItemTest {
    private MunchItem munchItem1;
    private MunchItem munchItem2;
    private MunchItem munchItem3;

    public MunchItemTest() {
        munchItem1 = new MunchItem();
        munchItem2 = new MunchItem();
        munchItem3 = new MunchItem();
    }

    @BeforeEach
    void runBefore() {
        munchItem1.setMunchItem("apple", 3, "fruit");
        munchItem2.setMunchItem("peanut", 4, "nut");
        munchItem3.setMunchItem("lettuce", 8, "vegetable");
    }

    @Test
    void testGetItemName() {
        assertEquals("apple", munchItem1.getItemName());
        assertEquals("peanut", munchItem2.getItemName());
        assertEquals("lettuce", munchItem3.getItemName());
    }

    @Test
    void testGetItemAmount() {
        assertEquals(3, munchItem1.getItemAmount());
        assertEquals(4, munchItem2.getItemAmount());
        assertEquals(8, munchItem3.getItemAmount());
    }

    @Test
    void testGetItemCategory() {
        assertEquals("fruit", munchItem1.getItemCategory());
        assertEquals("nut", munchItem2.getItemCategory());
        assertEquals("vegetable", munchItem3.getItemCategory());

    }
}