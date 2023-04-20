import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import shop.Item;
import storage.ItemStock;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ItemStockConstructorAndIncreaseTest {
    Item item  = new Item(1, "Item1", 17, "Item1Category");
    ItemStock itemStock = new ItemStock(item);

    @Test
    public void ItemStockConstructorTest(){
        assertEquals(item, itemStock.getItem());
        assertEquals(0, itemStock.getCount());
    }

    @RunWith(Parameterized.class)
    public static class ItemStockTestParametrized {
        private final ItemStock itemStock;
        private  int manipulationNumber;
        private int expectedNumber;

        public ItemStockTestParametrized(int initialCount, int manipulationNumber, int expectedNumber) {
            this.manipulationNumber = manipulationNumber;
            this.expectedNumber = expectedNumber;
            Item item = new Item(1, "Item1", 12, "Item1Category");
            itemStock = new ItemStock(item);
            itemStock.IncreaseItemCount(initialCount);
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {4, 4, 8},
                    {6, -3, 3},
                    {10, 10, 20},
                    {0, 0, 0}
            });
        }
        @Test
        public void IncreaseItemCountTest(){
            itemStock.IncreaseItemCount(manipulationNumber);
            assertEquals(expectedNumber, itemStock.getCount());
        }
    }
}
